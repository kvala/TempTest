package test;

import java.util.Map;
import java.util.HashMap;

public class HashTest {
    private Map<String, Integer> map;

    public HashTest() {
       map = new HashMap<>();
       map.put("foo", 1);
       map.put("bar", 3);
    }
 
    public int getValue(String input, int numRetries) throws Exception {
       try {
            System.out.println("called");
          return map.get(input);
       }
       catch (Exception e) {
          if (numRetries > 3) {
             throw e;
          }
          return getValue(input, numRetries + 1);
       }
    }

    public static void main(String[] args){
        HashTest hs = new HashTest();
        
        try {
            //System.out.print(hs.getValue("foo", 0));    // 1 and function will return result 1
            //System.out.print(hs.getValue("bar", 2)); //1 and function will return result 3
             System.out.print(hs.getValue("baz", 0)); //5 and will throw null pointer exception.
            //System.out.print(hs.getValue("fubar", 1)); //4 and will throw null pointer exception. 
        } catch (Exception e) {
           System.out.print(e.toString()); 
        }

    }
}
