package Lv2._52_파일명_정렬;

import java.util.*;

class Solution {
    static class File{
        String file_name;
        String head;
        int number;

        public File(String file_name, String head, int number) {
            this.file_name = file_name;
            this.head = head;
            this.number = number;
        }
    }

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        File[] file_info = new File[files.length];

        for (int i = 0; i < files.length; i++) {
            String[] split = splitFileName(files[i]);
            file_info[i] = new File(files[i], split[0], Integer.parseInt(split[1]));
        }

        Arrays.sort(file_info, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if ((o1.head).equals(o2.head)) { 	// HEAD 부분이 같다면
                    return o1.number-o2.number; 	// NUMBER 오름차순 정렬
                }else{
                    return (o1.head).compareTo(o2.head); // HEAD 부분을 기준으로 사전 순 정렬
                }
            }
        });

        for(int i=0; i< file_info.length; i++) {
            answer[i] = file_info[i].file_name;
        }
        return answer;
    }

    String[] splitFileName(String file) {
        String[] str = new String[3];
        str[0] = ""; // HEAD
        str[1] = ""; // NUMBER
        str[2] = ""; // TAIL

        int idx = 0;
        for (int i = 0; i < file.length(); i++) {
            char c = file.charAt(i);

            if(idx==0 && !Character.isDigit(c)){
                str[idx] += c;
                continue;
            }

            if(idx==0 && Character.isDigit(c)){
                idx ++;
            }

            if(idx==1 && Character.isDigit(c)){
                str[idx] += c;
                continue;
            }

            if(idx==1 && !Character.isDigit(c)){
                idx ++;
            }
            str[idx] += c;
        }

        str[0] = str[0].toLowerCase(); // 소문자로 변환

        return str;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
        // {"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"}
    }
}
