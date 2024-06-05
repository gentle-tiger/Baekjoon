import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
        for (int i = 1; i < 9+1; i++) {
            System.out.printf("%d * %d = %d",n,i,n*i );
            System.out.println();
        }

    }
}