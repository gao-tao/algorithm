package org.example.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每 种组合中不存在重复的数字。
 * 说明：所有数字都是正整数。解集不能包含重复的组合。
 * <p>
 * 示例 1: 输入: k = 3 , n = 7
 * 输出: [ [ 1 , 2 , 4 ] ]
 * <p>
 * 示例 2: 输入: k = 3 , n = 9
 * 输出: [ [ 1 , 2 , 6 ] , [ 1 , 3 , 5 ] , [ 2 , 3 , 4 ] ]
 */
public class CombinedSum {


    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,new ArrayList<Integer>(),3,1,9);
        System.out.println(res);
    }

    public static void dfs(List<List<Integer>> res, List<Integer> list, int k, int start, int n) {

        if (list.size() == k || n < 0) {

            if (list.size() == k && n == 0) {
                res.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for (int i = start; i < 9; i++) {
            list.add(i);
            dfs(res, list, k, i + 1, n - i);
            list.remove(list.size() - 1);
        }

    }
}
