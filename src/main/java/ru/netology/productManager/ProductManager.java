package ru.netology.productManager;


import ru.netology.domain.product.Product;




public class ProductManager {

    private ProductRepositiry cellRepo;

    public ProductManager(ProductRepositiry cellRepo) {
        this.cellRepo = cellRepo;
    }

    public void add(Product product) {            // Добавление продукта
        cellRepo.save(product);
    }


    public Product[] searchBy(String text) {     // Поиск по
        Product[] result = new Product[0];
        for (Product product : cellRepo.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                   tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {   // Определение соответствия товара
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
