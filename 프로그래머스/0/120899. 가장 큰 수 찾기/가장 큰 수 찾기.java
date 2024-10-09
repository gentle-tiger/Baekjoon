class Solution {
    public int[] solution(int[] array) {
        int maxValue = array[0]; // 배열의 첫 번째 요소로 초기화
        int maxIndex = 0;

        // 배열을 순회하면서 가장 큰 값과 인덱스를 찾음
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
                maxIndex = i;
            }
        }

        // 결과를 int[] 배열로 반환
        int[] result = {maxValue, maxIndex};
        return result;
    }
}
