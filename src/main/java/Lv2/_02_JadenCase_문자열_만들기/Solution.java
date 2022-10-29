package Lv2._02_JadenCase_문자열_만들기;

class Solution {
    public String solution(String s) {
        String answer = s.toLowerCase();
        char[] words = answer.toCharArray();
        for(int i = 0 ; i < words.length; i++){
            if(words[i] != words[0]) {
                if(words[i] == ' ') {
                    if(words[i] != words[words.length-1] && words[i+1] != ' ' && words[i] > 96 && words[i] < 123){
                        words[i+1] = (char)(words[i+1]-32);
                    }
                }else {
                    if (words[i-1] == ' ' && words[i] > 96 && words[i] < 123) {
                        words[i] = (char) (words[i] - 32);
                    }
                }
            }else{
                if(words[0] > 96) {
                    words[0] = (char)(words[0] - 32);
                }
            }
        }
        answer = new String(words);

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution("3people unFollowed me"));
        System.out.println(s.solution("A bb 1a Aa vvv"));
    }
}
