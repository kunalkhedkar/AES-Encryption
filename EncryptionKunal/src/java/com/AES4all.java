package com;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;

public class AES4all {

    public static Cipher getAESCBCEncryptor(byte[] keyBytes, byte[] IVBytes, String padding) throws Exception{
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(IVBytes);
        Cipher cipher = Cipher.getInstance("AES/CBC/"+padding);
        cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
        return cipher;
    }
    
    public static Cipher getAESCBCDecryptor(byte[] keyBytes, byte[] IVBytes, String padding) throws Exception{
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(IVBytes);
        Cipher cipher = Cipher.getInstance("AES/CBC/"+padding);
        cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
        return cipher;
    } 

    public static Cipher getAESECBEncryptor(byte[] keyBytes, String padding) throws Exception{
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/"+padding);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher;
    }
    
    public static Cipher getAESECBDecryptor(byte[] keyBytes, String padding) throws Exception{
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/"+padding);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher;
    }
    
    public static byte[] encrypt(Cipher cipher, byte[] dataBytes) throws Exception{
        ByteArrayInputStream bIn = new ByteArrayInputStream(dataBytes);
        CipherInputStream cIn = new CipherInputStream(bIn, cipher);
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        int ch;
        while ((ch = cIn.read()) >= 0) {
          bOut.write(ch);
        }
        return bOut.toByteArray();
    } 

    public static byte[] decrypt(Cipher cipher, byte[] dataBytes) throws Exception{
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        CipherOutputStream cOut = new CipherOutputStream(bOut, cipher);
        cOut.write(dataBytes);
        cOut.close();
        return bOut.toByteArray();    
    } 
    /**
     * @param args
     */
    
    public static byte[] demo1encrypt(byte[] keyBytes, byte[] ivBytes, String sPadding, byte[] messageBytes) throws Exception {
        Cipher cipher = getAESCBCEncryptor(keyBytes, ivBytes, sPadding); 
        return encrypt(cipher, messageBytes);
    }

    public static byte[] demo1decrypt(byte[] keyBytes, byte[] ivBytes, String sPadding, byte[] encryptedMessageBytes) throws Exception {
        Cipher decipher = getAESCBCDecryptor(keyBytes, ivBytes, sPadding);
        return decrypt(decipher, encryptedMessageBytes);
    }
    
    public static byte[] demo2encrypt(byte[] keyBytes, String sPadding, byte[] messageBytes) throws Exception {
        Cipher cipher = getAESECBEncryptor(keyBytes, sPadding); 
        return encrypt(cipher, messageBytes);
    }

    public static byte[] demo2decrypt(byte[] keyBytes, String sPadding, byte[] encryptedMessageBytes) throws Exception {
        Cipher decipher = getAESECBDecryptor(keyBytes, sPadding);
        return decrypt(decipher, encryptedMessageBytes);
    }
    
    public static void main(String[] args) throws Exception {
        String sDemoMesage = "sharmaraju352@gmail.com";
        byte[] demoMesageBytes = sDemoMesage.getBytes("UTF-8");
   
        String key="#Octopus12Ites#%";
        byte[] demoKeyBytes=key.getBytes("UTF-8");
        String iv="#Place12Me#%%*)^";
        byte[] demoIVBytes=iv.getBytes("UTF-8");
        String sPadding = "ISO10126Padding";
//        
//        String salt = "Random$Salt#ForPlaceMe#WithSpecialCharacters12@$@4&#%^$*";
//         
        String name="sunny.gh.gm@gmail.com";  
        byte[] nameBytes=name.getBytes("UTF-8");
        byte[] demo1EncryptedBytes = demo1encrypt(demoKeyBytes, demoIVBytes, sPadding, nameBytes);
        System.out.println("encrypted: "+ new String(SimpleBase64Encoder.encode(demo1EncryptedBytes)));
//        
//        
//
//        byte[] demo1EncryptedBytes=SimpleBase64Encoder.decode("hxeedxzkvnvzEvdJTVW3xQy5Z/jCBfmKclZSN4HsuZs=");
//        byte[] demo1DecryptedBytes = demo1decrypt(demoKeyBytes, demoIVBytes, sPadding, demo1EncryptedBytes);
//        System.out.println("Demo1 decrypted message : "+new String(demo1DecryptedBytes));


//        String key="*#PlAceME@a2*17#";
//        
//        System.out.println(SimpleBase64Encoder.decode("I09jdG9wdXMxMkl0ZXMjJQ=="));
      
    }


//      IMP https://stackoverflow.com/questions/39353020/creating-a-background-thread-for-sending-email 
//      send mail servlet
//    1. CreateSingleUser
//    2. CreateMultipleUser 
//    3. SaveNewUserWelcomeIntroData 
//    4. EditEmail 
//    5. SendActivationCode  
//    6. ResendOTP
    
    
}
