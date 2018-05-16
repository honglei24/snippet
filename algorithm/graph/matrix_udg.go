package main

import (
	"fmt"
)

/*
matrix undirected graph
 */

type MatrixUDG struct {
	numOfEdges int
	vertexList []interface{}
	edges [][]int
}

func (g *MatrixUDG) getNumOfVertex() int {
	return len(g.vertexList)
}

func (g *MatrixUDG) getNumOfEdges() int {
	return g.numOfEdges
}

func (g *MatrixUDG) getValueByIndex(i int) interface{} {
	return g.vertexList[i]
}

func (g *MatrixUDG) getWeight(v1, v2 int) int {
	return g.edges[v1][v2]
}

func (g *MatrixUDG) insertVertex(vertex interface{}) {
	g.vertexList = append(g.vertexList, vertex)
}

func (g *MatrixUDG) insertEdge(v1, v2 int, weight int) {
	g.edges[v1][v2] = weight
	g.edges[v2][v1] = weight
	g.numOfEdges++
}

func (g *MatrixUDG) deleteEdge(v1, v2 int) {
	g.edges[v1][v2] = 0
	g.edges[v2][v1] = 0
	g.numOfEdges--
}

func (g *MatrixUDG) getFirstNeighbor(v int) int {
	vexnum := len(g.vertexList)
	if ( v < 0 || v > (vexnum - 1)) {
		return -1
	}
	for i := 0; i < vexnum; i++ {
		if (g.edges[v][i] > 0) {
			return i
		}
	}
	return -1
}

func (g *MatrixUDG) getNextNeighbor(v1, v2 int) int {
	vexnum := len(g.vertexList)
	if ( v1 < 0 || v1 > (vexnum - 1) || v2 < 0 || v2 > (vexnum - 1)) {
		return -1
	}
	for i := v2 + 1; i < vexnum; i++ {
		//fmt.Println(i)
		if (g.edges[v1][i] > 0) {
			return i
		}
	}
	return -1
}

func (g *MatrixUDG) depthFirstSearch(isVisited []bool, i int){
	fmt.Printf("%v, ", g.getValueByIndex(i))
	isVisited[i] = true

	w := g.getFirstNeighbor(i)
	for (w != -1) {
		if (!isVisited[w]) {
			g.depthFirstSearch(isVisited, w)
		}
		w = g.getNextNeighbor(i, w)
	}
}

func (g *MatrixUDG) DepthFirstSearch(){
	isVisited := make([]bool, g.getNumOfVertex())

	for i := 0; i < g.getNumOfVertex(); i ++ {
		if (!isVisited[i]) {
			g.depthFirstSearch(isVisited, i)
		}
	}
}

func (g *MatrixUDG) broadFirstSearch(isVisited []bool, i int){
	fmt.Printf("%v, ", g.getValueByIndex(i))
	isVisited[i] = true

	vertexNum := g.getNumOfVertex()
	queen := make([]int, vertexNum)
	queen = append(queen, i)
	for len(queen) != 0 {
		u := queen[0]
		queen = queen[1:]
		w := g.getFirstNeighbor(u)
		for w != -1 {
			if (!isVisited[w]) {
				fmt.Printf("%v, ", g.getValueByIndex(w))
				isVisited[w] = true
				queen = append(queen, w)
			}
			w = g.getNextNeighbor(u, w)
		}
	}
}

func (g *MatrixUDG) BroadFirstSearch(){
	isVisited := make([]bool, g.getNumOfVertex())

	for i := 0; i < g.getNumOfVertex(); i ++ {
		if (!isVisited[i]) {
			g.broadFirstSearch(isVisited, i)
		}
	}
}

func NewUDG(vertexs []string) *MatrixUDG {
	n := len(vertexs)
	var e[][]int
	for i := 0 ; i < n; i++ {
		tmp := make([]int, n)
		e = append(e, tmp)
	}
	g := &MatrixUDG{
		numOfEdges: 0,
		edges: e,
	}

	for _, v := range vertexs {
		g.insertVertex(v)
	}
	return g
}

func main() {
	vertexs := []string{"1", "2", "3", "4", "5", "6", "7", "8"}

	g := NewUDG(vertexs)
	g.insertEdge(0, 1, 1)
	g.insertEdge(0, 2, 1)
	g.insertEdge(1, 3, 1)
	g.insertEdge(1, 4, 1)
	g.insertEdge(2, 5, 1)
	g.insertEdge(2, 6, 1)
	g.insertEdge(3, 7, 1)
	g.insertEdge(4, 7, 1)
	g.insertEdge(5, 6, 1)
	fmt.Print("DFS: ")
	g.DepthFirstSearch()
	fmt.Println()
	fmt.Print("BFS: ")
	g.BroadFirstSearch()
}

