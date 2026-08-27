import java.security.*;
import java.util.*;
public class Task10{
    static Scanner s=new Scanner(System.in);
    public static void main(String[] args){
        try{
            System.out.print("Enter input data: ");
            String data=s.nextLine();
            MessageDigest md=MessageDigest.getInstance("MD5");
            System.out.println("Message digest object info:");
            System.out.println("Algorithm = " + md.getAlgorithm());
            System.out.println("ToString = " + md);
            md.update(data.getBytes());
            System.out.println("MD5(\"" + data + "\") = " +
                    HexFormat.of().formatHex(md.digest()));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
