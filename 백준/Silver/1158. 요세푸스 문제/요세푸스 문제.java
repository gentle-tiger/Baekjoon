import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * ** 문제 파악
 * 1.
 * ** 유의할 점
 * 1.
 * ** 접근 방법
 * 1.
 * ** 어려웠던 점
 * 1.
 * 2.
 *
 * ** 개선할 점
 * 1.
 *
 */
public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 한 줄을 읽은 후에
    String t = br.readLine();

    StringTokenizer st = new StringTokenizer(t);
    int s = Integer.parseInt(st.nextToken()); // 7
    int n = Integer.parseInt(st.nextToken()); // 3

    List<Integer> q = new ArrayList<>();

    for (int i = 1; i <= s; i++) {
      q.add(i);
    }

    int idx = 0; // 인덱스값
    int reset = 0; // 3번마다
    int len = 0;

    bw.write('<');

    while (!q.isEmpty()) {

      reset++;

      // 3번을 순회했다면
      if (reset == n) {
        if (len >= s - 1) {
          bw.write(Integer.toString(q.remove(idx)));
          break;
        }
        // 배열의 length에 q의 값을 값을 넣음.
        bw.write(q.remove(idx) + ", ");
        // 값을 넣었다면 reset의 값을 초기화 해주고 배열의 길이를 올려줌.
        reset = 0;
        len++;
      } else {
        idx++;
      }

      if (idx >= q.size()) {
        idx = 0;
      }
    }

    bw.write('>');

    bw.flush();

    bw.close();
    br.close();

  }

}