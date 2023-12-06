package Lv2._38_주차_요금_계산;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Solution {
    static SimpleDateFormat dateFormat;
    static HashMap<String, String> map;
    static HashMap<String, Long> timeMap;
    public int[] solution(int[] fees, String[] records) throws ParseException {
        List<Integer> result = new ArrayList<>();
        dateFormat = new SimpleDateFormat("HH:mm");
        map = new HashMap<>();
        timeMap = new HashMap<>();

        for(String s : records) {
            if(s.contains("IN")) {
                String key = s.split(" ")[1];
                String value = s.split(" ")[0];
                map.put(key, value);
            }else {
                String key = s.split(" ")[1];
                String value = s.split(" ")[0];
                timeCal(key, value); // 시간 차이 계산(함수화)
            }
        }

        if(!map.isEmpty()) { // 만약 출차 하지 않은 차가 있다면
            HashMap<String, String> putMap = new HashMap<String, String>(map);
            for (Map.Entry<String, String> entry : putMap.entrySet()) {
                String end = "23:59";
                timeCal(entry.getKey(), end);
            }
        }

        for (Map.Entry<String, Long> entry : timeMap.entrySet()) {
            long basicTime = fees[0];
            long basicCost = fees[1];
            long cntTime = fees[2];
            long cntCost = fees[3];

            String key = entry.getKey();
            Long val = entry.getValue();

            if(val < basicTime) { // 기본 요금일 경우
                long cost = basicCost;
                timeMap.put(key, cost);
            }else { // 추가요금 계산
                long cost = basicCost;
                val -= basicTime;
                double addTime = (double)val/(double)cntTime;
                double addCost = (Math.ceil(addTime)) * cntCost;
                cost += addCost;
                timeMap.put(key, cost);
            }
        }

        List<String> keySet = new ArrayList<>(timeMap.keySet()); // key값으로 정렬을 위한 keySet

        Collections.sort(keySet);  // key 값으로 정렬

        for(String s : keySet) { // 정렬된 순으로 list 에 추가
            result.add(Math.toIntExact(timeMap.get(s)));
        }

        int[] answer = new int[result.size()];  // 반환 배열 생성

        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    private void timeCal(String key, String value) throws ParseException {
        if(map.containsKey(key)) {
            String innerKey = map.get(key);
            Date date = dateFormat.parse(innerKey); // 입장한 시간
            Date date2 = dateFormat.parse(value); // 출차한 시간
            long time = (date2.getTime() - date.getTime())/1000/60;
            if(timeMap.containsKey(key)) {
                Long timeValue = timeMap.get(key) + time;
                timeMap.put(key, timeValue);
                map.remove(key);
            }else {
                timeMap.put(key, time);
                map.remove(key);
            }
        }
    }

    public static void main(String[] args) throws ParseException {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));
        System.out.println(Arrays.toString(s.solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"})));
        System.out.println(Arrays.toString(s.solution(new int[]{180, 5000, 10, 1000}, new String[]{"05:59 0000 IN", "05:59 1111 IN"}))); // 95000, 95000
    }
}
