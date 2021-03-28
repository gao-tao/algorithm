package org.example.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数字字符串S，比如S= "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 * 0<=F[i]<=2^31-1，（也就是说，每个整数都符合32位有符号整数类型）；
 * F.length>=3；
 * 对于所有的0<=i<F.length-2，都有F [i]+F [i+1]=F [i+2]成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 *
 * 示例 1：
 * 输入："123456579"
 * 输出：[123 ,456,579]
 *
 * 示例 2：输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 *
 * 示例 3：输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成。
 *
 * 示例 4：输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 *
 * 示例 5：输入: "1101111 "
 * 输出: [110,1,111] 解释:
 * 输出 [11,0,11,11] 也同样被接受。
 *
 * 提示：
 * 1. 1<=S.length<= 200
 * 2. 字符串S中只含有数字。
 */
public class FibonaccianSequence {


    public static void main(String[] args) {

        FibonaccianSequence sequence = new FibonaccianSequence();
        List<Integer> integers = sequence.splitIntoFibonacci("1101111");
        System.out.println(integers);
    }

    private List<Integer> splitIntoFibonacci(String str) {

        List<Integer> res = new ArrayList<>();
        backTrack(str.toCharArray(), res, 0);
        return res;

    }

    private boolean backTrack(char[] digit, List<Integer> res, int index) {

        //边界条件判断，如果截取完了，并且res长度大于等于3，表示找到了一个组合。
        if (index == digit.length && res.size() >= 3) {
            return true;
        }

        for (int i = index; i < digit.length; i++) {
            //两位以上的数字不能以0开头
            if (digit[index] == '0' && i > index) {
                break;
            }

            //截取字符串转化为数字
            long num = subDigit(digit, index, i + 1);

            //如果截取的数字大于int的最大值，则终止截取
            if (num > Integer.MAX_VALUE) {
                break;
            }
            int size = res.size();
            if (size >= 2 && num > res.get(size - 1) + res.get(size - 2)) {
                break;
            }
            if (size <= 1 || num == res.get(size - 1) + res.get(size - 2)) {
                res.add((int) num);
                if (backTrack(digit, res, i + 1)) return true;
                res.remove(res.size() - 1);
            }
        }

        return false;

    }

    //相当于截取字符串S中的子串然后转换为十进制数字
    private static long subDigit(char[] digit, int start, int end) {

        long res = 0;
        for (int i = start; i < end; i++) {
            //这里是算出真正的数字  digit[i] 是char类型，'0'是48
            res = res * 10 + digit[i] - '0';
        }
        return res;
    }


}
