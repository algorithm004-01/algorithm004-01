/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

/*
 * 方法1：使用递归的方法进行处理
 *      - 由于要自己申请资源，所以在使用的时候要求出树的大小
 *      - 遍历给出的树： 中序遍历就是 把根节点放到 中间进行处理
 * */
int treesize(struct TreeNode* root){
    if(root == NULL)
        return 0;
    
    return (treesize(root->left) + treesize(root->right) + 1);
}

void inorder(struct TreeNode *root, int *arry, int *size)
{
    if (!root) return;

    inorder(root->left, arry, size);
    arry[(*size)++] = root->val;
    inorder(root->right, arry, size);
}

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* inorderTraversal(struct TreeNode* root, int* returnSize) {
    int size = treesize(root);
    *returnSize = 0;

    int *arry = malloc((size + 1) * sizeof(int));

    inorder(root, arry, returnSize);

    return arry;
}

/*
 * 方法2：使用栈进行优化
 *      - 用栈模拟函数调用的过程
 * */

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* inorderTraversal(struct TreeNode* root, int* returnSize) {
    
    int *result = NULL;
    *returnSize = 0;

    struct TreeNode **stack = (struct TreeNode **)malloc(sizeof(struct TreeNode *));
    int length = 0;

    while (length > 0 || root != NULL) {
        if (root) {
            /* Stack push*/
            stack = (struct TreeNode **)realloc(stack, sizeof(struct TreeNode *) * (length + 1));
            stack[length++] = root;

            root = root->left;
        } else {
            /* Stack pop */
            root = stack[--length];
            result = (int *)realloc(result, sizeof(int) * (*returnSize + 1));
            /* 操作数据 */
            result[*returnSize] = root->val;
            *returnSize += 1;

            root = root->right;
        }
    }

    return result;
}