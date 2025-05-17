public class Q2119_ReversalNumber {
    public boolean isSameAfterReversals(int num) {
        // If the number is 0, it's the same after reversals.
        if (num == 0) {
            return true;
        }
        // If the last digit is 0, reversing it will make it lose that 0, and reversing again won't restore it.
        return num % 10 != 0;
    }

    public static void main(String[] args) {
        Q2119_ReversalNumber solution = new Q2119_ReversalNumber();

        // Test cases from the problem description and some additional ones
        System.out.println("Input: 526, Output: " + solution.isSameAfterReversals(526)); // Expected: true
        System.out.println("Input: 1800, Output: " + solution.isSameAfterReversals(1800)); // Expected: false
        System.out.println("Input: 0, Output: " + solution.isSameAfterReversals(0)); // Expected: true
        System.out.println("Input: 10, Output: " + solution.isSameAfterReversals(10)); // Expected: false
        System.out.println("Input: 100, Output: " + solution.isSameAfterReversals(100)); // Expected: false
        System.out.println("Input: 101, Output: " + solution.isSameAfterReversals(101)); // Expected: true
        System.out.println("Input: 21, Output: " + solution.isSameAfterReversals(21)); // Expected: true
    }
}
