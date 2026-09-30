import java.util.*;
public class Task1c {
    static Scanner sc = new Scanner(System.in);
    static int n, key[][];
    static String process(String text){
        String r = "";
        for(int p=0;p<text.length();p+=n){
            for(int i=0;i<n;i++){
                int sum = 0;
                for(int j=0;j<n;j++){
                    sum+= key[i][j]*(text.charAt(p+j)-'A');
                }
                r+= (char)((sum%26+26)%26+'A');
            }
        }
        return r;
    }
    static void inputKey(String msg){
        System.out.println(msg);
        key = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                key[i][j] = sc.nextInt();
            }
        }
    }
    static String encrypt(String text){
        inputKey("Enter key matrix:");
        while(text.length()%n!=0)
            text+="X";
        return process(text);
    }
    static String decrypt(String text){
        inputKey("Enter inverse key matrix:");
        return process(text);
    }
    public static void main(String[] args){
        System.out.println("Enter plain text:");
        String text = sc.nextLine().replaceAll(" ", "").toUpperCase();
        System.out.println("Enter block size:");
        n = sc.nextInt();
        String enc = encrypt(text);
        System.out.println("Encrypted text: " + enc);
        String dec = decrypt(enc);
        System.out.println("Decrypted text: " + dec);
    }
}
