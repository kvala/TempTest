public class Q1550_ConsecutiveOdd {
    public boolean threeConsecutiveOdds(int[] arr) {
        int counter = 0;
        for(int num : arr){
            if(num%2 == 0){
                counter = 0;
            } else {
                counter++;
                if(counter == 3){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q1550_ConsecutiveOdd s = new Q1550_ConsecutiveOdd();
        int[] input = { 1, 2, 34, 3, 4, 5, 7, 12, 21 };
        System.out.println(s.threeConsecutiveOdds(input));
    }
}
