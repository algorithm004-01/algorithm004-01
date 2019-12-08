import java.util.Arrays;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-27 08:52
 **/

public class Leetcode_1121_371 {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, arr2 = {2, 1, 4, 3, 9, 6};
        int[] orderedArr = relativeSortArray(arr1, arr2);
        Arrays.stream(orderedArr).forEach(System.out::println);

    }

    /**
     * 原解1:选择排序
     *
     * @author Shaobo.Qian
     * @date 2019/11/27
     */
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        //0.边界判断

        //1.依次取出 arr2中的每个元素
        int orderedIndex = 0;//arr2中已排定元素的索引(0~orderedIndex,不包含orderedIndex)
        for (int i = 0; i < arr2.length; i++) {
            //2.将arr2当前元素在 arr1中的位置排定(双指针)
            for (int j = orderedIndex; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]) {
                    swap(orderedIndex, j, arr1);
                    orderedIndex++;
                }
            }
        }
        //3.将 arr1未在 arr2中的出现的元素排定
        if (orderedIndex < arr1.length) {
            Arrays.sort(arr1, orderedIndex, arr1.length);
        }
        return arr1;
    }

    private static void swap(int index, int j, int[] arr1) {
        int temp = arr1[index];
        arr1[index] = arr1[j];
        arr1[j] = temp;
    }
}
