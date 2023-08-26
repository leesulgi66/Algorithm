function solution(targets) {
    let answer = 1;
    targets.sort((a,b) => b[0] - a[0]);
    let num = targets[0][0];
    console.log(targets);

    for(let i=1; i<targets.length; i++) {
        if(targets[i][1] <= num) {
            num = targets[i][0];
            answer++;
        }
    }

    return answer;
}

console.log(solution(targets=[[4,5],[4,8],[10,14],[11,13],[5,12],[3,7],[1,4]]));