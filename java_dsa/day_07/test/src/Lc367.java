public class Lc367 {
    public boolean isPerfectSquare(int num) {
        for (int i = 0;   i*i >=0 && i * i <= num; i ++) {   // chạy vòng lặp từ i= 0 đến i*i
            if ( i * i == num) {   // add điều kiện i*i >= 0 để i không là số âm
                return true;
            }
        }
        return false;
    }
}
