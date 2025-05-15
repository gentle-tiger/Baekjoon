import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        NavigableSet<String> inOffice = new TreeSet<>(Comparator.reverseOrder());
        
        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();

            if(st.nextToken().equals("enter")){
                inOffice.add(name);
            }else{
                inOffice.remove(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String name : inOffice){
            sb.append(name).append('\n');
        }
        
        System.out.println(sb);
    }
}