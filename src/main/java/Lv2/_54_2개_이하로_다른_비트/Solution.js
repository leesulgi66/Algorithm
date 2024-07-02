function solution(numbers) {
    var answer = [];

    for(let i=0; i<numbers.length; i++) {
        let num = numbers[i];
        if(!(num % 2)) {
            answer[i] = num+1;
        }else{
            let bin = num.toString(2);
            let unit = cal(bin);
            answer[i] = unit;
        }
    }

    return answer;
}

function cal (num) {
    let addNum = "10";
    let maxLen = num.length;
    let index = -1;
    for(let i=maxLen; i>0; i--) {
        // 우측에서 첫번째 0 찾기
        if(num[i]==='0') {
            index = i;
            break;
        }
    }

    if(index == -1) {
        let rnum = addNum + num.substring(1, maxLen);
        return parseInt(rnum, 2);
    }else {
        let rnum = num.substring(0, index) + addNum + num.substring(index+2, maxLen);
        return parseInt(rnum, 2);
    }

}

console.log(solution([2,127,129]));