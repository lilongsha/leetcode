package com.lty.lls.main;

import java.util.HashSet;
import java.util.Set;

public class Algorithm {
    /**
     * Approach 1: Brute Force  --fail
     * Time complexith : O(n^3)
     *
     * @param s
     * @return
     */
    public static int algorithm01(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (allUnique01(s.substring(i, j))) {
                    maxLength = Math.max(maxLength, j - i);
                } else {
                    break;
                }
            }
        }
        return maxLength;
    }

    private static boolean allUnique01(String substring) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < substring.length(); i++) {
            if (set.contains(substring.charAt(i)))
                return false;
            set.add(substring.charAt(i));
        }
        return true;
    }

    /**
     * Approach 2: Sliding Window
     * Tiem complexity : O(n)
     * Space complexity : O(min(m,n))
     * @param s
     * @return
     */
    public static int algorithm02(String s) {
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0, n = s.length();
        while (i < n && j < n) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            } else {
                maxLength = Math.max(maxLength, j - i + 1);
                set.add(s.charAt(j));
                j++;
            }
        }
        return maxLength;
    }
}
