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


func main() {
	values := []int{23, 12, 22, 6, 2, 6, 7, 9}
	bubbleSort(values)
	fmt.Println(values)
}

