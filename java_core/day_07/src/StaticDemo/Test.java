package StaticDemo;

public class Test {
    public static void main(String[] args) {
        // biến, method static thuộc về calss chứ không phải đối tượng
        System.out.println(Film.category);
        Film.methodStatic();

        Film film = new Film();
        film.methodNormal();
    }
}
