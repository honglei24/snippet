package main

import "fmt"

func main() {
	arr := []int{8, 1, 9, 2, 3, 4}
	sort(arr, len(arr))
	for _, v:= range arr {
		fmt.Printf("%d\t", v)
	}
}

func sort(a []int, n int) {
	//length := len(a)
	if n <= 1 {
		return
	}
	for i := 1; i < n; i++ {
		v := a[i]
		j := i - 1
		for ; j >= 0; j-- {
			if a[j] > v {
				a[j+1] = a[j]
			} else {
				break
			}
		}
		a[j+1] = v
	}
}
