package test;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q0001_Two_Sum {
    public int[] two_sum(int[] input, int target)
    {

        Map<Integer, Integer> m = new HashMap<Integer, Integer>();

        for(int i= 0; i< input.length ; i++) {
            int first = input[i];
            int second = target - input[i];

            if(m.containsKey(second)){
                return new int[]{i, m.get(second)};

            }
            else {
                m.put(first, i);
            }


        }
        return null;
    }

    public List<Integer[]> two_sum2(int[] input, int target)
    {
        List<Integer[]> f = new ArrayList<Integer[]>();

        Map<Integer, Integer> m = new HashMap<Integer, Integer>();

        for(int i= 0; i< input.length ; i++) {
            int first = input[i];
            int second = target - input[i];

            if(m.containsKey(second)){
                f.add(new Integer[]{i, m.get(second)});
                //return new int[]{i, m.get(second)};

            }
            else {
                m.put(first, i);
            }


        }
        return f;
    }

    public int[] two_sum_sorted(int[] input, int target){
        int start = 0;
        int end = input.length - 1; 

        while (start < end){
            int sum = input[start] + input[end];

            if(sum == target){
                return new int[] {start, end};
            }
            else{

                if(target < sum){
                    end--;
                } else {
                    start++;
                }

            }
        }

        return null;
    }

    public List<Integer[]> two_sum_sorted1(int[] input, int target){
        List<Integer[]> f = new ArrayList<Integer[]>();
        int start = 0;
        int end = input.length - 1; 

        while (start < end){
            int sum = input[start] + input[end];

            if(sum == target){
                f.add( new Integer[] {start, end});
            }
            else{

                if(target < sum){
                    end--;
                } else {
                    start++;
                }

            }
        }

        return f;
    }

    public static void main(String[] args){
        Q0001_Two_Sum test = new Q0001_Two_Sum();

        int[] input = {1, 2, 3, 4, 5};
        int target = 7;
        int[] result = test.two_sum_sorted(input, target);
        List<Integer[]> resultA = test.two_sum2(input, target);

        for (Integer[] iA : resultA) {
            for (int i : iA) {
                System.out.println(i);
            }
        }

        // if(result != null) {
        //     System.out.println("Indices "+ result[0] + " and " + result[1] +
        //             " with values " + input[result[0]] + " and " + input[result[1]] + " add upto " +
        //             target);
        // }
        // else {
        //     System.out.print("No result match");
        // }
    }
    
}


