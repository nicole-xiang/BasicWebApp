package com.develogical;
import java.util.Arrays;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("name")) {
            return "NX-Team";
        }
        if (query.toLowerCase().contains("plus") || query.toLowerCase().contains("minus")) {
            String[] parts = query.split(" ");
            Integer num1 = Integer.parseInt(parts[Arrays.asList(parts).indexOf("plus")-1]); 
            Integer num2 = Integer.parseInt(parts[Arrays.asList(parts).indexOf("plus")+1]);
            
            if (Arrays.asList(parts).contains("plus")){
                String ans = String.valueOf(num1+num2);
                return ans;
            }
            if (Arrays.asList(parts).contains("minus")){
                String ans = String.valueOf(num1-num2);
                return ans;
            }
            }
        return "";
    }
}
