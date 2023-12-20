package Lv1._82_붕대_감기;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        final int maxHealth = health;
        int time = 0;

        for(int i=0; i< attacks.length; i++) {
            int timeI = (attacks[i][0])-1;
            int damage = attacks[i][1];
            health = healthCal(time, timeI, bandage, health, maxHealth);
            health = health - damage;

            if(health <= 0) {
                return -1;
            }
            time = timeI + 1;
        }

        return health;
    }

    private int healthCal(int time, int maxTime, int[] bandage, int health, int maxHealth) {
        int duration = maxTime - time;
        int totalBonus = (duration/bandage[0]) * bandage[2];
        int totalHeal = duration * bandage[1];

        health = health + totalBonus + totalHeal;
        if(health >= maxHealth) {
            health = maxHealth;
        }

        return health;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[] {5, 1, 5}, 30, new int[][] {{2, 10}, {9, 15}, {10, 5}, {11, 5}}));  // 5
        System.out.println(s.solution(new int[] {3, 2, 7}, 30, new int[][] {{1, 15}, {5, 16}, {8, 16}}));  // -1
    }
}
