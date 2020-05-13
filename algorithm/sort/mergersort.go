package main

import "fmt"

func main() {
	arr := []int{8, 1, 5, 9, 7, 2, 6, 3, 4}
	mergersort(arr, 0, len(arr)-1)
	for _, v:= range arr {
		fmt.Printf("%d\t", v)
	}
}

func mergersort(a []int, left, right int) {
	if left >= right {
		return
	}
	mid := (left + right) / 2
	mergersort(a, left, mid)
	mergersort(a, mid + 1, right)
	merger(a, left, mid, right)
}

func merger(a []int, left, mid, right int) {
	tmp := make([]int, right-left + 1)
	count := 0
	i := left
	j := mid + 1
	for ;i<=mid && j<=right; {
		if a[i] <= a[j] {
			tmp[count] = a[i]
			i++
		} else {
			tmp[count] = a[j]
			j++
		}
		count++
	}
	if i > mid {
		for ;j <= right; j++{
			tmp[count] = a[j]
			count++
		}
	}
	if j > right {
		for ;i <= mid; i++{
			tmp[count] = a[i]
			count++
		}
	}
	for k:=0; k < count; k++ {
		a[left+k] = tmp[k]
	}
}
