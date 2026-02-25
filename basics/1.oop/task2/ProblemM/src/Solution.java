public class Solution {
    public void solve(char ch) {
        if(ch>='a'&&ch<='z')
        {
            System.out.println("ALPHA\n" + "IS SMALL");
        }
        else if(ch>='A'&&ch<='Z'){
            System.out.println("ALPHA\n" + "IS CAPITAL");
        }
        else System.out.println("IS DIGIT");
    }
}
