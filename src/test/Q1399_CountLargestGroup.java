
//https://www.youtube.com/watch?v=BpnENvTusW4&ab_channel=CodeHarmony
/*
 * n range from 1 to 10^4 i.e is 1 to 10000. So highest number sum can be
 * 9999 == 9+9+9+9 = 36
 */
public class Q1399_CountLargestGroup {
    int[] map = new int[40];
    int gmax = 0;
    public int countLargestGroup(int n) {
        for (int i = 1; i <= n; i++) {
            int getsum = getSum(i);
            map[getsum]++;

            // Update max group size if current group exceeds it
            if(map[getsum] > gmax) gmax = map[getsum];
        }

        int max = 0;
        for (int m : map) {
            if(m == gmax){
                max++;
            }
        }

        return max;
    }

    public int getSum(int input) {
        //121 => 1+2+1 = 4
        // 121/10 = 12, 121%10 = 1
        //12/10 = 1, 12%10 = 2
        //1/10 => 0, 1% 10 = 1
        //1 => 1
        //9999 => 36
        //1000 => 1

        int sum = 0;
        while(input > 0){
            int d = input / 10;
            int r = input % 10;
            sum = sum + r;
            input = d;
        }
        return sum;
    }

    public static void main(String[] args) {
        Q1399_CountLargestGroup s = new Q1399_CountLargestGroup();

        System.out.println(s.countLargestGroup(13));
    }
}
