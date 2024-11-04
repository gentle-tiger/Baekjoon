class Solution {
    public int solution(String str1, String str2) {
        boolean answer = str2.contains(str1);
        return answer == true ? 1 : 0;
    }
}