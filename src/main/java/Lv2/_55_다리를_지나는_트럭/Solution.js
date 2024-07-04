function solution(bridge_length, weight, truck_weights) {
    let sum = 0;
    let time = 0;
    let idx = 0;

    const queue = new Queue();

    while(true) {
        if(idx == truck_weights.length) {
            time += bridge_length;
            break;
        }
    
        if(queue.size() == bridge_length) {
            let temp = queue.dequeue();
            sum -= temp;
            if(sum + truck_weights[idx] <= weight) {
                queue.enqueue(truck_weights[idx]);
                sum += truck_weights[idx];
                idx++;
                time++;
                continue;
    
            }else {
                queue.enqueue(0);
                time++;
                continue;
            }
    
        }
    
        if(sum + truck_weights[idx] <= weight) {
            queue.enqueue(truck_weights[idx]);
            sum += truck_weights[idx];
            idx++;
            time++;
        }else {
            queue.enqueue(0);
            time++;
        }
    }
    
    return time;
}

class Queue {
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


console.log(solution(2,10,[7,4,5,6]));