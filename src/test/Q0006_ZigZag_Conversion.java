package test;

import java.util.ArrayList;
import java.util.List;

public class Q0006_ZigZag_Conversion {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        List<Character>[] rows = new List[numRows];
        int k = 0;
        int direction = numRows == 1 ? 0 : -1;
    
        for (int i = 0; i < numRows; ++i)
          rows[i] = new ArrayList<>();
    
        for (final char c : s.toCharArray()) {
          rows[k].add(c);
          if (k == 0 || k == numRows - 1)
            direction *= -1;
          k += direction;
        }
    
        for (List<Character> row : rows)
          for (final char c : row)
            sb.append(c);
    
        return sb.toString();
    }

    public static void main(String[] arg){
        Q0006_ZigZag_Conversion cls = new Q0006_ZigZag_Conversion();
        String result = cls.convert("PAYPALISHIRING", 3);
        System.out.println(result);
    }
}
