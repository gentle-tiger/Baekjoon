import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

     // br.readLine()으로 정수 값을 읽어온다.
        for(int i = 0; i < 4; i++){
                int a = Integer.parseInt(br.readLine());
                int b = Integer.parseInt(br.readLine());
               
            if(a > 0 && b > 0) {
                System.out.print(1);
                break;
            }else if(a < 0 && b > 0){
                System.out.print(2);
                break;
            }else if(a < 0 && b < 0){
                System.out.print(3);
                break;
            }else{
                System.out.print(4);
                break;
            }
        }

    }

}