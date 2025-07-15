import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int L, C;
    public static String[] arr;
    public static String[] path;
    public static final Set<String> VOWEL = Set.of("a", "e", "i", "o", "u");
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new String[C];
        path = new String[L];
        for(int i = 0; i < C; i++){
            arr[i] = st.nextToken();
        }


        Arrays.sort(arr);

        dfs(0, 0);

        System.out.println(sb);
    }


    private static void dfs(int depth, int start){

        if(depth == L){
            int v = 0, c = 0; 

            for(String s : path){
                if(VOWEL.contains(s)) v++;
                else c++;
            }
            if(v >= 1 && c >= 2){
                for(String x : path){
                    sb.append(x);
                }
                sb.append("\n");
            }
            return;
        }

        for(int i = start; i < C; i++){
            path[depth] = arr[i];
            dfs(depth + 1, i + 1);
        }
    }
}