package _13_2016년;

public class testNum13 {
    public static void main(String[] args) {
        int a = 5;
        int b = 24;
        //2016년

        int sum = 0;
        int[] month = {31,29,31,30,31,30,31,31,30,31,30};
        String[] days = new String[]{"THU","FRI","SAT","SUN","MON","TUE","WED"};
        for (int i = 0; i < a-1; i++){
            sum += month[i]; //121
        }
        sum += b; //145
        int result = sum%7; //5
        String answer = days[result];
        System.out.println(answer);
    }
}
