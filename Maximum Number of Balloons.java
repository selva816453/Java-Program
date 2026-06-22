// Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
// You can use each character in text at most once. Return the maximum number of instances that can be formed.

 
// Example 1:
// Input: text = "nlaebolko"
// Output: 1

// Example 2:
// Input: text = "loonbalxballpoon"
// Output: 2

// Example 3:
// Input: text = "leetcode"
// Output: 0
 

// Constraints:
// 1 <= text.length <= 104
// text consists of lower case English letters only.


class Maximum Number of Balloons{
    public int maxNumberOfBalloons(String text) {
        if(text.length()<7){
            return 0;
        }
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:text.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
       int b=map.getOrDefault('b',0);
       int a=map.getOrDefault('a',0);
       int l=map.getOrDefault('l',0)/2;
       int o=map.getOrDefault('o',0)/2;
       int n=map.getOrDefault('n',0);
        return Math.min(b,Math.min(a,Math.min(l,Math.min(o,n))));
}
}