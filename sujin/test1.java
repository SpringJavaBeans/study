package org.exercise.together;

class test1 {

    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int min = 1; // 맨 앞 아파트
        for (int i = 0; i < stations.length; i++) {
            int internetOkMin =stations[i] - w;
            if(internetOkMin > min) { // 지금 기지국의 앞부분에 전파안되는 아파트가 있는지
                int cnt = 1; //필요한 기지국 수
                while (cnt * (2*w +1) < internetOkMin - min) {
                    cnt++;
                }
                answer+= cnt;
            }
            //마지막아파트일때
            if (i == stations.length -1) {
                int internetOkMax =stations[i] + w; //전파가는 마지막 아파트 번호
                if(internetOkMax < n) { // 지금 스테이션의 뒷부분에 전파안되는 아파트가 있는지
                    int cnt = 1; //필요한 기지국 수
                    while (cnt * (2*w +1) < n - internetOkMax) {
                        cnt++;
                    }
                    answer+= cnt;
                }
            }else{
                min = stations[i] + w +1; //다음 스테이션에서 전파안되는 최소 아파트의 번호
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 11;
        int[] stations = {4, 11};
        int w = 1;
        solution(n,stations,w);
    }


}