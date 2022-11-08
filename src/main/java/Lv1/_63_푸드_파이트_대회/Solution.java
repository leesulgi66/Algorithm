package Lv1._63_푸드_파이트_대회;

class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        StringBuilder str = new StringBuilder();
        for(int i = 1; i < food.length; i++) {
            int addnum = food[i]/2;
            for(int j = 0; j < addnum; j++) {
                String foods = Integer.toString(i);
                str.append(foods);
            }
        }

        answer.append(str);
        answer.append("0");
        String reversedStr = str.reverse().toString();
        answer.append(reversedStr);

        return answer.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1, 3, 4, 6})); // "1223330333221"
        System.out.println(s.solution(new int[]{1, 7, 1, 2})); // "111303111"
    }
}
