import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        
        int len = num_list.length;
        ArrayList<Integer> list = new ArrayList<>();

        for(int num : num_list){
            list.add(num);
        }
        
            int end_num = num_list[len-1];
            int prev = num_list[len-2];
        
            if(end_num > prev){
                    list.add(end_num - prev);
            }else{
                list.add(end_num * 2);
            }
        
        return list.stream().mapToInt(i -> i).toArray();
        }
}