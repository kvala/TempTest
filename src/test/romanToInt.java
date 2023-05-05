package test;

import java.util.*;
import java.util.HashMap;

public class romanToInt {
    public int romanToIntConvert(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int len = s.length();

        for(int i = 0; i < len; i++){
            if ( i+1 < len && map.get(s.charAt(i)) < map.get(s.charAt(i+1) )){
                res -= map.get(s.charAt(i));
            } 
            else {
                res += map.get(s.charAt(i));
            }
        }


        return res;
    }

    public static void main(String[] args){
        romanToInt c = new romanToInt();
        System.out.println(c.romanToIntConvert("III"));
    }

}
