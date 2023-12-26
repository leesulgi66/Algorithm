package Lv2._43_방문_길이;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        String[] commends = dirs.split("");
        int[] start = {0, 0};
        int[] temp = {0, 0};
        Map<String, Integer> map = new ConcurrentHashMap<>();

        for(int i=0; i<commends.length; i++) {
            if(Objects.equals(commends[i], "U")) {
                if(start[1]+1 <= 5) {
                    temp = start.clone();
                    start[1] = start[1]+1;
                    String s1 = numbs(temp, start);
                    String s2 = numbs(start, temp);
                    if(!map.containsKey(s1)) {
                        if(!map.containsKey(s2)) {
                            map.put(s1, 1);
                            map.put(s2, 1);
                            answer++;
                        }
                    }
                }
            }else if(Objects.equals(commends[i], "L")){
                if(start[0]-1 >= -5) {
                    temp = start.clone();
                    start[0] = start[0]-1;
                    answer = getAnswer(answer, start, temp, map);
                }
            }else if(Objects.equals(commends[i], "R")){
                if(start[0]+1 <= 5) {
                    temp = start.clone();
                    start[0] = start[0]+1;
                    answer = getAnswer(answer, start, temp, map);
                }
            }else if(Objects.equals(commends[i], "D")){
                if(start[1]-1 >= -5) {
                    temp = start.clone();
                    start[1] = start[1]-1;
                    answer = getAnswer(answer, start, temp, map);
                }
            }
        }
        return answer;
    }

    private int getAnswer(int answer, int[] start, int[] temp, Map<String, Integer> map) {
        String s1 = numbs(temp, start);
        String s2 = numbs(start, temp);
        if(!map.containsKey(s1)) {
            if(!map.containsKey(s2)) {
                map.put(s1, 1);
                map.put(s2, 1);
                answer++;
            }
        }
        return answer;
    }

    String numbs(int[] a, int[] b) {
        StringBuilder s = new StringBuilder();
        s.append(a[0]);
        s.append(a[1]);
        s.append(b[0]);
        s.append(b[1]);
        return s.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.solution("ULURRDLLU")); // 7
        System.out.println(s.solution("LULLLLLLU")); // 7
    }
}
