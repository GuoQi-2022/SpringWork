import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.security.Key;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;

import com.example.springdemo.Utils.RsaSign;

/**
 * @author wb.guoqi
 * @create 2022/5/6 14:24
 */
public class RSACoderTest {
    private String publicKey;

    private String privateKey;

    @Before
    public void setUp() throws Exception {
        Map<String, Key> keyMap = RsaSign.initKey();
        publicKey = RsaSign.getPublicKey(keyMap);
        privateKey = RsaSign.getPrivateKey(keyMap);
        System.err.println("公钥: \n\r" + publicKey);
        System.err.println("私钥： \n\r" + privateKey);
    }

    @Test
    public void test() throws Exception {
        System.err.println("公钥加密——私钥解密");
        String inputStr = "abc";
        byte[] encodedData = RsaSign.encryptByPublicKey(inputStr, publicKey);
        byte[] decodedData = RsaSign.decryptByPrivateKey(encodedData, privateKey);
        String outputStr = new String(decodedData);
        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);
        assertEquals(inputStr, outputStr);
    }

    @Test
    public void testSign() throws Exception {
        System.err.println("私钥加密——公钥解密");
        String inputStr = "charset=utf8&timestamp=1651803487&userid=405637e40e1fef7337fae0f9a7779f6d78306ae22c6d308ba5dbb1e331bd7625";
        byte[] data = inputStr.getBytes();
        byte[] encodedData = RsaSign.encryptByPrivateKey(data, privateKey);
        byte[] decodedData = RsaSign.decryptByPublicKey(encodedData, publicKey);
        String outputStr = new String(decodedData);
        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);
        assertEquals(inputStr, outputStr);
        System.err.println("私钥签名——公钥验证签名");
        // 产生签名
        String sign = RsaSign.sign(encodedData, privateKey);
//        String sign = "Dk7G5oG9R8wI5cXQQKl3foBK4XQwT6qTRzDrF9soW1OIFzyFS\\/c54h4+SG02F9n2LRam5akVW4h89xHRMgDZ7g3mwDJEbedRADruP56U638SsYy1OBCcRWPSSmUJQUZCfeldb\\/PzXBOqmrLMWM\\/Juhp32Wuox\\/bQHczO+ygZk1RvXv0FinHXLSaWS2b7VhS2z3iUdCpqKoXeDGhhBjvVe\\/w\\/r7IBnX8+mwXVwr8huvHps8KWpGtXrsg\\/Hc4df3EyMRjpOG5HnYadzQUra0x22od6\\/x1eF308w3MldTZfrJDFs7\\/I2pQKuaM8rNl7nSTmDKldONdvrH4X0Oe\\/EkOgJA==\",\n";
        System.err.println("签名:" + sign);
        // 验证签名
//        final byte[] bytes = Base64.decodeBase64(sign);
//        boolean status = RsaSign.verify(bytes, publicKey, sign);
        boolean status = RsaSign.verify(encodedData, publicKey, sign);
        System.err.println("状态:" + status);
    }
}
