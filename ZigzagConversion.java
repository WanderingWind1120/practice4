package org.example;

public class ZigzagConversion {
    public String solution (String s, int numRows){
        if (numRows ==1){
            return s;
        }
        int k = 2 * (numRows -1);
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i<= numRows-1; i++){
            int index = i;
            while (index <= s.length()-1){
                newString.append(s.charAt(i));
                if (i != 0 && i != numRows-1){
                    int k1 = k - 2*i;
                    int k2 = index + k1;
                    newString.append(s.charAt(k2));
                }
                index = index + k;
            }
        }
        return newString.toString();
    }
}
