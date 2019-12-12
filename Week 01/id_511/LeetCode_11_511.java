package id_511;

/**
 * @version 1.0
 * @Description: 盛水最多的容器
 * @author: bingyu
 * @date: 2019/10/19 19:03
 */
public class LeetCode_11_511 {

    //方法一：自己的解决思路：其实就是求得长和宽的面积哪个最大，我们遍历每个数字，并让这个数字其它每个数字组和成一个面积，然后取最大的那一个
    //嵌套循环，时间复杂度是O(n^2)
    public static int getMaxArea(int[] arr){
        int maxArea = 0;
        for (int i = 0;i < arr.length - 1;++i) { //i控制左数字遍历(注意这里需要控制好边界)
            for (int j = i + 1;j < arr.length;++j) { //j是控制右数字遍历
                int area = (j - i) * getMinHeigh(arr,i,j); //这里j是始终大于i的
                maxArea = getMax(maxArea,area);
            }
        }
        return maxArea;
    }

    public static int getMax(int maxArea, int area) {
        if (maxArea < area) {
            maxArea = area;
        }
        return maxArea;
    }

    //选择其中最小的一个高
    public static int getMinHeigh(int[] arr, int i, int j) {
        return (arr[i] > arr[j]) ? arr[j] : arr[i];
    }

    //思路：左右边界，向中间逼近，即用最左边和最右边的柱子，然后向中间移动，当遇到比现在的柱子还要高的柱子时计算面积比较大小，直到两根柱子碰到一起
    //时间复杂度O(n)
    public static int maxArea(int[] arr){
        int height = getMinHeigh(arr,0,arr.length-1); //两边界的高度
        int maxArea = height * (arr.length - 1);  //两边界形成的面积
        for (int i = 0,j = arr.length - 1;i < j;) { //i代表最左边的柱子，j代表最右边的柱子
            int minHeight = getMinHeigh(arr,i,j); //这里第一次计算就是两边界容器的高度
            int length = j - i; //当前容器的长
            if (height < minHeight && maxArea < minHeight * length) { //如果当前高度大于两边界容器的高度,并且计算的面积也要比之前的面积大，赋值给maxArea
                height = minHeight; //注意这里height始终用边界容器的高度比较
                maxArea = minHeight * length;
            }
            if (arr[i] > arr[j]) { //当等到左边界向中间移动至大于右边界时，右边界再开始向中间移动(该题的重点)
                j--;
            }else {
                i++;
            }
        }
        return maxArea;
    }

    //覃超老师的解法
    public static int maxArea2(int[] arr) {
        int max = 0;
        for (int i = 0, j = arr.length - 1; i < j; ) {
            int minHeight = arr[i] < arr[j] ? arr[i++] : arr[j--];
            //这里有一个重要的细节就是，当等到左边界向中间移动至大于右边界时，右边界才开始向中间移动,为什么要这样做?
            // 因为容器的大小取决于小的那一个数字，如果开始左边界小于右边界，右边界就开始移动，就算下一个比右边界大，但是容器的大小仍取决于小的左边界没有任何意义，
            // 所以只有等到左边界的高度大于右边界的高度时，右边界再向中间移动才会有意义
            int area = (j - i + 1) * minHeight; //计算area = [ j - i + 1] * minheight时，这里之所以要加1，是因为上一步操作将i++或者j--了
            max = Math.max(max,area);
        }
        return max;
    }

    public static void main(String[] args) {
        //int[] arr = {1,8,6,2,5,4,8,3,7};
        int[] arr = {2,3,4,5,18,17,6};
        int maxArea = maxArea(arr);
        System.out.println(maxArea);
    }




}
