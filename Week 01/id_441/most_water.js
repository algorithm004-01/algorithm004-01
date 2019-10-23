// 盛水最多的容器
// O(n^2)
function Solution(arr) {
    const max = 0;
    for (let i = 0; i < arr.length; i++) {
        for (let j = i + 1; j < arr.length; j++) {
            let area;
            if (arr[i] < arr[j]) {
                area = arr[i] * (j - i)
            } else {
                area = arr[j] * (j - i)
            }
            max < area ? max = area : max
        }
    }
    return max
}
// O(n)
// 此种解法其实目的就是找出宽度最宽，高度最高的两个值；
// 因为是首位指针所以宽度肯定是最宽的
// 接下来就是循环找出高度比边界要高的值，才有可能是面积最大的（因为边界的宽度是最宽的）
// 所以通过这个方法能找出面积最大的情况，而由于每次最大的面积都会记录下来所以不会漏掉面积最大的值
// 左右夹逼得办法
const arr = [6, 8, 6, 2, 5, 4, 8, 3, 7]
const maxArea = (arr) => {
    let max = 0;
    console.log(arr)
    for (let i = 0, j = arr.length - 1; i < j;) {
        const minHeight = arr[i] < arr[j] ? arr[i++] : arr[j--]
        console.log(i, j)
        const width = j - i + 1
        console.log(width, 'width')
        const area = minHeight * width
        console.log(area)
        max = max < area ? area : max
    };
    return max
}
console.log(maxArea(arr))