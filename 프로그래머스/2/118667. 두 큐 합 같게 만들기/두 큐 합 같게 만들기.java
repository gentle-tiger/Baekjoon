import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
 
       int n = queue1.length;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        long q1_sum = 0;
        long q2_sum = 0;
				// 두 큐의 합이 소수라면 바로 -1을 return한다. 
        if((q1_sum + q2_sum) % 2  != 0) return -1;

        // q에 스택을 추가하면서 각 큐의 합계를 구한다.
        for (int value : queue1) {
            q1.add(value);
            q1_sum += value;
        }
    
        for (int value : queue2) {
            q2.add(value);
            q2_sum += value;
        }


        // 반복 작업
        // 반복 횟수는 얼마로 정해야할까?
        for (int i = 0; i < 4 * n; i++) {

            if (q1_sum > q2_sum) {
                int value = q1.remove();
                q2.add(value);
                q1_sum -= value; // q1는 --
                q2_sum += value; // q2는 ++
            } else if (q1_sum < q2_sum) {
                int value = q2.remove();
                q1.add(value);
                q1_sum += value; // q1는 ++
                q2_sum -= value; // q2는 --
            } else {
                return i; // i가 결국 count....
            }
        }
        return -1;
    }
}