package practice;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    private int id;
    private String name;
    private int price;
    private String brand;
    private int count;

    @Override
    public String toString() {
        System.out.printf("%-5d %-15s %-10d %-10s %-10d ",this.getId(), this.getName(),this.getPrice(),this.getBrand()
        ,this.getCount());
        return  "";
    }
}
