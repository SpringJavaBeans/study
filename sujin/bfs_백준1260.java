import java.util.*;

public class bfs_백준1260 {
    public static void main(String[] args) {
        //입력
        int[] nmv = {4, 5, 1};
        int[][] graph = {
                {1, 2},
                {1, 3},
                {1, 4},
                {2, 4},
                {3, 4}
        };
        List<Integer> bfsOrder = performBFS(nmv, graph);
        bfsOrder.forEach(vertex -> System.out.print(vertex + " "));
    }

    private static List<Integer> performBFS(int[] nmv, int[][] graph) {
        int numberOfVertices = nmv[0]; //노드 갯수
        int numberOfedges = nmv[1]; //간선 갯수
        int startVertex = nmv[2]; //시작 정점

        int[][] adjMatrix = buildAdjMatrix(numberOfVertices, graph); //인접행렬을 구한다

        List<Integer> bfsOrder = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[numberOfVertices];
        queue.add(startVertex);
        visited[startVertex-1] = true;
        bfsOrder.add(startVertex);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited[current-1] = true;

            for(int i = 1; i < adjMatrix.length; i++){
                if(visited[i-1] == false && adjMatrix[current][i] == 1) {
                    queue.add(i);
                    bfsOrder.add(i);
                    if(bfsOrder.size() == numberOfVertices) {
                        return bfsOrder;
                    }
                }
            }
        }
        return bfsOrder;
    }

    private static int[][] buildAdjMatrix(int vertices, int[][] graph) {
        int[][] adjMatrix = new int[vertices+1][vertices+1];

        for(int i = 0; i < graph.length; i++) {
            int x = graph[i][0];
            int y = graph[i][1];
            adjMatrix[x][y] = adjMatrix[y][x] = 1;
        }
        return adjMatrix;
    }
}
