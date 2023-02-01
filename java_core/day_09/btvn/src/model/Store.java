package model;

public class Store {
    private int id;
    private String name;
    private String description;
    private int quality;
    private int price;

    public Store() {
    }

    public Store(int id, String name, String description, int quality, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quality = quality;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quality=" + quality +
                ", price=" + price +
                '}';
    }
}
