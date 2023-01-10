package sc;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    public static void main(String[] args) {
        Console cons = System.console();

        String init = cons.readLine("> ");

        String[] load = init.trim().split(" ");

        if (load[0].equals("load")) {

            try {
                //open a file first
                String fileName = load[1] + ".cart";
                File f = new File("./shoppingcart", fileName);
            
                if (f.createNewFile()){
                    Cart cart = new Cart(load[1]);
                    List<String> toAdd = new ArrayList<>();
                    try {
                        FileReader fr = new FileReader(f);
                        BufferedReader br = new BufferedReader(fr);
                        String line;
                        while ((line = br.readLine())!= null){

                            toAdd.add(line);
                        }
                        cart.setItems(toAdd);
                        br.close();
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    System.out.printf("%s shopping cart loaded (new)\n", load[1]);
                    CommandHandler handler = new CommandHandler(cart);

                    while (true){

                        handler.action();
                        cart.save(f, cart.getItems());
                        System.out.printf("cart contents saved to %s\n", load[1]);
    
                    }


                } else {

                    Cart cart = new Cart(load[1]);
                    List<String> toAdd = new ArrayList<>();
                    try {
                        FileReader fr = new FileReader(f);
                        BufferedReader br = new BufferedReader(fr);
                        String line;
                        while ((line = br.readLine())!= null){

                            toAdd.add(line);
                        }
                        cart.setItems(toAdd);
                        br.close();
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    System.out.printf("%s shopping cart loaded (existing)\n", load[1]);

                    CommandHandler handler = new CommandHandler(cart);
                    
                    while (true){
                        
                        handler.action();
                        cart.save(f, cart.getItems());
                        System.out.printf("cart contents saved to %s\n", load[1]);
                        
                        }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        
        } else {
                System.out.println("Usage: load name.cart");
            }

            
    }
}
        