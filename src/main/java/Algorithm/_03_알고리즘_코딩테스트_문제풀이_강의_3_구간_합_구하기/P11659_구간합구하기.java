package Algorithm._03_알고리즘_코딩테스트_문제풀이_강의_3_구간_합_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11659_구간합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int suNo =Integer.parseInt(stringTokenizer.nextToken());
        int quizNo =Integer.parseInt(stringTokenizer.nextToken());

        long[]S = new long[suNo + 1]; // 0번째 인덱스를 한칸 밀기 위해 +1

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i=1; i<=suNo; i++) { // 합배열 만들기
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int q=0; q<quizNo; q++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i-1]);
        }

    }
}
