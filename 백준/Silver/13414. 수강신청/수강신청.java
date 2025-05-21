import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int l = Integer.parseInt(input[1]);

        Set<String> list = new LinkedHashSet<>();
        
        // System.out.println(n +" " + l);
        
        for(int i = 0; i < l; i++){
            String person = br.readLine();

            if(!list.contains(person)){
              list.add(person);   
            }else{
              list.remove(person); // 삭제하고
              list.add(person); // 맨 뒤
            }
        }
        int i = 0;
        for(String s : list){
            if(i < n){
                System.out.println(s);
                i++;
            }else{
                return;
            }
        }

        
        // System.out.println("Hello world!");
    }
}