public class 음식조합만들기 {
    /**
     문제 설명
     "음식 조합 만들기": 당신은 n개의 다른 종류의 음식 재료가 있습니다.
     각 재료는 양수로 표현되며, 이 재료들을 사용하여 특정 칼로리(target)를 만드는 음식 조합을 만들려고 합니다.
     당신은 재료를 중복 없이 선택하여, 선택한 재료들의 합이 정확히 타겟 칼로리와 일치하도록 음식을 만들어야 합니다.
     이때, 가능한 모든 음식 조합의 수를 찾으세요.
     재료의 순서를 바꾸는 것은 결과에 영향을 주지 않으며,
     각 재료는 오직 한 번만 사용할 수 있습니다.

     제한사항
     주어지는 재료의 개수는 2개 이상 15개 이하입니다.
     각 재료는 1 이상 100 이하인 자연수입니다.
     타겟 칼로리는 1 이상 300 이하인 자연수입니다..
     **/
    static int result = 0;
    public static void main(String[] args) {
        int[] ingredients = {4, 1, 2, 1};
        //{2, 3, 7, 8, 10};
        int target = 4;
        //10
        int cnt = performDFS(ingredients, target, 0, 0);
        System.out.print(cnt);
    }

    public static int performDFS(int[] ingredients, int target, int depth, int sum) {
        if(ingredients.length == depth) {
            if(sum == target) {
                result++;
            }
        }else {
            performDFS(ingredients, target,depth +1, sum); //더해보는곳
            performDFS(ingredients, target,depth +1, ingredients[depth]+sum); //안 더해보는곳
        }
        return result;
    }
}