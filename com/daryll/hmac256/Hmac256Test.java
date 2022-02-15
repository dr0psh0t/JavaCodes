package com.daryll.hmac256;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Hmac256Test {

    public static byte[] hmac256(byte[] secretKey, byte[] message) {
        byte[] hmac256;

        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec sks = new SecretKeySpec(secretKey, "HmacSHA256");
            mac.init(sks);
            hmac256 = mac.doFinal(message);
            return hmac256;

        } catch (Exception e) {
            throw new RuntimeException("Failed to generate HMACSHA256 encrypt ");
        }
    }

    public static void main(String[] args) {

        //String secretKey = "secreT1_";
        //String message = "Hello world from Java!";

        String secretKey = "12345";
        String message = "helloworld";

        byte[] hmacSha256 = hmac256(secretKey.getBytes(StandardCharsets.UTF_8), message.getBytes(StandardCharsets.UTF_8));

        //String base64HmacSha256 = Base64.getEncoder().encodeToString(hmacSha256);
        //System.out.println("Base64: "+base64HmacSha256);

        String hextStr = String.format("%032x%n", new BigInteger(1, hmacSha256));
        System.out.println("Hex: "+hextStr);
    }
}