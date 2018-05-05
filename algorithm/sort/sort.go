package main

import (
	"fmt"
)

func bubbleSort(values []int) {
	flag := true
	for i := 0; i < len(values)-1; i++ {
		flag = true
		for j := 0; j < len(values)-i-1; j++ {
			if values[j] > values[j+1] {
				flag = false
				values[j], values[j+1] = values[j+1], values[j]
			}
		}
		if flag == true {
			break
		}
	}
}

func quickSort(values []int, left, right int) {
	if left < right {
		storeIndex := left
		key := values[right]
		for i := left; i < right; i++ {
			if values[i] < key {
				values[storeIndex], values[i] = values[i], values[storeIndex]
				storeIndex++
			}
		}
		fmt.Println(values)
		values[storeIndex], values[right] = values[right], values[storeIndex]
		quickSort(values, left, storeIndex - 1)
		quickSort(values, storeIndex + 1 , right)
	}
}

func main() {
	values := []int{23, 12, 22, 6, 2, 6, 7, 9}
	bubbleSort(values)
	fmt.Println(values)
	values1 := []int{23, 12, 22, 6, 2, 6, 7, 9,45}
	quickSort(values1, 0, len(values1)-1)
	fmt.Println(values1)
}
