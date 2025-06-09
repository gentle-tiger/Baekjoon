import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken()); // 총감독관 감시 B명 
        int C = Integer.parseInt(st.nextToken()); // 부감독관 감시 C명 

        long viewer = 0;

        for(int i = 0; i < N; i++){
            int person = A[i];
            viewer += 1; // 총 시험 감독관 인원 추가
            person -= B; // 감시자 수 줄이기

            // 감시해야할 사람이 남아 있다면,
            if(person > 0){
                viewer += (person + C - 1) / C;
            }
            
        }
        
        System.out.println(viewer);
    }
}