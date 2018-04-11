/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import static com.AES4all.demo1decrypt;
import static com.AES4all.demo1encrypt;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Octopus ITES
 */
public class Test {
    
    
    public static void main(String[] args) throws Exception {
        
        String input="kunal";
//        String digest1="kDigestOne123456";   //#Octopus12Ites#%
//        String digest2="kDigestTwo234567";
        String digest1="1234567890123456";   // need 16 len
        String digest2="1234567890123456";
        String digest1_64,digest2_64;
        
//        char d1[]=SimpleBase64Encoder.encode(digest1.getBytes("UTF-8"));
//        char d2[]=SimpleBase64Encoder.encode(digest2.getBytes("UTF-8"));

//        System.out.println(new String (SimpleBase64Encoder.decode("I09jdG9wdXMxMkl0ZXMjJQ==")));
        digest1_64=new String (SimpleBase64Encoder.encode(digest1.getBytes("UTF-8")));
        digest2_64=new String (SimpleBase64Encoder.encode(digest2.getBytes("UTF-8")));
//        
        byte[] demoKeyBytes=SimpleBase64Encoder.decode(digest1_64);
        byte[] demoIVBytes=SimpleBase64Encoder.decode(digest2_64);
        String sPadding = "ISO10126Padding";

        byte[] objBytes = input.getBytes("UTF-8");
        byte[] objEncryptedBytes = demo1encrypt(demoKeyBytes, demoIVBytes, sPadding, objBytes);

        String encrypt=new String(SimpleBase64Encoder.encode(objEncryptedBytes));
        
        
        byte[] EncryptedBytes = SimpleBase64Encoder.decode(encrypt);
        byte[] DecryptedBytes = demo1decrypt(demoKeyBytes, demoIVBytes, sPadding, EncryptedBytes);
        String decrypt =new String(DecryptedBytes);
        
        
        System.out.println("encrypt "+encrypt);
        System.out.println("decrypt "+decrypt);
        System.out.println("MD% "+md5(input+"addSalt123456789"));
        
    }
    
    
    
        public static String md5(String input) {
		
            String md5 = null;
            if(null == input) return null;

            try {

            //Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");

            //Update input string in message digest
            digest.update(input.getBytes(), 0, input.length());

            //Converts message digest value in base 16 (hex) 
            md5 = new BigInteger(1, digest.digest()).toString(16);

            } catch (NoSuchAlgorithmException e) {

                    e.printStackTrace();
            }
            return md5;
    }
    
}
