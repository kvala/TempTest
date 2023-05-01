import java.util.*;

public class HashtableRunner {

    public Integer topRun(List<Integer> locations){
        int output = 0;
        int place_id = -1;

        Hashtable<Integer, Integer> directory = new Hashtable<>();
        for(Integer loc : locations){
            if(directory.containsKey(loc)){
                int val = directory.get(loc);
                directory.put(loc, val+1);
                if(output < val+1){
                    output = val+1;
                    place_id = loc;
                }
            } 
            else {
                    directory.put(loc, 1);
                    if(output < 1){
                        output = 1;
                        place_id = loc;
                    }
                }
        }

        return place_id;
    }

    public static void main(String[] args){
        HashtableRunner cls = new HashtableRunner();

        List<Integer> l = new ArrayList<Integer>();

        l.add(5);
        l.add(2);
        l.add(2);
        l.add(5);
        l.add(2);

        System.out.println(cls.topRun(l));
    }
    
}
