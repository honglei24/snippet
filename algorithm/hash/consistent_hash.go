package main

import (
	"fmt"
)

// FNV1_32_HASH
func getHash(str string) int32 {
	FNV_prime :=16777619
	hash := 2166136261
	for i := 0; i < len(str); i++ {
		hash = (hash ^ int([]rune(str)[i]) ) * FNV_prime
	}
	hash += hash << 13
	hash ^= hash >> 7
	hash += hash << 3
	hash ^= hash >> 17
	hash += hash << 5

	if int32(hash) < 0 {
		return -int32(hash)
	}

	return int32(hash)
}

func getServer(node string, hashMap map[int]string) string {
	hash := getHash(node)
	first_value := ""
	for key, value := range(hashMap) {
		if first_value == "" {
			first_value = value
		}
		if key >= int(hash) {
			return value
		}
	}
	return first_value
}

func createHashMap(servers []string, hashMap map[int]string) {
	for i := 0; i< len(servers); i++ {
		hash := getHash(servers[i])
		//fmt.Printf("[ %v ]'s hash code is: %v.\n", servers[i], hash)
		hashMap[int(hash)] = servers[i]
	}
}

func main() {
	servers := []string{"192.168.0.1:100", "192.168.0.2:100", "192.168.0.3:100", "192.168.0.4:100"}

	// virtual node
	N := 4;
	virtualServer := make([]string, 0)
	for i := 0; i < len(servers)*N; i++ {
		index := i / N
		str := fmt.Sprintf("%s__%v", servers[index], i % N)
		virtualServer = append(virtualServer, str)
	}
	// key: hash code, value: server name
	hashMap := make(map[int]string)

	//createHashMap(servers, hashMap)
	createHashMap(virtualServer, hashMap)

	nodes := []string{"10.0.0.1:1000", "10.0.0.2:2000", "10.0.0.3:3000", "10.0.0.4:4000","10.0.0.5:5000"}
	for i := 0; i< len(nodes); i++ {
		fmt.Printf("[ %v ]'s hash code is %v and it is routed to server %v.\n", nodes[i], getHash(nodes[i]), getServer(nodes[i], hashMap))
	}
}
