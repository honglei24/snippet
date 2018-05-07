package main

import (
	"fmt"
)

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
		//fmt.Println(values)
		values[storeIndex], values[right] = values[right], values[storeIndex]
		quickSort(values, left, storeIndex - 1)
		quickSort(values, storeIndex + 1 , right)
	}
}

func main() {
	values := []int{23, 12, 22, 6, 2, 6, 7, 9,45}
	quickSort(values, 0, len(values)-1)
	fmt.Println(values)
}

