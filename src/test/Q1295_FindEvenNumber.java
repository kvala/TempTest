public class Q1295_FindEvenNumber {
    public int findNumbers(int[] nums) {
        int counter = 0;
        for(int n : nums){
            if(isEvenDigit(n)){
                counter++;
            }
        }

        return counter;
    }

    public boolean isEvenDigit(int num){
        int countdigits = 0;
        while(num != 0 ){
            num = num/10;
            countdigits++;
        }

        return countdigits % 2 == 0; 
        //return (countdigits & 1) == 0;

    }

    public static void main(String[] args){
        Q1295_FindEvenNumber s = new Q1295_FindEvenNumber();
        int[] input = {12,24343,120, 121};

        //int[] input  = {12,345,2,6,7896};
        System.out.println(s.findNumbers(input));
    }
}
