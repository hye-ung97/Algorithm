function solution(id_pw, db) {
    let map = new Map();

    for (const temp of db) {
        map.set(temp[0], temp[1]);
    }

    if(map.has(id_pw[0])){
        let pw = map.get(id_pw[0]);
        return pw === id_pw[1] ? 'login' : 'wrong pw';
    }
    return 'fail';
}