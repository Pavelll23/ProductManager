import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.product.Product;
import ru.netology.productManager.*;

public class ManagerTest {
    private ProductRepositiry repositiry = new ProductRepositiry();
    private ProductManager manager = new ProductManager(repositiry);

    Product product = new Product(25, "СмартТВ", 5000);
    Product book = new Book(11, "Моя весна", "Александр Шубкин", 300);
    Product smartphone = new Smartphone(33, "Смартфон", 15000, "Самсунг");

    @Test
    public void ShouldSaveProduct() {
        repositiry.save(smartphone);

        Product[] expected = {smartphone};
        Product[] actual = repositiry.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteById() {
        repositiry.save(book);
        repositiry.save(smartphone);
        repositiry.save(product);
        repositiry.deleteById(11);

        Product[] expected = {smartphone, product};
        Product[] actual = repositiry.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        repositiry.save(book);
        repositiry.save(smartphone);
        repositiry.save(product);

        Product[] expected = {book, smartphone, product};
        Product[] actual = repositiry.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAdd() {
        manager.add(book);

        Product[] expected = {book};
        Product[] actual = repositiry.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSearchBy() {
        manager.add(book);
        manager.add(smartphone);
        manager.add(product);
        String text = "Смарт";

        Product[] expected = {smartphone, product};
        Product[] actual = manager.searchBy(text);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteByIdIfHiIs() {
        repositiry.save(book);
        repositiry.save(smartphone);
        repositiry.save(product);
        repositiry.deleteById(25);

        Product[] expected = {book,smartphone};
        Product[] actual = repositiry.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldDeleteByIdIfNoId(){
        repositiry.save(book);
        repositiry.save(smartphone);
        repositiry.save(product);

        Assertions.assertThrows(NotFoundExeption.class,() -> {
            repositiry.deleteById(2);
        });
    }
}





