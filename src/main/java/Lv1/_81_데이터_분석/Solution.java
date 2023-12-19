package Lv1._81_데이터_분석;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        String[] sortStringArr = {"code", "date", "maximum", "remain"};
        int extN = 0;
        int sortN = 0;
        for(int i=0; i<sortStringArr.length; i++) {
            if(sortStringArr[i].equals(sort_by)) {
                sortN = i;
            }
            if(sortStringArr[i].equals(ext)) {
                extN = i;
            }
        }

        // date로 정렬
        int finalExtN = extN;
        Arrays.sort(data, Comparator.comparingInt(o -> o[finalExtN]));

        ArrayList<int[]> list = new ArrayList<>();
        int cnt = 0;
        for(int i=0; i<data.length; i++) {
            if(data[i][extN] < val_ext) {
                cnt++;
                list.add(data[i]);
            }
        }

        int[][] answer = new int[list.size()][4];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        int finalSortN = sortN;
        Arrays.sort(answer, Comparator.comparingInt(o -> o[finalSortN]));

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        System.out.println(Arrays.deepToString(s.solution(data, "date", 20300501, "remain")));
    }
}
