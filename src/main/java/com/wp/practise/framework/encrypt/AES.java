package com.wp.practise.framework.encrypt;

import com.wp.practise.framework.exception.AesDecodeException;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by Wang Peng on 2017/6/14.
 */
public class AES {

    private final Cipher encrpytCipher;

    private final Cipher decrpytCipher;

    private final SecretKeySpec key;

    private final static long LONG_BYTES = 8;

    public AES(byte[] secretKey) {
        try {
            key = new SecretKeySpec(secretKey, "AES");
            encrpytCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            decrpytCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            encrpytCipher.init(Cipher.ENCRYPT_MODE, key);
            decrpytCipher.init(Cipher.DECRYPT_MODE, key);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new RuntimeException("cannot generate secret key.", e);
        }
    }

    public static byte[] generatorSafeKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();
            return secretKey.getEncoded();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("cannot generate secret key.", e);
        }
    }

    public String encodeBase64URLSafeStringLong(long value) {
        byte[] rawData = ByteBuffer.allocate(8).putLong(value).array();
        return encodeBase64URLSafeString(rawData);
    }

    public long decodeBase64Long(String value) throws AesDecodeException {
        byte[] bytes = decodeBase64(value);
        if (bytes == null || bytes.length != LONG_BYTES) {
            throw new AesDecodeException("fail to decode: " + value);
        }
        return ByteBuffer.wrap(bytes).getLong();
    }

    public String encodeBase64URLSafeString(byte[] rawData) {
        byte[] encrypted;
        synchronized (encrpytCipher) {
            try {
                encrypted = encrpytCipher.doFinal(rawData);
                return Base64.encodeBase64URLSafeString(encrypted);
            } catch (IllegalBlockSizeException | BadPaddingException e) {
                try {
                    encrpytCipher.init(Cipher.ENCRYPT_MODE, key);
                } catch (InvalidKeyException ex) {
                    throw new RuntimeException("fail to encrypt:" + Arrays.toString(rawData), ex);
                }
                throw new RuntimeException("fail to encrypt:" + Arrays.toString(rawData), e);
            }
        }
    }

    public byte[] decodeBase64(String value) throws AesDecodeException {
        byte[] encrypted = Base64.decodeBase64(value);
        synchronized (decrpytCipher) {
            try {
                return decrpytCipher.doFinal(encrypted);
            } catch (IllegalBlockSizeException | BadPaddingException e) {
                try {
                    decrpytCipher.init(Cipher.DECRYPT_MODE, key);
                } catch (InvalidKeyException ex) {
                    throw new AesDecodeException("fail to decode:" + value, ex);
                }
                throw new AesDecodeException("fail to decode:" + value, e);
            }
        }
    }

    public static void main(String[] args) {
        byte[] safeKey = generatorSafeKey();
        for (byte b : safeKey) {
            System.out.printf("%d,", b);
        }
    }

}
