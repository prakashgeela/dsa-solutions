package greedy.easy;

import java.util.Arrays;

public class AssignCookieMemorization {

    public int findContentChildren(int[] student, int[] cookie) {
        Arrays.sort(student);
        Arrays.sort(cookie);

        Integer[][] dp = new Integer[student.length][cookie.length];
        return help(0, 0, student, cookie, dp);
    }

    private int help(int studentIdx, int cookieIdx, int[] student, int[] cookies, Integer[][] dp) {

        if (studentIdx == student.length || cookieIdx == cookies.length) return 0;

        if (dp[studentIdx][cookieIdx] != null) return dp[studentIdx][cookieIdx];

        int result = 0;

        if (student[studentIdx] <= cookies[cookieIdx]) {
            result =  Math.max(result, 1+help(1+studentIdx, 1+cookieIdx,
                    student, cookies, dp));
        }

        result = Math.max(result, help(studentIdx, 1+cookieIdx,
                student, cookies, dp));

        return dp[studentIdx][cookieIdx] = result;
    }

    public static void main(String[] args) {

        AssignCookieMemorization assignCookieMemorization = new AssignCookieMemorization();

        int[] students = {1, 2};
        int[] cookies = {1, 2, 3};

        System.out.println(assignCookieMemorization.findContentChildren(students, cookies));
    }
}
