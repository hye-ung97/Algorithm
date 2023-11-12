function solution(my_string) {
    my_string = my_string.toLowerCase();
    let arr = [...my_string];
    return arr.sort().join('');
}