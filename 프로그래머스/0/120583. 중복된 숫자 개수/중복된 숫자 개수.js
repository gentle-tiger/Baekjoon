function solution(array, n) {
    let count = 0;
    var answer = array.filter(item => item === n ? count++ : 0)
    return count;
}