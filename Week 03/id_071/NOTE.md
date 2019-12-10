> 深度优先搜索(dfs) 广度优先搜索(bfs)


##### dfs 深度优先遍历

    //递归、栈的方式
    func dfs(node []int) {
        visited := []int{}
        //node in visited
        if _, ok := visited[]; ok {
            return
        }
        visited = append(visited,node)
        
        dfs(node[left])
        dfs(node[right])
    }
    
    //
    visited := []int{}
    func dfs(node []int{}, visted []int){
        visited = append(visited,node)
        for k, v := range node['children'] {
            //next_node in visited
            if _, ok :range visited[next_node]; ok {
                dfs(next_node, visited)
            }
        }
    }

##### bfs 广度优先遍历（层级遍历）

    //对列 queue
    func bfs(graph []int, start in, end int){
        visited := []int{}
        queue := []int{}
        queue = append(queue,graph[start])
        visited = append(visited,start)
        for len(queue) > 0 {
            
        }
        
    }
    

***


> 贪心算法

##### 贪心算法 每一步选择中都采取当前状态下最好或最优的选择，从而希望导致结果是全局最好或最优的算法

    常用语 哈夫曼编码、最小生成树
    1、贪心 得到全局最优解
    2、贪心的角度 从前往后 或 从后往前
    
##### 步骤

    1、定义了期望值 和 限制值
    2、尝试看下贪心算法能否解决问题 每次选择当前情况下，在对限制值同等贡献量的情况下，对期望值贡献最大的数据
    3、举例看下贪心算法啊产生的结果是否是最优解

##### 贪心、回溯、动态规划

    贪心 寻找局部最优解
    回溯 
    动态规划 


***


> 二分查找

##### 简单的二分查找 就是 有序数组中不存在重复元素
    
    1. 循环退出条件  left <= right
    
    2. mid 的取值 left+(right-left)/2 or left+((right-left)>>1)
    
    3. left 和 right 的更新 left = mid + 1 or right = mid - 1
    
##### 变体的二分查找

    变体一：查找第一个值等于给定值的元素
    变体二：查找最后一个值等于给定值的元素
    变体三：查找第一个大于等于给定值的元素
    变体四：查找最后一个小于等于给定值的元素

##### 条件

    单调性 有序
    上下界 有边界 (bounded)
    索引访问 数组 (index accessible)
    
    连续内存空间
    
    对比 二叉搜索树

##### 代码模板

    //循环
    left,right := 0, len(nums)
    for left <= right {
        mid := (left+right)/2
        
        if target == nums[mid] {
            return mid
        }else if target > nums[mid]{
            left = mid + 1
        }else{
            right = mid - 1 
        }
    }
    
    
    //递归
    func binary (nums []int, val int ) int {
        l := len(nums)
        return binarysearch(nums, val, 0, l)
    }
    
    func binarySearch(nums []int, val int, low int, high int){
        if low > high {
            return -1
        }
        mid := low+((high-low)>>1)
        if val == nums[mid] {
            return mid
        } else val > nums[mid] {
            return binarySearch(nums, val, mid + 1, high)
        }else{
            return bunarySearch(nums, val, low, mid + 1)
        }
    }

