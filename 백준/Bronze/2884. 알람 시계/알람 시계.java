import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

// M > 45일 때, H가
// H != 0 이고, M이 높을 때 or 낮을 때


//      M부터 확인해야 함.
        if(M >= 45){
            int newM = M - 45;
            System.out.print(H+ " ");
            System.out.print(newM);
//      M이 45분보다 적고 H가 0일 때
        } else{
            // 0시라면
            if(H == 0){
                int newH = H +23;
                int newM = M+60-45;
                if(newM == 60){
                    newM--;

                }
                System.out.print(newH+ " ");
                System.out.print(newM);
            }else{
            // 0시가 아니라면
                int newH = H-1;
                int newM = M+60-45;
                if(newM == 60){
                    newM--;
                }
                System.out.print(newH+ " ");
                System.out.print(newM);
            }
        }
    }
}
