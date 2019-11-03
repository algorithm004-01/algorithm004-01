<!--
 * @Description: This is a description
 * @Author: Ask
 * @LastEditors: Ask
 * @Date: 2019-10-07 19:58:38
 * @LastEditTime: 2019-10-27 19:40:36
 -->

# NOTE
本周最大的收获就是递归的套路化

1.树的面试题解法一般都是递归,为什么?
由树的数据结构决定,子树和整树的结构一致. 最小子树的解合在一起就是整个树的解,和递归的实现思路大致一致.


泛型递归

```javascript
function recursion() {
  // 1.递归终止条件 recursion terminator
  // 2.执行内容 process logic in current level
  // 3.执行继续往下递归 drill down
  // 4.重置状态值之类 revert state if needed
}
// demo
function main(str) {
  let newStr = "";
  let recursion = (str, index) => {
    // 1.递归终止条件 recursion terminator
    if(index === str.length) return;
    // 2.执行内容 process logic in current level
    newStr += str.charAt(index).toUpperCase();
    // 3.执行继续往下递归 drill down
    recursion(str, ++index);
    // 4.重置状态值之类 revert state if needed
  };
  recursion(str, 0);
  return newStr
}

let str = 'asdfkl';
console.log(main(str));
```
