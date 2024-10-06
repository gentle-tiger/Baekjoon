class Solution {
    public String solution(String my_string) {
        StringBuilder result = new StringBuilder();
        
        // 문자열의 각 문자를 순회 
        for(int i = 0; i < my_string.length(); i++){
            char c = my_string.charAt(i);
            
            // 대문자라면 소문자로 변환
            if(Character.isUpperCase(c)){
                result.append(Character.toLowerCase(c));
            }
            
            // 소문자라면 대문자로 변환
            else if(Character.isLowerCase(c)){
                result.append(Character.toUpperCase(c));
            }
        }
        return result.toString();
    }
}