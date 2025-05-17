import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAvgStream {
    int size;
    Deque q = new ArrayDeque<>();
    int sum = 0;

    public MovingAvgStream(int size){
        this.size = size;

    }

     public double next(int val) {
        q.add(val);
        int first = 0;
        if(q.size() > size){
            first = (int) q.poll();
        }

        sum = sum + val - first;

        return (1.0*sum) / q.size();
    }

     public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int windowSize = 3;
        MovingAvgStream ma = new MovingAvgStream(windowSize);

        for (int value : data) {
            double average = ma.next(value);
            System.out.println("Current value: " + value + ", Moving Average: " + average);
        }
    }
}
