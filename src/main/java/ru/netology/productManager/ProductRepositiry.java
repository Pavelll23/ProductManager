package ru.netology.productManager;


import ru.netology.domain.product.Product;

public class ProductRepositiry {

    private Product[] products = new Product[0];

    public void save (Product product){                // Сохранение товара
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++){
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }
    public void deleteById(int id){                     // Удаление по Id
        Product[] tmp = new Product[products.length - 1];
        int index =0;
        for (Product product : products){
            if(product.getId() != id){
                tmp[index] = product;
                index ++;
            }
        }
        products = tmp;
    }
    public Product[] findAll(){          // Получить все сохраненные товары
       return products;
    }
}
