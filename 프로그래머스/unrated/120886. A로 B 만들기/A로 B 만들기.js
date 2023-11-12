function solution(before, after) {
    var answer = 0;
    let beforSort = [...before].sort().join('');
    let afterSort = [...after].sort().join('');
    return beforSort === afterSort ? 1 : 0;
}