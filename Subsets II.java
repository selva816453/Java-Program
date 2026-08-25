// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.

 

// Example 1:
// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

// Example 2:
// Input: nums = [0]
// Output: [[],[0]]
 

// Constraints:
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10


class Subsets II{
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set=new HashSet<>();
        List<List<Integer>> a=new ArrayList<>();
        a.add(new ArrayList<>());
        for(int n:nums){
            int sixe=a.size();
            for(int i=0;i<sixe;i++){
                ArrayList<Integer> temp=new ArrayList<>(a.get(i));
                temp.add(n);
                
                set.add(temp);
            }
            a.addAll(set);
            set.clear();
        }
        Set<List<Integer>> sett=new HashSet<>(a);
            return new ArrayList<>(sett);
        }
}