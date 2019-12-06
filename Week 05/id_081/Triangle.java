import java.util.List;


public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = triangle;
        for(int i = triangle.size() - 1; i > 0; i--) {
            for(int j = 1; j < triangle.get(i).size(); j++) {
                triangle.get(i - 1).set(j / 2, triangle.get(i -1).get(j / 2) + Math.min(triangle.get(i).get(j), triangle.get(i).get(j - 1)));
            }
        }

        return dp.get(0).get(0);
    }

}