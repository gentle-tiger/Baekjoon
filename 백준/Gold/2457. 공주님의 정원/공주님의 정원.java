import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static class Flower{
        int start;
        int end;

        public Flower(int fa, int fb, int la, int lb ){
            this.start = fa * 100 + fb;
            this.end = la * 100 + lb;
        }
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        List<Flower> flowers = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            flowers.add(new Flower(a,b,c,d));
            
        }

        flowers.sort((f1, f2) -> {
            if(f1.start == f2.start) return f2.end - f1.end;
            return f1.start - f2.start;
        });

        int start = 301; // 시작 날 
        int end = 1130; // 마감 날
        int index = 0;
        int count = 0; // 필요한 꽃의 수 
        while(start <= end){
            int maxEnd = start;
            boolean found = false;

            while(index < N && flowers.get(index).start <= start){
                Flower f = flowers.get(index);

                if(f.end > maxEnd){
                    maxEnd = f.end;
                    found = true;
                }
                index++;
            }

            if(!found){
                System.out.println(0);
                return;
            }


            start = maxEnd;
            count++;
            
        }

        System.out.println(count);
    }
}