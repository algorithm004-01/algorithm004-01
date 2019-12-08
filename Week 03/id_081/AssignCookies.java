/**
 * AssignCookies
 */
public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;

        int gIndex = 0;
        int sIndex = 0;

        while (gIndex < g.length && sIndex < s.length) {
            if (g[gIndex] <= s[sIndex]) {
                count++;
                gIndex++;
            }
            sIndex++;
        }
        return count;
    }
}