function solution(msg) {
    let answer = [];
    let words = [];
    // words 배열에 A~Z까지 저장한다.
    for (let i=0; i<26; i++) {
        words[i+1] = String.fromCharCode([65+i]);
    }

    while(msg.length > 0) {
        for(let i=msg.length; i>0; i--){
            let target = msg.substring(0, i);
            if(words.includes(target)) {
                answer.push(words.indexOf(target)); // 찾은 값의 인덱스 저장
                if(msg.length > target.length+1) {
                    words.push(target+ msg.substring(i, i+1));
                }
                msg = msg.substring(i, msg.length);
                break;
            }
        }
    }

    return answer;
}

console.log(solution("KAKAO"));
console.log(solution("TOBEORNOTTOBEORTOBEORNOT"));