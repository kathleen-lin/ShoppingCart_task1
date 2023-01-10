package sc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Cart {

    //attributes
    private String customer;
    private List<String> items;

    //constructors
    public Cart(String customer){
        this.customer = customer;
    }

    //getters and setters
    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    public List<String> getItems() {
        return items;
    }
    public void setItems(List<String> items) {
        this.items = items;
    }

    //methods
    public void add(List<String> newEntry) {
        //add to list - how to allow multiple arguments without knowing the size of things customers are going to write into?
        items.addAll(newEntry);
        
    
    }

    public void list(List<String> itemsInCart) {
        //printf the list<String> items, while formated to 1. 2. 3.
        for (int i = 0; i < itemsInCart.size(); i++ ){
            System.out.printf("%d. %s\n", i+1, itemsInCart.get(i));
    }
    }

    public void delete(int index){
        items.remove(index - 1);
    }

    public void save(File file, List<String> itemsInCart)throws IOException{
        //write list of items to file
        FileWriter writer = new FileWriter(file);
        BufferedWriter br = new BufferedWriter(writer);
        for (int i = 0; i < itemsInCart.size(); i++){
            br.write(itemsInCart.get(i));
            br.newLine();
        }
        br.flush();
        br.close();

    }

    
}
