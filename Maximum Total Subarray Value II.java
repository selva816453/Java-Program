// You are given an integer array nums of length n and an integer k.
// You must select exactly k distinct subarrays nums[l..r] of nums. Subarrays may overlap, but the exact same subarray (same l and r) cannot be chosen more than once.
// The value of a subarray nums[l..r] is defined as: max(nums[l..r]) - min(nums[l..r]).
// The total value is the sum of the values of all chosen subarrays.
// Return the maximum possible total value you can achieve.

 
// Example 1:
// Input: nums = [1,3,2], k = 2
// Output: 4
// Explanation:
// One optimal approach is:
// Choose nums[0..1] = [1, 3]. The maximum is 3 and the minimum is 1, giving a value of 3 - 1 = 2.
// Choose nums[0..2] = [1, 3, 2]. The maximum is still 3 and the minimum is still 1, so the value is also 3 - 1 = 2.
// Adding these gives 2 + 2 = 4.

// Example 2:
// Input: nums = [4,2,5,1], k = 3
// Output: 12
// Explanation:
// One optimal approach is:
// Choose nums[0..3] = [4, 2, 5, 1]. The maximum is 5 and the minimum is 1, giving a value of 5 - 1 = 4.
// Choose nums[1..3] = [2, 5, 1]. The maximum is 5 and the minimum is 1, so the value is also 4.
// Choose nums[2..3] = [5, 1]. The maximum is 5 and the minimum is 1, so the value is again 4.
// Adding these gives 4 + 4 + 4 = 12.

 
// Constraints:
// 1 <= n == nums.length <= 5 * 10​​​​​​​4
// 0 <= nums[i] <= 109
// 1 <= k <= min(105, n * (n + 1) / 2)


class Maximum Total Subarray Value II{
     class SparseTable {
        int[][] maxTable;
        int[][] minTable;
        int[] log;
        SparseTable(int[] nums) {
            int n = nums.length;
            log = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                log[i] = log[i / 2] + 1;
            }
            int k = log[n] + 1;
            maxTable = new int[n][k];
            minTable = new int[n][k];
            for (int i = 0; i < n; i++) {
                maxTable[i][0] = nums[i];
                minTable[i][0] = nums[i];
            }
            for (int j = 1; j < k; j++) {
                for (int i = 0; i + (1 << j) <= n; i++) {
                    maxTable[i][j] = Math.max(
                        maxTable[i][j - 1],
                        maxTable[i + (1 << (j - 1))][j - 1]
                    );
                    minTable[i][j] = Math.min(
                        minTable[i][j - 1],
                        minTable[i + (1 << (j - 1))][j - 1]
                    );
                }
            }
        }
        int getMax(int l, int r) {
            int j = log[r - l + 1];
            return Math.max(
                maxTable[l][j],
                maxTable[r - (1 << j) + 1][j]
            );
        }
        int getMin(int l, int r) {
            int j = log[r - l + 1];
            return Math.min(
                minTable[l][j],
                minTable[r - (1 << j) + 1][j]
            );
        }
    }
    class Node {
        long value;
        int l, r;
        Node(long value, int l, int r) {
            this.value = value;
            this.l = l;
            this.r = r;
        }
    }
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        SparseTable st = new SparseTable(nums);
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(b.value, a.value)
        );
        for (int l = 0; l < n; l++) {
            long val = (long) st.getMax(l, n - 1) - st.getMin(l, n - 1);

            pq.offer(new Node(val, l, n - 1));
        }
        long ans = 0;
        while (k-- > 0) {
            Node cur = pq.poll();
            ans += cur.value;
            if (cur.r > cur.l) {
                int nr = cur.r - 1;
                long nextVal = (long) st.getMax(cur.l, nr)- st.getMin(cur.l, nr);

                pq.offer(new Node(nextVal, cur.l, nr));
            }
        }
        return ans;
    }
}