package Sanjay;

import java.util.HashMap;
import java.util.Map;

public class uniquemap {

    static void findUniqueChars(char[] input) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : input) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        System.out.print("Unique characters: ");

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
    public static void main(String[] args){
        String s = "HelloWorld";
        char[] ch = s.toCharArray();
        findUniqueChars(ch);


    }
}
