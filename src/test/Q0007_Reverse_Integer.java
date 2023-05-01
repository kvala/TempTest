package test;

public class Q0007_Reverse_Integer {
    
    public int reverse(int x) {
        long ans = 0;
 
         //-123
         while (x != 0) {
             ans = ans * 10 + x % 10;//
             x /= 10;
         }
 
         return (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) ? 0 : (int) ans;
 
     }

     public static void main(String[] args){
        Q0007_Reverse_Integer cls = new Q0007_Reverse_Integer();
        cls.reverse(-123);
     }
}
