package main

import "fmt"

const N = 4

func main() {
	arr := make([][]int, N)
	for i := 0; i < N; i++ {
		arr[i] = make([]int, N)
	}

	for i := 0; i < N; i++ {
		for j := 0; j < N; j++ {
			arr[i][j] = i*N + j + 1
		}
	}
	spin(arr, N)

	for i := 0; i < N; i++ {
		for j := 0; j < N; j++ {
			fmt.Printf("%d\t", arr[i][j])
		}
		println()
	}
	//arr := []int{8, 1, 9, 2, 3, 4}
	//sort(arr, len(arr))
	//for _, v:= range arr {
	//	fmt.Printf("%d\t", v)
	//}
}

func spin(a [][]int, n int) {
	if n <= 1 {
		return
	}
	for i := 0; i <= (n-1)/2; i++ {

		for j := 0; j <= (n-1)/2; j++ {
			a[i][j], a[j][n-1-i], a[n-1-i][n-1-j], a[n-1-j][i] = a[n-1-j][i], a[i][j], a[j][n-1-i], a[n-1-i][n-1-j]
		}
	}
}