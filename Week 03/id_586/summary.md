# DFS, BFS and Binary Search

- 深度优先搜索（DFS）

在这个策略中，我们采用深度作为优先级，以便从跟开始一直到达某个确定的叶子，然后再返回根到达另一个分支。

深度优先搜索策略又可以根据根节点、左孩子和右孩子的相对顺序被细分为先序遍历，中序遍历和后序遍历。

- 宽度优先搜索（BFS）

我们按照高度顺序一层一层的访问整棵树，高层次的节点将会比低层次的节点先被访问到

```python
# DFS 代码模板
# 递归写法
visited = set()

def dfs(node, visited):
    if node in visited: # terminator
        # already visited
        return

    visited.add(node)

    # process current node here.

    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node, visited)

# 非递归写法
def DFS(self, tree):

    if tree.root is None:
        return []

    visited, stack = [], [tree.root]

    while stack:
        node = stack.pop()
        visited.add(node)

        process (node)
        nodes = generate_related_nodes(node)
        stack.push(nodes)

    # other processing work

#BFS 代码模板
def BFS(graph, start, end):

    queue = []
    queue.append([start])
    visited.add(start)

    while queue:
        node = queue.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)

    # other processing work

# 二分查找代码模板
def bs(array, target):
    left, right = 0, len(array) - 1
    while left <= right:
        # mid = left + (right - left) / 2
        mid = (left + right) / 2
        if array[mid] == target:
            # find the target!!
            break or return result
        elif array[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
```

## 102 二叉树的层次遍历

给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如: 给定二叉树: [3,9,20,null,null,15,7]

     3
    / \
    9  20
      /  \
     15   7

返回其层次遍历结果：

    [
        [3],
        [9,20],
        [15,7]
    ]

```CPP
/*
 * 方法1 ： 使用迭代法，使遍历的元素借用一个队列更方便
 * /
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ret;

        if (!root) return ret;

        queue<TreeNode*> q;
        TreeNode *curr;

        q.push(root);

        while(q.empty() == 0) {
            vector<int> level;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                curr = q.front();
                level.push_back(curr->val);
                q.pop();
                if (curr->left) q.push(curr->left);
                if (curr->right) q.push(curr->right);
            }
            ret.push_back(level);
        }

        return ret;
    }
};

/*
 * 方法2： 使用递归的方法
 * */
class Solution {
public:
    vector<vector<int>> ret;

    void buildVector(TreeNode *root, int depth)
    {
        if(root == NULL) return;
        /* start the current level */
        if(ret.size() == depth)
            ret.push_back(vector<int>());

        /* fulfil the current level */
        ret[depth].push_back(root->val);

        /* process child nodes for the next level */
        buildVector(root->left, depth + 1);
        buildVector(root->right, depth + 1);
    }

    vector<vector<int> > levelOrder(TreeNode *root) {
        buildVector(root, 0);
        return ret;
    }
}；
```

## 433. 最小基因变化

一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。

注意:

    起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
    所有的目标基因序列必须是合法的。
    假定起始基因序列与目标基因序列是不一样的。

示例 1:

    start: "AACCGGTT"
    end:   "AACCGGTA"
    bank: ["AACCGGTA"]
    返回值: 1

示例 2:

    start: "AACCGGTT"
    end:   "AAACGGTA"
    bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
    返回值: 2

示例 3:

    start: "AAAAACCC"
    end:   "AACCCCCC"
    bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
    返回值: 3

```cpp
class Solution1 {
public:
    //解法1：单向bfs
    int minMutation(string start, string end, vector<string>& bank) {
        //1: 判读极端情况
        if(start.empty() || end.empty() || bank.empty()) return -1;

        if(find(bank.begin(), bank.end(), end) == bank.end())
            return -1; //目标基因不在基因库中

        //2: bfs的初始化工作: 初始化步长，初始化queue，将start入队列，用vecotr来标记已经访问过的点。
        vector<int> visit(bank.size(),0);
        int step=0;
        queue<string> q;
        q.push(start);

        //3: 进行bfs : 先将步长+1，然后确定每次bfs的长度size，寻找目标基因，然后出栈入栈等操作
        while (!q.empty()) {
            step++;
            int n = q.size();//确定每次bfs的宽度
            for (int i = 0; i < n; ++i) {
                string &temp = q.front(); q.pop();//获得队头元素
                for (int j = 0; j < bank.size(); ++j) {//遍历整个基因库,访问未标记的基因；找到某个字符变异的基因添加标记，并进入队列即可
                    if (visit[j] == 0) {
                        int diff = 0;
                        for (int k = 0; k < temp.size(); ++k)
                            if (temp[k] != bank[j][k]) diff++;

                        if (diff == 1) { //找到某个字符编译的基因
                            if (bank[j] == end) return step;//若该下标j代表的基因为目标基因，则直接返回步长
                            visit[j] = 1;//标记下标为j的基因已访问
                            q.push(bank[j]);
                        }
                    }
                }
            }
        }
        return -1;
    }
};

/*
 * - 由于单向bfs类似金字塔，越到底层，塔基越大（而众多塔基中只有一点end满足条件），而且其回溯路径也少。
 *   所以我们采用双向bfs,即既从begin->end遍历，又从end->begin遍历，当然每次我们都选用较短队列进行遍历，这样可减少用时。
 * - 循环结束的条件是两个bfs碰头。每个单词遍历的方向，1由前向后遍历，2由后向前遍历，3两个bfs碰头。
 *   公式：0|1=1、0|2=2、1|2=3和i&i=i、i&0=0
 * */
class Solution2 {
public:
    //解法2：双向bfs
    int minMutation(string start, string end, vector<string>& bank) {
        //1:建立hashmap表，顺便去掉重复元素
        unordered_map<string,int> mp;
        for (const auto& b : bank) mp[b] = 0;

        //2:排除极端情况，end不在基因库中
        if (mp.count(end) == 0) return -1;

        //3:bfs的初始化工作
        queue<string> q1({start}), q2({end});//前向队列，后向队列
        int step=0;
        const char table[4]={'A','C','G','T'};//基因的字符
        //或1表示前向队列由前往后遍历，或2表示后向队列由后向前遍历，每次我们选用较小的队列进行遍历
        for (mp[start] |= 1,mp[end] |= 2; q1.size() && q2.size(); ++step) {//每遍历完一次，步长+1
            bool first = q1.size() < q2.size();
            queue<string> &q = first ? q1 : q2;//选择较小的队列进行遍历节约时间
            int flag = first ? 1 : 2;//此次遍历的方式

            for (int n = q.size(); n--; q.pop()) {
                string& temp = q.front();
                if (mp[temp] == 3) return step; //两个队列碰头，返回步长
                for (int i = 0; i < temp.size(); ++i) {
                    for (int j = 0; j < 4; ++j) {
                        string s = temp;
                        if (s[i] == table[j]) continue; //重复字符，跳出循环，寻找下一个字符
                        s[i] = table[j];
                        //该单词不在map中或该单词已经被遍历过了，跳出循环，寻找下一个单词
                        if (mp.count(s) == 0 || mp[s] & flag) continue;
                        mp[s] |= flag;//标记该单词已经被遍历过了
                        q.push(s);
                    }
                }
            }
        }
        return -1;
    }
};
```

## 22 generate-parentheses

给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
例如，给出 n = 3，生成结果为：

    [
    "((()))",
    "(()())",
    "(())()",
    "()(())",
    "()()()"
    ]

```cpp
class Solution {
public:

    #if 1
    vector<string> generateParenthesis(int n) {
        vector<string> ret;
        generate(ret, "", 0, 0, n);
        return ret;
    }

    void generate(vector<string> &ans, string cur, int open, int close, int n) {
        if (cur.length() == n * 2) {
            ans.push_back(cur);
            return;
        }

        if (open < n)
            generate(ans, cur + "(", open + 1, close, n);
        if (close < open)
            generate(ans, cur + ")", open, close + 1, n);
    }
    #else
    vector<string> generateParenthesis(int n) {
        vector<string> ret;
        generate(ret, "", n, n);
        return ret;
    }

    void generate(vector<string> &ans, string cur, int left, int right) {
        if (left == 0 && right == 0) {
            ans.push_back(cur);
            return;
        }

        if (left > 0)
            generate(ans, cur + "(", left - 1, right);
        if (right > left)
            generate(ans, cur + ")", left, right - 1);
    }
    #endif
};
```

## 515. 在每个树行中找最大值

您需要在二叉树的每一行中找到最大的值。

输入:

          1
         / \
        3   2
       / \   \  
      5   3   9 
输出: [1, 3, 9]

```cpp
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    /* DFS solution */
    vector<int> solution;
    void helper(TreeNode* node, int cl) {
        if (node == NULL) return;

        if (solution.size() < cl + 1)
            solution.push_back(node->val);
        else {
            if (solution[cl] < node->val)
                solution[cl] = node->val;
        }
        helper(node->left, cl+1);
        helper(node->right, cl+1);
    }

    vector<int> largestValues(TreeNode* root) {
        if(root == NULL) return solution;

        helper(root, 0);
        return solution;
    }
};
```

## 126. 单词接龙 II

```cpp
class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> dict(wordList.begin(), wordList.end()), head, tail;
        if (dict.find(endWord) == dict.end()) {
            return {};
        }
        head.insert(beginWord);
        tail.insert(endWord);
        unordered_map<string, vector<string>> children;
        vector<vector<string>> ladders;
        vector<string> ladder;
        ladder.push_back(beginWord);
        if (searchLadders(head, tail, dict, children, false)) {
            genLadders(beginWord, endWord, children, ladder, ladders);
        }
        return ladders;
    }
private:
    bool searchLadders(unordered_set<string>& head, unordered_set<string>& tail, unordered_set<string>& dict, unordered_map<string, vector<string>>& children, bool flip) {
        if (head.empty()) {
            return false;
        }
        if (head.size() > tail.size()) {
            return searchLadders(tail, head, dict, children, !flip);
        }
        for (string word : head) {
            dict.erase(word);
        }
        for (string word : tail) {
            dict.erase(word);
        }
        unordered_set<string> intermediate;
        bool done = false;
        for (string word : head) {
            string temp = word;
            for (int i = 0; i < word.size(); i++) {
                char t = word[i];
                for (int j = 0; j < 26; j++) {
                    word[i] = 'a' + j;
                    if (tail.find(word) != tail.end()) {
                        done = true;
                        flip ? children[word].push_back(temp) : children[temp].push_back(word);
                    } else if (!done && dict.find(word) != dict.end()) {
                        intermediate.insert(word);
                        flip ? children[word].push_back(temp) : children[temp].push_back(word);
                    }
                }
                word[i] = t;
            }
        }
        return done || searchLadders(tail, intermediate, dict, children, !flip);
    }
    
    void genLadders(string beginWord, string endWord, unordered_map<string, vector<string>>& children, vector<string>& ladder, vector<vector<string>>& ladders) {
        if (beginWord == endWord) {
            ladders.push_back(ladder);
        } else {
            for (string child : children[beginWord]) {
                ladder.push_back(child);
                genLadders(child, endWord, children, ladder, ladders);
                ladder.pop_back();
            }
        }
    }
};
```
## 127. 单词接龙

给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

- 每次转换只能改变一个字母。
- 转换过程中的中间单词必须是字典中的单词。

说明:

    如果不存在这样的转换序列，返回 0。
    所有单词具有相同的长度。
    所有单词只由小写字母组成。
    字典中不存在重复的单词。
    你可以假设 beginWord 和 endWord 是非空的，且二者不相同。

示例 1:

    输入:
    beginWord = "hit",
    endWord = "cog",
    wordList = ["hot","dot","dog","lot","log","cog"]

    输出: 5

    解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
        返回它的长度 5。

示例 2:

    输入:
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log"]

    输出: 0

    解释: endWord "cog" 不在字典中，所以无法进行转换。

算法中最重要的步骤是找出相邻的节点，也就是只差一个字母的两个单词

This problem has a nice BFS structure. Let's illustrate this using the example in the problem statement.

    beginWord = "hit",
    endWord = "cog",
    wordList = ["hot","dot","dog","lot","log","cog"]

Since only one letter can be changed at a time, if we start from "hit", we can only change to those words which have exactly one letter different from it (in this case, "hot"). Putting in graph-theoretic terms, "hot" is a neighbor of "hit". The idea is simpy to start from the beginWord, then visit its neighbors, then the non-visited neighbors of its neighbors until we arrive at the endWord. This is a typical BFS structure.

```cpp
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> dict(wordList.begin(), wordList.end());
        queue<string> todo;
        todo.push(beginWord);
        int ladder = 1;
        while (!todo.empty()) {
            int n = todo.size();
            for (int i = 0; i < n; i++) {
                string word = todo.front();
                todo.pop();
                if (word == endWord) {
                    return ladder;
                }
                dict.erase(word);
                for (int j = 0; j < word.size(); j++) {
                    char c = word[j];
                    for (int k = 0; k < 26; k++) {
                        word[j] = 'a' + k;
                        if (dict.find(word) != dict.end()) {
                            todo.push(word);
                        }
                     }
                    word[j] = c;
                }
            }
            ladder++;
        }
        return 0;
    }
};
```

The above code starts from a single end beginWord. We may also start from the endWord simultaneously. Once we meet the same word, we are done. This link provides such a two-end search solution. I rewrite the code below for better readability. This solution uses two pointers phead and ptail to switch to the smaller set at each step to save time.

```cpp
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> dict(wordList.begin(), wordList.end()), head, tail, *phead, *ptail;
        if (dict.find(endWord) == dict.end()) {
            return 0;
        }
        head.insert(beginWord);
        tail.insert(endWord);
        int ladder = 2;
        while (!head.empty() && !tail.empty()) {
            if (head.size() < tail.size()) {
                phead = &head;
                ptail = &tail;
            } else {
                phead = &tail;
                ptail = &head;
            }
            unordered_set<string> temp;
            for (auto it = phead -> begin(); it != phead -> end(); it++) {
                string word = *it;
                for (int i = 0; i < word.size(); i++) {
                    char t = word[i];
                    for (int j = 0; j < 26; j++) {
                        word[i] = 'a' + j;
                        if (ptail -> find(word) != ptail -> end()) {
                            return ladder;
                        }
                        if (dict.find(word) != dict.end()) {
                            temp.insert(word);
                            dict.erase(word);
                        }
                    }
                    word[i] = t;
                }
            }
            ladder++;
            phead -> swap(temp);
        }
        return 0;
    }
};
```

## 529. 扫雷游戏

给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：

    如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
    如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
    如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
    如果在此次点击中，若无更多方块可被揭露，则返回面板。

示例 1：

    输入: 

    [['E', 'E', 'E', 'E', 'E'],
    ['E', 'E', 'M', 'E', 'E'],
    ['E', 'E', 'E', 'E', 'E'],
    ['E', 'E', 'E', 'E', 'E']]

    Click : [3,0]

    输出: 

    [['B', '1', 'E', '1', 'B'],
    ['B', '1', 'M', '1', 'B'],
    ['B', '1', '1', '1', 'B'],
    ['B', 'B', 'B', 'B', 'B']]


```CPP
class Solution {
public:
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        if(board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }
        reveal(board,click[0],click[1]);
        return board;
    }

    bool inboard(const vector<vector<char>>& board, int x, int y){
        return ( x>=0 && x<board.size() && y>=0 && y<board[0].size() );
    }

    void reveal(vector<vector<char>>& board, int x, int y){
        if(!inboard(board,x,y)) return;
        if(board[x][y] == 'E'){
            //search 8 adjacent squares
            int count = 0;
            if(inboard(board,x-1,y-1) && board[x-1][y-1] == 'M') count++;
            if(inboard(board,x-1,y  ) && board[x-1][y  ] == 'M') count++;
            if(inboard(board,x-1,y+1) && board[x-1][y+1] == 'M') count++;
            if(inboard(board,x  ,y-1) && board[x  ][y-1] == 'M') count++;
            if(inboard(board,x  ,y+1) && board[x  ][y+1] == 'M') count++;
            if(inboard(board,x+1,y-1) && board[x+1][y-1] == 'M') count++;
            if(inboard(board,x+1,y  ) && board[x+1][y  ] == 'M') count++;
            if(inboard(board,x+1,y+1) && board[x+1][y+1] == 'M') count++;

            if(count>0)
                board[x][y] = '0'+count;
            else{
                board[x][y] = 'B';
                reveal(board,x-1,y-1);
                reveal(board,x-1,y  );
                reveal(board,x-1,y+1);
                reveal(board,x  ,y-1);
                reveal(board,x  ,y+1);
                reveal(board,x+1,y-1);
                reveal(board,x+1,y  );
                reveal(board,x+1,y+1);
            }
        }
    }
};
```

## 200. 岛屿数量

给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

示例 1:

    输入:
    11110
    11010
    11000
    00000

    输出: 1

示例 2:

    输入:
    11000
    11000
    00100
    00011

    输出: 3

```cpp
/* 方法一：深度优先搜索
 *  线性扫描整个二维网格，如果一个结点包含 1，则以其为根结点启动深度优先搜索。
 *  在深度优先搜索过程中，每个访问过的结点被标记为 0。计数启动深度优先搜索的根结点的数量，
 *  即为岛屿的数量。
 */
class Solution1 {
private:
  void dfs(vector<vector<char>>& grid, int r, int c) {
    int nr = grid.size();
    int nc = grid[0].size();

    grid[r][c] = '0';
    if (r - 1 >= 0 && grid[r-1][c] == '1') dfs(grid, r - 1, c);
    if (r + 1 < nr && grid[r+1][c] == '1') dfs(grid, r + 1, c);
    if (c - 1 >= 0 && grid[r][c-1] == '1') dfs(grid, r, c - 1);
    if (c + 1 < nc && grid[r][c+1] == '1') dfs(grid, r, c + 1);
  }

public:
  int numIslands(vector<vector<char>>& grid) {
    int nr = grid.size();
    if (!nr) return 0;
    int nc = grid[0].size();

    int num_islands = 0;
    for (int r = 0; r < nr; ++r) {
      for (int c = 0; c < nc; ++c) {
        if (grid[r][c] == '1') {
          ++num_islands;
          dfs(grid, r, c);
        }
      }
    }

    return num_islands;
  }
};

/*
 * 方法二: 广度优先搜索
 *   线性扫描整个二维网格，如果一个结点包含 1，则以其为根结点启动广度优先搜索。
 *   将其放入队列中，并将值设为 0 以标记访问过该结点。迭代地搜索队列中的每个结点，
 *   直到队列为空。
 * */
class Solution2 {
public:
  int numIslands(vector<vector<char>>& grid) {
    int nr = grid.size();
    if (!nr) return 0;
    int nc = grid[0].size();

    int num_islands = 0;
    for (int r = 0; r < nr; ++r) {
      for (int c = 0; c < nc; ++c) {
        if (grid[r][c] == '1') {
          ++num_islands;
          grid[r][c] = '0'; // mark as visited
          queue<pair<int, int>> nei***ors;
          nei***ors.push({r, c});
          while (!nei***ors.empty()) {
            auto rc = nei***ors.front();
            nei***ors.pop();
            int row = rc.first, col = rc.second;
            if (row - 1 >= 0 && grid[row-1][col] == '1') {
              nei***ors.push({row-1, col}); grid[row-1][col] = '0';
            }
            if (row + 1 < nr && grid[row+1][col] == '1') {
              nei***ors.push({row+1, col}); grid[row+1][col] = '0';
            }
            if (col - 1 >= 0 && grid[row][col-1] == '1') {
              nei***ors.push({row, col-1}); grid[row][col-1] = '0';
            }
            if (col + 1 < nc && grid[row][col+1] == '1') {
              nei***ors.push({row, col+1}); grid[row][col+1] = '0';
            }
          }
        }
      }
    }

    return num_islands;
  }
};
```

## 322. 零钱兑换

给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

示例 1:

    输入: coins = [1, 2, 5], amount = 11
    输出: 3 
    解释: 11 = 5 + 5 + 1

示例 2:

    输入: coins = [2], amount = 3
    输出: -1

说明: 你可以认为每种硬币的数量是无限的。

```cpp
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        // int Max = amount + 1;
        // vector<int> dp(amount + 1, Max);
        // dp[0] = 0;
        // for (int i = 1; i <= amount; i++) {
        //     for (int j = 0; j < coins.size(); j++) {
        //         if (coins[j] <= i) {
        //             dp[i] = min(dp[i], dp[i - coins[j]] + 1);
        //         }
        //     }
        // }
        // return dp[amount] > amount ? -1 : dp[amount];

        vector<int> need(amount+1, amount+1);
        need[0] = 0;
        for (int c : coins)
            for (int a = c; a <= amount; a++)
                need[a] = min(need[a], need[a-c] + 1);
        return need.back() > amount ? -1 : need.back();
    }
};
```

## 455. 分发饼干

假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

注意：

    你可以假设胃口值为正。
    一个小朋友最多只能拥有一块饼干。

示例 1:

    输入: [1,2,3], [1,1]

    输出: 1

解释: 
    你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
    虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
    所以你应该输出1。

示例 2:

    输入: [1,2], [1,2,3]

    输出: 2

解释: 
    你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
    你拥有的饼干数量和尺寸都足以让所有孩子满足。
    所以你应该输出2.

```CPP
/*贪心问题。优先满足胃口小的小朋友的需求。
    1. 对 g 和 s 升序排序
    2. 初始化两个指针 i 和 j 分别指向 g 和 s 初始位置
    3. 对比 g[i] 和 s[j]
        g[i] <= s[j]：饼干满足胃口，把能满足的孩子数量加 1，并移动指针 i = i + 1，j = j + 1
        g[i] > s[j]：无法满足胃口，j 右移，继续查看下一块饼干是否可以满足胃口
*/
class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int g_length = g.size();
        int s_length = s.size();

        int i = 0;
        int j = 0;
        int res = 0;

        while (i < g_length && j < s_length) {
            if (g[i] <= s[j]) {
                //可以满足胃口，把小饼干喂给小朋友
                res += 1;
                i += 1;
                j += 1;
            } else
                //不满足胃口，查看下一块小饼干
                j += 1;
        }
        return res;
    }
};
```

## 122. 买卖股票的最佳时机 II

给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

    输入: [7,1,5,3,6,4]
    输出: 7
    解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
        随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 

```CPP
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.size(); i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
};
```

## 55. 跳跃游戏

给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个位置。

示例 1:

    输入: [2,3,1,1,4]
    输出: true
    解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。

示例 2:

    输入: [3,2,1,0,4]
    输出: false
    解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

```cpp
class Solution {
public:
    bool canJump(vector<int>& nums) {
        // int i = 0;
        // for (int reach = 0; i < nums.size() && i <= reach; ++i)
        //     reach = max(i + nums[i], reach);
        // return i == nums.size();

        if (nums.size() == 0) return false;
        int len = nums.size() - 1;
        for (int i = nums.size() - 1; i >= 0; i--)
            if (nums[i] + i >= len) len = i;
        return len == 0;
    }
};
```

## 860. 柠檬水找零

在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
注意，一开始你手头没有任何零钱。
如果你能给每位顾客正确找零，返回 true ，否则返回 false 。

示例 1：

    输入：[5,5,5,10,20]
    输出：true
    解释：
    前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
    第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
    第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
    由于所有客户都得到了正确的找零，所以我们输出 true。

示例 2：

    输入：[5,5,10]
    输出：true

示例 3：

    输入：[10,10]
    输出：false

示例 4：

    输入：[5,5,10,10,20]
    输出：false
    解释：
    前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
    对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
    对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
    由于不是每位顾客都得到了正确的找零，所以答案是 false。

提示：

    0 <= bills.length <= 10000
    bills[i] 不是 5 就是 10 或是 20

```cpp
/*
Count the number of $5 and $10 in hand.
if (customer pays with $5) five++;
if (customer pays with $10) ten++, five--;
if (customer pays with $20) ten--, five-- or five -= 3;
*/
class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) five--, ten++;
            else if (ten > 0) ten--, five--;
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }
};
```

## 69. x 的平方根

实现 int sqrt(int x) 函数。
计算并返回 x 的平方根，其中 x 是非负整数。
由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

    输入: 4
    输出: 2

示例 2:

    输入: 8
    输出: 2
    说明: 8 的平方根是 2.82842..., 
        由于返回类型是整数，小数部分将被舍去。

```cpp
class Solution {
public:
    int mySqrt(int x) {
        // 注意：针对特殊测试用例，例如 2147395599
        // 要把搜索的范围设置成长整型
        // 为了照顾到 0 把左边界设置为 0
        if (x == 0 || x == 1) return x;

        long left = 0;
        // # 为了照顾到 1 把右边界设置为 x // 2 + 1
        long right = x / 2 + 1;

        while (left < right) {
            // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
            long mid = left + (right - left + 1) / 2;
            //long mid = (left + right + 1) >> 1;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 因为一定存在，因此无需后处理
        return (int) left;
    }
};
```

## 33. 搜索旋转排序数组

假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
你可以假设数组中不存在重复的元素。
你的算法时间复杂度必须是 O(log n) 级别。

示例 1:

    输入: nums = [4,5,6,7,0,1,2], target = 0
    输出: 4

示例 2:

    输入: nums = [4,5,6,7,0,1,2], target = 3
    输出: -1

```cpp
class Solution {
public:
    int search(vector<int>& nums, int target) {
#ifdef OK
        int lo = 0, hi = nums.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            double num = (nums[mid] < nums[0]) == (target < nums[0])
                        ? nums[mid]
                        : target < nums[0] ? -INFINITY : INFINITY;

            if (num < target)
                lo = mid + 1;
            else if (num > target)
                hi = mid;
            else
                return mid;
        }
        return -1;
#else
        int lo=0,hi=nums.size()-1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(nums[mid]>nums[hi]) lo=mid+1;
            else hi=mid;
        }
        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot=lo;
        lo=0;hi=nums.size()-1;
        // The usual binary search and accounting for rotation.
        while(lo<=hi){
            int mid=(lo+hi)/2;
            int realmid=(mid+rot)%nums.size();
            if(nums[realmid]==target)return realmid;
            if(nums[realmid]<target)lo=mid+1;
            else hi=mid-1;
        }
        return -1;
#endif
    }
};
```