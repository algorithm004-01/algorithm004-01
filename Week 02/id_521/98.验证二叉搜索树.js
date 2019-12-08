/*
 * @lc app=leetcode.cn id=98 lang=javascript
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isValidBST = function(root) {
    function helper(root, lower, upper) {
        //stop 
        if(root === null) return true
 
        //loginc
        let val = root.val
        if(lower !== null && val <= lower) return false
        if(upper !== null && val >= upper) return false
        
        //drill down
        // 左子节点上界为直接父节点， 下界为往上找，找到第一节点是另一节点的右节点，这个另一个节点就是下界。
        /**
         *              10
         *                \
         *                 15
         *                /
         *               12
         *              /
         *             11
         *   11的上界为12， 下界为10，因为15及其之后的节点都要比10大，即(10< ? < X) 找的轨迹就是
         *    
         *               \
         *               /
         *              /
         *             /
         *
         */
        if(!helper(root.left, lower , val)) return false 
        
        if(!helper(root.right, val, upper)) return false
        // 右子节点上界为直接父节点， 上界为找到的第一个节点是另一个节点的左子节点， 这个另一个节点就是上界
        /**
         *                  15
         *                  / 
         *                 12
         *                   \
         *                    13
         *                     \ 
         *                      14
         * 14的下界为13， 上界为15， 因为15的左边节点都要小于它， ( X<?<15 ), 找的轨迹就是
         *   
         * 
         *                    /
         *                    \
         *                     \
         *                      \
         *     
         */

         return true
        
    }
    
    return helper(root, null, null)

};
// @lc code=end

