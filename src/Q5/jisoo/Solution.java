package Q5.jisoo;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("()(((()())(())()))(())")); // 17
        System.out.println(solution("()()()")); // 0
        System.out.println(solution("(())")); // 2
        System.out.println(solution("((()))")); // 4
    }
    public static int solution(String arrangement) {
        int answer = 0;
        Stack<Character> ��ȣüũ�뽺�� = new Stack<>();
        for(int i=0 ; i<arrangement.length() ; i++) {
            char ch = arrangement.charAt(i);

            // i�� ������ �� ��Ұ� �ƴϰ�, �ٷ� ���� ��Ұ� ')'�̸� ������ ó��
            if(i < arrangement.length() - 1) {
                char ch2 = arrangement.charAt(i+1);
                if(ch == '(' && ch2 == ')') {
                    answer += ��ȣüũ�뽺��.size();
                    i++;
                    continue;
                }
            }

            if(ch == '(') {
                ��ȣüũ�뽺��.push(ch);
            }
            else if(ch == ')') {
                ��ȣüũ�뽺��.pop();
                answer++;
            }
        }
        return answer;
    }
}
