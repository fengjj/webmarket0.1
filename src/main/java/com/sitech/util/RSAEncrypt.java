package com.sitech.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.io.LineIterator;
import org.apache.commons.lang.ArrayUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * RSAEncrypt
 *
 * @author fWX194970 符鹏飞
 * @version [版本号, 2014-3-3]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class RSAEncrypt
{
    /**
     * 私钥数据字符串
     */
    public static final String DEFAULT_PRIVATE_KEY =
        "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBANaUCInVRtewjsno" + "\r"
            + "mqtMk89GnYZVFp6UvcZo06JSiJsjqKz5HWAOvmStSF38hCdEZ6y/HDU91egxeBbF" + "\r"
            + "ha1Zj8OxCDCyOLlWhJE7B5N6lJoII3Y6dd2qigfvQKOIPcWbtThQEKGy1DhsAjXE" + "\r"
            + "LUSRpoeBteqTDdui/SWDlUmrN3UFAgMBAAECgYBdYdUJbvjCm0K42fKdw9i7puac" + "\r"
            + "9GDAqMiiFTKs/LAYm/8nL8655BC1rbfFt0Qn9pwL0KvM+9kgkI7LkjBnzYdDfY2J" + "\r"
            + "ykUwZtG+g7Kwehw773shA+Y4NAUy6FJN9WcLkrfrpO0KQVs7BJ52eVUM48ujMXfn" + "\r"
            + "tPnqamW5qcvxMWbEQQJBAPU4jlZLKUxuzo29yBLXx3vZZHtrUlWq7greewqNjC7l" + "\r"
            + "xPa4+ktzCQvgTosIKJBGcSaWIMTjC/wOfPBd+1rGydECQQDgAqinIwH81dl2bRO3" + "\r"
            + "ZpmgMnnyUWzyNuKx61n1n6DR5FDv3r9pICSLA8Lx2FrfoWL9oYO7ZKXgLc2RnOdQ" + "\r"
            + "N1D1AkB4kcEyXqxEn2rBuGFKGnxDwcStBjyqUGvQPkmjC6u0V1b7tEGknUACbdxQ" + "\r"
            + "ccd4AJqbzU75X2VCHmGB0cPHg1wxAkAiQ0XYipo7OdpRKs3hN2g4AIB2d83aHlr+" + "\r"
            + "K6lO0GOgtvNKPR+5zJjKSoD+zMDZg63IbXPgrbxRVbAjnYQj2NIhAkANi2INnl5O" + "\r"
            + "xGa4fDNE5FDhPB9Y+cLysxK+A2CtVFY7gZqJO8wFU7Sgbzyg1365Z22387IMg56g" + "\r" + "aZJpSTpAXMqc" + "\r";

    /**
     * 公钥数据字符串
     */
     public static final String DEFAULT_PUBLIC_KEY =
     "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDWlAiJ1UbXsI7J6JqrTJPPRp2G" + "\r"
     + "VRaelL3GaNOiUoibI6is+R1gDr5krUhd/IQnRGesvxw1PdXoMXgWxYWtWY/DsQgw" + "\r"
     + "sji5VoSROweTepSaCCN2OnXdqooH70CjiD3Fm7U4UBChstQ4bAI1xC1EkaaHgbXq" + "\r" + "kw3bov0lg5VJqzd1BQIDAQAB"
     + "\r";
    /**
     * 日志工具
     */
//    private static final Log LOG = LogManager.getDebugLog();

    /**
     * 字节数据转字符串专用集合
     */
    private static final char[] HEX_CHAR =
        {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 私钥
     */
    private RSAPrivateKey privateKey;

    /**
     * 公钥
     */
    private RSAPublicKey publicKey;

    /**
     * 获取私钥
     *
     * @return 当前的私钥对象
     */
    public RSAPrivateKey getPrivateKey()
    {
        return privateKey;
    }

    /**
     * 获取公钥
     *
     * @return 当前的公钥对象
     */
    public RSAPublicKey getPublicKey()
    {
        return publicKey;
    }

    /**
     * 随机生成密钥对
     */
    public void genKeyPair()
    {
        KeyPairGenerator keyPairGen = null;
        try
        {
            keyPairGen = KeyPairGenerator.getInstance("RSA");
        }
        catch (NoSuchAlgorithmException e)
        {
//            LOG.warn("No such algorithm!");
        }

        if (null != keyPairGen)
        {
            keyPairGen.initialize(1024, new SecureRandom());
            KeyPair keyPair = keyPairGen.generateKeyPair();
            this.privateKey = (RSAPrivateKey)keyPair.getPrivate();
            this.publicKey = (RSAPublicKey)keyPair.getPublic();
        }
    }

    /**
     * 从文件中输入流中加载公钥
     *
     * @param in 公钥输入流
     */
    public void loadPublicKey(InputStream in)
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            //FORTIFY.Denial_of_Service modfy by zhangjian
            LineIterator lineIterator = new LineIterator(br);
            StringBuffer sb = new StringBuffer();
            String readLine = "";
            while (lineIterator.hasNext())
            {
                readLine = (String)lineIterator.next();
                if (readLine.charAt(0) == '-')
                {
                    continue;
                }
                else
                {
                    sb.append(readLine);
                    sb.append('\r');
                }
            }

            loadPublicKey(sb.toString());
        }
        catch (Exception e)
        {
//            LOG.warn("Public data stream read error!", e);
        }
    }

    /**
     * 从字符串中加载公钥
     *
     * @param publicKeyStr 公钥数据字符串
     */
    public void loadPublicKey(String publicKeyStr)
    {
        try
        {
            BASE64Decoder base64Decoder = new BASE64Decoder();
            byte[] buffer = base64Decoder.decodeBuffer(publicKeyStr);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
            this.publicKey = (RSAPublicKey)keyFactory.generatePublic(keySpec);
        }
        catch (NoSuchAlgorithmException e)
        {
        }
        catch (InvalidKeySpecException e)
        {
        }
        catch (IOException e)
        {
        }
        catch (NullPointerException e)
        {
        }
    }

    /**
     * 从文件中加载私钥
     *
     * @param in 私钥文件名
     */
    public void loadPrivateKey(InputStream in)
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            //FORTIFY.Denial_of_Service modfy by zhangjian
            LineIterator lineIterator = new LineIterator(br);
            StringBuffer sb = new StringBuffer();
            String readLine = "";
            while (lineIterator.hasNext())
            {
                readLine = (String)lineIterator.next();
                if (readLine.charAt(0) == '-')
                {
                    continue;
                }
                else
                {
                    sb.append(readLine);
                    sb.append('\r');
                }
            }
            loadPrivateKey(sb.toString());
        }
        catch (Exception e)
        {
        }
    }

    /**
     * loadPrivateKey
     *
     * @param privateKeyStr String
     */
    public void loadPrivateKey(String privateKeyStr)
    {
        try
        {
            BASE64Decoder base64Decoder = new BASE64Decoder();
            byte[] buffer = base64Decoder.decodeBuffer(privateKeyStr);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            this.privateKey = (RSAPrivateKey)keyFactory.generatePrivate(keySpec);
        }
        catch (NoSuchAlgorithmException e)
        {
        }
        catch (InvalidKeySpecException e)
        {
        }
        catch (IOException e)
        {
        }
        catch (NullPointerException e)
        {
        }
    }

    /**
     * 加密过程
     *
     * @param pubKey 公钥
     * @param plainTextData 明文数据
     * @return byte
     */
    public byte[] encrypt(RSAPublicKey pubKey, byte[] plainTextData)
    {
        if (pubKey == null)
        {
        }

        Cipher cipher = null;
        byte[] output = null;
        try
        {
            // cipher = Cipher.getInstance("RSA", new BouncyCastleProvider());
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            if ( plainTextData.length < 117)
            {
                 output = cipher.doFinal(plainTextData);
            }
            else
            {
                for (int i = 0; i < plainTextData.length; i += 64)
                { 
                    byte[] doFinal = cipher.doFinal(ArrayUtils.subarray(plainTextData, i,i + 64)); 
                    output = ArrayUtils.addAll(output, doFinal);  
                }
            }
//            output = cipher.doFinal(plainTextData);
            return output;
        }
        catch (NoSuchAlgorithmException e)
        {
        }
        catch (NoSuchPaddingException e)
        {
            // e.printStackTrace();
            return null;
        }
        catch (InvalidKeyException e)
        {
        }
        catch (IllegalBlockSizeException e)
        {
            System.out.println(e);
        }
        catch (BadPaddingException e)
        {
        }

        return output;
    }

    /**
     * 解密过程
     *
     * @param priKey 私钥
     * @param cipherData 密文数据
     * @return byte 明文
     * @throws Exception 解密过程中的异常信息
     */
    public byte[] decrypt(RSAPrivateKey priKey, byte[] cipherData)
        throws Exception
    {
        if (privateKey == null)
        {
        }
        Cipher cipher = null;
        byte[] output = null;
        try
        {
            // cipher = Cipher.getInstance("RSA", new BouncyCastleProvider());
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            if(cipherData.length<128)
            {
                output = cipher.doFinal(cipherData);
            }
            else
            {
                for (int i = 0; i < cipherData.length; i += 128) 
                {
                    byte[] doFinal = cipher.doFinal(ArrayUtils.subarray(cipherData, i, i + 128));
                    output = ArrayUtils.addAll(output, doFinal);  
    
                }
            }
//            output = cipher.doFinal(cipherData);
            return output;
        }
        catch (NoSuchAlgorithmException e)
        {
        }
        catch (NoSuchPaddingException e)
        {
            // e.printStackTrace();
            return null;
        }
        catch (InvalidKeyException e)
        {
        }
        catch (IllegalBlockSizeException e)
        {
            System.out.println(e);
        }
        catch (BadPaddingException e)
        {
        }

        return output;
    }

    /**
     * 字节数据转十六进制字符串
     *
     * @param data 输入数据
     * @return 十六进制内容
     */
    public static String byteArrayToString(byte[] data)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < data.length; i++)
        {
            // 取出字节的高四位 作为索引得到相应的十六进制标识符 注意无符号右移
            stringBuilder.append(HEX_CHAR[(data[i] & 0xf0) >>> 4]);
            // 取出字节的低四位 作为索引得到相应的十六进制标识符
            stringBuilder.append(HEX_CHAR[data[i] & 0x0f]);
            // if (i < data.length - 1)
            // {
            // stringBuilder.append(' ');
            // }
        }
        return stringBuilder.toString();
    }
    

    
    public static void main(String[] args)
        throws Exception
    {
        
        RSAEncrypt rsaEncrypt = new RSAEncrypt();
        
        // 加载私钥
        rsaEncrypt.loadPublicKey(DEFAULT_PUBLIC_KEY);
        
        String str = "paymentID=6980256a-a9a2-432b-82a5-e8dac9ae9bff&userAccount=咪咕动漫&payType=98&idEXT=1";
        
        str = "paymentID=6980250449102a12f016000350100000&userAccount=咪咕动漫&payType=1001";
        
        str = "paymentID=698025500001508200753100016&userAccount=咪咕动漫&payType=98&idEXT=6&token=STnid0000001440056750279C7ZZoMNAkQ75gv0wnfxM3GWLx1s5zIZO";
        System.out.println("加密原始数据：" + str);
        System.out.println("==========加密流程===========");
        // RSA加密字节数组
        byte[] plainText = null;
        
        try
        {
            // RSA加密
            plainText = rsaEncrypt.encrypt(rsaEncrypt.getPublicKey(), str.getBytes("UTF-8"));
        }
        catch (Exception e)
        {
        }
        
        if (null != plainText)
        {
              System.out.println("RSA加密后："+byteArrayToString(plainText));
        }
        else
        {
            
        }
        BASE64Encoder base64 = new BASE64Encoder();
        
        String encodeStr3 = base64.encode(plainText);
                System.out.println("BASE64加密后【最终加密结果】："+encodeStr3);
        
//        encodeStr3 =
//            "i4OnJF8vri5u2e7wb/nZ0pFzwCIdDSzgs08OTLkWvXgc8vqFZ9jy+N/8Fs+7ORspJ393Q+TBmbPo"
//                + "yTQ95smig/xeC+RtaNFtSLI236Kka6yEbO4ZH9BWa5YN3LocddQ5K8QNgbYyVdnRuUvp/7qkcdXn"
//                + "nEax5IG1/mFU6GE+P7U=";
//        
//        encodeStr3 =
//            "i4OnJF8vri5u2e7wb/nZ0pFzwCIdDSzgs08OTLkWvXgc8vqFZ9jy+N/8Fs+7ORspJ393Q+TBmbPoyTQ95smig/xeC+RtaNFtSLI236Kka6yEbO4ZH9BWa5YN3LocddQ5K8QNgbYyVdnRuUvp/7qkcdXnnEax5IG1/mFU6GE+P7U=";
//        
//        encodeStr3 =
//            "qq5bbq8zvhbwIcEcHj7xOmemUH2KOtpfHJRyWRY9uy1Xctxt4ggJf7pmtSdZTu6zOHWyYNffbs+P\n1qUdwXqijlaYLf3z6Sjm0zX14g7Rk1+eZHafKSgWq9l3b6YTCta5yL2xm3zWUSpyELRf2+stTFn9\nPB4xV2Xi6CaZILx9fVE=";
        
        //        encodeStr3="qq5bbq8zvhbwIcEcHj7xOmemUH2KOtpfHJRyWRY9uy1Xctxt4ggJf7pmtSdZTu6zOHWyYNffbs P\n1qUdwXqijlaYLf3z6Sjm0zX14g7Rk1 eZHafKSgWq9l3b6YTCta5yL2xm3zWUSpyELRf2 stTFn9\nPB4xV2Xi6CaZILx9fVE=";
        
        System.out.println("==========解密流程===========");
        System.out.println("待解密值：" + encodeStr3);
        System.out.println(URLEncoder.encode(encodeStr3, "UTF-8"));
        
        BASE64Decoder bb = new BASE64Decoder();
        
        byte[] bytes = bb.decodeBuffer(encodeStr3);
        
        System.out.println("Base64解密后：" + byteArrayToString(bytes));
        
        rsaEncrypt.loadPrivateKey(DEFAULT_PRIVATE_KEY);
        
        byte[] tt = rsaEncrypt.decrypt(rsaEncrypt.getPrivateKey(), bytes);
        
        System.out.println("RSA解密后【最终解密结果】：" + new String(tt, "UTF-8"));
        
    }

}
