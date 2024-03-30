import java.util.*;
import java.util.stream.Collectors;

class 가장큰수 {

    public static String solution(int[] numbers) {
        // 정수 배열을 리스트로 변환
        List<String> numbersList = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());

        // 두 문자열을 서로 다른 순서로 연결했을 때 더 큰 숫자를 앞으로 정렬
        numbersList.sort((a, b) -> (b + a).compareTo(a + b));

        // 만약 가장 큰 숫자가 0이면 전체 숫자가 0
        if (numbersList.get(0).equals("0")) {
            return "0";
        }

        // 문자열 리스트를 연결하여 결과 생성
        StringBuilder sb = new StringBuilder();
        for (String numStr : numbersList) {
            sb.append(numStr);
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        solution(numbers);
    }
}

