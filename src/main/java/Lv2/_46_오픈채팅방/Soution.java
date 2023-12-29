package Lv2._46_오픈채팅방;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = new String[record.length];
        Map<String, String> map = new HashMap<>();
        String enter = "님이 들어왔습니다.";
        String leave = "님이 나갔습니다.";

        for(int i=0; i<record.length; i++) {
            String[] s = record[i].split(" ");
                if(!s[0].equals("Leave")) {
                    map.put(s[1], s[2]);
                }
        }

        for(int i=0; i<record.length; i++) {
            String nickName = map.get(record[i].split(" ")[1]);
            if(record[i].contains("Enter")) {
                answer[i] = nickName+enter;
            }else if(record[i].contains("Leave")) {
                answer[i] = nickName+leave;
            }
        }

        answer = Arrays.stream(answer)
                .filter(s -> (s!=null && s.length() >0 ))
                .toArray(String[]::new);

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})));
        //"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."
    }
}
