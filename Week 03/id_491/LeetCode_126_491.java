class Solution {
    private Set<String> visited = new HashSet<>();
    private List<List<String>> stepList = new ArrayList<>();
    private List<List<String>> stepListEnd = new ArrayList<>();
    private Set<String> wordListSet;
    private int min = 0;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        wordListSet = new HashSet<>(wordList);
        if (!wordList.contains(endWord)) {
            return this.stepList;
        }

        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        stepList.add(temp);

        List<String> tempEnd = new ArrayList<>();
        tempEnd.add(endWord);
        stepListEnd.add(tempEnd);

        for (int k = 0; k < beginWord.length(); k++) {
            if (beginWord.charAt(k) != endWord.charAt(k)) {
                this.min++;
            }
        }

        mutation(wordList, 0, 0);
        return stepList;
    }

    private boolean found(int begin, int end) {

        if (begin + end < this.min) {
            return false;
        }

        boolean foundResult = false;
        List<List<String>> foundList = new ArrayList<>();
        for (int i = 0; i < stepList.size(); i++) {
            String beginWord = stepList.get(i).get(begin);
            for (int j = 0; j < stepListEnd.size(); j++) {
                String endWord = stepListEnd.get(j).get(end);
                if (beginWord.equals(endWord)) {
                    List<String> tempFound = new ArrayList<>();
                    tempFound.addAll(stepList.get(i));
                    if (stepListEnd.get(j).size() > 1) {
                        for (int a = stepListEnd.get(j).size() - 2; a >= 0; a--) {
                            tempFound.add(stepListEnd.get(j).get(a));
                        }
                    }

                    foundList.add(tempFound);
                    foundResult = true;
                }
            }
        }

        if (foundList.size() > 0) {
            this.stepList = foundList;
        }

        return foundResult;
    }

    public void mutation(List<String> wordList, int stepBegin, int stepEnd) {
        List<List<String>> tempSteps = new ArrayList<>();
        boolean foundResult = this.found(stepBegin, stepEnd);
        if (foundResult) {
            return;
        } else {
            if (stepBegin <= stepEnd) {
                for (int i = 0; i < stepList.size(); i++) {
                    char[] chars = stepList.get(i).get(stepBegin).toCharArray();
                    for (int j = 0; j < chars.length; j++) {
                        chars = stepList.get(i).get(stepBegin).toCharArray();
                        for (char ch = 'a'; ch <= 'z'; ch++) {
                            chars[j] = ch;
                            String tmp = new String(chars);
                            if (wordListSet.contains(tmp)) {
                                if (visited.contains(tmp)) {
                                    continue;
                                }
                                List<String> tempTemp = new ArrayList<String>(stepList.get(i));
                                tempTemp.add(tmp);
                                tempSteps.add(tempTemp);
                            }
                        }
                    }
                    visited.add(stepList.get(i).get(stepBegin));
                }
                stepList = tempSteps;
                if (tempSteps.size() == 0 || stepBegin + 1 > wordList.size()) {
                    return;
                }

                stepBegin++;
            } else {
                for (int i = 0; i < stepListEnd.size(); i++) {
                    char[] chars = stepListEnd.get(i).get(stepEnd).toCharArray();
                    for (int j = 0; j < chars.length; j++) {
                        chars = stepListEnd.get(i).get(stepEnd).toCharArray();
                        for (char ch = 'a'; ch <= 'z'; ch++) {
                            chars[j] = ch;
                            String tmp = new String(chars);
                            if (wordListSet.contains(tmp)) {
                                if (visited.contains(tmp)) {
                                    continue;
                                }

                                List<String> tempTemp = new ArrayList<String>(stepListEnd.get(i));
                                tempTemp.add(tmp);
                                tempSteps.add(tempTemp);
                            }
                        }
                    }
                    visited.add(stepListEnd.get(i).get(stepEnd));
                }
                stepListEnd = tempSteps;
                if (tempSteps.size() == 0 || stepEnd + 1 > wordList.size()) {
                    return;
                }

                stepEnd++;
            }

            mutation(wordList, stepBegin, stepEnd);
        }
    }
}
