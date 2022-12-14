package model;

public class Serial extends Film{
    private int number;
    private double avgTime;

    public Serial() {
    }

    public Serial(int id, String title, String category, String director, String day, int number, double avgTime) {
        super(id, title, category, director, day);
        this.number = number;
        this.avgTime = avgTime;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(double avgTime) {
        this.avgTime = avgTime;
    }

    @Override
    public String toString() {
        return "Serial{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", director='" + getDirector() + '\'' +
                ", day='" + getDay() + '\'' +
                ", number=" + number +
                ", avgTime=" + avgTime +
                '}';
    }
}
