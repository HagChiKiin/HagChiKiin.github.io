import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Dijkstra {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 6, 0, 1, 0},
                {6, 0, 5, 2, 2},
                {0, 5, 0, 0, 5},
                {1, 2, 0, 0, 1},
                {0, 2, 5, 1, 0},
        };
        int startPoint = 0;
        ///
        int[] distance = new int[graph.length];
        int[] pre = new int[graph.length];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startPoint] = 0;
        Set<Integer> visited = new HashSet<>();
        while (visited.size() < graph.length) {
            // tim dinh co khoang cach nho nhat den startPoint
            int u = findMinDistaneNode(distance, visited);
            // duyet cac dinh ke của u
            for (int v = 0; v < graph.length; v++) {
                if (graph[u][v] != 0 && !visited.contains(v)) {
                    int newDistanceOfV = distance[u] + graph[u][v];
                    if (newDistanceOfV < distance[v]) {
                        distance[v] = newDistanceOfV;
                        pre[v] = u;
                    }
                }
            }
            visited.add(u);
        }

        int endPoint = 4;
        System.out.println("distance to " + endPoint + " =" + distance[endPoint]);
        while (endPoint != startPoint) {
            System.out.println(endPoint + " -> ");
            endPoint = pre[endPoint];
            if (endPoint == startPoint) {
                System.out.println(startPoint);
            }
        }
    }

    private static int findMinDistaneNode(int[] distance, Set<Integer> visited) {
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] < min) {
                min = distance[i];
                index = i;
            }
        }

        return index;
    }

}

