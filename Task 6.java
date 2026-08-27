import java.util.*;
import javax.crypto.*;
public class Task6{
    static Scanner s=new Scanner(System.in);
    static Cipher c;
    static byte[] encrypt(String str,SecretKey k1,SecretKey k2,int f) throws Exception{
        String a=f==2?"DESede":"DES";
        c=Cipher.getInstance(a + "/ECB/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE,k1);
        byte[] e=c.doFinal(str.getBytes());
        if(f==1){
            c.init(Cipher.ENCRYPT_MODE,k2);
            e=c.doFinal(e);
        }
        System.out.println("Encrypted: " + new String(e));
        return e;
    }
    static String decrypt(byte[] e, SecretKey k1, SecretKey k2, int f) throws Exception {
        String a=f==2?"DESede":"DES";
        c=Cipher.getInstance(a + "/ECB/PKCS5Padding");
        if(f==1){
            c.init(Cipher.DECRYPT_MODE,k2);
            e=c.doFinal(e);
        }
        c.init(Cipher.DECRYPT_MODE,k1);
        e=c.doFinal(e);
        System.out.println("Decrypted: " + new String(e));
        return new String(e);
    }
    public static void main(String[] args){
        try{
            System.out.print("Enter plaintext: ");
            String str=s.nextLine();
            System.out.print("Enter 1 for 2DES or 2 for 3DES: ");
            int f=s.nextInt();
            String a=f==2?"DESede":"DES";
            KeyGenerator kg=KeyGenerator.getInstance(a);
            SecretKey k1=kg.generateKey();
            SecretKey k2=kg.generateKey();
            byte[] e=encrypt(str,k1,k2,f);
            decrypt(e,k1,k2,f);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
