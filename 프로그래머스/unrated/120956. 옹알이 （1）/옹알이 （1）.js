function solution(babbling) {
    var answer = 0;
    for (let element of babbling) {
        element = element.replace('aya','.').replace('ye','.').replace('woo','.').replace('ma','.');
        const regex = /[a-zA-Z]+/;
        if(!regex.test(element)){
            answer++;
        }
    }
    return answer;
}