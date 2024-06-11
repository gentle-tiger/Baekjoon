import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);



        int num = sc.nextInt();
        if(num % 4 == 0 ){
            if(num % 100 != 0){
                System.out.print('1');    
            }else if(num % 400 == 0){
                System.out.print('1');
            }else{
                System.out.print('0');
            }
        }else{
          System.out.print('0');
        }

    }

}