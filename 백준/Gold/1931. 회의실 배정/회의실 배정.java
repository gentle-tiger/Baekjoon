import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    private static class Meeting implements Comparable<Meeting>{
        final int start; 
        final int end;

        Meeting(int start, int end){
            this.start = start; 
            this.end = end;
        }

        @Override
        public int compareTo(Meeting m){
            return (this.end != m.end) ? this.end - m.end : this.start - m.start;
        }
        
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Meeting> list = new ArrayList<>(n);

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
        
            list.add(new Meeting(start, end));
        }

        Collections.sort(list);

        int count = 0;
        int endTime = -1; 

        // 이미 위에서 종료시간순으로 계산했기 때문에 
        for(Meeting m : list){
            if(m.start >= endTime){
                count++;
                endTime = m.end;
            }
        }
            
        
        System.out.println(count);
    }
}