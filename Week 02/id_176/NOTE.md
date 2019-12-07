## Note

二叉树遍历 

1. 前序(Pre-order): 根-左-右
2. 中序(In-order): 左-根-右 
3. 后序(Post-order): 左-右-根 

示例代码 

```python
def preorder(self, root):
	if root:
	 	self.traverse_path.append(root.val) 
		self.preorder(root.left) 
		self.preorder(root.right) 

def inorder(self, root):
	if root:
 		self.inorder(root.left) 
    self.traverse_path.append(root.val) 
    self.inorder(root.right) 

def postorder(self, root):
	if root:
 		self.postorder(root.left) 
    self.postorder(root.right) 
    self.traverse_path.append(root.val) 

```



二叉搜索树(Binary Search Tree)

也称有序二叉树(Ordered Binary Tree)、 排序二叉树(Sorted Binary Tree)，是指一棵空树或者具有下列性质的 二叉树:

1. 左子树上所有结点的值均小于它的根结点的值;
2. 右子树上所有结点的值均大于它的根结点的值;
3. 以此类推:左、右子树也分别为二叉查找树。

中序遍历:升序排列

递归 Recursion 

```python
def recursion(level, param1, param2, ...): 
  # recursion terminator
	if level > MAX_LEVEL:
    process_result
		return
  # process logic in current level
	process(level, data...) 
  # drill down
	self.recursion(level + 1, p1, ...)
	# reverse the current level status if needed
```





二叉树遍历 

1. 前序(Pre-order): 根-左-右
2. 中序(In-order): 左-根-右 
3. 后序(Post-order): 左-右-根 

示例代码 

```python
def preorder(self, root):
	if root:
	 	self.traverse_path.append(root.val) 
		self.preorder(root.left) 
		self.preorder(root.right) 

def inorder(self, root):
	if root:
 		self.inorder(root.left) 
    self.traverse_path.append(root.val) 
    self.inorder(root.right) 

def postorder(self, root):
	if root:
 		self.postorder(root.left) 
    self.postorder(root.right) 
    self.traverse_path.append(root.val) 

```



二叉搜索树(Binary Search Tree)

也称有序二叉树(Ordered Binary Tree)、 排序二叉树(Sorted Binary Tree)，是指一棵空树或者具有下列性质的 二叉树:

1. 左子树上所有结点的值均小于它的根结点的值;
2. 右子树上所有结点的值均大于它的根结点的值;
3. 以此类推:左、右子树也分别为二叉查找树。

中序遍历:升序排列

递归 Recursion 

```python
def recursion(level, param1, param2, ...): 
  # recursion terminator
	if level > MAX_LEVEL:
    process_result
		return
  # process logic in current level
	process(level, data...) 
  # drill down
	self.recursion(level + 1, p1, ...)
	# reverse the current level status if needed
```



