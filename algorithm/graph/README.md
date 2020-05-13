# 图相关算法

|代码|说明|
|-|-|
|[Knight.java](Knight.java)|贪婪法求马的遍历的一个解
|[KnightAll.java](KnightAll.java)|回溯法求马的遍历的所有解
|[matrix_dg.go](matrix_dg.go)|用数组实现有像图，并实现了深度优先和广度优先算法，另外实现了一个依赖算法，比如A依赖B表示成A->B. 依赖算法可以从一个复杂的图中打印优先级高的节点，防止依赖产生的错误。比如A->B,那B事件必须在A事件之前发生，否则在执行A事件的时候会出现依赖错误。
|[matrix_udg.go](matrix_udg.go)|用数组实现无向图，并实现了深度优先和广度优先算法
