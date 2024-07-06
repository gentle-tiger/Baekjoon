import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(String.valueOf(br.readLine()));

        StringTokenizer st = new StringTokenizer(br.readLine());
        float[] tokens = new float[N];
        for(int i=0; i<N; i++ ){
            tokens[i] = Float.parseFloat(st.nextToken());
        }

        float sum = 0;
        float max = 0;
        for (float  token : tokens) {
            sum += token;
            if(max < token){
                max = token;
            }
        }
        float result = (sum / max * 100) / N;

        System.out.println(result);
    }
}
