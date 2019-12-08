//一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
//
// 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
//
// 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
//
// 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
//
// 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
//
// 注意:
//
//
// 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
// 所有的目标基因序列必须是合法的。
// 假定起始基因序列与目标基因序列是不一样的。
//
//
// 示例 1:
//
//
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//返回值: 1
//
//
// 示例 2:
//
//
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//返回值: 2
//
//
// 示例 3:
//
//
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//返回值: 3
//
//
package com.aseara.leetcode.editor.cn.a433;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 433.最小基因变化 <br />
 * Date: 2019/11/24 <br/>
 *
 * @author qiujingde
 */
class MinimumGeneticMutation {
    private Solution solution = new Solution();

    @Test
    void test1() {
        String start = "AAAAAAAA";
        String end = "CCCCCCCC";

        String[] bank = {"AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA","CCCCCCCC"};

        assertEquals(8, solution.minMutation(start, end, bank));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0) {
            return -1;
        }
        Set<String> dict = new HashSet<>(Arrays.asList(bank));

        Set<String> startSet = new HashSet<>();
        startSet.add(start);

        if (!dict.contains(end)) {
            return -1;
        }
        dict.remove(end);
        Set<String> endSet = new HashSet<>();
        endSet.add(end);

        char[] codes = {'A', 'C', 'G', 'T'};

        int step = 0;
        while (!startSet.isEmpty()) {
            step ++;
            Set<String> next = new HashSet<>();

            for (String gen : startSet) {
                char[] genCodes = gen.toCharArray();
                for (int i = 0; i < genCodes.length; i++) {
                    char curCode = genCodes[i];
                    for (char code : codes) {
                        if (code != curCode) {
                            genCodes[i] = code;
                            String newGen = new String(genCodes);
                            if (endSet.contains(newGen)) {
                                return step;
                            } else if (dict.contains(newGen)){
                                next.add(newGen);
                                dict.remove(newGen);
                            }
                        }
                    }
                    genCodes[i] = curCode;
                }
            }

            if (next.size() > endSet.size()) {
                startSet = endSet;
                endSet = next;
            } else {
                startSet = next;
            }
        }

        return -1;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
