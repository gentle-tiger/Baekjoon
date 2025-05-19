import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        // System.out.println("n :" + n + " q :" + q);
        
        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            String url = st.nextToken();
            String pass = st.nextToken();
            
            // System.out.println(url + ", " +  pass);

            map.put(url, pass);
        }
        
        
        for(int i = 0; i < q; i++){
            String pw = map.get(br.readLine());
            System.out.println(pw);
        }
        // System.out.println("Hello world!");
    }
}