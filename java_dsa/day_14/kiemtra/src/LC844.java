public class LC844 {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder arr1 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {        // vòng lặp tìm ra ký tự tại chuỗi s là #
                if (arr1.length() > 0) {
                    arr1 = new StringBuilder(arr1.substring(0, arr1.length() - 1));   // nếu đúng thì sẽ xóa ký tự cuối cùng bang subtring
                }
            } else {
                arr1.append(s.charAt(i));   // nếu khong phai # thi them vao chuoi arr1
            }
        }
        String arr2 = "";
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (arr2.length() > 0) {
                    arr2 = arr2.substring(0, arr2.length() - 1);
                }
            } else {
                arr2 = arr2 + t.charAt(i);
            }
        }
        return arr1.toString().equals(arr2);
    }
}
