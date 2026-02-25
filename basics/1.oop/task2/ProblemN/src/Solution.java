public class Solution {
    public char solve(char ch ){
        String s = String.valueOf(ch);
        if(ch>='a'&&ch<='z') {
            return s.toUpperCase().charAt(0);
        }
        return s.toLowerCase().charAt(0);

    }
}
