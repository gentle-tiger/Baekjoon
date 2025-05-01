import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        // 1) 각 번호의 위치 저장
        int[] pos = new int[N+1];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(arr[i]);
            pos[num] = i;
        }

        // 2) 번호 i와 i+1이 연속 구간인지 확인하며 최장 길이 계산
        int maxLen = 1, curLen = 1;
        for (int i = 1; i < N; i++) {
            if (pos[i] < pos[i+1]) {
                curLen++;
            } else {
                curLen = 1;
            }
            if (curLen > maxLen) {
                maxLen = curLen;
            }
        }

        // 3) 이동해야 할 최소 아이 수 = N - maxLen
        System.out.println(N - maxLen);
    }
}
