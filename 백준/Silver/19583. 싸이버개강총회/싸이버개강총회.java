import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] times = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine()); // 22:00 23:00 23:30
        for(int i = 0; i < 3; i++){
        
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), ":");
            int hh = Integer.parseInt(st2.nextToken());
            int mm = Integer.parseInt(st2.nextToken());
            // System.out.println((hh * 100) + mm);
            times[i] = (hh * 100) + mm;
        }            


        Set<String> in = new HashSet<>();
        Set<String> out = new HashSet<>();
        String line; 
        while((line = br.readLine()) != null && !line.isEmpty()){

            StringTokenizer st3 = new StringTokenizer(line); // 21:30 malkoring
            if(!st3.hasMoreTokens()) break;
            StringTokenizer st4 = new StringTokenizer(st3.nextToken(), ":"); // 21 30 
            int hh2 = Integer.parseInt(st4.nextToken()); // 21
            int mm2 = Integer.parseInt(st4.nextToken()); // 30
            int t = (hh2 * 100) + mm2; // 2130 
            String nick = st3.nextToken();
            if(t <= times[0]){
                in.add(nick);
            }else if(times[1] <= t && t <= times[2]){
                out.add(nick);
            }
        }

        int cnt = 0;
        for (String id : in)
            if (out.contains(id)) cnt++;

        System.out.println(cnt);
        
        // System.out.println("hellooooo");
    }
}
