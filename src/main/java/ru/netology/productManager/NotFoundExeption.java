package ru.netology.productManager;


public class NotFoundExeption extends RuntimeException{

    public NotFoundExeption(String msg){
       super(msg);
    }
}
