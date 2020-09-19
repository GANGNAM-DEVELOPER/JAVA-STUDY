package K5.incheol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Incheol Jung
 */
public class Solution {
    public static Map<String, String> userNameMap = new HashMap<>();

    static class History{
        private String id;
        private Action action;

        public History(String id, Action action) {
            this.id = id;
            this.action = action;
        }

        public static History createBy(String str){
            String[] arr = str.split(" ");
            Action action = arr.length > 1 ? Action.findAction(arr[0].toLowerCase()) : null;
            String id = arr.length > 1 ? arr[1] : "";
            String name = arr.length > 2 ? arr[2] : "";

            History history = new History(id, action);
            updateUserNameMap(history, name);

            return history;
        }

        public static void updateUserNameMap(History history, String name){
            switch (history.action){
                case Enter :
                case Change:
                    userNameMap.put(history.id, name);
            }
        }

        public String getRecord() {
            return userNameMap.get(this.id) + "���� " + this.action.getDisplayName();
        }
    }

    public enum Action {
        Enter("enter", "���Խ��ϴ�."),
        Leave("leave", "�������ϴ�."),
        Change("change", "����Ǿ����ϴ�.");

        private String value;
        private String displayValue;

        Action(String value, String displayValue){
            this.value = value;
            this.displayValue = displayValue;
        }

        public static Action findAction(String value){
            return Arrays.stream(values()).filter(i -> i.getValue().equals(value)).findFirst().orElseThrow(RuntimeException::new);
        }

        public String getValue() {
            return this.value;
        }

        public boolean isMove(){
            return this.value.equals(Enter.value) || this.value.equals(Leave.value);
        }

        public String getDisplayName() {
            return this.displayValue;
        }
    }

    public String[] solution(String[] record) {
        List<History> histories = new ArrayList<>();
        for(String eachRecord : record){
            histories.add(History.createBy(eachRecord));
        }
        return histories.stream().filter(history -> history.action.isMove()).map(History::getRecord).toArray(String[]::new);
    }

    // �׽�Ʈ ���
    //�׽�Ʈ 1 ��	��� (28.00ms, 54.3MB)
    //�׽�Ʈ 2 ��	��� (23.90ms, 53.8MB)
    //�׽�Ʈ 3 ��	��� (35.63ms, 53.9MB)
    //�׽�Ʈ 4 ��	��� (22.78ms, 52.5MB)
    //�׽�Ʈ 5 ��	��� (35.61ms, 54.8MB)
    //�׽�Ʈ 6 ��	��� (40.75ms, 55.4MB)
    //�׽�Ʈ 7 ��	��� (40.41ms, 54.9MB)
    //�׽�Ʈ 8 ��	��� (47.06ms, 54.4MB)
    //�׽�Ʈ 9 ��	��� (47.99ms, 55.7MB)
    //�׽�Ʈ 10 ��	��� (40.50ms, 55.8MB)
    //�׽�Ʈ 11 ��	��� (36.04ms, 55.1MB)
    //�׽�Ʈ 12 ��	��� (27.97ms, 53.9MB)
    //�׽�Ʈ 13 ��	��� (53.75ms, 54.4MB)
    //�׽�Ʈ 14 ��	��� (39.36ms, 54.5MB)
    //�׽�Ʈ 15 ��	��� (15.73ms, 53.3MB)
    //�׽�Ʈ 16 ��	��� (18.29ms, 53.3MB)
    //�׽�Ʈ 17 ��	��� (26.22ms, 53.3MB)
    //�׽�Ʈ 18 ��	��� (18.89ms, 53.4MB)
    //�׽�Ʈ 19 ��	��� (43.18ms, 54.6MB)
    //�׽�Ʈ 20 ��	��� (35.46ms, 55.3MB)
    //�׽�Ʈ 21 ��	��� (35.87ms, 55.6MB)
    //�׽�Ʈ 22 ��	��� (48.71ms, 55.3MB)
    //�׽�Ʈ 23 ��	��� (49.67ms, 55.8MB)
    //�׽�Ʈ 24 ��	��� (47.98ms, 55.3MB)
    //�׽�Ʈ 25 ��	��� (336.16ms, 158MB)
    //�׽�Ʈ 26 ��	��� (400.46ms, 163MB)
    //�׽�Ʈ 27 ��	��� (469.24ms, 166MB)
    //�׽�Ʈ 28 ��	��� (445.36ms, 168MB)
    //�׽�Ʈ 29 ��	��� (419.70ms, 167MB)
    //�׽�Ʈ 30 ��	��� (399.68ms, 164MB)
    //�׽�Ʈ 31 ��	��� (373.64ms, 173MB)
    //�׽�Ʈ 32 ��	��� (328.89ms, 149MB)
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] arr = sol.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
        for(String str : arr){
            System.out.println(str);
        }
    }
}
