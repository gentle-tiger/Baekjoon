class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, target, 0);
    }
    
    int dfs(int[] numbers, int index, int target, int cur){
        
        // index 가 numbers의 길이만큼 순회했을 때 현재의 값이 target과 일치한다면 + 1
        if(index == numbers.length){
            if(cur == target){
                return 1;
            }else{
                return 0; 
            }
        }
        
        
        int sum = 0; 
        sum += dfs(numbers, index + 1, target, cur + numbers[index]);
        sum += dfs(numbers, index + 1, target, cur - numbers[index]);
        
        
        return sum; 
    }
}