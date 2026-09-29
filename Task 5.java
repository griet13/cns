import java.util.*;
public class Task5{
    static Scanner sc = new Scanner(System.in);
    private static String encrypt(String str,String key){
        int[] a = new int[256];
        int i=0,j=0,t;
        String r = "";
        for(i=0;i<256;i++){
            a[i]=i;
        }
        for(i=0;i<256;i++){
            j = (j+a[i]+key.charAt(i%key.length()))%256;
            t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
        i=j=0;
        for(char c:str.toCharArray()){
            i = (i+1)%256;
            j = (j+a[i])%256;
            t = a[i];
            a[i] = a[j];
            a[j] = t;
            r+= (char)(c^a[(a[i]+a[j])%256]);
        }
        return r;
    }
    private static String decrypt(String str,String key){
        return encrypt(str,key);
    }
    public static void main(String[] args){
        String str = sc.nextLine();
        String key = sc.nextLine();
        String enc = encrypt(str,key);
        System.out.println("Encryption: " + enc);
        String dec = decrypt(enc,key);
        System.out.println("Decryption: " + dec);
    }
}
