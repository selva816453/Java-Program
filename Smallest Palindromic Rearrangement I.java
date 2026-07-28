// You are given a palindromic string s.
// Return the lexicographically smallest palindromic permutation of s.

 

// Example 1:
// Input: s = "z"
// Output: "z"
// Explanation:
// A string of only one character is already the lexicographically smallest palindrome.

// Example 2:
// Input: s = "babab"
// Output: "abbba"
// Explanation:
// Rearranging "babab" → "abbba" gives the smallest lexicographic palindrome.

// Example 3:
// Input: s = "daccad"
// Output: "acddca"
// Explanation:
// Rearranging "daccad" → "acddca" gives the smallest lexicographic palindrome.

 

// Constraints:
// 1 <= s.length <= 105
// s consists of lowercase English letters.
// s is guaranteed to be palindromic.


class Smallest Palindromic Rearrangement I{
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        StringBuilder left = new StringBuilder();
        String mid = "";
        for (int i = 0; i < 26; i++) {
            while (freq[i] >= 2) {
                left.append((char) ('a' + i));
                freq[i] -= 2;
            }
            if (freq[i] == 1) {
                mid = String.valueOf((char) ('a' + i));
            }
        }
        String right = new StringBuilder(left).reverse().toString();
        return left.toString() + mid + right;
    }
}