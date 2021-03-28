package org.example.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [ 1 , 2 , 3 ]
 * 输出:
 * [
 * [ 1 , 2 , 3 ] ,
 * [ 1 , 3 , 2 ] ,
 * [ 2 , 1 , 3 ] ,
 * [ 2 , 3 , 1 ] ,
 * [ 3 , 1 , 2 ] ,
 * [ 3 , 2 , 1 ]
 * ]
 */
public class FullPermutation {


    public static void main(String[] args) {

        List<List<Integer>> res = new ArrayList<>();
        int num[] = {1, 2, 3};

        fullPermutation(res, new ArrayList<Integer>(), num);
        System.out.println(res);
    }

    public static void fullPermutation(List<List<Integer>> res, List<Integer> list, int[] num) {

        //终止条件
        if (list.size() == num.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < num.length; i++) {

            if (list.contains(num[i])) {
                continue;
            }
            list.add(num[i]);
            fullPermutation(res, list, num);
            list.remove(list.size() - 1);
        }
    }
}
