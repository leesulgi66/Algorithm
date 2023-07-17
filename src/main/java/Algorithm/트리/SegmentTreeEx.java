package Algorithm.트리;

import java.util.Arrays;

public class SegmentTreeEx {
    static int[] number;
    public static void main(String[] args) {
        number = new int[]{5, 8, 4, 3, 7, 2, 1, 6};
        int N = number.length;
        // Tree의 높이는 전체 배열 개수를 log화 한 것
        // leaf는 n개이고, 전체 개수는 각 leaf를 더한 개수도 포함해야 하므로, log(n)의 높이로 구해야함(소수점이 있어 더 필요하니 ceil 사용)
        // Java의 log는 자연로그 함수이므로 log(2)를 통해 나누어 log2로 나누는 효과를 구함
        int h = (int)Math.ceil(Math.log(N)/Math.log(2));

        // Tree에 들어가는 Node의 개수는 2의 높이+1 제곱의 미만 개이다.
        int treeSize = (int)Math.pow(2, h+1);
        int[] treeArr = new int[treeSize];

        int startNode = (int)Math.pow(2, h);

        // tree에 배열 넣기
        for(int i=0; i<number.length; i++) {
            treeArr[i+startNode] = number[i];
        }

        // 합배열 채우기
        int[] sumArr = sum(treeArr);
        System.out.println(Arrays.toString(sumArr));  // [0, 36, 20, 16, 13, 7, 9, 7, 5, 8, 4, 3, 7, 2, 1, 6]

        // 구간 합 구하기
        int PFSum = prefixSum(2,6,startNode,treeArr);
        System.out.println(PFSum);

        // update 해보기
        update(10, 5, startNode, treeArr);
        System.out.println(Arrays.toString(treeArr));  // [0, 39, 20, 19, 13, 7, 12, 7, 5, 8, 4, 3, 10, 2, 1, 6]

    }

    private static int[] sum(int[] arr) {
        for(int i=arr.length; i>1 ; i--) {
            int parents = (i-1)/2;
            if(parents !=0){
                arr[parents] += arr[i-1];
            }
        }
        return arr;
    }

    private static int prefixSum(int a, int b,int startNode, int[] arr) {
        int start = a + startNode -1;
        int end = b + startNode -1;
        int sum = 0;
        while(start < end){
            if(start%2==1){
                sum += arr[start];
            }
            if(end%2==0){
                sum += arr[end];
            }

            start = (start+1)/2;
            end = (end-1)/2;
        }

        if(start == end) {
            sum += arr[start];
        }

        return sum;
    }

    private static int[] update(int a, int index,int startNode, int[] arr) {
        int node = index+startNode-1;
        int num = a - arr[node];
        while(node > 0) {
            arr[node] += num;
            node = node/2;
        }

        return arr;
    }

}
