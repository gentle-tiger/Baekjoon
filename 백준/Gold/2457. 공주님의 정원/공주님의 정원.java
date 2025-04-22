import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] flowers = new int[N][4];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 4; j++) {
                flowers[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 피는 달/날 기준 오름차순, 피는 날짜 같으면 지는 날짜 내림차순
        Arrays.sort(flowers, (a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    if (a[2] == b[2]) return b[3] - a[3];
                    return b[2] - a[2];
                }
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int startMonth = 3;
        int startDay = 1;
        int endMonth = 11;
        int endDay = 30;

        int count = 0;
        int idx = 0;

        while (startMonth < endMonth || (startMonth == endMonth && startDay <= endDay)) {
            int maxMonth = startMonth;
            int maxDay = startDay;

            boolean found = false;

            while (idx < N) {
                int fm = flowers[idx][0];
                int fd = flowers[idx][1];
                int tm = flowers[idx][2];
                int td = flowers[idx][3];

                // 이 꽃이 현재 날짜 이전에 피어야 함
                if (fm < startMonth || (fm == startMonth && fd <= startDay)) {
                    // 이 꽃이 현재 max 지는 날짜보다 늦게 지면 갱신
                    if (tm > maxMonth || (tm == maxMonth && td > maxDay)) {
                        maxMonth = tm;
                        maxDay = td;
                        found = true;
                    }
                    idx++;
                } else {
                    break;
                }
            }

            if (!found) {
                System.out.println(0);
                return;
            }

            startMonth = maxMonth;
            startDay = maxDay;
            count++;
        }

        System.out.println(count);
    }
}
