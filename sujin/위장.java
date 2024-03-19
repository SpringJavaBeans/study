import java.util.*;

class Solution {

    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i< clothes.length; i++) {
            //착용 안하는 경우를 포함해서 기본값 1 
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }
        Collection<Integer> values = map.values();
        answer = values.stream().reduce(1, (a,b) -> a*b);
        //모든 아이템을 착용 안하는 경우 -1
        return answer-1;
    }
}
