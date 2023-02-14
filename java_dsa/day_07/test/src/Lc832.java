public class Lc832 {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int[] row = image[i];
            int left = 0, right = row.length - 1;  // ta tạo 2 con trỏ chạy từ trái và phải về nhau của mảng row la từng hàng của matran image
            while (left <= right) {   // điều kiện break là left>right
                if (row[left] == row[right]) { // Nếu phần tử tại left = right
                    row[left] = 1 - row[left];    // thìta có phần tử  left = 1 - left.. nếu left cũ là 0 thì left mới là 1. left cũ là 1 thì left mới là 0
                    row[right] = row[left]; // và phần tử right sẽ bằng left
                }
                left++; // tăng dần left và giảm dần right khi left> right thì break vòng lặp
                right--; // nếu left bằng right thì phần tử tại left luôn bằng phần tử tại right và sẽ trả về 1 - nó
            }
        }
        return image;

    }
}
// 1 1 0              1 0 0
// 1 0 1  ->    ->    0 1 0
// 0 0 0              1 1 1