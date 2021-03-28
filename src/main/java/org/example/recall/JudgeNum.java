package org.example.recall;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水 平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例: board=
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word="ABCCED",返回 true
 * 给定 word="SEE", 返回 true
 * 给定 word="ABCB", 返回 false
 * <p>
 * 提示：board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class JudgeNum {

    public static void main(String[] args) {

        char[][] arr = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        String str = "ABCCED";
//        String str = "SEE";
        String str = "ABCB";
        boolean res = judgeNum(arr, str);
        System.out.println(res);
    }


    public static boolean judgeNum(char[][] arr, String str) {

        char[] words = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (dfs(arr, i, j, words, 0)) {
                    return true;
                }

            }
        }
        return false;
    }

    private static boolean dfs(char[][] arr, int i, int j, char[] words, int index) {
        //边界的判断，如果越界直接返回false。index表示的是查找到字符串word的第几个字符，
        //如果这个字符不等于board[i][j]，说明验证这个坐标路径是走不通的，直接返回false
        if (i >= arr.length || i < 0 || j >= arr[0].length || j < 0 || arr[i][j] != words[index]) {
            return false;
        }

        //当单词读完的时候
        if (index == words.length - 1) {
            return true;
        }

        char temp = arr[i][j];

        arr[i][j] = '.';

        boolean res =
                //向上
                dfs(arr, i + 1, j, words, index + 1) ||
                //向右
                dfs(arr, i, j + 1, words, index + 1) ||
                //向下
                dfs(arr, i - 1, j, words, index + 1) ||
                //向左
                dfs(arr, i, j - 1, words, index + 1);

        //还原单词 防止代码污染
        arr[i][j] = temp;
        return res;
    }
}
