import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] graph = {
                //  0  1  2  3  4  5  6
                {0, 1, 0, 0, 0, 0, 0}, // 0
                {1, 0, 1, 1, 1, 0, 0}, // 1
                {0, 1, 0, 0, 0, 1, 0}, // 2
                {0, 1, 0, 0, 0, 1, 1}, // 3
                {0, 1, 0, 0, 0, 0, 1}, // 4
                {0, 0, 1, 1, 0, 0, 0}, // 5
                {0, 0, 0, 1, 1, 0, 0}  // 6
        };
        BFS(graph);
    }

    private static void DFS_stack(int[][] graph) {
        Stack<Integer> stack = new Stack<>();
        // add dinh dau tien
        stack.add(0);
        // danh dau 0 da duoc duyet
        Set<Integer> visited = new HashSet<>();     // boolean[] visited = new boolean[100]
        visited.add(0);                            // visite[0] =true;
        // duyet stack den khi stack rong
        while (!stack.isEmpty()) {
            // lay ra dinh o top
            int u = stack.pop();
            // process dinh u
            System.out.print(u + "-");
            // add cac dinh ke voi u vao stack va visit
            for (int v = 0; v < graph.length; v++) {
                if (graph[u][v] == 1 && !visited.contains(v)) {
                    stack.push(v);
                    // danh dau v da duoc visited
                    visited.add(v);
                }
            }
        }

    }
    private static void DFS_recursion(int[][] graph, Set<Integer> visited, int u){
        //process u
        System.out.print(u+"-");
        visited.add(u);
        for (int v = 0; v < graph.length; v++) {
            if(graph[u][v] == 1 && !visited.contains(v)){
                visited.add(v);
                DFS_recursion(graph,visited,v);
            }
        }
    }
    private static void BFS(int[][] graph){
        Queue<Integer> queue = new LinkedList<>();
        // them dinh vao queue
        // danh dau dinh da visited
        queue.add(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        while (!queue.isEmpty()){
            // lay dau queue
            int u = queue.poll();
            // process
            System.out.print(u +"-");
            // add tat ca cac dinh ke của u vao queue
            for (int v = 0; v < graph.length; v++) {
                if(graph[u][v] == 1 && !visited.contains(v)){
                    queue.add(v);
                    visited.add(v);
                }
            }
        }
    }
}
