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

    public int findNumbers2(int[] nums) {
        // Counter to count the number of even digit integers
        int evenDigitCount = 0;

        for (int num : nums) {
            if ((num >= 10 && num <= 99) || (num >= 1000 && num <= 9999) || num == 100000)
                evenDigitCount++;
        }

        return evenDigitCount;
    }

    public static void main(String[] args){
        Q1295_FindEvenNumber s = new Q1295_FindEvenNumber();
        int[] input = {12,24343,120, 121};

        //int[] input  = {12,345,2,6,7896};
        System.out.println(s.findNumbers(input));
    }
}



// Let's take a look at the constraint again.

// 1≤nums[i]≤10 
// 5
 

// OR

// 1≤nums[i]≤100000

// Let's take a look at the integers in the range [1,100000].

// 1⇝9 have 1, hence an odd number of digits.
// 10⇝99 have 2, hence an even number of digits.
// 100⇝999 have 3, hence an odd number of digits.
// 1000⇝9999 have 4, hence an even number of digits.
// 10000⇝99999 have 5, hence an odd number of digits.
// 100000 has 6, hence an even number of digits.



// Let N be the length of nums, which represents the number of integers for which we have to check.

// Time complexity: O(N)

// We have a for loop which checks if each num is in the range of [10,99] or [1000,9999], or is 100000. We do this for N integers. Now, checking and incrementing (if required) will take O(1) time.

// Hence, for N integers, the time complexity of findNumbers is O(N).

// Space complexity: O(1)

// We are using constant extra space. Hence, the space complexity is O(1).
