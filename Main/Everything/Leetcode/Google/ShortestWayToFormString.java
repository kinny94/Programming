import java.util.HashSet;
import java.util.Set;

class ShortestWayToFormStirng {
    public int shortestWay(String source, String target) {
        char[] cs = source.toCharArray(), ts = target.toCharArray();
        int[][] idx = new int[cs.length][26];
        idx[cs.length - 1][cs[cs.length - 1] - 'a'] = cs.length; 
        for (int i = cs.length - 2; i >= 0; i--) {
            idx[i] = Arrays.copyOf(idx[i + 1],26);
            idx[i][cs[i] - 'a'] = i + 1; 
        }
        int j = 0, res = 1;
        for (int i = 0; i < ts.length; i++) {
            if (j == cs.length) {
                j = 0;
                res++;
            }
            j = idx[j][ts[i] - 'a'];
            if (idx[0][ts[i] - 'a'] == 0) return -1;
            if (j == 0) {
                res++;
                i--;
            }
        }
        return res;
    }
}