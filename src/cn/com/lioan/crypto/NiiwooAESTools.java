package cn.com.lioan.crypto;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: 你我金融app采用的对称加密工具类
 * @Description: 加密工具类
 * @date 2015-4-15 下午2:14:05
 */

public class NiiwooAESTools {

    /**
     * 使用<code>secret</code>对paramValues按以下算法进行签名： <br/>
     * uppercase(hex(sha1(secretkey1value1key2value2...secret))
     *
     * @param paramValues 参数列表
     * @param secret
     * @return
     * @throws Exception
     */
    public static String sign(Map<String, String> paramValues, String secret) {
        return sign(paramValues, null, secret);
    }

    /**
     * 对paramValues进行签名，其中ignoreParamNames这些参数不参与签名
     *
     * @param paramValues
     * @param ignoreParamNames
     * @param secret
     * @return
     * @throws Exception
     */
    public static String sign(Map<String, String> paramValues, List<String> ignoreParamNames, String secret) {
        try {
            StringBuilder sb = new StringBuilder();
            List<String> paramNames = new ArrayList<String>(paramValues.size());
            paramNames.addAll(paramValues.keySet());
            if (ignoreParamNames != null && ignoreParamNames.size() > 0) {
                for (String ignoreParamName : ignoreParamNames) {
                    paramNames.remove(ignoreParamName);
                }
            }
            Collections.sort(paramNames);

            sb.append(secret);
            for (String paramName : paramNames) {
                sb.append(paramName).append(paramValues.get(paramName));
            }
            sb.append(secret);
            byte[] sha1Digest = getSHA1Digest(sb.toString());
            return byte2hex(sha1Digest);
        } catch (IOException e) {
            return null;
        }
    }

    private static byte[] getSHA1Digest(String data) throws IOException {
        byte[] bytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            bytes = md.digest(data.getBytes(Charsets.UTF_8));
        } catch (GeneralSecurityException gse) {
            throw new IOException(gse.getMessage());
        }
        return bytes;
    }

    /**
     * 二进制转十六进制字符串
     *
     * @param bytes
     * @return
     */
    private static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }

    /**
     * @param jsonString
     * @param secret     秘钥
     * @return String    返回类型
     * @Title: encrypt
     * @Description: AES加密
     */
    public static String encrypt(String jsonString, String secret) {
        if (!StringUtils.isEmpty(jsonString)) {
            try {
                byte[] bytes = jsonString.getBytes();
                bytes = encrypt(bytes, secret.getBytes(Charsets.UTF_8), false,
                        secret.getBytes(Charsets.UTF_8));
                jsonString = bytes == null ? jsonString : Base64.encodeBase64String(bytes);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jsonString;

    }

    private static byte[] encrypt(byte[] content, byte[] key, boolean md5Key,
                                  byte[] iv) {
        try {
            if (md5Key) {
                MessageDigest md = MessageDigest.getInstance("MD5");
                key = md.digest(key);
            }
            SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // "算法/模式/补码方式"
            IvParameterSpec ivps = new IvParameterSpec(iv);// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivps);
            return cipher.doFinal(content);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * @param jsonString
     * @param key
     * @return String    返回类型
     * @Title: decrypt
     * @Description: AES解密
     */
    public static String decrypt(String jsonString, String key) {
        if (!StringUtils.isEmpty(jsonString)) {
            try {
                JSONObject.parseObject(jsonString);
            } catch (JSONException ex) {
                try {
                    byte[] bytes = jsonString.getBytes();
                    bytes = Base64.decodeBase64(bytes);
                    bytes = decrypt(bytes, key.getBytes(Charsets.UTF_8), false, key.getBytes(Charsets.UTF_8));
                    jsonString = bytes == null ? jsonString : new String(bytes, Charsets.UTF_8);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return jsonString;
    }

    private static byte[] decrypt(byte[] content, byte[] key, boolean md5Key,
                                  byte[] iv) {
        try {
            if (md5Key) {
                MessageDigest md = MessageDigest.getInstance("MD5");
                key = md.digest(key);
            }
            SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // "算法/模式/补码方式"
            IvParameterSpec ivps = new IvParameterSpec(iv);// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivps);
            return cipher.doFinal(content);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        String secret = "A1B2C3D4E5F60708";

        String source = "{UserId:\"310723AF-A705-48EC-BD78-855FF725BC1F\",HaveOtherIncome:\"True\",OtherIncome:\"200\",CompanyName:\"团贷网\",Position:\"工程师\",Deparment:\"技术中心\",JobProvince:\"广东省\",JobCity:\"东莞市\",JobArea:\"南城区\",PositionLevel:\"1\",IncomeTypeId:\"1\",WorkEmail:\"test@tuandau.com\",CompanyProvince:\"广东省\",CompanyCity:\"东莞市\",CompanyArea:\"南城区\",CompanyAddress:\"民间金融街\",CompanyTypeId:\"1\",CompanyIndustryTypeId:\"1\",CompanySizeTypeId:\"2\",WorkYears:\"1\",CompanyPhone:\"0768999999\",UserTypeId:\"1\",IsComplete:\"1\"}";
        System.out.println("原文: " + source);
        String jsonString = encrypt(source, secret);
        System.out.println("加密后: " + jsonString);


        Map<String, String> paramValues = new HashMap<String, String>();
        paramValues.put("v", "2.0");
        paramValues.put("userToken", "C51BB1E5CE4570A8A668784CDCF0265C");
        paramValues.put("jsonString", jsonString);
        paramValues.put("appKey", "00001");
        String sign = sign(paramValues, secret);
        paramValues.put("sign", sign);
        System.out.println("生成的签名：" + sign);
    }
}
