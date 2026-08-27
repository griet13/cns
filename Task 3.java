import java.util.*;
import javax.crypto.*;
public class Task3{
    static Scanner s=new Scanner(System.in);
    static Cipher cipher;
    static byte[] encrypt(String data) throws Exception{
        byte[] encrypted=cipher.doFinal(data.getBytes());
        System.out.println(encrypted);
        return encrypted;
    }
    static byte[] decrypt(byte[] data) throws Exception{
        byte[] decrypted=cipher.doFinal(data);
        System.out.println(new String(decrypted));
        return decrypted;
    }
    public static void main(String[] args){
        try{
            String data=s.nextLine();
            KeyGenerator keygen=KeyGenerator.getInstance("Blowfish");
            SecretKey key=keygen.generateKey();
            cipher=Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE,key);
            byte[] encrypted=encrypt(data);
            cipher.init(Cipher.DECRYPT_MODE,key);
            decrypt(encrypted);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
