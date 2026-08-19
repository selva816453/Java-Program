// A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
// Given a string s, return true if it is a palindrome, or false otherwise.
 

// Example 1:
// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "amanaplanacanalpanama" is a palindrome.

// Example 2:
// Input: s = "race a car"
// Output: false
// Explanation: "raceacar" is not a palindrome.
// Example 3:
// Input: s = " "
// Output: true
// Explanatio
// n: s is an empty string "" after removing non-alphanumeric characters.
// Since an empty string reads the same forward and backward, it is a palindrome.
 

// Constraints:s
// 1 <= s.length <= 2 * 105
// s consists only of printable ASCII characters.


class Valid Palindrome{
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        StringBuilder temp=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                temp.append(ch);
            }
        }
        String a=temp.toString();
        String b=temp.reverse().toString();
        return a.equals(b);
    }
}