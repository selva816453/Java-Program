// You are given two integers num1 and num2 representing an inclusive range [num1, num2].
// The waviness of a number is defined as the total count of its peaks and valleys:
// A digit is a peak if it is strictly greater than both of its immediate neighbors.
// A digit is a valley if it is strictly less than both of its immediate neighbors.
// The first and last digits of a number cannot be peaks or valleys.
// Any number with fewer than 3 digits has a waviness of 0.
// Return the total sum of waviness for all numbers in the range [num1, num2].
 

// Example 1:
// Input: num1 = 120, num2 = 130
// Output: 3
// Explanation:
// In the range [120, 130]:
// 120: middle digit 2 is a peak, waviness = 1.
// 121: middle digit 2 is a peak, waviness = 1.
// 130: middle digit 3 is a peak, waviness = 1.
// All other numbers in the range have a waviness of 0.
// Thus, total waviness is 1 + 1 + 1 = 3.

// Example 2:
// Input: num1 = 198, num2 = 202
// Output: 3
// Explanation:
// In the range [198, 202]:
// 198: middle digit 9 is a peak, waviness = 1.
// 201: middle digit 0 is a valley, waviness = 1.
// 202: middle digit 0 is a valley, waviness = 1.
// All other numbers in the range have a waviness of 0.
// Thus, total waviness is 1 + 1 + 1 = 3.

// Example 3:
// Input: num1 = 4848, num2 = 4848
// Output: 2
// Explanation:
// Number 4848: the second digit 8 is a peak, and the third digit 4 is a valley, giving a waviness of 2.

 

// Constraints:
// 1 <= num1 <= num2 <= 1015​​​​​​​




class Total Waviness of Numbers in Range II{
    static class Pair {
        long count;
        long wav;
        Pair(long c, long w) {
            count = c;
            wav = w;
        }
    }
    String s;
    Pair[][][][][] dp;
    boolean[][][][][] vis;
    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {
        if (x < 0) return 0;
        s = String.valueOf(x);
        int n = s.length();
        dp = new Pair[n][11][11][2][2];
        vis = new boolean[n][11][11][2][2];
        return dfs(0, -1, -1, 0, 1).wav;
    }
    private Pair dfs(int pos, int prev, int prev2, int started, int tight) {
        if (pos == s.length()) {
            return new Pair(1, 0);
        }
        if (tight == 0 && vis[pos][prev + 1][prev2 + 1][started][0]) {
            return dp[pos][prev + 1][prev2 + 1][started][0];
        }
        int limit = (tight == 1) ? s.charAt(pos) - '0' : 9;
        long totalCount = 0;
        long totalWav = 0;
        for (int d = 0; d <= limit; d++) {
            int newTight = (tight == 1 && d == limit) ? 1 : 0;
            int newStarted = (started == 1 || d != 0) ? 1 : 0;
            int newPrev = prev;
            int newPrev2 = prev2;
            if (newStarted == 0) {
                newPrev = -1;
                newPrev2 = -1;
            } else {
                newPrev2 = prev;
                newPrev = d;
            }
            Pair child = dfs(pos + 1, newPrev, newPrev2, newStarted, newTight);
            totalCount += child.count;
            long add = 0;
            if (started == 1 && prev2 != -1) {
                if ((prev2 < prev && prev > d) ||
                    (prev2 > prev && prev < d)) {
                    add = child.count;
                }
            }
            totalWav += child.wav + add;
        }
        Pair res = new Pair(totalCount, totalWav);
        if (tight == 0) {
            vis[pos][prev + 1][prev2 + 1][started][0] = true;
            dp[pos][prev + 1][prev2 + 1][started][0] = res;
        }
        return res;
    }
}