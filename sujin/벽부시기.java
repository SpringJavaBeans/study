import java.util.*;

public class 벽부시기 {
    /**
    <문제 설명>
    입력: 첫째 줄에 맵의 행(n)과 열(m)의 크기가 주어집니다. (1 ≤ n, m ≤ 1,000)
    다음 n개의 줄에 걸쳐 맵의 정보가 주어집니다. 여기서 0은 벽을, 1은 이동할 수 있는 길을 나타냅니다.
    출력:
    시작점(1, 1)에서 목적지(n, m)까지 도달하는 데 필요한 최소 이동 횟수를 출력합니다.(현재 위치부터 이동횟수)
    만약, 목적지까지 도달할 수 없다면 -1을 출력합니다.
    <문제 조건>
    맵의 시작점은 항상 (1, 1)이고, 목적지는 (n, m)입니다.
    벽(0)을 한 번만 부수고 지나갈 수 있습니다.
    이동은 상, 하, 좌, 우로만 가능합니다.
    **/
    public static class Position {
        int x, y, cnt;
        boolean isBreak; // 벽을 부쉈는지 여부
        public Position(int x, int y, int cnt, boolean isBreak) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.isBreak = isBreak;
        }
    }

    public static void main(String[] args) {
        int[] nmv = {6, 4};
        int[][] maps = {
                {1,1,1,0},
                {0,0,1,0},
                {1,1,1,1},
                {1,0,0,1},
                {1,0,0,0},
                {1,1,0,1}
        };
        int bfsCnt = performBFS(nmv, maps);
        System.out.print(bfsCnt);
    }

    public static int performBFS(int[] nmv, int[][] maps) {
        Queue<Position> q = new LinkedList<>();
        boolean[][][] visited = new boolean[nmv[0]][nmv[1]][2]; //마지막 배열은 [부수지않고 방문여부, 부수고 방문여부]
        q.add(new Position(0,0,0,false));
        visited[0][0][0] = true;

        int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // 좌, 우, 위, 아래

        while (!q.isEmpty()) {
            Position current = q.poll();
            if(current.x == nmv[0]-1 && current.y == nmv[1]-1){
                return current.cnt;
            }
            for(int i = 0; i < direction.length; i++) {
                int x = current.x + direction[i][0];
                int y = current.y + direction[i][1];
                if(x >= 0 && y >= 0 && x < nmv[0] && y < nmv[1]) {
                    if(maps[x][y] == 1 && visited[x][y][0] == false) { //부수지 않고 q에 추가
                        visited[x][y][current.isBreak ? 1 : 0] = true;
                        q.add(new Position(x, y, current.cnt + 1, current.isBreak));
                    }
                    if (maps[x][y] == 0 && current.isBreak == false) { //부숴야 q에 추가
                        visited[x][y][1] = true; //벽을 부수고 방문했다고 표시
                        System.out.println("부쉈다 :" + x + ", " + y);
                        q.add(new Position(x, y, current.cnt + 1, true));
                    }
                }
            }
        }
        return -1;
    }
}