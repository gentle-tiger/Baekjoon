import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());  // 여기 수정
        }

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken()); // 총감독관 감시 B명 
        int C = Integer.parseInt(st.nextToken()); // 부감독관 감시 C명 

        long viewer = 0;  // 주의: long 안 쓰면 오버플로우 발생

        for(int i = 0; i < N; i++){
            int person = A[i];
            viewer += 1; // 총감독관 1명
            person -= B;

            if(person > 0){
                viewer += (person + C - 1) / C;
            }
        }
        
        System.out.println(viewer);
    }
}
