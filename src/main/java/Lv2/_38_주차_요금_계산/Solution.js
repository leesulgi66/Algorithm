function solution(fees, records) {
    var numTime = {};
    let period = {};
    let checkArr = [];
    for(let i=0; i<records.length; i++) {
        if(records[i].includes("IN")) {
            const key = records[i].split(" ")[1];
            const val = records[i].split(" ")[0];
            numTime[key] = val;
            checkArr.push(key);
        } else {
            const key = records[i].split(" ")[1];
            const val2 = records[i].split(" ")[0];
            const val1 = numTime[key];
            let duration = dateCal(val1, val2);
            console.log(duration);
            if(period[key]) {
                const val = period[key];
                period[key] = (val + duration);
            }else {
                period[key] = duration;
            }
            // for(let i = 0; i < checkArr.length; i++) {
            //     if(checkArr[i] === key)  {
            //       checkArr.splice(i, 1);
            //       i--;
            //     }
            //   }
            checkArr = checkArr.filter((element) => element !== key);
        }
    }

    if(checkArr.length != 0) {
        for(let i=0; i<checkArr.length; i++) {
            const key = checkArr[i];
            const val2 = "23:59"
            const val1 = numTime[key];
            let duration = dateCal(val1, val2);
            const val = period[key];
            if(period[key]) {
                const val = period[key];
                period[key] = (val + duration);
            }else {
                period[key] = duration;
            }
        }
    }

    let answer = [];

    for(const key in period) {
        const basicTime = fees[0];
        const basicCost = fees[1];
        const cntTime = fees[2];
        const cntCost = fees[3];

        let val = period[key];

        if(val < basicTime) {
            let cost = basicCost;
            period[key] = cost;
        }else {
            let cost = basicCost;
            val = val - basicTime;
            let addTime = val/cntTime;
            let addCost = (Math.ceil(addTime)) * cntCost;
            cost = cost + addCost;
            period[key] = cost;
        }

    }

    let sortable = [];
    for (let key in period) {
        sortable.push([key, period[key]]);
    }

    sortable.sort(function(a, b) {
        return a[0] - b[0];
      });

    for(let i=0; i<sortable.length; i++) {
        answer.push(sortable[i][1]);
    }

    return answer;
}

function dateCal(time1, time2) {
    const date = "2023-09-03 ";
    const t1 = new Date(date+time1).getTime();
    const t2 = new Date(date+time2).getTime();
    return (t2-t1)/1000/60;
}
console.log(solution(fees = [180, 5000, 10, 600], records = ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]));
console.log(solution(fees = [1, 461, 1, 10], records = ["00:00 1234 IN"]));