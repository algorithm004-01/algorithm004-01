package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author 潘磊明
 * @date 2019/12/6
 */
public class Leaderboard {
    Map<Integer, List<Integer>> scoreMap;
    Map<Integer, Integer> playerMap;

    public Leaderboard() {
        scoreMap = new TreeMap<>(new MyComparator());
        playerMap = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        if (playerMap.containsKey(playerId)) {
            Integer lastScore = playerMap.get(playerId);
            Integer newScore = score + lastScore;
            playerMap.put(playerId, newScore);
            List<Integer> playerList = scoreMap.get(lastScore);
            Integer newPlayerId = playerId;
            playerList.remove(newPlayerId);
            List<Integer> newPlayerList = scoreMap.getOrDefault(newScore, new ArrayList<>());
            newPlayerList.add(playerId);
            scoreMap.put(newScore, newPlayerList);
        } else {
            playerMap.put(playerId, score);
            List<Integer> playerList = scoreMap.getOrDefault(score, new ArrayList<>());
            playerList.add(playerId);
            scoreMap.put(score, playerList);
        }
    }

    public int top(int K) {
        int res = 0;
        for (Map.Entry<Integer, List<Integer>> entry : scoreMap.entrySet()) {
            List<Integer> playerList = entry.getValue();
            if (K > 0) {
                if (playerList.size() < K) {
                    res += playerList.size() * entry.getKey();
                    K -= playerList.size();
                } else {
                    res += entry.getKey() * K;
                    K = 0;
                }
            } else {
                break;
            }
        }
        return res;
    }

    public void reset(int playerId) {
        Integer score = playerMap.get(playerId);
        playerMap.put(playerId, 0);
//        playerMap.remove(playerId);
        List<Integer> playerList = scoreMap.get(score);
        Integer newPlayerId = playerId;
        playerList.remove(newPlayerId);
        if (playerList.isEmpty()) {
            scoreMap.remove(score);
        }
        List<Integer> newPlayerList = scoreMap.getOrDefault(0, new ArrayList<>());
        newPlayerList.add(newPlayerId);
        scoreMap.put(0, newPlayerList);
    }
}

class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer i1, Integer i2) {
        return i2 - i1;
    }

}
