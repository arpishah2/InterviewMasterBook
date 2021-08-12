package String;

public class StringToInteger {

    public int myAtoi(String s) {
        
    	int i=0;
    	
        if(s == null || s.isEmpty()){
            return 0;
        }
        
        if(s.length() == 1){
        	if(isDigit(s.charAt(i))){
        		return s.charAt(i) - '0';
        	} else {
        		return 0;
        	}
        
        }
        
        double result = 0;
        int sign = 1;
        
        // ignore leading whitespace
        while(i < s.length() && s.charAt(i) == ' '){
            i++;
        }
        
        //determine the sign
        if(i < s.length() && s.charAt(i) == '+'){
            sign = 1;
            i++;
        } else if(i < s.length() && s.charAt(i) == '-'){
            sign = -1;
            i++;
        }
        
        //read the digits
        while(i < s.length() && isDigit(s.charAt(i))){
            
            result = (result * 10) + (s.charAt(i) - '0');
            
            if(result * sign <= Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            } else if(result * sign >= Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            
            i++;
        }    
        
        return (int) (sign * result);
        
    }
    
    public static boolean isDigit(char ch){
        return ch >= '0' && ch <= '9';  
    }
    
    public static void main(String args[]){
    	StringToInteger stoi = new StringToInteger();
    	int ans = stoi.myAtoi("  ");
    	System.out.println(ans);
    }

}

/*

https://leetcode.com/problems/string-to-integer-atoi/

Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.
Note:

Only the space character ' ' is considered a whitespace character.
Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.

Input: s = "   -42"
Output: -42
Explanation:
Step 1: "   -42" (leading whitespace is read and ignored)
            ^
Step 2: "   -42" ('-' is read, so the result should be negative)
             ^
Step 3: "   -42" ("42" is read in)
               ^
The parsed integer is -42.
Since -42 is in the range [-231, 231 - 1], the final result is -42.

*/
