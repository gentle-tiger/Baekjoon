import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, String> employee = new HashMap<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String log = st.nextToken();
            employee.put(name, log);
        }


        Iterator<Map.Entry<String, String>> iter = employee.entrySet().iterator();
        while(iter.hasNext()){
            if(iter.next().getValue().equals("leave")){
                iter.remove();
            }
        }

        Map<String, String> decending = new TreeMap<>(employee).descendingMap();
        
        // 조회해보기
        for(Map.Entry<String, String> e : decending.entrySet()){
            System.out.println(e.getKey());
        }

        
    }
}