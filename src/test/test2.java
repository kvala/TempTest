package test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class test2 {
 
    
    public static void main(String[] args){
        // int sum = 0;
        // int i=10;
        // while (i < 1){
        //     sum+=i;
        //     sum = sum * 2;
        //     i--;
        // }

        // System.out.println(sum);

        //System.out.println(recu("ketan"));

        String[] y = { "15", "2"};
        Arrays.sort(y);
        System.out.println(y[0]);
    }


    public static List<Integer> map(List<Integer> array, Function<Integer, Integer> method){
        List<Integer> result = new ArrayList<>();
        for(int element: array){
            int value = method.apply(element);
        }
        return result;

    }


    public static String recu(String s ){
        if(s.length() <=1){
            return s;
        }
        String f = s.substring(0, 1);
        String l = s.substring(1);

        return recu(l);
    }
}
