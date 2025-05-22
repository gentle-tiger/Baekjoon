import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> attendees = new LinkedHashSet<>();

        for(int i = 0; i < l; i++){
            String id = br.readLine();

            attendees.remove(id);
            attendees.add(id);
        }

        StringBuilder sb = new StringBuilder();
        int printed = 0; 
        for(String id : attendees){
            if(printed == n) break;
            sb.append(id).append("\n");
            printed++;
        }


        System.out.println(sb.toString());
        
    }
}