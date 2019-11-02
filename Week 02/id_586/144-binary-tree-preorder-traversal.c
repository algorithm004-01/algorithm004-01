/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
#if 0
int treesize(struct TreeNode *root) {
    if (!root) return 0;

    return treesize(root->left) + treesize(root->right) + 1;
}
void preorder(struct TreeNode *root, int *arry, int *size) {
    if (!root) return;

    arry[(*size)++] = root->val;
    preorder(root->left, arry, size);
    preorder(root->right, arry, size);
}
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* preorderTraversal(struct TreeNode* root, int* returnSize){
    int size = treesize(root);
    int *arry = malloc(sizeof(int) * (size + 1));
    *returnSize = 0;
    preorder(root, arry, returnSize);
    return arry;
}

#else
int* preorderTraversal(struct TreeNode* root, int* returnSize){

    struct TreeNode **stack = malloc(sizeof(struct TreeNode*));
    int len = 0;
    int *ret = NULL;

    *returnSize = 0;

    while (len > 0 || root != NULL) {
        if (root) {
            /* 操作数据 */
            ret = (int *) realloc(ret, sizeof(int) * (*returnSize + 1));
            ret[*returnSize] = root->val;
            *returnSize += 1;

            /*stack push*/
            stack = (struct TreeNode **) realloc(stack, sizeof(struct TreeNode*) * (len + 1));
            stack[len++] = root;
            root = root->left;
        } else {
            /*stack pop */
            root = stack[--len];
            root = root->right;
        }
    }
    
    return ret;
}
#endif