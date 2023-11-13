function solution(array) {
    var answer = 0;
    let str = array.join('');
    for (const temp of str) {
        if(temp === '7'){
            answer++;
        }
    }
    return answer;
}