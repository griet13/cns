import java.util.*;
public class Task1a{
    static Scanner s=new Scanner(System.in);
    static String encrypt(String str,int key){
        StringBuilder r=new StringBuilder();
        for(char c:str.toCharArray()){
            if(Character.isUpperCase(c))
                c=(char)((c-'A'+key)%26+'A');
            else if(Character.isLowerCase(c))
                c=(char)((c-'a'+key)%26+'a');
            r.append(c);
        }
        return r.toString();
    }
    static String decrypt(String str,int key){
        return encrypt(str,26-key%26);
    }
    public static void main(String[] args){
        String str=s.nextLine();
        int key=s.nextInt();
        String enc=encrypt(str,key);
        System.out.println("Encryption: " + enc);
        System.out.println("Decryption: " + decrypt(enc,key));
    }
}
