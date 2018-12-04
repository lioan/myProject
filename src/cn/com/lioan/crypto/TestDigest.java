package cn.com.lioan.crypto;

import org.apache.commons.codec.digest.DigestUtils;

public class TestDigest {

    static final String PRE_FIX = "actshiyi1001";
    static final String SUF_FIX = "-huodong1001";

    public static String digestWithMD5(String message) {
        String digestText = DigestUtils.md5Hex(message);
        return digestText;
    }

    //使用Java签名算法进行签名
    public static String digestWithSHA1J(String message) {
        String digestString = "";

        return digestString;
    }

    public static void main(String[] args) {
		/*String sharedUserId = "b9bcac8a-7915-4621-915a-b4817bdc0ed8";
		String userId = "801a4192-2606-4f71-a496-04f7f22a1fa4";
		int challengeScore = 600;
		int playId = 355;
		String message1 = PRE_FIX + userId + sharedUserId +challengeScore;
		String message2 = PRE_FIX + userId + playId;
		String result1 = digestWithMD5(message1);
		String result2 = digestWithMD5(message2);
		System.out.println(message1);
		System.out.println("MD5HEX RESULT1 == " + result1);
		System.out.println(message1);
		System.out.println("MD5HEX RESULT2 == " + result2);*/


    }

}
