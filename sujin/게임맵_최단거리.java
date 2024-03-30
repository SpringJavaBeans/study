import java.util.*;

public class 게임맵_최단거리 {

    static private class Position {
        int x, y, moveCount;

        public Position(int x, int y, int moveCount) {
            this.x = x;
            this.y = y;
            this.moveCount = moveCount;
        }

        public Position move(int dx, int dy) {
            return new Position(this.x + dx, this.y + dy, this.moveCount + 1);
        }

        public boolean isValid(int[][] maps, boolean[][] visited) {
            if (x >= 0 && x < maps.length && y >= 0 && y < maps[0].length) {
                return maps[x][y] == 1 && visited[x][y] == false;
            }
            return false;
        }
    }

    public static int solution(int[][] maps) {
        int answer = -1;
        Queue<Position> bfsQueue = new LinkedList<>();
        bfsQueue.add(new Position(0, 0, 1)); // 현재 위치와 이동거리를 초기화

        int[][] moveDirections = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // 위, 아래, 좌, 우
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true;

        while (!bfsQueue.isEmpty()) {
            Position currentPosition = bfsQueue.poll();

            if (currentPosition.x == maps.length - 1 && currentPosition.y == maps[0].length - 1) { // 종료
                answer = currentPosition.moveCount;
                break;
            }

            for (int[] direction : moveDirections) {
                Position newPosition = currentPosition.move(direction[0], direction[1]);
                if (newPosition.isValid(maps, visited)) {
                    visited[newPosition.x][newPosition.y] = true;
                    bfsQueue.add(newPosition);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
    }
}
