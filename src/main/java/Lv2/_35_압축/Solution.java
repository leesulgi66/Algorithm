package Lv2._35_압축;

import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> result = new ArrayList();
        HashMap<String, Integer> map = new HashMap<>();
        int index = 27;
        for(int i=0; i<26; i++) {  // 기본 A~Z 까지의 인덱스 1~26
            char word = (char)(65 + i); // 첫 문자 A의 아스키 코드
            map.put( Character.toString(word) , i+1); // 1씩 증가 시키며 아스키코드로 저장한다.
        }

        StringBuffer sb = new StringBuffer(msg); // 문자열을 쉽게 자르기 위한 StringBuilder

        while(sb.length() > 0) { // 
            for (int i = sb.length(); i > 0; i--) {
                String target = sb.substring(0, i);
                if (map.containsKey(target)) {
                    result.add(map.get(target)); // 해당되는 단어의 index 값을 저장 한다.
                    if (sb.length() > target.length()+1) { // sb의 뒤에 단어가 남아있는 것을 length를 이용해 체크
                        map.put((target + sb.substring(i, i + 1)), index); // 찾은 단어 + 다음 단어를 만들고 추가 저장을 해준다.
                        index++; // 인덱스 증가
                    }
                    sb.delete(0, i); // 찾은 단어만큼 앞부분을 삭제한다.
                    break;
                }
            }
        }

        return result.stream() // stream 을 이용해 List 를  Array 로 변경한다.
                .filter(Objects::nonNull)
                .mapToInt(i -> i)
                .toArray();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(Arrays.toString(s.solution("KAKAO")));
        System.out.println(Arrays.toString(s.solution("TOBEORNOTTOBEORTOBEORNOT")));
    }
}
