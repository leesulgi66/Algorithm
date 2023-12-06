function solution(n, t, m, p) {
    var answer = '';
    let numbers = "";
    let cnt = 0;
    const max = t*m; // 반복문의 최대 값

    for(let i=0; numbers.length < max; i++) {
        numbers = numbers + i.toString(n);
    }

    for(let i=p-1; i < max; i=i+m){
        answer = answer + (numbers.charAt(i));
        cnt++;
    }

    return answer.toUpperCase();
}

console.log(solution(2,4,2,1));