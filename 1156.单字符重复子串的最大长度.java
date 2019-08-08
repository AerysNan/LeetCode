/*
 * @lc app=leetcode.cn id=1156 lang=java
 *
 * [1156] 单字符重复子串的最大长度
 */

import javafx.util.Pair;
import java.util.ArrayList;

class Solution {
    public int maxRepOpt1(String text) {
        ArrayList<Pair<Character, Integer>> arrayList = new ArrayList<>();
        int index = 0;
        int[] count = new int[26];
        count[text.charAt(0) - 'a']++;
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(index) != text.charAt(i)) {
                Pair<Character, Integer> p = new Pair<>(text.charAt(index), i - index);
                arrayList.add(p);
                index = i;
            }
            count[text.charAt(i) - 'a']++;
        }
        arrayList.add(new Pair<>(text.charAt(index), text.length() - index));
        int result = -1;
        for (Pair<Character, Integer> p : arrayList)
            result = Math.max(result, Math.min(p.getValue() + 1, count[p.getKey() - 'a']));
        for (int i = 1; i < arrayList.size() - 1; i++)
            if (arrayList.get(i - 1).getKey().equals(arrayList.get(i + 1).getKey())
                    && arrayList.get(i).getValue().equals(1))
                result = Math.max(result,
                        Math.min(arrayList.get(i - 1).getValue() + arrayList.get(i + 1).getValue() + 1,
                                count[arrayList.get(i + 1).getKey() - 'a']));
        return result;
    }
}
