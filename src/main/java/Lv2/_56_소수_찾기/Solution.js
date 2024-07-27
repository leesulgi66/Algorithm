class Queue {
    // 기본 Queue 클래스
    constructor() {
        this._arr = [];
    }
    enqueue(item) {
        this._arr.push(item);
    }
    dequeue(){
        return this._arr.shift();
    }
    size() {
        return this._arr.length;
    }
}

let queue = new Queue(); // 전역변수로 큐 생성

function solution(numbers) {
    var answer = 0;
    const len = numbers.length;
    const set = new Set();
    let list = new Array(len).fill(-1);

    queue.enqueue([numbers,"", list]);  // 첫큐에 number, 기본string, visit배열을 입력
    console.log(queue);

    while(queue.size() > 0) {
        let q = queue.dequeue(); // 들어있는 큐를 꺼냄
        let visit = q[2]; // 큐에서의 visit배열 
        let s = q[1]; // 큐에있는 기본 string

        for(let i=0; i<len; i++) {
            if(visit[i] == -1) { // visit 배열이 방문하지 않았을때
                let visitN = visit.slice(); // visti 배열 얕은 복사.
                visitN[i] = 1; // 방문 처리
                set.add(parseInt(s+numbers.charAt(i))); // 중복 방지를 위해 set에 기본string + slice string을 넣어주기    
                queue.enqueue([numbers, s+numbers.charAt(i), visitN]); // 다시 큐에 number, 변경된 string, visit배열 넣기
            }
        }
    }

    console.log(set);
    
    for(n of set) {
        // set 배열을 돌며 소수찾기
        if(isPrime(n)) answer++;
    }

    return answer;
}

function isPrime(num) {
    if(num <= 1){
        return false;
    }
    for(let i=2; i<=Math.sqrt(num); i++){
        if(num % i == 0) return false;
    }
    console.log(num);
    return true;
}

console.log(solution("171"));