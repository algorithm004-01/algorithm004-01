## 代码模板



## DFS

```java
private static Set<TreeNode> visited = new HashSet<>();
    public void dfs(TreeNode node) {
        // terminator
        if (node == null || visited.contains(node)) {
            return;
        }
        visited.add(node);
        // process
        process(node);
        // drill down
        dfs(node.left);
        dfs(node.right);
        // reverse state
    }

    private void process(TreeNode node) {
        System.out.println(node.val);
    }	
```





## BFS



```java
private static Set<TreeNode> visited = new HashSet<>();
public void bfs(TreeNode node) {
    Deque<List<TreeNode>> queue = new ArrayDeque<>();
    queue.push(Arrays.asList(node));
    visited.add(node);
    List<TreeNode> toVisit;
    while ((toVisit = queue.pollFirst()).size() > 0) {
        for (TreeNode treeNode : toVisit) {
            visited.add(treeNode);

            process(treeNode);

            List<TreeNode> relatedNodes = generateRelatedNodes(treeNode);

            queue.push(relatedNodes);
        }

    }
}

private List<TreeNode> generateRelatedNodes(TreeNode node) {
    List<TreeNode> res = new ArrayList<>();
    if (node.left != null) {
        res.add(node.left);
    }
    if (node.right != null) {
        res.add(node.right);
    }
    return res;
}

private void process(TreeNode node) {
    System.out.println(node.val);
}
```

```java
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (root == null) {
            return ansList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                ans.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ansList.add(ans);
        }
        return ansList;
    }
```



### 二分查找模板

```java
public int search(int[] nums) {
  	int left = 0,right = nums.length - 1;
  	while (left <= right) {
      mid = (left + right) / 2;
      if (nums[mid] == target) {
        // find the target break or return result;
        return mid;
      }else if (nums[mid] < target) {
        left = mid + 1;
      }else {
        right = mid - 1;
      }
    }
}
```



## 总结

> 这周经过老师的线上答疑后，了解到自己的不足，我现在需要的仅仅是不停的汲取知识，将别人的完全理解后，写出来，这种反复。等自己有一定题目的积累后再考虑自己思路想法。
>
> 这周遇到不会的题目先将其记住，反复敲代码，反复记忆。
>
> 改善点：
>
> 1. 自己去看国外most votes 变得频繁，经常会觉得他们的思路很神奇 让自己觉得自愧不如且小上瘾。
> 2. 也偶尔会去看一些 其他语言的代码是如何书写的 发现用java去按照他们的代码去写 有时真的非常丑陋 （ps 可能自己java的功底也不深）
>
> 二分查找中间无序的索引
>
> ```java
> public int findIndex(int[] nums) {
>   int left = 0, right = nums.length - 1;
>   while (left <= right) {
>     int mid = (left + right) / 2;
>     if (nums[mid] > nums[mid + 1]) {
>       return mid;
>     } else {
>       if (nums[mid] < nums[left]) right = mid - 1;
>       else left = mid + 1;
>     }
>   }
> }
> ```
>
> 