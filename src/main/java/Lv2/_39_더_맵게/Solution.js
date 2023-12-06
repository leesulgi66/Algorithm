function solution(scoville, K) {
    let answer = 0;
    let heap = new MinHeap;
    for(let i=0; i<scoville.length; i++) {
        heap.heappush(scoville[i]);
    }

    while(heap.heappeek() < K) {
        if(heap.size() == 1) {
            if(heap.heappeek() < K) {
                return -1;
            }
        }

        let a = heap.heappop();
        let b = heap.heappop();
        heap.heappush(a+(b*2));
        answer++;
    }

    return answer;
}

class MinHeap {
    constructor() {
        this.heap = [ null ]; // 첫 원소는 사용x
    }

    size() {
        return this.heap.length - 1;
    }

    getMin() {
        return this.heap[1] ? this.heap[1] : null;
    }

    swap(a, b) {
        [ this.heap[a], this.heap[b] ] = [ this.heap[b], this.heap[a] ];
    }

    heappush(value) {
        this.heap.push(value);
        let curIdx = this.heap.length - 1;
        let parIdx = (curIdx / 2) >> 0;

        while(curIdx > 1 && this.heap[parIdx] > this.heap[curIdx]) {
            this.swap(parIdx, curIdx)
            curIdx = parIdx;
            parIdx = (curIdx / 2) >> 0;
        }
    }

    heappop() {
        const min = this.heap[1];
        if(this.heap.length <= 2) this.heap = [ null ];
        else this.heap[1] = this.heap.pop();

        let curIdx = 1;
        let leftIdx = curIdx * 2;
        let rightIdx = curIdx * 2 + 1;

        if(!this.heap[leftIdx]) return min;
        if(!this.heap[rightIdx]) {
            if(this.heap[leftIdx] < this.heap[curIdx]) {
                this.swap(leftIdx, curIdx);
            }
            return min;
        }

        while(this.heap[leftIdx] < this.heap[curIdx] || this.heap[rightIdx] < this.heap[curIdx]) {
            const minIdx = this.heap[leftIdx] > this.heap[rightIdx] ? rightIdx : leftIdx;
            this.swap(minIdx, curIdx);
            curIdx = minIdx;
            leftIdx = curIdx * 2;
            rightIdx = curIdx * 2 + 1;
        }

        return min;
    }

    heappeek() {
        const min = this.heap[1];
        return min;
    }
}

console.log(solution(scoville = [1, 2, 3, 9, 10, 12], K = 7));