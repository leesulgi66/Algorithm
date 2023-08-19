function solution(n, k) {
    let answer = 0;
    let num = n.toString(k);
    let numbs = num.split("0");

    numbs.forEach(function(item){
        if(item != 1 && item != ""){
            const i = parseInt(item);
            if(isPrime(i)) answer++;
        }
    })

    return answer;
}

function isPrime(num) {
    if(num == 1){
        return false;
    }
    for(let i=2; i<=Math.sqrt(num); i++){
        if(num % i == 0) return false;
    }
    return true;
}


console.log(solution(437674, 3));