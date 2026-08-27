import java.util.Scanner;
import org.apache.commons.text.StringEscapeUtils;
public class XSSDemo{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your comment:");
        String input=scanner.nextLine();
        System.out.println("Without XSS protection: " + input);
        String safe=StringEscapeUtils.escapeHtml4(input);
        System.out.println("With XSS protection: " + safe);
        scanner.close();
    }
}
