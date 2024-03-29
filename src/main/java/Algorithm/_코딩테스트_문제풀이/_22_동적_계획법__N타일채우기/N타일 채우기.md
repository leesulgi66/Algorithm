# N타일 채우기

[문제 링크](https://www.acmicpc.net/problem/11726)

### 문제
2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.

![N타일](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/11726/1.png)

### 입력
첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

### 출력
첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.

***

| 예제 입력1 | 예제 출력1 |
|--------|--------|
| 2      | 2      |


| 예제 입력2 | 예제 출력2 |
|--------|--------|
| 9      | 55     |


___

#### 01 문제 분석하기
문제의 내용에 따라 2XN 크기의 직사각형을 1X2 또는 2X1 크기의 타일로 채우는 경우의 
수를 구하는 점화식 D[N]을 정의합니다. 점화식을 정의한 후에는 문제가 단순화되도록 
가정하는 것이 중요합니다. 1부터 N-1 크기에 직사각형과 관련된 경우의 수를 모두 구해 
놓았다고 가정하고 문제에 접근해 보겠습니다.

먼저 N 보다 작은 길이의 모든 경우의 수가 구해져 있다고 가정했으므로 N 바로 직전에 
구해야 하는 N-1, N-2에서 N 의 길이를 만들기 위한 경우의 수를 생각해 보겠습니다.

![N타일 1](https://github.com/leesulgi66/Algorithm/assets/107823688/53a41d18-32d8-4832-af69-417f1751f1eb)

이와 같이 생각을 할 수 있다면 다음과 같이 점화식을 도출할 수 있습니다.

##### *점화식*
D[N] = (D[N-1] + D[N-2])

이제 본격적으로 문제를 풀면 됩니다.


#### 02 손으로 풀어보기

1. 점화식의 형태와 의미를 도출합니다.  
D[N] : 길이 N으로 만들 수 있는 타일의 경우의 수
2. 점화식을 구합니다.  
D[N] = D[N-1] + D[N-2]   // D[N-1]과 D[N-2]의 경우의 수의 합이 D[N]
3. 점화식으로 D 배열을 채운 후 D[N]의 값을 출력합니다. D배열을 채울 때마다 
문제에서 주어진 값(10,007)으로 %연산을 수행하는 것도 잊지 마세요.  
   ![N타일 2](https://github.com/leesulgi66/Algorithm/assets/107823688/e94ec09a-060e-4c68-901f-f229aa7ff989)



#### 03 슈도코드 작성하기
```java
D[N](길이가 2xN인 직사각형이 2x1,2x2 타일을 봍일 수 있는 경우의 수)
D[1] = 1;   // 길이가 2*1일 때 타일의 경우의 수
D[2] = 2;   // 길이가 2*2일 때 타일의 경우의 수

for(i -> 3~N){
    D[i] = D[i -1] + D[i -2]  // N-1 길이일 때 경우의 수 + N-2 길이일 때 경우의 수
    나온 결과를 10007 나머지 연산 수행하기
}
D[N]값 출력하기

```
