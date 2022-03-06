package com.example.poshell.cli;

import com.example.poshell.biz.PosService;
import com.example.poshell.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class PosCommand {

    private PosService posService;

    @Autowired
    public void setPosService(PosService posService) {
        this.posService = posService;
    }

    @ShellMethod(value = "List Products", key = "p")
    public String products() {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (Product product : posService.products()) {
            stringBuilder.append("\t").append(++i).append("\t").append(product).append("\n");
        }
        return stringBuilder.toString();
    }

    @ShellMethod(value = "New Cart", key = "n")
    public String newCart() {
        return posService.newCart() + " OK";
    }
    @ShellMethod(value = "Empty your Cart", key = "e")
    public String emptyCart(){
        posService.emptyCart();
        return "Cart clear";
    }
    @ShellMethod(value = "show total price", key = "t")
    public String totalPrice(){
        double total = posService.getCart().total();
        return "Total...\t\t\t" + total;
    }

    @ShellMethod(value = "Add a Product to Cart", key = "a")
    public String addToCart(String productId, int amount) {
        if (posService.add(productId, amount)) {
            return posService.getCart().toString();
        }
        return "ERROR";
    }
    @ShellMethod(value = "Check out the Cart", key = "c")
    public String checkoutCart(){
        if(posService.getCart() == null)
        {
            return "There is no Cart!";
        }
        else{
            return posService.getCart().toString();
        }
    }
    @ShellMethod(value = "Modify the amount of the specific product in your Cart", key = "m")
    public String modifyCart(String productId, int amount) {
        if(posService.getCart() == null){
            return "There is no Cart!";
        }
        if (amount <= 0) {
            return "Failed! The amount must be greater than 0.";
        }
        if (posService.modify(productId, amount)) {
            return posService.getCart().toString();
        }
        return "Modify failed.Product \"" + productId + "\" could not be found.";
    }
}
