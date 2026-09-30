import java.security.*;
import java.util.*;
public class Task11{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        try{
            KeyPairGenerator kg = KeyPairGenerator.getInstance("DSA");
            kg.initialize(1024);
            KeyPair kp = kg.generateKeyPair();
            PrivateKey privatekey = kp.getPrivate();
            PublicKey publickey = kp.getPublic();
            String data = sc.nextLine();
            Signature sig=Signature.getInstance("SHA256withDSA");
            sig.initSign(privatekey);
            sig.update(data.getBytes());
            byte[] ds=sig.sign();
            System.out.println("Digital Signature: " + Base64.getEncoder().encodeToString(ds));
            sig.initVerify(publickey);
            sig.update(data.getBytes());
            System.out.println("Signature Verified: " + sig.verify(ds));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
