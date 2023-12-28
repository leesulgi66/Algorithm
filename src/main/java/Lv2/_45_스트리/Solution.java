package Lv2._45_스트리;

import java.util.Stack;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(int i=0; i<skill_trees.length; i++) {
            Stack<String> stack = new Stack<>();
            String[] skills = skill.split("");
            for (int k=skills.length-1; k>=0; k--) {
                stack.push(skills[k]);
            }
            String[] words = skill_trees[i].split("");
            for(int j=0; j<words.length; j++) {
                if(!stack.isEmpty()) { // stack이 비어있지 않고
                    if(stack.peek().equals(words[j])) { // 제일 위의 값이 같으면
                        stack.pop(); // pop() 해준다.
                    }
                }
            }

            if(stack.isEmpty()) { // stack이 모두 비어있다면 순차대로 스킬을 쓴 것.
                answer++;
            }else{
                int count = 0;
                for(String s : stack) { // stack에 값이 남아 있다면, 현재 단어에서 남은 스택의 단어가 없어야 한다. "AECB" 에서 CB가 차례대로 나가고 D가 남는다면 "AECB"에 D가 없어야 참.
                    if(!skill_trees[i].contains(s)) {
                        count++;
                    }
                }
                if(stack.size() == count) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
