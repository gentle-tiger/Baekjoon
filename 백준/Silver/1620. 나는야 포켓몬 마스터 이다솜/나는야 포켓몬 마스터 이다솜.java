import java.util.*;
import java.lang.*;
import java.io.*;


// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int Q = Integer.parseInt(input[1]);
        // System.out.println(N + "  " + Q);
        Map<String, String> dictionary = new HashMap<>();
        for(int i = 1; i <= N; i++){
            String o = br.readLine();
            // System.out.println(o);
            // 둘다 String으로 저장 -> answer 확인시 int, String 구분하여 받지 못하기 때문에
            String convertI = Integer.toString(i);
            dictionary.put(o, convertI);
        }


        // 기존 dictionary(이름→번호)로부터 번호→이름 맵 한 번 생성
        Map<String, String> idxToName = new HashMap<>(dictionary.size());
        for (Map.Entry<String, String> e : dictionary.entrySet()) {
            idxToName.put(e.getValue(), e.getKey());
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < Q; i++) {
            String answer = br.readLine();
        
            // 숫자면 번호 → 이름, 아니면 이름 → 번호
            if (Character.isDigit(answer.charAt(0))) {
                sb.append(idxToName.get(answer)).append('\n');
            } else {
                sb.append(dictionary.get(answer)).append('\n');
            }
        }
        
        System.out.print(sb.toString());
        // System.out.println("Hello world!");
    }
}