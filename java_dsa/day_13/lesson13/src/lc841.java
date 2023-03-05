import java.util.*;

public class lc841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();   // them phòng 0 vao queue
        q.add(0);
        Set<Integer> visited = new HashSet<>();  // danh dau phong 0 da visited
        visited.add(0);

        while (!q.isEmpty()) {
            int u = q.poll();   // lay ra phong dau tien u
            System.out.print(u + "-");  // In ra phòng đã ghé thăm để kiểm tra
            List<Integer> list = rooms.get(u);  // Lấy danh sách các phòng kề với phòng u
            for (int v : list
                 ) {
                if(!visited.contains(v)){   // phòng v chưa dc visited
                    q.add(v);    // them v
                    visited.add(v);    // danh dau v da duoc visited
                }
                
            }
        }

        return visited.size() == rooms.size();
    }

}
