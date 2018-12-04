import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class TestSystemIn {

    public void traditionalSystemIn() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inStr = "";
        try {
            inStr = reader.readLine();
            System.out.println(inStr);
//			System.out.println();
            inStr = reader.readLine();
            System.out.println(inStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void newScanner() {
        Scanner scanner = new Scanner(System.in);
        int a1 = scanner.nextInt();
        System.out.println(a1);
        scanner.next();
    }

    public static void main(String[] args) {
        TestSystemIn test = new TestSystemIn();
//		test.traditionalSystemIn();
        test.newScanner();
    }

}
