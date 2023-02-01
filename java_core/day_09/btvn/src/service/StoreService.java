package service;

import database.StoreDatabase;
import model.Store;
import repository.StoreRepository;

import java.util.ArrayList;

public class StoreService {
    public StoreRepository storeRepository = new StoreRepository();
    public void seelist(){
        for (Store a : storeRepository.findAll()
             ) {
            System.out.println(a);
        }
    }
    public void findName(String name){
        for (Store b:storeRepository.findByName(name)
             ) {
            System.out.println(b);
        }
    }
    public void findId(int id){
        storeRepository.findById(id);

        }
    public void findQuality(){
        for (Store c:storeRepository.findByQuality() ) {
            System.out.println(c);

        }
    }

    public void findPrice(){
       storeRepository.findByPrice();

        }





}
