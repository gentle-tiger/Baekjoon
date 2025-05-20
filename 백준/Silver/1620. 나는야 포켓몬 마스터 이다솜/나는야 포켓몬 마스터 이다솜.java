import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    private static final Map<String, String> nameToIndex = new HashMap<>();
    private static final Map<String, String> indexToName = new HashMap<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        // 도감 데이터 입력
        for(int i = 1; i <= n; i++){
            String name = br.readLine();
            String index = String.valueOf(i); // 인덱스 값은 문제열로 저장

            nameToIndex.put(name, index);
            indexToName.put(index, name);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++){
            String answer = br.readLine();
            
            if(Character.isDigit(answer.charAt(0))){
                sb.append(indexToName.get(answer)).append('\n');
            }else{
                sb.append(nameToIndex.get(answer)).append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}