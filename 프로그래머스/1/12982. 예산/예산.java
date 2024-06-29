import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        
        int budgetCopy = budget; 
        int count = 0;
        
        for(int price : d){
            if(budget >= price){
                budget -= price;
                count++;
            }else{
                break;
            } 
        }
        return count;
    }
}