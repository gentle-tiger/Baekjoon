import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// A[X][Y]의 값을 채우는 구간 합 공식
// A[X][Y] = A[X][Y-1] + A[X-][Y] - A[X-1][Y-1] + A[X][Y]


public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 주어진 수


        int start = 1;
        int end = 1;
        int sum = 1; // 시작점 -> 1
        int count = 1; // end == N일 떄 종료하므로 미리 1을 넣어준다.

        // two pointer :  start는 감소  end는 확장의 의미이다.
        // end가 N을 만나면 바로 +1 해주고 종료하면 되는 것이었다.
        while (end != N) {
            if (sum < N) {
                end++;
                sum += end;
            } else  {
                sum -= start;
                start++;
                // sum == N일 경우
            }

            if(sum == N){
//                System.out.println("end : "+ end + "| start : "+ start  );
                count++;
                end++;
                sum += end;

            }

        }

        System.out.println(count);
    }
}


