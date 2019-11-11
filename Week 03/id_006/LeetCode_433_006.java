package com.mrglint.leetcode.week03.solution433;

import java.util.*;

/**
 * @author luhuancheng
 * @since 2019-10-31 08:37
 */
public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        // 建立基因字典 ["A", "C", "G", "T"]
        char[] mutationMeta = new char[]{'A', 'C', 'G', 'T'};
        // 建立基因库映射，方便查看变异基因是否存在于基因库
        Map<String, Boolean> geneMap = new HashMap<>(bank.length);
        for (String s : bank) {
            geneMap.put(s, true);
        }
        Set<String> known = new HashSet<>();

        int mutationCount = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        known.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String queueHead = queue.poll();
                if (Objects.equals(queueHead, end)) {
                    return mutationCount;
                }
                // 进行变异
                for (int i = 0; i < queueHead.length(); i++) {
                    for (char c : mutationMeta) {
                        char[] chars = queueHead.toCharArray();
                        if (chars[i] != c) {
                            chars[i] = c;
                            String mutationGene = new String(chars);
                            if (geneMap.containsKey(mutationGene) && !known.contains(mutationGene)) {
                                queue.offer(mutationGene);
                                known.add(mutationGene);
                            }
                        }
                    }
                }
            }
            mutationCount++;
        }
        return -1;
    }

    public static void main(String[] args) {
        /**
         * "AACCGGTT"
         * "AACCGCTA"
         * ["AACCGGTA","AACCGCTA","AAACGGTA"]
         */
        Solution solution = new Solution();
        System.out.println(solution.minMutation("AACCGGTT", "AACCGCTA", new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
    }
}

