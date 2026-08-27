package com.islab;
import java.security.*;
public class SHA1{
    public static void main(String[] a){
        try{
            MessageDigest md=MessageDigest.getInstance("SHA-1");
            System.out.println("Message digest object info:");
            System.out.println("Algorithm = " + md.getAlgorithm());
            System.out.println("ToString = " + md);
            String[] inputs={"","abc","abcdefghijklmnopqrstuvwxyz"};
            for(String input:inputs){
                byte[] output=md.digest(input.getBytes());
                System.out.println("\nSHA1(\"" + input + "\") = " + bytesToHex(output));
            }
        } catch(Exception e){
            System.out.println("Exception: " + e);
        }
    }
    static String bytesToHex(byte[] b){
        String r="";
        for(byte x:b)
            r+=String.format("%02X",x);
        return r;
    }
}
