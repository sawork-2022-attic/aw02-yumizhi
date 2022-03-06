package com.example.poshell.biz;

import com.example.poshell.model.Cart;
import com.example.poshell.model.Product;

import java.util.List;

public interface PosService {
    public Cart getCart();

    public Cart newCart();

    //public void checkout(Cart cart);

    public void emptyCart();

    public double total(Cart cart);

    public boolean add(Product product, int amount);

    public boolean add(String productId, int amount);


    public boolean modify(String productId, int amount);

    public List<Product> products();
}
