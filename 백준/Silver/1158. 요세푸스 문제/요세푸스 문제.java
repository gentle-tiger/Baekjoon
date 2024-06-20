import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> Q = new LinkedList<>();

        for(int i = 1; i <= N; i++ ) {
            Q.offer(i);
        }
        int index= 0;
        int count = 1;
        int[] arr = new int[N];

        while(!Q.isEmpty()){
            int popQ = Q.poll(); // poll()는 맨 앞에 있는 값을 확인 후 삭제한다.
            if(count == K){
                // K만큼 순회했다면 popQ의 값을 배열에 넣어주고 다시 K만큼 순회한다.
                arr[index] = popQ;
                count = 1;
                index ++;
            }else{
                // K만큼 순회하지 않았다면 순회해주고 그 값은 다시 Queue에 넣어준다.
                Q.add(popQ);
                count ++;
            }
        }

            System.out.print("<");
        for(int i = 0; i< arr.length; i++){

            if(i == arr.length-1){
                System.out.print(arr[i]);
            }else{
                System.out.print(arr[i]+", ");
            }
        }
        System.out.print(">");
    }
}