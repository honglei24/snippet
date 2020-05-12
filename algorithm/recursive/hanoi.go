package main

import "fmt"

var count int
func main() {
	count = 0
	//var a, b, c []int
	A := "A"
	B := "B"
	C := "C"
	hanoi(7, A, B, C)
}

func move(disk int, M string, N string) {
	count++
	fmt.Printf("step %d: move %d from %s to %s\n", count, disk, M, N)
}

func hanoi(n int, A, B, C string) {
	if n==1 {
		move(1, A, C)
	} else {
		hanoi(n-1, A, C, B)
		move(n, A, C)
		hanoi(n-1, B, C, A)
	}
}
