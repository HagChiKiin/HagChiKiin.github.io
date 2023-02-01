package repository;

import database.StoreDatabase;
import model.Store;

import java.util.ArrayList;

public class StoreRepository {
    public ArrayList<Store> findAll(){
        return StoreDatabase.store;

    }
    public ArrayList<Store> findByName(String name) {
        ArrayList<Store> rs = new ArrayList<>();
        for (Store e : StoreDatabase.store) {
            if (e.getName().toLowerCase().contains(name.toLowerCase())) {
                rs.add(e);
            }
        }
        return rs;
    }
    public void findById(int id) {
        for (Store f:StoreDatabase.store) {
            if (f.getId() == id) {
                System.out.println(f);
            }
        }
        System.out.println();
        ArrayList<Store> rs = new ArrayList<>();
            for (Store e: StoreDatabase.store) {
                if(e.getId()!=id){
                     rs.add(e);
                }
            }
        System.out.println("Danh sách sau khi xóa là: ");
        System.out.println(rs);
        }



    public ArrayList<Store> findByQuality(){
        ArrayList<Store> st = new ArrayList<>();
        for (Store g: StoreDatabase.store) {
            if(g.getQuality() < 5){
                st.add(g);
            }
        }
        return st;
    }
    public void findByPrice(){
        ArrayList<Store> st1 = new ArrayList<>();
        ArrayList<Store> st2 = new ArrayList<>();
        ArrayList<Store> st3 = new ArrayList<>();
        for (Store g : StoreDatabase.store) {
            if(g.getPrice() < 50_000){
                st1.add(g);
            }else if (g.getPrice()> 100_000){
                st2.add(g);
            }else {
                st3.add(g);
            }
        }
        System.out.println("Các sản phẩm có giá dưới 50k là: \n"+st1);
        System.out.println("Các sản phẩm có giá trên 100k là: \n "+st2);
        System.out.println("Các sản phẩm có giá từ 50k đến 100k là: \n "+st3);
    }
}
