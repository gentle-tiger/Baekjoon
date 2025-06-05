import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1) 두 스택 초기화: left = 커서 왼쪽, right = 커서 오른쪽
        ArrayDeque<Character> left  = new ArrayDeque<>();
        ArrayDeque<Character> right = new ArrayDeque<>();
        for (char c : br.readLine().toCharArray()) {
            left.push(c);
        }

        int m = Integer.parseInt(br.readLine());

        // 2) for문으로 명령 처리
        for (int i = 0; i < m; i++) {
            String cmd = br.readLine();

            // **첫 글자 검사** → 명령 종류 판단
            char op = cmd.charAt(0);

            // 1) L: 커서를 왼쪽으로 이동
            if (op == 'L') {
                if (!left.isEmpty()) {
                    right.push(left.pop());
                }

            // 2) D: 커서를 오른쪽으로 이동
            } else if (op == 'D') {
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }

            // 3) B: 커서 왼쪽 문자 삭제
            } else if (op == 'B') {
                if (!left.isEmpty()) {
                    left.pop();
                }

            // 4) P x: 커서 왼쪽에 문자 x 추가
            } else if (op == 'P') {
                // 문자열 전체가 "P x"이므로 index 2에 문자가 들어옴
                char x = cmd.charAt(2);
                left.push(x);
            }
        }

        // 3) 최종 결과: left 스택을 모두 right로 옮긴 뒤, right에서 꺼내며 출력
        StringBuilder sb = new StringBuilder(left.size() + right.size());
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.print(sb.toString());
    }
}
