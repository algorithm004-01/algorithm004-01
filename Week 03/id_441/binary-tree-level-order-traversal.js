// https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description
// 二叉树的层次遍历
// 1.广度优先遍历
var levelOrder = function (root) {
    if (!root) return []
    let res = [],
        queue = [root]
    while (queue.length) {
        let arr = [],
            nextNode = []
        while (queue.length) {
            let curr = queue.shift()
            arr.push(curr.val)
            if (curr.left) nextNode.push(curr.left)
            if (curr.right) nextNode.push(curr.right)
        }
        queue = nextNode
        res.push(arr)
    }
    return res
}
//2.深度优先遍历，记录每一层来进行访问
var levelOrder = function (root) {
    if(!root) return [];
    const result = [];
    return levelOrder([root.left,root.right])
}

function serach(layers,node,k) {
    if(node === null) return ;
    if(!layers[k]){
        layers[k] = [node.val]
    }else{
        layers[k].push(node.val)
    }
    serach(layers, node.left, k+1)
    serach(layers, node.right, k+1)
}
