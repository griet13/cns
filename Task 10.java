import java.security.*;
public class MD5{
    public static void main(String[] a){
        try{
            MessageDigest md=MessageDigest.getInstance("MD5");
            System.out.println("Message digest object info:");
            System.out.println("Algorithm = " + md.getAlgorithm());
            System.out.println("ToString = " + md);
            String[] inputs={"","abc","abcdefghijklmnopqrstuvwxyz"};
            for(String input:inputs){
                byte[] output=md.digest(input.getBytes());
                System.out.println("\nMD5(\"" + input + "\") = " + bytesToHex(output));
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
