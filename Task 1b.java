package com.islab;
import java.util.*;
public class SubstitutionCipher{
    static Scanner sc=new Scanner(System.in);
    static String a="abcdefghijklmnopqrstuvwxyz";
    static String b="zyxwvutsrqponmlkjihgfedcba";
    static String encrypt(String str){
        String r="";
        for(char c:str.toCharArray())
            r+=b.charAt(a.indexOf(c));
        return r;
    }
    static String decrypt(String str){
        String r="";
        for (char c:str.toCharArray())
            r+=b.charAt(a.indexOf(c));
        return r;
    }
    public static void main(String[] args){
        System.out.print("Enter any string: ");
        String str=sc.nextLine();
        String enc=encrypt(str);
        System.out.println("The encrypted data is: " + enc);
        System.out.println("The decrypted data is: " + decrypt(enc));
    }
}
