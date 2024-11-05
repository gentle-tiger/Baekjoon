class Solution {
    public int solution(String my_string, String target) {
        boolean answer = my_string.contains(target);
        return answer ? 1: 0;
    }
}