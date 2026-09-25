import java.util.*;
import javax.crypto.*;
public class Task2{
    static Scanner s=new Scanner(System.in);
    static Cipher cipher;
    static byte[] encrypt(String data) throws Exception{
        byte[] encrypted=cipher.doFinal(data.getBytes());
        System.out.println("Encrypted: " + encrypted);
        return encrypted;
    }
    static void decrypt(byte[] data) throws Exception{
        byte[] decrypted=cipher.doFinal(data);
        System.out.println("Decrypted: " + new String(decrypted));
    }
    public static void main(String[] args){
        try{
            String data=s.nextLine();
            KeyGenerator kg=KeyGenerator.getInstance("DES");
            SecretKey key=kg.generateKey();
            cipher=Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,key);
            byte[] encrypted=encrypt(data);
            cipher.init(Cipher.DECRYPT_MODE,key);
            decrypt(encrypted);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
