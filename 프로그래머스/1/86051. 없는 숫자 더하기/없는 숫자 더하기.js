function solution(numbers) {
    var answer = 0;
    numbers = numbers.sort();
    var sum = numbers.reduce((acc, number) => acc + number, 0);
    return 45 - sum;
}