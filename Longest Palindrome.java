// Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
// Letters are case sensitive, for example, "Aa" is not considered a palindrome.

 

// Example 1:
// Input: s = "abccccdd"
// Output: 7
// Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

// Example 2:
// Input: s = "a"
// Output: 1
// Explanation: The longest palindrome that can be built is "a", whose length is 1.
 

// Constraints:
// 1 <= s.length <= 2000
// s consists of lowercase and/or uppercase English letters only.


class Longest Palindrome{
    public int longestPalindrome(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int first=0;
        int mid=0;
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            int num=entry.getValue();
            while(num>=2){
                first++;
                num-=2;
            }
            if(num==1){
                    mid++;
                }
        }
        int sum=first*2;
        if(mid>0){
            sum+=1;
        }
        return sum;
    }
}