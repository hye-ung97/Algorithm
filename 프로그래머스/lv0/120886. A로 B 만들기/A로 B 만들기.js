function solution(before, after) {
    let beforSort = [...before].sort().join('');
    let afterSort = [...after].sort().join('');
    return beforSort === afterSort ? 1 : 0;
}