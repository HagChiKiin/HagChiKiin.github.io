package model;

public class Movie extends Film{
    private int time;

    public Movie() {
    }

    public Movie(int id, String title, String category, String director, String day, int time) {
        super(id, title, category, director, day);
        this.time = time;
    }


    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", director='" + getDirector() + '\'' +
                ", day='" + getDay() + '\'' +
                ", time=" + time +   '}';
    }
}
