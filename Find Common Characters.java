
// Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.

 
// Example 1:
// Input: words = ["bella","label","roller"]
// Output: ["e","l","l"]

// Example 2:
// Input: words = ["cool","lock","cook"]
// Output: ["c","o"]
 
// Constraints:
// 1 <= words.length <= 100
// 1 <= words[i].length <= 100
// words[i] consists of lowercase English letters.



class Find Common Characters{
     public List<String> commonChars(String[] words) {
        int[]fre=new int[26];
        Arrays.fill(fre,Integer.MAX_VALUE);
        for(String word:words){
            int[]freq=new int[26];
            for(char ch:word.toCharArray()){
                freq[ch-'a']++;
            }
            for(int i=0;i<26;i++){
                fre[i]=Math.min(freq[i],fre[i]);
            }
        }
        List<String> res=new ArrayList<>();
        for(int i=0;i<26;i++){
            while(fre[i]>0){
                res.add((char)(i+'a')+"");
                fre[i]--;
            }
        }
        return res;
    }
}
