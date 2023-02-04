package ru.netology.productManager;

import ru.netology.domain.product.Product;

public class  Book extends Product {
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public Book(int id, String name, String author, int price){
        super(id, name, price);
        this.author = author;
    }
}
