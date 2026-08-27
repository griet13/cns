import java.security.*;
import java.util.*;
public class Task11{
    static Scanner s=new Scanner(System.in);
    public static void main(String[] args){
        try{
            KeyPairGenerator kg=KeyPairGenerator.getInstance("DSA");
            kg.initialize(1024);
            KeyPair kp=kg.generateKeyPair();
            PrivateKey privateKey=kp.getPrivate();
            PublicKey publicKey=kp.getPublic();
            String data=s.nextLine();
            byte[] dataBytes=data.getBytes();
            Signature sig=Signature.getInstance("SHA256withDSA");
            sig.initSign(privateKey);
            sig.update(dataBytes);
            byte[] ds=sig.sign();
            System.out.println("Digital Signature: " +
                    Base64.getEncoder().encodeToString(ds));
            sig.initVerify(publicKey);
            sig.update(dataBytes);
            System.out.println("Signature Verified: " +
                    sig.verify(ds));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
