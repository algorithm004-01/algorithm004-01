package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/11/6
 */
public class NQueens {
//    public List<List<String>> solveNQueens(int n) {
//        List<List<String>> result = new ArrayList<>();
//        for (int i = 0; i < n; i++)
//            traversal(result, new ArrayList<String>(), n, i, 1);
//        return result;
//    }
//
//    private void traversal(List<List<String>> result, List<String> list, int n, int offset, int level){
//        list.add(setQueen(n, offset));
//        //判断是否能够攻击到前面已经摆放好的皇后
//        if(canAttack(list, n, offset)) return;
//        if(level == n) {result.add(new ArrayList<>(list)); return;};
//        for (int i = 0; i < n; i++) {
//            traversal(result, list, n, i, level + 1);
//            list.remove(list.size() - 1);
//        }
//    }
//
//    private boolean canAttack(List<String> list, int n, int offset) {
//        int count = 0;
//        for (int i = list.size() - 2; i >= 0; i--){
//            count += 1;
//            String tmp = list.get(i);
//            if (tmp.charAt(offset) == 'Q') return true;
//            if ((offset - count) >= 0 && tmp.charAt(offset - count) == 'Q') return true;
//            if ((offset + count) < n && tmp.charAt(offset + count) == 'Q') return true;
//        }
//        return false;
//    }
//
//    private String setQueen(int n, int offset){
//        StringBuilder str = new StringBuilder();
//        for (int i = 0; i < n; i++) {
//            if (i == offset) str.append('Q');
//            else str.append('.');
//        }
//        return str.toString();
//    }
}
