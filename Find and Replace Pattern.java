// Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.
// A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
// Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.

 
// Example 1:
// Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
// Output: ["mee","aqq"]
// Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
// "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.

// Example 2:
// Input: words = ["a","b","c"], pattern = "a"
// Output: ["a","b","c"]
 

// Constraints:
// 1 <= pattern.length <= 20
// 1 <= words.length <= 50
// words[i].length == pattern.length
// pattern and words[i] are lowercase English letters.


class Find and Replace Pattern{
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans=new ArrayList<>();
        for(String n:words){
            if(isCheck(n,pattern)){
                ans.add(n);
            }
        }
        return ans;
    }
    static boolean isCheck (String s,String p){
        if(s.length()!=p.length()){
            return false;
        }
        Map<Character,Character> map1 =new HashMap<>();
        Map<Character,Character> map2 =new HashMap<>();
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            char b=p.charAt(i);
            if(map1.containsKey(a) && map1.get(a)!=b){
                return false;
            }
            if(map2.containsKey(b) && map2.get(b)!=a){
                return false;
            }
            map1.put(a,b);
            map2.put(b,a);
        }
        return true;
    }
}