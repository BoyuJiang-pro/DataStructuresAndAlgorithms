package org.jpro;

import org.jpro.utils.TimeTools;
/**
 * 求第n个斐波那契数
 */
public class Fibonacci {

    /**
     * 递归求解法
     * NOTE:此方法存在性能问题
     *
     * @param n 第n个斐波那契数
     * @return 第n个斐波那契数的值
     */
    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 迭代求解法
     *
     * @param n n个斐波那契数
     * @return 第n个斐波那契数的值
     */
    public static int fib2(int n) {
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }


    public static void main(String[] args) {
        int n = 20;
        TimeTools.check("fib", () -> System.out.println(fib(n)));
        TimeTools.check("fib2", () -> System.out.println(fib2 (n)));
    }

}
