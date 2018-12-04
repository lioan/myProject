package cn.com.lioan.crypto;

public class Charsets {

    public static final String UTF_8 = "utf-8";

    public static final String GBK = "gbk";

    public static final String GB2312 = "gb2312";

    public static final String GB18030 = "gb18030";

    public static String trim(String charset) {
        if (charset == null || charset.length() == 0) {
            return UTF_8;
        }
        charset = charset.toLowerCase();
        if (charset.equals(UTF_8)) {
            return UTF_8;
        } else if (charset.equals(GBK)) {
            return GBK;
        } else if (charset.equals(GB2312)) {
            return GB2312;
        } else if (charset.equals(GB18030)) {
            return GB18030;
        }
        return UTF_8;
    }
}
