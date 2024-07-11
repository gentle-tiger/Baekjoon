class Solution {
    public int solution(int a, int b, int n) {
        return calculateCola(a, b, n, 0);

    }
    public int calculateCola(int a, int b, int n, int totalBottles){
     
        if(n < a) return totalBottles;
        
        int newCola = (n / a) * b; 
        int remainingBottles = (n % a) + newCola;
        
        return calculateCola(a,b,remainingBottles, totalBottles + newCola);
    }
}