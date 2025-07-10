import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    private static class Egg {
        int dur; 
        int w; 

        Egg(int dur, int w){
            this.dur = dur;
            this.w = w;
        }

    }
    static int N; 
    static Egg[] eggs;
    static int best; 
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        for(int i = 0; i < N; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()),
                               Integer.parseInt(st.nextToken()));
        }

        dfs(0,0);

        System.out.println(best);
        
    }

    private static void dfs(int idx, int cracked){

        if(idx == N){
            best = Math.max(best, cracked);
            return;
        }

        if(cracked == N){
            best = N;
            return;
        }

        Egg cur = eggs[idx];
        if(cur.dur <= 0){
            dfs(idx + 1, cracked);
            return;
        }

        boolean hit = false;

        for(int i = 0; i < N; i++){
            if(i == idx || eggs[i].dur <= 0) continue;

            hit = true;

            Egg tgt = eggs[i];
            cur.dur -= tgt.w;
            tgt.dur -= cur.w;

            int newly = cracked;
            if(cur.dur <= 0) newly++;
            if(tgt.dur <= 0) newly++;

            dfs(idx + 1, newly);

            cur.dur += tgt.w;
            tgt.dur += cur.w;
            
            
        }

        if(!hit) dfs(idx + 1, cracked);
        
    }
}