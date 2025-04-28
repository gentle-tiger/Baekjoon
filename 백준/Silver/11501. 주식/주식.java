import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
                int answer = 0; 
                long profit = 0;        // ▶ 이익을 바로 누적
                int N = Integer.parseInt(br.readLine());
    
                String[] input = br.readLine().split(" ");
    
                int cur = Integer.parseInt(input[0]);
                List<Integer> sum = new ArrayList<>();
                for(int i = 1; i < N; i++){
                    int next = Integer.parseInt(input[i]);
    
                    // System.out.println("cur :" + cur + "  next : "+ next + " sum : " +  (next-cur));
                    if(cur == next) {
                       continue;      
                    }else if(cur < next) {
                       sum.add(next-cur);
                       cur = next; 
                    }else if(cur > next) {
                       sum.add(next-cur);
                       cur = next;
                    } 
                }

                for(int num : sum){
                    answer += num;
                }
    
                if(answer < 0) answer = 0;
                // System.out.println(answer);

                
                int maxPrice = 0;       // ▶ 뒤에서 본 최대가
                // 뒤에서부터 순회하며 이익 누적
                for (int i = N - 1; i >= 0; i--) {
                    int price = Integer.parseInt(input[i]);
                    if (price < maxPrice) {
                        profit += (maxPrice - price);
                    } else {
                        maxPrice = price;
                    }
                }
                System.out.println(profit);

            }

    }
}