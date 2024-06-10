import java.io.*;
//import java.util.Scanner;
//import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));






        bw.write("\\    /\\"+'\n'); // 읽기
        bw.write(" )  ( ')"+'\n'); // 읽기
        bw.write("(  /  )"+'\n'); // 읽기
        bw.write(" \\(__)|"+'\n'); // 읽기

        bw.flush(); // 버퍼의 내용 출력


    }

}

//        StringTokenizer tk = new StringTokenizer(br.readLine(),"/"); //  공백을 기준으로 나눈다.
//        a b c d e  -> buffer는 한 줄로 읽는다  print : a b c d e
//                      token은 특정 기준으로 나눠서 읽는다. print : a, b ,c , d, e 나눠서

//        while (tk.hasMoreTokens()) {
//        String s = tk.nextToken();
//            System.out.println(s);
////            System.out.print(tk.nextToken() + " ");
//        }