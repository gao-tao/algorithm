package org.example.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例: 输入: nums=[1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class WithoutDuplicateElements {


    public static void main(String[] args) {

        int[] num = {1, 2, 3};
        List<List<Integer>> list = new ArrayList<>();
//        backTrack(list, num, new ArrayList<Integer>(), 0);
//        System.out.println(list);

//        List<List<Integer>> bit = bit(num);
//        System.out.println(bit);

        tree(list, new ArrayList<Integer>(), num, 0);
        System.out.println(list);

    }

    //回溯算法
    public static List<List<Integer>> backTrack(List<List<Integer>> list, Integer[] chars, List<Integer> tempList, int index) {

        list.add(new ArrayList<>(tempList));

        for (int i = index; i < chars.length; i++) {

            //做出选择
            tempList.add(chars[i]);

            //递归
            backTrack(list, chars, tempList, i + 1);

            //撤销选择
            tempList.remove(tempList.size() - 1);

        }
        return list;
    }


    //位运算的方式
    public static List<List<Integer>> bit(int[] nums) {

        //子集的长度是2的nums.length次方，这里通过移位计算
        int length = 1 << nums.length;

        List<List<Integer>> res = new ArrayList<>(length);
        //遍历从0到length中间的所有数字，根据数字中1的位置来找子集
        for (int i = 0; i < length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                //如果数字i的某一个位置是1，就把数组中对应的数字添加到集合
                if (((i >> j) & 1) == 1)
                    list.add(nums[j]);
            }
            res.add(list);
        }
        return res;

    }

    //非递归的方式（自己研究）



    //通过树来解决
    public static void tree(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {

        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        //每一个节点都有两个分支，一个选一个不选
        //走不选这个分支
        tree(res, list, nums, index + 1);
        list.add(nums[index]);
        tree(res, list, nums, index + 1);
        list.remove(list.size() - 1);
    }


}
