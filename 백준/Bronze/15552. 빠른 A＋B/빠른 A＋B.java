import com.sun.security.jgss.GSSUtil;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine()); // 1, 1

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());


            bw.write(String.valueOf(A + B));

            bw.newLine(); // 새로운 줄로 이동
        }
    bw.flush(); // 버퍼 비우기
    bw.close(); // BufferedWriter 닫기
    br.close(); // BufferedReader 닫기
    }
}