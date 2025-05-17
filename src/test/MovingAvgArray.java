public class MovingAvgArray {

    private final int[] window;
    private int insert;
    private int count;
    private double sum;

    public MovingAvgArray(int size) {
        window = new int[size];
        insert = 0;
        count = 0;
        sum = 0;
    }

    public double next(int val) {
        if (count < window.length) {
            count++;
        }
        sum -= window[insert];
        sum += val;
        window[insert] = val;
        insert = (insert + 1) % window.length;
        return sum / count;
    }

 
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int windowSize = 3;
        MovingAvgArray ma = new MovingAvgArray(windowSize);

        for (int value : data) {
            double average = ma.next(value);
            System.out.println("Current value: " + value + ", Moving Average: " + average);
        }
    }
}
