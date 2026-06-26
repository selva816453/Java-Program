// You are given an integer array nums and an integer target.
// Return the number of subarrays of nums in which target is the majority element.
// The majority element of a subarray is the element that appears strictly more than half of the times in that subarray.

 
// Example 1:
// Input: nums = [1,2,2,3], target = 2
// Output: 5
// Explanation:
// Valid subarrays with target = 2 as the majority element:
// nums[1..1] = [2]
// nums[2..2] = [2]
// nums[1..2] = [2,2]
// nums[0..2] = [1,2,2]
// nums[1..3] = [2,2,3]
// So there are 5 such subarrays.

// Example 2:
// Input: nums = [1,1,1,1], target = 1
// Output: 10
// Explanation:
// ​​​​​​​All 10 subarrays have 1 as the majority element.

// Example 3:
// Input: nums = [1,2,3], target = 4
// Output: 0
// Explanation:
// target = 4 does not appear in nums at all. Therefore, there cannot be any subarray where 4 is the majority element. Hence the answer is 0.

 
// Constraints:
// 1 <= nums.length <= 10​​​​​​​5
// 1 <= nums[i] <= 10​​​​​​​9
// 1 <= target <= 109


class Count Subarrays With Majority Element II{
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] bit = new int[2 * n + 3]; 
        int offset = n + 1;
        long count = 0;
        int prefix = 0;
        update(bit, 0 + offset, bit.length);
        for (int j = 0; j < n; j++) {
            prefix += (nums[j] == target) ? 1 : -1;
            int idx = prefix + offset;
            count += query(bit, idx - 1);
            update(bit, idx, bit.length);
        }
        return count;
    }
    private void update(int[] bit, int pos, int size) {
        for (; pos < size; pos += pos & (-pos)) {
            bit[pos]++;
        }
    }
    private long query(int[] bit, int pos) {
        long sum = 0;
        for (; pos > 0; pos -= pos & (-pos)) {
            sum += bit[pos];
        }
        return sum;
    }
}