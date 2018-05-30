package com.sitech.util;


import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import com.sitech.market.busiobject.basicclass.BaseClass;

/**
 * 加密、解密工具类.
 * 
 * @author xuyya
 * @version 1.0, Jul 17, 2012/4:07:29 PM
 * 
 */
public class CryptUtil extends BaseClass {

	private static final Logger logger = Logger.getLogger(CryptUtil.class);

	private static final byte[] DES_KEY = {21, 1, -110, 82, -32, -85, -128, -65};

	/**
	 * 此类为工具类,不需要实例化,将构造方法私有化.
	 */
	private CryptUtil() {

	}

	public static Key toKey(byte[] key) throws InvalidKeySpecException, InvalidKeyException, NoSuchAlgorithmException {

		DESKeySpec deskey = new DESKeySpec(key);

		// 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		return keyFactory.generateSecret(deskey);
	}

	public static String encrypt(byte[] data) {
		return encrypt(data, DES_KEY);
	}

	/**
	 * DES数据加密算法,如果加密字符串为null时，返回null.
	 * 
	 * @param data
	 *            要进行加密的数据
	 * @return 加密后的数据
	 */
	public static String encrypt(byte[] data, byte[] key) {
		String encryptedData = null;
		try {
			// DES算法要求有一个可信任的随机数源
			SecureRandom sr = new SecureRandom();

			// 加密对象
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, toKey(key), sr);

			// 加密，并把字节数组编码成字符串
			encryptedData = new String(Base64.encodeBase64(cipher.doFinal(data)), "UTF-8");

		} catch (Exception e) {
			logger.error("", e);

			return null;
		}
		return encryptedData;
	}

	/**
	 * DES数据解密算法,如果加密字符串为null时，返回null.
	 * 
	 * @param cryptData
	 *            加密数据
	 * @return 解密后的数据
	 */
	public static byte[] decrypt(String data) {
		return decrypt(data, DES_KEY);
	}

	public static byte[] decrypt(String data, byte[] key) {
		byte[] decryptedData = null;
		try {
			// DES算法要求有一个可信任的随机数源
			SecureRandom sr = new SecureRandom();

			// 解密对象
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, toKey(key), sr);

			decryptedData = cipher.doFinal(Base64.decodeBase64(data.getBytes("UTF-8")));

		} catch (Exception e) {
			logger.error("", e);

			return null;
		}
		return decryptedData;
	}

	/**
	 * 
	 * MD5加密实现方法，如果加密字符串为null时，返回null.
	 * 
	 * @param string
	 *            需要加密的字符串
	 * @return String 经过MD5加密返回的字符串
	 */
	public final static String md5(String string) {
		char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		try {
			byte[] strTemp = string.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			logger.error("", e);

			return null;
		}
	}

}

