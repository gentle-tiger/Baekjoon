import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++){
            int t = Integer.parseInt(br.readLine());
            
            Map<String, Integer > map = new HashMap<>();
            
            for(int j = 0; j < t; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();
                if(map.containsKey(type)){
                    map.put(type, map.get(type) + 1);
                }else{
                    map.put(type, 1);
                }
            }


            int result = 1; 
            for(int count : map.values()){
                result *= count+ 1;
            }
            System.out.println(result - 1);
        }
    }
}