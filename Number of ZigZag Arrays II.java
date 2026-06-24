// You are given three integers n, l, and r.
// A ZigZag array of length n is defined as follows:
// Each element lies in the range [l, r].
// No two adjacent elements are equal.
// No three consecutive elements form a strictly increasing or strictly decreasing sequence.
// Return the total number of valid ZigZag arrays.
// Since the answer may be large, return it modulo 109 + 7.
// A sequence is said to be strictly increasing if each element is strictly greater than its previous one (if exists).
// A sequence is said to be strictly decreasing if each element is strictly smaller than its previous one (if exists).

 
// Example 1:
// Input: n = 3, l = 4, r = 5
// Output: 2
// Explanation:
// There are only 2 valid ZigZag arrays of length n = 3 using values in the range [4, 5]:
// [4, 5, 4]
// [5, 4, 5]

// Example 2:
// Input: n = 3, l = 1, r = 3
// Output: 10
// Explanation:
// ​​​​​​​There are 10 valid ZigZag arrays of length n = 3 using values in the range [1, 3]:
// [1, 2, 1], [1, 3, 1], [1, 3, 2]
// [2, 1, 2], [2, 1, 3], [2, 3, 1], [2, 3, 2]
// [3, 1, 2], [3, 1, 3], [3, 2, 3]
// All arrays meet the ZigZag conditions.

 

// Constraints:
// 3 <= n <= 109
// 1 <= l < r <= 75​​​​​​​


class Number of ZigZag Arrays II{
    static final int MOD = 1_000_000_007;
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        long[][] Inc = new long[m][m];
        long[][] Dec = new long[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (j > i) Inc[i][j] = 1;
                if (j < i) Dec[i][j] = 1;
            }
        }
        long[] v0 = new long[m];
        Arrays.fill(v0, 1L);
        int steps = n - 1;
        int fullPairs = steps / 2;
        int remainder = steps % 2;
        long[][] combo = matMult(Inc, Dec); 
        long[][] comboPow = matPow(combo, fullPairs, m);
        long[] v = matVec(comboPow, v0, m);
        if (remainder == 1) {
            v = matVec(Dec, v, m);
        }
        long totalDownStart = 0;
        for (long x : v) totalDownStart = (totalDownStart + x) % MOD;
        long ans = (2 * totalDownStart) % MOD;
        return (int) ans;
    }
    private long[][] matMult(long[][] A, long[][] B) {
        int n = A.length, k = B[0].length, mid = B.length;
        long[][] C = new long[n][k];
        for (int i = 0; i < n; i++) {
            for (int t = 0; t < mid; t++) {
                if (A[i][t] == 0) continue;
                long a = A[i][t];
                for (int j = 0; j < k; j++) {
                    C[i][j] = (C[i][j] + a * B[t][j]) % MOD;
                }
            }
        }
        return C;
    }    
    private long[] matVec(long[][] A, long[] v, int m) {
        long[] res = new long[m];
        for (int i = 0; i < m; i++) {
            long s = 0;
            for (int t = 0; t < m; t++) {
                s += A[i][t] * v[t] % MOD;
            }
            res[i] = s % MOD;
        }
        return res;
    }
    private long[][] matPow(long[][] A, int p, int m) {
        long[][] R = new long[m][m];
        for (int i = 0; i < m; i++) R[i][i] = 1;
        long[][] base = A;
        while (p > 0) {
            if ((p & 1) == 1) R = matMult(R, base);
            base = matMult(base, base);
            p >>= 1;
        }
        return R;
    }
}