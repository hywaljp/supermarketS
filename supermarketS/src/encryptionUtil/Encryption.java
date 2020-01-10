package encryptionUtil;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Encryption {
    private final static String DES = "DES";

    private final static String key = "3214324242332";


    public static String encryptjm(String data) throws Exception {
        byte[] bt = encrypt(data.getBytes(), key.getBytes());
        String strs = Base64.getEncoder().encodeToString(bt);
        // String strs = new BASE64Encoder().encode(bt);
        // String strs = new Base64Encoder().encode(bt);
        return strs;
    }


    public static String decryptjm(String data) throws IOException, Exception {
        if (data == null)
            return null;
        byte[] buf = Base64.getDecoder().decode(data);
        byte[] bt = decrypt(buf, key.getBytes());
        return new String(bt);
    }


    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }


    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    /**
     * Description 获取字符串MD5值
     *
     * @param sourceStr
     */
//    private static String MD5(String sourceStr) {
//        String result = "";
//        try {
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            md.update(sourceStr.getBytes());
//            byte b[] = md.digest();
//            int i;
//            StringBuffer buf = new StringBuffer("");
//            for (int offset = 0; offset < b.length; offset++) {
//                i = b[offset];
//                if (i < 0)
//                    i += 256;
//                if (i < 16)
//                    buf.append("0");
//                buf.append(Integer.toHexString(i));
//            }
//            result = buf.toString();
//            // System.out.println("MD5(" + sourceStr + ",32) = " + result);
//            // System.out.println("MD5(" + sourceStr + ",16) = " +
//            // buf.toString().substring(8, 24));
//        } catch (NoSuchAlgorithmException e) {
//            // log.error(e.getMessage());
//        }
//        return result;
//    }

}
