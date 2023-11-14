function solution(arr) {
    return arr.reduce((answer, b) => answer + b, 0) / arr.length;;
}