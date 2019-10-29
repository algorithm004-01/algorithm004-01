class Solution:
    def inorderTraversal(self, root) -> list:
        data = []
        stack = []
        current = root
        # 需要注意current和stack同时为None的时候才能跳出循环
        while current or stack:
            while current:
                stack.append(current)
                current = current.left
            pop_node = stack.pop()
            data.append(pop_node.val)
            current = pop_node.right
        return data
