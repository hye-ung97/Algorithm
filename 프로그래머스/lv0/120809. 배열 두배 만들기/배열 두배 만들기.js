function solution(numbers) {
    var answer = [];
    for(var i of numbers){
        answer.push(i * 2);
    }
    return answer;
    //return numbers.reduce((a, b) => [...a, b * 2], []);
    //const solution = (numbers) => numbers.map((number) => number * 2)
}