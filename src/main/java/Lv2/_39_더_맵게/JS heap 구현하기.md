# [참고 블로그](https://velog.io/@longroadhome/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-JS%EB%A1%9C-%EA%B5%AC%ED%98%84%ED%95%98%EB%8A%94-HEAP)

### 힙에서 부모 - 자식 간 관계
앞서서 힙은 배열을 이용해 완전 이진 트리 형태로 구현한다고 했다. 이진 트리이기 때문에 당연히 부모와 자식 노드가 발생하는데, 힙의 경우엔 보통의 완전 이진 트리와는 다르게 반정렬 상태(느슨한 정렬 상태)를 유지한다. 이는 최대힙이라면 큰 값이 부모 노드쪽에, 최소힙이라면 작은 값이 부모 노드 쪽에 배치되는 것만 유지하고 왼쪽 자식과 오른쪽 자식은 부모 노드보다 작은 값을 유지하기만 하면 된다.

그렇다면 배열을 이용해 어떻게 힙을 구현할 수 있을까? 알고리즘 문제에서 배열의 첫번째 값은 비워두는 경우가 종종 있다. 이는 배열의 첫번째 요소가 가지는 index는 0이기 때문에 '1번째' 라는 말과 인지부조화가 생기기에 계산의 편의성을 위해 그러한 경향을 띄는 편이다. 물론 이러한 부조화에 익숙하다면 굳이 처음을 비워둘 필요는 없지만, 해당 포스팅에서도 역시 계산의 편의성을 위해 첫 배열의 값은 비워두고 시작한다.  

```
class Heap {
  constructor() {
    this.heap = [ null ];	// 첫 원소는 사용 X
  }
}
```

배열의 첫 원소는 사용하지 않으므로 부모와 자식 간 다음의 관계가 성립한다. 완전 이진 트리의 일종이기 때문에 Binaray Search tree에서의 부모-자식 간 관계와 유사하다.  
- 왼쪽 자식의 index = 부모 index * 2
- 오른쪽 자식의 index = (부모 index * 2) + 1
- 부모의 index = Math.floor(자식의 인덱스 / 2);

### 삽입

삽입 역시 비슷하다. 일단 마지막 노드에 들어온 값을 push하여 삽입한다. 이때 재귀적이든 반복문을 돌리든 부모노드를 확인하면서 들어온 값이 부모노드보다 작은지 큰지를 구분하여 위치를 교환을 계속 실행해주며 정렬해준다. 최소힙으로 구현할 때의 삽입과정을 살펴보자.  

###### 최대힙이라면 반대의 계산결과로 적용해주면 된다!

```
... 

heappush(value) {
  this.heap.push(value);
  let curIdx = this.heap.length - 1;
  let parIdx = (curIdx / 2) >> 0;
  
  // 최소힙이므로 부모노드가 제일 작아야 한다. 즉 부모노드가 현재노드보다 큰 지 검사하며 반복한다.
  while(curIdx > 1 && this.heap[parIdx] > this.heap[curIdx]) {
    [ this.heap[parIdx], this.heap[curIdx] ] = [ this.heap[curIdx], this.heap[parIdx] ];
    // 구조분해 할당을 이용해 부모와 자식을 swap 한다. 따로 함수로 빼주어 작성해도 좋다.
    curIdx = parIdx;
    parIdx = (curIdx / 2) >> 0;
  }
}
```

### 삭제
삭제 역시 로직은 이진 트리의 그것(?)과 유사하다. 일단 힙에서는 최소힙이든 최대힙이든 루트 노드가 항상 먼저 배출되어야 한다. 배출되고 나서 생기는 빈자리는 가장 마지막 노드, 즉 배열에서 제일 뒤에 있는 값을 가져온다. 그리고 다시 루트노드서 부터 재정렬을 실행해준다. 역시 **최소힙** 에서의 제거과정을 코드로 보자.  

```
..
heappop() {
  const min = this.heap[1];	// 배열 첫 원소를 비워두므로 root는 heap[1]에 항상 위치한다.
  if(this.heap.length <= 2) this.heap = [ null ];
  else this.heap[1] = this.heap.pop();
  // 배열 마지막 원소를 root 위치에 먼저 배치하는 과정이다.
  // if-else로 분기되는 이유는 추후 heap이 비었는지 아닌지 확인하기 위해 size 체크 함수를 만들때 -1을 통해 0을 만들어주기 때문.
  
  let curIdx = 1;
  let leftIdx = curIdx * 2;
  let rightIdx = curIdx * 2 + 1;
  
  if(!this.heap[leftIdx]) return min;
  // 왼쪽 자식이 없다는 것은 오른쪽 자식도 없는, 즉 루트만 있는 상태이므로 바로 반환!
  if(!this.heap[rightIdx]) {
    if(this.heap[leftIdx] < this.heap[curIdx]) {
      [ this.heap[leftIdx], this.heap[curIdx] ] = [ this.heap[curIdx], this.heap[leftIdx] ];
      // 오른쪽 자식이 없다면 왼쪽 자식하나만 있다는 것을 의미한다.
    }
    return min;
  }
  
  // 위에 조건에 걸리지 않는 경우 왼쪽과 오른쪽 자식이 모두 있는 경우이다.
  // 따라서 현재 노드가 왼쪽 또는 오른쪽 보다 큰 지 작은지를 검사하며 반복한다.
  while(this.heap[leftIdx] < this.heap[curIdx] || this.heap[rightIdx] < this.heap[curIdx]) {
    // 왼쪽과 오른쪽 자식 중에 더 작은 값과 현재 노드를 교체하면 된다.
    const minIdx = this.heap[leftIdx] > this.heap[rightIdx] ? rightIdx : leftIdx;
    [ this.heap[minIdx], this.heap[curIdx] ] = [ this.heap[curIdx], this.heap[minIdx] ];
    curIdx = minIdx;
    leftIdx = curIdx * 2;
    rightIdx = curIdx * 2 + 1;
  }
  
  return min;
}
```

### 전체 코드
삽입과 삭제, 두 가지 핵심 로직 구현을 완료했다. 나머지는 그저 현재 heap의 크기와 값을 삭제하지 않고 작은 값이 무엇인지만 알려주는 유틸성 함수들만 구현해주었다. 주석을 제거한 전체 코드는 아래와 같다.  

```java
class MinHeap {
    constructor() {
        this.heap = [ null ];
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
}
```