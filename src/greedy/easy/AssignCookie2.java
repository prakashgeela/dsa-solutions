package greedy.easy;

import java.util.Arrays;

public class AssignCookie2 {

    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        int maxCookie = 0;
        int gSize = g.length;
        int sSize = s.length;

        while (i < gSize && j < sSize) {
            if (s[j] >= g[i]) {
                maxCookie++;
                i++;
            }
            j++;
        }

        return maxCookie;

    }

    public static void main(String[] args) {
        int[] g = {1, 5, 3, 3, 4};
        int[] s = {4, 2, 1, 2, 1, 3};

        System.out.println(findContentChildren(g, s));


    }
}
