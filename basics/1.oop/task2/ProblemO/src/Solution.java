public class Solution {
    long a , b ;
    char x ;

    public Solution(long a , char x , long b) {
        this.a = a;
        this.b = b;
        this.x = x;
    }

    public void calc(){
        if (x=='+'){
            System.out.println(a+b);
        }
        else if (x=='-'){
            System.out.println(a-b);
        }
        else if (x=='*'){
            System.out.println(a*b);
        }
        else if (x=='/'){
            System.out.println(a/b);
        }
    }
}
