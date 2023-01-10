package sc;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;

public class CommandHandler {

    private Cart cart;

    public CommandHandler (Cart cart){
        this.cart = cart;
    }

    public void action() {
        Console cons = System.console();
        List<String> cartItems = cart.getItems();
        Boolean stop = false;

        while (!stop){
            String cmd = cons.readLine(">>");
            String[] command = cmd.trim().split(" ");

            switch (command[0]){
                case "list":
                    int cartCount = cartItems.size();
                    if (cartCount == 0) {
                        System.out.println("Cart is empty");
                    } else {
                        //do something
                        cart.list(cartItems);
                    }
                    break;
                    
                case "add":
                    //items to add to cart are command [1] onwards
                    String add = "";
                    List<String> addToCart = new LinkedList<>();
                    for (int i = 1; i < command.length; i++){
                        addToCart.add(command[i]);
                        add = add + " " + command[i];

                        
                    }
                    cart.add(addToCart);
                    System.out.printf("%s added to the cart\n", add);
                    break;

                case "delete":
                    Integer index = Integer.parseInt(command[1]);
                    //System.out.printf("I will delete index %d\n", index);
                    String deleted = cart.getItems().get(index-1);
                    System.out.printf("%s removed from cart\n", deleted);
                    cart.delete(index);
                    break;
                    
                case "exit":
                    System.exit(1);
                    break;

                case "save":
                    stop = true;
                    break;



            }
            
            }
        
    }

}
