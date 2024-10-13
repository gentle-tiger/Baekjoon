import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ** 문제 파악
 * 1. 정답과 힌트의 숫자는 서로 다른 숫자 세 개로 구성되어 있다.
 * 2. 정답과 힌트의 숫자를 비교했을 때, 서로 동일한 자리에 위치하면 스트라이크 1번으로 센다.
 * 3. 정답과 힌트의 숫자를 비교했을 때, 세 자리 중에 있기는 하지만 다른 자리에 위치해 있지만 볼 1번으로 센다.
 * 4. 이때, 힌트를 통해 정답을 맞출 가능성이 있는 수가 몇 개인지 파악하는 문제.
 * ** 유의할 점
 * 1. 정답을 맞추는 게 아닌 가능성이 있는 수가 몇 개인지 반환해야 함.
 *
 * ** 접근 방법
 * 1. 힌트를 통해 스트라이크와 볼을 분리한다.
 * 2.
 * ** 어려웠던 점
 * 1.
 * 2.
 *
 *
 * ** 개선할 점
 * 1.
 *
 */
public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // N
    int N = Integer.parseInt(br.readLine());
    // 결과 예상 개수
    int count = 0;
    // [질문 개수, 스트라이크 수, 볼 수]
    int[][] quest = new int[N][3]; 
    
    // 힌트 받아오기
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int guess = Integer.parseInt(st.nextToken());    // 추측 숫자
      int strike = Integer.parseInt(st.nextToken());  // 스트라이크 수
      int ball = Integer.parseInt(st.nextToken());    // 볼 수
      quest[i][0] = guess;
      quest[i][1] = strike;
      quest[i][2] = ball;
    }

    // 123부터 987까지 모든 가능한 세 자리 수를 탐색
    for (int num = 123; num <= 987; num++) {
      int first = num / 100;            // 첫 번째 자리 숫자
      int second = (num / 10) % 10;     // 두 번째 자리 숫자
      int third = num % 10;             // 세 번째 자리 숫자

      // 각 자릿수가 1~9 사이인지, 그리고 중복되지 않는지 확인
      if (first == 0 || second == 0 || third == 0) {
        continue; // 0이 포함되면 제외
      }
      if (first == second || first == third || second == third) {
        continue; // 중복된 숫자가 있으면 제외
      }

      boolean isPossible = true; // 현재 숫자가 가능한지 여부를 나타내는 플래그

      // 모든 질문에 대해 현재 숫자가 조건을 만족하는지 확인
      for (int i = 0; i < N; i++) {
        int questNum = quest[i][0];      // 현재 질문의 추측 숫자
        int questStrike = quest[i][1];   // 현재 질문의 스트라이크 수
        int questBall = quest[i][2];     // 현재 질문의 볼 수

        // 질문 숫자의 각 자릿수 분리
        int qFirst = questNum / 100;
        int qSecond = (questNum / 10) % 10;
        int qThird = questNum % 10;

        int strike = 0; // 현재 숫자에 대한 스트라이크 수
        int ball = 0;   // 현재 숫자에 대한 볼 수

        // 스트라이크 계산: 같은 자리의 숫자가 일치할 경우
        if (first == qFirst) {
          strike++;
        }
        if (second == qSecond) {
          strike++;
        }
        if (third == qThird) {
          strike++;
        }

        // 볼 계산
        if (first == qSecond || first == qThird) {
          ball++;
        }
        if (second == qFirst || second == qThird) {
          ball++;
        }
        if (third == qFirst || third == qSecond) {
          ball++;
        }

        // 스트라이크와 볼 수가 기대값과 일치하지 않으면 불가능한 숫자임
        if (strike != questStrike || ball != questBall) {
          isPossible = false;
          break; // 더 이상 검사할 필요 없이 다음 숫자로 넘어감
        }
      }
      // 모든 질문을 만족하면
      if (isPossible) {
        count++;
      }

    }

    // 가능한 숫자의 총 개수를 출력
    System.out.println(count);
  }

}