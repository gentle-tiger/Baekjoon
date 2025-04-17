import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        Integer[] B = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }      

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int[] result = new int[N];

        for(int i = 0; i < N; i++){
            result[i] = A[i] * B[i];
        }

        int sum = 0; 
        for(int num : result){
            sum += num;
        }
        
        System.out.println(sum);
    }
}