package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 潘磊明
 * @date 2019/12/5
 */
public class RelativeSortArray {
//    public int[] relativeSortArray(int[] arr1, int[] arr2) {
//        List<Integer> list1 = new ArrayList<>();
//        List<Integer> list2 = new ArrayList<>();
//        int[] arr = new int[arr1.length];
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < arr1.length; i++) {
//            if(!map.containsKey(arr1[i])) map.put(arr1[i], new ArrayList<>());
//            map.get(arr1[i]).add(arr1[i]);
//        }
//        for (int i = 0; i < arr2.length; i++) {
//            list1.addAll(map.get(arr2[i]));
//            map.remove(arr2[i]);
//        }
//        for (List<Integer> list : map.values()) {
//            list2.addAll(list);
//        }
//        Collections.sort(list2);
//        for(int i = 0; i < list1.size(); i++) {
//            arr[i] = list1.get(i);
//        }
//        for (int i = 0; i < list2.size(); i++) {
//            arr[list1.size() + i] = list2.get(i);
//        }
//        return arr;
//    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] array = new int[1001];
        for(int i : arr1) array[i]++;
        int tmp = 0;
        for (int i : arr2) {
            while(array[i] != 0) {
                arr1[tmp] = i;
                array[i]--;
                tmp++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) continue;
            while (array[i] != 0) {
                arr1[tmp] = i;
                array[i]--;
                tmp++;
            }
        }
        return arr1;
    }
}
