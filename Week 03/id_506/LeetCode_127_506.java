class Solution {

	int count = 0;

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {



		if (beginWord.length() == 0 || endWord.length() == 0 || wordList.size() == 0){
			return 0;
		}

		boolean result = false;
		for (String s: wordList) {

			if (s.equals(endWord)){
				result = true;
			}
		}

		if (!result){
			return 0;
		}


		return bfs(beginWord, endWord, wordList);

	}

    	public boolean isOne(String now, String next){

		if (now.length() != next.length()){
			return false;
		}

		char[] nowArray = now.toCharArray();
		char[] nextArray = next.toCharArray();
		int num = 0;
		for (int i = 0; i < now.length(); i++){

			if (nowArray[i] != nextArray[i]){
				num++;
			}
		}
		if (num == 1){
			return true;
		}
		return false;

	}

    int bfs(String start, String end, List<String> wordList){

		List<String> queue = new ArrayList<>();

		Set<String> visit = new HashSet<>();

		queue.add(start);
		visit.add(start);

		int step = 1;
		while (!queue.isEmpty()){
			step ++;

			List<String> now = new ArrayList<>();
			for (String s: queue) {
				now.add(s);
			}
			queue.clear();
			for (String tmp: now
			) {


				for (int i = 0; i < wordList.size(); i++) {

					if (!visit.contains(wordList.get(i))) {

						if (isOne(tmp, wordList.get(i))) {

							if (end.equals(wordList.get(i))) {
								return step;
							}

							queue.add(wordList.get(i));
							visit.add(wordList.get(i));

						}
					}
				}

			}


		}

		return 0;


	}


}