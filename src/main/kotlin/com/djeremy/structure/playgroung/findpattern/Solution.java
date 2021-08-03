package com.djeremy.structure.playgroung.findpattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Provide entry input");
        String entry = scanner.nextLine();

        System.out.println("Provide pattern");
        String pattern = scanner.nextLine();

        int method1 = calculateMethod1(pattern, entry);
        System.out.println("Method1 = " + method1);

        int method2 = calculateMethod2(pattern, entry);
        System.out.println("Method2 = " + method2);
    }

    private static int calculateMethod1(String pattern, String entry) {
        char[] patternChar = pattern.toCharArray();
        char[] entryChar = entry.toCharArray();

        HashMap<Integer, List<Integer>> positions = new HashMap<>();

        for (int i = 0; i < patternChar.length - 1; i++) {
            for (int j = 0; j < entryChar.length - 1; j++) {
                if (patternChar[i] == entryChar[j]) {
                    List<Integer> orDefault = positions.getOrDefault(i, new ArrayList<>());
                    orDefault.add(j);
                    positions.put(i, orDefault);
                }
            }
        }

        return calculate(positions, -1, 0);
    }


    private static int calculate(
            HashMap<Integer, List<Integer>> positions,
            int currentValue,
            int currentLevel
    ) {

        if (positions.size() == 1) {
            return positions.get(currentLevel).size();
        }

        if (currentLevel == 0) {
            return positions.get(currentLevel).stream().mapToInt(
                    c -> calculate(positions, c, currentLevel + 1)
            ).sum();
        }

        return positions.get(currentLevel).stream()
                .filter(c -> c > currentValue).mapToInt(
                        c -> {
                            if (currentLevel == positions.size() - 1) {
                                return 1;
                            } else {
                                return calculate(positions, c, currentLevel + 1);
                            }
                        }
                ).sum();
    }


    //    ===========================================================================================
    private static int calculateMethod2(String pattern, String entry) {
        return calculate(pattern.toCharArray(), entry.toCharArray(), 0, 0);
    }

    private static int calculate(char[] pattern, char[] entry, int patternPosition, int startingFrom) {
        int num = 0;
        char p = pattern[patternPosition];
        for (int j = startingFrom; j < entry.length; j++) {
            if (entry[j] == p) {
                if (patternPosition == pattern.length - 1) {
                    num = num + 1;
                } else {
                    num += calculate(pattern, entry, patternPosition + 1, j + 1);
                }
            }
        }
        return num;
    }
}