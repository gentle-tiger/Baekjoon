import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        /* ❶ 그룹 → 멤버 리스트, ❷ 멤버 → 그룹 */
        HashMap<String,List<String>> groupToMembers = new HashMap<>();
        HashMap<String, String> memberToGroup = new HashMap<>();
        
        for(int i = 0; i < t; i++){

            String group = br.readLine(); // twice, blackpink, redvelvet

            int m = Integer.parseInt(br.readLine());

            List<String> members = new ArrayList<>();
            for(int j = 0; j < m; j++){
                String member = br.readLine();
                members.add(member);
                memberToGroup.put(member, group);
            }

            Collections.sort(members);
            groupToMembers.put(group,members);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++){
            String word = br.readLine();
            int type = Integer.parseInt(br.readLine());

            if(type == 0){
                for(String mem : groupToMembers.get(word)){
                    sb.append(mem).append("\n");
                }
            }
            else{
                sb.append(memberToGroup.get(word)).append("\n");
            }
        }

        System.out.println(sb.toString());

    }
}