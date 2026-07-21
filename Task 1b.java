import java.util.Scanner;
public class SubstitutionCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = "abcdefghijklmnopqrstuvwxyz";
        String b = "zyxwvutsrqponmlkjihgfedcba";
        System.out.print("Enter text: ");
        String text = sc.nextLine().toLowerCase();
        String enc = "", dec = "";
        for (char c : text.toCharArray()) {
            int i = a.indexOf(c);
            enc += (i != -1) ? b.charAt(i) : c;
        }
        for (char c : enc.toCharArray()) {
            int i = b.indexOf(c);
            dec += (i != -1) ? a.charAt(i) : c;
        }
        System.out.println("Encrypted Text : " + enc);
        System.out.println("Decrypted Text : " + dec);
        sc.close();
    }
}
