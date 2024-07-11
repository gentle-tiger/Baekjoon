class Solution {
    public int solution(int a, int b, int n) {
        // 상빈이가 받은 콜라 병 수를 저장할 변수
        int totalCola = 0;
        // 현재 보유 중인 빈 병 수가 교환할 수 있는 최소 병 수보다 적어질 때까지 반복
        while (n >= a) {
            // 교환 가능한 콜라 병 수 계산 (현재 보유한 빈 병을 a개 주고 b병을 받음)
            int newCola = n / a * b;
            // 남은 빈 병 수 계산 (현재 보유한 빈 병 수에서 교환에 사용한 병 수의 나머지 + 받은 새 콜라 병 수)
            int remainingBottles = n % a + newCola;
            // 상빈이가 받은 콜라 병 수를 누적
            totalCola += newCola;
            // 새로운 빈 병 수로 업데이트
            n = remainingBottles;
        }
        // 최종적으로 받은 콜라 병 수 반환
        return totalCola;
    }
}