package cn.com.lioan.basic;

public class TestRecursive {

    public static void main(String[] args){
        TestRecursive tr = new TestRecursive();
        System.out.println(tr.fr(10));
    }

    /**
     * 青蛙跳：总共有n阶台阶，青蛙一次可以跳一个台阶或两个台阶，n个台阶总共有多少种跳法
     * 递归解：
     * @param n
     * @return
     */
    public int fr(int n){
        if (n == 1 || n == 0)
            return 1;
        return fr(n-1) + fr(n-2);
    }
}
