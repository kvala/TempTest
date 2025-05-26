public class Q977_SquareSorted {
    public int[] sortedSquares(int[] nums) {
        int[] out = new int[nums.length];
        int s = 0, e = nums.length - 1;
        int c = nums.length - 1;

        while (s <= e) {
            if (Math.abs(nums[s]) < Math.abs(nums[e])) {
                out[c--] = nums[e] * nums[e];
                e--;
            } else {
                out[c--] = nums[s] * nums[s];
                s++;
            }
        }
        return out;
    }

    public static void main(String[] args) {

        int[] input = {-4,-1,0,3,10};
        Q977_SquareSorted s = new Q977_SquareSorted();
        for( int o : s.sortedSquares(input)){
            System.out.println(o);
        }
    }
}
