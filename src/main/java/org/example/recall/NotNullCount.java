package org.example.recall;

import java.util.Arrays;

/**
 * 你有一套活字字模tiles，其中每个字模上都刻有一个字母tiles[i]。返回你可以印出的非空字母序列的数目。
 * 注意：本题中，每个活字字模只能使用一次。
 * <p>
 * 示例 1：
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 * <p>
 * 示例 2：
 * 输入："AAABBC"
 * 输出：188
 * <p>
 * 提示：
 * 1.   1 < = tiles.length < = 7
 * 2.   tiles 由大写英文字母组成
 */
public class NotNullCount {

    public static void main(String[] args) {
        String str = "AAB";
        int i = NotNullCount(str);
        System.out.println(i);
    }


    private static int NotNullCount(String str) {

        int[] count = new int[26];
        char[] chars = str.toCharArray();
        for (char c : chars)
            count[c - 'A']++;

        int res[] = new int[1];
        backTrack(res, count);
        return res[0];
    }

    private static void backTrack(int res[], int arr[]) {

        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) continue;
            //如果没使用完就继续使用，然后把这个字符数量减1
            arr[i]--;
            //使用一个字符集，结果的数量就加1
            res[0]++;
            backTrack(res, arr);
            //当字符使用完成以后还原
            arr[i]++;
        }
    }
}
