// You are given an integer array nums and an integer k.
// An integer x is almost missing from nums if x appears in exactly one subarray of size k within nums.
// Return the largest almost missing integer from nums. If no such integer exists, return -1.
// A subarray is a contiguous sequence of elements within an array.
 

// Example 1:
// Input: nums = [3,9,2,1,7], k = 3
// Output: 7
// Explanation:
// 1 appears in 2 subarrays of size 3: [9, 2, 1] and [2, 1, 7].
// 2 appears in 3 subarrays of size 3: [3, 9, 2], [9, 2, 1], [2, 1, 7].
// 3 appears in 1 subarray of size 3: [3, 9, 2].
// 7 appears in 1 subarray of size 3: [2, 1, 7].
// 9 appears in 2 subarrays of size 3: [3, 9, 2], and [9, 2, 1].
// We return 7 since it is the largest integer that appears in exactly one subarray of size k.

// Example 2:
// Input: nums = [3,9,7,2,1,7], k = 4
// Output: 3
// Explanation:
// 1 appears in 2 subarrays of size 4: [9, 7, 2, 1], [7, 2, 1, 7].
// 2 appears in 3 subarrays of size 4: [3, 9, 7, 2], [9, 7, 2, 1], [7, 2, 1, 7].
// 3 appears in 1 subarray of size 4: [3, 9, 7, 2].
// 7 appears in 3 subarrays of size 4: [3, 9, 7, 2], [9, 7, 2, 1], [7, 2, 1, 7].
// 9 appears in 2 subarrays of size 4: [3, 9, 7, 2], [9, 7, 2, 1].
// We return 3 since it is the largest and only integer that appears in exactly one subarray of size k.

// Example 3:
// Input: nums = [0,0], k = 1
// Output: -1
// Explanation:
// There is no integer that appears in only one subarray of size 1.

 

// Constraints:
// 1 <= nums.length <= 50
// 0 <= nums[i] <= 50
// 1 <= k <= nums.length


class Find the Largest Almost Missing Integer{
    public int largestInteger(int[] nums, int k) {
        List<List<Integer>> li=new ArrayList<>();
        for(int i=0;i<=nums.length-k;i++){
            List<Integer> l=new ArrayList<>();
            for(int j=i;j<i+k;j++){
                l.add(nums[j]);
            }
            li.add(l);
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<li.size();i++){
            List<Integer> a=li.get(i);
            Set<Integer> set=new HashSet<>(a);
            for(int j:set){
                map.put(j,map.getOrDefault(j,0)+1);
            }
        }
        int max=-1;
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            if(entry.getValue()==1){
                if(max<entry.getKey()){
                    max=entry.getKey();
                }
            }
        }
        return max;
    }
}