import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);



        int num = sc.nextInt();
        int sum = 0;
        for (int i = 1; i < num+1; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

}

