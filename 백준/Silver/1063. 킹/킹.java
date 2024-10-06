import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 * ** 문제 파악
 * 8 * 8 체스판이 있으며, 체스말의 위치는 "알파벳 + 숫자"로 이루어져있다.
 * 체스말의 알파벳은 열(가장 왼쪽 열부터 A~H)을 나타내며, 숫자 행(가장 아래 행부터 1~8)을 나타낸다.
 * 체스말을 기준으로
 * LT T RT     (-1,-1)(-1,0)(-1,1)
 * L  O  R  -> (0, -1)(0, 0)(0, 1)
 * LB B RB     (1, -1)(1, 0)(1, 1)
 *
 *
 * ** 유의할 점
 * 1. 체스판에는 돌이 하나 있는데, 돌과 같은 곳으로 이동할 때는, 돌을 킹이 움직인 방향과 같은 방향으로 한 칸 이동시켜야 한다.
 *    즉, 킹이 움직이려는 자리에 돌이 있다면, 킹의 이동 거리만큼 돌의 위치도 같은 방향으로 이동시킨다.
 * 2. 체스판에서 킹과 돌이 이동하였을 때, 킹이나 돌이 체스판 밖으로 나간다면 그 이동은 무시하고 다음 이동을 준비한다.
 * 3. 이동 횟수 N은 50 이하의 자연수이다.
 *
 *
 * ** 접근 방법
 * 1. 킹과 돌의 초기 위치를 "알파벳 + 숫자" 형식에서 2차원 배열의 인덱스로 변환하여 문제를 해결하고자 함.
 *      - 열(A~H)을 숫자(0~7)으로 변환: 'A'는 0, 'B'는 1, ..., 'H'는 7
 *      - 행(1~8)을 숫자(0~7)으로 변환: '1'은 0, '2'는 1, ..., '8'은 7
 *      - 예: "A1" → [0][0], "A2" → [1][0]
 *
 * ** 어려웠던 점
 * 1. 입력으로 주어지는 문자를 숫자로 변환하는 과정에서, 행과 열의 순서를 재배치하는 부분이 헷갈렸음.
 * 2. 숫자를 다시 문자열로 변환할 때, 정수값을 char로 변환하여 처리해야 한다는 점을 알게 되어, 그 과정이 조금 까다로웠음.
 *
 *
 * ** 개선할 점
 * 1. BufferedReader와 Map 사용에 아직 익숙하지 않아, 의사코드를 먼저 작성한 후 일부는 구글링과 GPT의 도움을 받아 해결하였습니다.
 * 2. if 문의 중복으로 인해, 킹과 돌의 이동 시점을 결정하는 과정에서 혼란스러웠습니다.
 * 3. 그럼에도 불구하고, 이러한 방식으로 문제에 접근하려고 노력하였습니다.
 *
 */
public class Main {

  public static void main(String[] args) throws IOException {
    // 방향을 저장할 Map 생성
    Map<String, int[]> dirMap = new HashMap<>();
    dirMap.put("LT", new int[]{-1, -1}); // 왼쪽 위
    dirMap.put("T", new int[]{-1, 0});   // 위
    dirMap.put("RT", new int[]{-1, 1});  // 오른쪽 위
    dirMap.put("L", new int[]{0, -1});   // 왼쪽
    dirMap.put("R", new int[]{0, 1});    // 오른쪽
    dirMap.put("LB", new int[]{1, -1});  // 왼쪽 아래
    dirMap.put("B", new int[]{1, 0});    // 아래
    dirMap.put("RB", new int[]{1, 1});   // 오른쪽 아래

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 첫 번째 줄 입력: 킹 위치, 돌 위치, 이동 횟수
    String firstLine = br.readLine();
    String[] st = firstLine.split(" ");
    String K = st[0];
    String S = st[1];
    int N = Integer.parseInt(st[2]);

    // 킹 위치를 숫자로 변환
    char kColChar = K.charAt(0);
    int kCol = kColChar - 'A';
    int kRow = 8 - Integer.parseInt(K.substring(1));
    int[] King = {kRow, kCol};

    // 돌 위치를 숫자로 변환
    char sColChar = S.charAt(0);
    int sCol = sColChar - 'A';
    int sRow = 8 - Integer.parseInt(S.substring(1));
    int[] Stone = {sRow, sCol};

    // N번의 이동을 처리
    for (int i = 0; i < N; i++) {
      String direction = br.readLine();

      // 입력된 방향이 Map에 있는지 확인
      if (dirMap.containsKey(direction)) {
        // Map에 방향이 존재한다면 key에 대응하는 value 값을 가져온다.
        int[] move = dirMap.get(direction);

        // 킹의 새로운 위치 계산
        int nextKingRow = King[0] + move[0];
        int nextKingCol = King[1] + move[1];

        // 킹이 체스판 안에 있는지 확인
        if (0 <= nextKingRow && nextKingRow < 8 && 0 <= nextKingCol && nextKingCol < 8) {
          // 킹이 이동하려는 위치에 돌이 있는지 확인
          if (nextKingRow == Stone[0] && nextKingCol == Stone[1]) {
            // 돌의 새로운 위치 계산
            int nextStoneRow = Stone[0] + move[0];
            int nextStoneCol = Stone[1] + move[1];

            // 돌이 체스판 안에 있는지 확인
            if (0 <= nextStoneRow && nextStoneRow < 8 && 0 <= nextStoneCol && nextStoneCol < 8) {
              // 돌 이동
              Stone[0] = nextStoneRow;
              Stone[1] = nextStoneCol;

              // 킹 이동
              King[0] = nextKingRow;
              King[1] = nextKingCol;
            } else {
              // 돌이 체스판 밖으로 나가면 킹의 이동 무시
              continue;
            }
          }
          // 돌이 없는 경우 킹만 이동
          else {
            King[0] = nextKingRow;
            King[1] = nextKingCol;
          }
        }
        // 킹이 체스판 밖으로 나가면 이동 무시
        else {
          continue;
        }
      }
    }

    // 최종 위치를 출력 (알파벳 + 숫자 형식으로 변환)
    String resultKing = (char) ('A' + King[1]) + "" + (8 - King[0]);
    String resultStone = (char) ('A' + Stone[1]) + "" + (8 - Stone[0]);

    System.out.println(resultKing);
    System.out.println(resultStone);
  }
}
