import java.util.*;

class Solution {
    boolean solution(String s) {
        // boolean answer = true;

        Deque<Character> stack = new ArrayDeque<>();

        for(int i=0; i< s.length(); i++){
            
            char c = s.charAt(i);
            char ex = s.charAt(0);
            // 시작이 ')'라면 바로 false;
            if(ex == ')') return false; 
            
            if(c == '('){
                stack.push(c);
            }else{
                // )가 나왔을 떄 stack이 비어있으면 바로 false 를 리턴해준다. 
                if(stack.isEmpty()) return false;
                stack.pop();
            }    
        }
        // 비어 있으면 true를 반환하고, 하나 이상의 요소가 있으면 false를 반환
        boolean isEmpty = stack.isEmpty();
        return isEmpty;
    }
}