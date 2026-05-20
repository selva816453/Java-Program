// You are given a string s, and your task is to reverse the string.

// Examples:

// Input: s = "Geeks"
// Output: "skeeG"

// Input: s = "for"
// Output: "rof"

// Input: s = "a"
// Output: "a"

// Constraints:
// 1 <= s.size() <= 106
// s contains only alphabetic characters (both uppercase and lowercase).

class Reverse a String{
    public static String reverseString(String s) {
        StringBuilder ans = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--){
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}