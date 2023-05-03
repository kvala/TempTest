package test;

public class Atoi {
    public int myAtoi(String input){
        
        if(input == null || input.isEmpty()){
            return 0;
        }
        boolean isNegative = false;
        int result = 0;
        if(input.charAt(0) == '-'){
            isNegative = true;
            input = input.substring(1);
        }

        //123
        for( char c : input.toCharArray()){
            result = result*10 + (c - '0');            

        }

        if(isNegative){
            result = result * -1;
        }


        return result;

    }


    public static void main (String[] args){
        Atoi c = new Atoi();
        System.out.println(c.myAtoi("523"));

    }
}
