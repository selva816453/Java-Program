// Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors. If there is no such integer in the array, return 0.

// Example 1:
// Input: nums = [21,4,7]
// Output: 32
// Explanation: 
// 21 has 4 divisors: 1, 3, 7, 21
// 4 has 3 divisors: 1, 2, 4
// 7 has 2 divisors: 1, 7
// The answer is the sum of divisors of 21 only.


// Example 2:
// Input: nums = [21,21]
// Output: 64


// Example 3:
// Input: nums = [1,2,3,4,5]
// Output: 0
 

// Constraints:
// 1 <= nums.length <= 104
// 1 <= nums[i] <= 105


class Four Divisors{
     public int sumFourDivisors(int[] nums) {
        int summ=0;
        for(int i=0;i<nums.length;i++){
            int aa=isCheck(nums[i]);
            summ+=aa;
        }
        return summ;
    }
    static int isCheck(int a){
        int count=0;
        int sum=0;
        for(int i=1;i*i<=a;i++){
            if(a%i==0){
                int d1=i;
                int d2=a/i;
                if(d1==d2){
                    count++;
                    sum+=d1;
                }else{
                    count+=2;
                    sum+=d1+d2;
                }
            }
            if(count>4) {
                return 0;
            }
        }
        if(count==4){
            return sum;
        }
        return 0;
    }
}