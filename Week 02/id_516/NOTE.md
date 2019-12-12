# 第二周学习笔记

## 哈希表、映射、集合

> 散列表，通过升纬来获取更好的查询性能
>
> 如何散列做得好 -> hashCode 这个方法就需要 （减少哈希碰撞） 拉链式
>
> 退化链表





## 树、二叉树、二叉搜索树

> 查看脑图



## 递归

> 特殊的一种循环（通过函数体来进行的循环）
>
> 不断地循环某一条指令
>
> 系统做了个调用栈

1. 不要人肉递归
2. 最近重复子问题
3. 数学归纳法思维

### 模板

```java
public void recur(int level,Object param) {
  // terminated
  if (level > MAX_LEVEL) {
    return ;
  } 
  // process current logic
  process(level,param);
    
  // drill down
  recur(level + 1,param);
  
  // **restore current status**
}
```





### 形象记忆

> 盗梦空间
>
> 将上层的需要的信息带入下一层（互不干扰的世界），最后也需要将状态进行复原。
>
> 树
>
> 从程序开始时，就是不断的往下生成树（多种不同可能）。 （分治，剪枝）



### 最近重复性（分治、回溯）

> 分治：子问题
>
> 回溯：去实验



```java
public void divideConquer(Object problem,Object param) {
  // terminated
  if (problem == null) {
    return;
  }
  
  // prepare data
  Object data = prepareData(problem);
  Collection<Object> subProlems = splitProblem(problem,data);
  Collction<Object> subResults = new LinkedList<>();
  // process and add to subResults
  subProblems.forEach(i-> {
    processResult(i,param,subResults);
  });
  
  Object result = handleResult(subResults);
  
  // ** revert current level states **
  
}
```



### 最优重复性 （动态规划）

> 动态规划 剪枝？

















## 点评

1. https://github.com/algorithm004-01/algorithm004-01/issues/392

   > 对于递归代码，若试图想清楚整个递和归的过程，实际上是进入一个**思维误区**，而具体做法为，如果一个问题A可以分解为若干个子问题B、C、D，可以假设子问题B、C、D已经解决。而且，只需要思考问题A和子问题B、C、D两层之间的**关系**即可，不需要一层层往下思考子问题与子子问题，子子问题与子子子问题之间的关系。屏蔽掉递归细节，这样理解起来就简单多了。
   > 因此，理解递归代码，就把它抽象成一个递推公式，不用想一层层的调用关系，不要试图用人脑去分解递归的每个步骤。

   这段话结合让我有点明白 **不要人肉递归**的大概含义了。

2. https://github.com/algorithm004-01/algorithm004-01/issues/438

   他的总结点比较全，有空可以按照这个去拓展一下

3. https://github.com/algorithm004-01/algorithm004-01/pull/419/files

   Mark 他的map数据结构，下周回来再看。

4. https://github.com/algorithm004-01/algorithm004-01/pull/429/files

   ```java
   /**
    * BinaryTreeInorderTraversal
    */
   public class BinaryTreeInorderTraversal {
       public List<Integer> inorderTraversal(TreeNode root) {
           List<Integer> list = new ArrayList()<>();
           Stack<TreeNode> stack = new Stack()<>();
           TreeNode cur = root;
           while(cur!=null || !stack.isEmpty()){
               if(cur != null){
                   stack.push(cur);
                   cur = cur.left;
               }else{
                   TreeNode node = stack.pop();
                   list.add(node.val);
                   cur = node.right;
               }
           }
           return list;
       }
   } 
   ```

   > 这里的Stack可用Deque来替代。
   >
   > 且用栈的方式会有爆栈的风险，虽然递归也有，但递归空间复杂度小。

5. https://github.com/algorithm004-01/algorithm004-01/pull/390/files

   ```java
   private enum CommandCode {
           READ, TRAVERSAL
       }
   
       private static class Command {
           CommandCode code;
           TreeNode node;
           Command(CommandCode code, TreeNode node) {
               this.code = code;
               this.node = node;
           }
       }
   
       private void traversal5(TreeNode root, List<Integer> store) {
           if (root == null) {
               return;
           }
           LinkedList<Command> stack = new LinkedList<>();
           stack.push(new Command(CommandCode.TRAVERSAL, root));
           while (!stack.isEmpty()) {
               Command command = stack.pop();
               TreeNode node = command.node;
               switch (command.code) {
                   case READ:
                       store.add(node.val);
                       break;
                   case TRAVERSAL:
                       if (node.right != null) {
                           stack.push(new Command(CommandCode.TRAVERSAL, node.right));
                       }
                       if (node.left != null) {
                           stack.push(new Command(CommandCode.TRAVERSAL, node.left));
                       }
                       stack.push(new Command(CommandCode.READ, node));
               }
           }
       }
   ```

   > 用栈的方式去做了个前序遍历，代码虽然长，但是还是很清晰的。











## 感想



这周有点忙活，周内并没有充分的利用时间。而且这个递归也是自己比较晕的类型，属于老师说的那种新手，下周重复做题时希望自己能刻意练习将这个难关攻克。

  

