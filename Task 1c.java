import java.util.*;
class HillCipher{
    static Scanner s=new Scanner(System.in);
    static String cipher(String text,int[][] key,int n){
        String r="";
        for(int p=0;p<text.length();p+=n)
            for(int i=0;i<n;i++){
                int x=0;
                for(int j=0;j<n;j++)
                    x+=key[i][j]*(text.charAt(p+j)-'A');
                r+=(char)('A'+(x%26+26)%26);
            }
        return r;
    }
    static int[][] input(int n){
        int a[][]=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                a[i][j]=s.nextInt();
        return a;
    }
    public static void main(String[] args){
        System.out.print("Enter plain-text: ");
        String p=s.nextLine().replace(" ", "").toUpperCase();
        System.out.print("Enter block size: ");
        int n=s.nextInt();
        System.out.println("Enter key matrix:");
        int[][] key=input(n);
        while (p.length() % n != 0) p+="X";
        String e=cipher(p,key,n);
        System.out.println("Encrypted Text: " + e);
        System.out.println("Enter inverse key matrix:");
        int[][] inv=input(n);
        String d=cipher(e,inv,n);
        System.out.println("Decrypted Text: " + d);
    }
}
