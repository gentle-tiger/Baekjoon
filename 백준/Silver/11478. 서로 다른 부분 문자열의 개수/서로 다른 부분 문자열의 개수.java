import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();

        // 최대 N(N+1)/2 ≈ 500 500 개이므로 초깃값을 넉넉히 주면 재해싱이 줄어듭니다.
        Set<String> subs = new HashSet<>(n * (n + 1) / 2);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                subs.add(s.substring(i, j));
            }
        }

        System.out.println(subs.size());
    }
}
