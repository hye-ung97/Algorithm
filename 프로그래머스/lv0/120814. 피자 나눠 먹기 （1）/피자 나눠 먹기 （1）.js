function solution(n) {
    var a = Math.trunc(n / 7);
    return n % 7 === 0 ? a : a + 1;
}