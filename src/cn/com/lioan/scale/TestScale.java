package cn.com.lioan.scale;

import java.io.UnsupportedEncodingException;

public class TestScale {

    //字符串转为十六进制
    private String string2Hex1(String text) {
        int n = 0x100;
        System.out.println(n);
        StringBuffer sb = new StringBuffer();
        byte[] bytes = text.getBytes();
        for (int i = 0; i < bytes.length; i++) {
//			System.out.println(bytes[i]);
//			System.out.println((bytes[i] >> 4) & 0xF);
            sb.append((char) (((bytes[i] >> 4) & 0xF) + ((int) 'a')));
            sb.append((char) (((bytes[i]) & 0xF) + ((int) 'a')));
//			sb.append((char)((bytes[i] >> 4) & 0xF));
//			sb.append((char)((bytes[i]) & 0xF));
        }
        return sb.toString();
    }

    public static String hexadecimal(String input, String charsetName) throws UnsupportedEncodingException {
        if (input == null) throw new NullPointerException();
        return asHex(input.getBytes(charsetName));
    }

    private static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();

    public static String asHex(byte[] buf) {
        char[] chars = new char[2 * buf.length];
        for (int i = 0; i < buf.length; ++i) {
            chars[2 * i] = HEX_CHARS[(buf[i] & 0xF0) >>> 4];
            chars[2 * i + 1] = HEX_CHARS[buf[i] & 0x0F];
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        TestScale test = new TestScale();
        String str = "10";
        String hexString = test.string2Hex1(str);
        System.out.println("hex1 === " + hexString);

        String input = "10";
        String charsetName = "UTF-8";
        String hex = "";
        try {
            hex = TestScale.hexadecimal(input, charsetName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("hex2 === " + hex);
    }
}