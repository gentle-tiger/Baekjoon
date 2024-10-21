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
 * 1. 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있으며, 순서도래 K번째 사람을 제거한다.
 * 2. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나가며, N명의 사람이 모두 제거될 때까지 계속된다.
 * ** 유의할 점
 * 1. 제거된 사람들을 제외한 나머지 중에서 다시 이 과정이 이루어진다는 점.
 * ** 접근 방법
 * 1. List의 크기가 동적으로 변경되는 특성을 활용하여, List에 N명을 담고, 순서대로 제거하는 과정을 반복함.
 * ** 어려웠던 점
 * 1. 처음에는 제거된 사람들을 제외하는지 몰라서 문제 푸는데에 어려움을 겪음.
 * 2.
 *
 * ** 개선할 점
 * 1. 문제는 ArrayList를 만들어 풀었지만, 동작 로직을 보면 큐와 동일한 로직으로 진행되는 것을 알 수 있다.
 * 2. 큐에 대해 공부하고 이를 적용해봐야 할 것 같다.
 *    - ArrayList로 문제를 풀었을 때, 시간이 3340ms가 걸렸다면, Queue는 768ms 만에 해결했다.
 *    - ArrayList는 메모리  상에서 연속된 공간에 할당되며, 그 연속성을 유지하기 위해서는 나머지 요소들이 새로운 배열의 처음부터 다시 시작해야 한다.
 *    - Queue는 메모리 상에서 비연속적으로 저장되지만 각 노도는 다음 노드르르 가리키는 포인터를 통해 서로 연결되어 있기 때문에, 중간에 요소가 제거되어도 노드 간의 참조만 변경된다.
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

//    List<Integer> peopleList = new ArrayList<>();
    Queue<Integer> q = new LinkedList<>();

    // 1 2 3 4 5 6 7
    for(int i = 1; i <= s; i++) {
//      peopleList.add(i);
      q.add(i);
    }

    // 3번의 카운트를 할 변수
    int count = 0;

     bw.write("<");
//    while(!peopleList.isEmpty()){
    while(!q.isEmpty()){
//      int curr = peopleList.remove(0);
      int currQ = q.remove();
      count++;
      // 3번을 다 돌았다면
      if(count == n){
        //  peopleList에 하나의 값만 남았을 경우
//        if(peopleList.isEmpty()) {
        if (q.isEmpty()){
//          bw.write(Integer.toString(curr));
          bw.write(Integer.toString(currQ));
        }else{
//          bw.write(curr + ", ");
          bw.write(currQ + ", ");
        }
        count = 0;
      }else{
        // 3번을 다 돌지 않았다면 그 값을 맨 뒤에 추가.
//        peopleList.add(curr);
        q.add(currQ);
      }
    }
    bw.write(">");


    bw.flush();

    bw.close();
    br.close();

  }

}
