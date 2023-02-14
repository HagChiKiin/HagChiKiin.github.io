public class Lc2418 {
    public String[] sortPeople(String[] names, int[] heights) {
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names.length - 1; j++) {   // for trâu  so sánh j vs j+1 nên j <= length-2
                if (heights[j] < heights[j + 1]) {       // nếu phần tử chiều cao tại j mà nhỏ hơn tại j + 1 thì tiến hành đổi chỗ
                    int t = heights[j];             // đổi chỗ chiều cao
                    heights[j] = heights[j + 1];
                    heights[j + 1] = t;
                    String s = names[j];                // đổi chỗ tên
                    names[j] = names[j + 1];
                    names[j + 1] = s;
                }
            }
        }
        return names;  // trả về mảng tên theo yêu cầu đề bài
    }
}
