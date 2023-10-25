package com.example.springdemo.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定字符串J  代表石头中宝石的类型，和字符串  S代表你拥有的石头。  S  中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J  中的字母不重复，J  和  S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 */
public class gemAndStone {
    public static void main(String[] args) {
        String jew = "z";
        String stones = "ZZ";
        int i = numJewelsInStones(jew, stones);
        System.out.println(i);
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int sum = 0;
        char[] jewArr = jewels.toCharArray();
        char[] stoArr = stones.toCharArray();
        Set<Character> chars = new HashSet<Character>();
        for (char c : jewArr) {
            chars.add(c);
        }
        for (char c : stoArr) {
            if (chars.contains(c)) {
                sum++;
            }
        }
        return sum;

        /*
        * let count = 0
          for(let i = 0;i<J.length;i++){
            count += S.split(J[i]).length - 1
          }
          return count
          * */
    }
/*      暴力上层循环（时间复杂度与空间复杂度都不理想）
    public static int numJewelsInStones(String jewels, String stones) {
        String[] jewArr = jewels.split("");
        String[] stonArr = stones.split("");
        int sum = 0;
        Stream<String> stream = Arrays.stream(stones.split(""));
        for (int i = 0; i < jewArr.length; i++) {
            String s = jewArr[i];
            for (int j = 0; j < stonArr.length; j++) {
                if (s.equals(stonArr[j])){
                    sum++;
                }
            }
        }
        return sum;
    }
*/
}
