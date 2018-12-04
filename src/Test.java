import java.util.HashMap;


public class Test {

    public static void main(String[] args) {
//如果返回目标对象 则无法调用invoke方法 调用的是目标对象的方法 即没有实现代理功能
        // TODO Auto-generated method stub
//		String str = null;
//		System.out.println(str.equals("1"));
//		System.out.println("1".equals(str));
//		int i = 0;
//		while (true) {
//			++i;
//			System.out.println(i);
//			break;
//		}
//		System.out.println(math.abs(1 - 6));
//		stairCase(6);

    }

    static void stairCase(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n - i - 1; j > 0; j--) {
                System.out.print(' ');
            }
            for (int k = i + 1; k > 0; k--) {
                System.out.print('#');
            }
            System.out.println();
        }
    }

}
