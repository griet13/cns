import java.util.*;
public class Task5{
    static Scanner s=new Scanner(System.in);
    static String encrypt(String data,String key){
        int[] a=new int[256];
        int i=0,j=0,t;
        for(i=0;i<256;i++) a[i]=i;
        for(i=0;i<256;i++){
            j=(j+a[i]+key.charAt(i%key.length()))%256;
            t=a[i];
            a[i]=a[j];
            a[j]=t;
        }
        String r="";
        i=j=0;
        for(char c:data.toCharArray()){
            i=(i+1)%256;
            j=(j+a[i])%256;
            t=a[i];
            a[i]=a[j];
            a[j]=t;
            r+=(char)(c^a[(a[i]+a[j])%256]);
        }
        return r;
    }
    static String decrypt(String data,String key){
        return encrypt(data,key);
    }
    public static void main(String[] args){
        System.out.print("Enter the plain text: ");
        String data=s.nextLine();
        System.out.print("Enter the key: ");
        String key=s.nextLine();
        String enc=encrypt(data, key);
        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + decrypt(enc,key));
    }
}
