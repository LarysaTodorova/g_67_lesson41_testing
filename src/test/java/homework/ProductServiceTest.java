package homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    /*
    Возьмите сервис продуктов из материалов занятия 36.
Напишите тесты на этот сервис (минимум 3 тест-кейса).
     */
    private ProductService service;

    @BeforeEach
    public void setUp() {
        service = new ProductService();
    }

    /*  1. Передаём отрицательную цену продукта. Например, -5,6.
        Проверяем, действительно ли метод выбрасывает ожидаемый эксепшен.
     */
    @Test
    public void expectExceptionIfProductPriceIsNegative() {
        Product product = createProduct("Orange", -5.6);
        assertThrows(
                NegativeProductPriceException.class,
                () -> service.addProduct(product),
                "The method did not throw the expected exception when the product price was negative."
        );
    }

    /*  2. Передаём положительную цену продукта. Например,3.0.
        Проверяем, действительно ли метод вернул правильную цену.
     */
    @Test
    public void checkIfProductPriceIsCorrect() throws EmptyProductTitleException, NegativeProductPriceException, ProductNotFoundException {
        double expectedPrice = 3.0;
        Product product = createProduct("Orange", 3.0);
        service.addProduct(product);
        Product foundProduct = service.findByTitle("Orange");
        double actualPrice = foundProduct.getPrice();
        assertEquals(expectedPrice, actualPrice, "The method did not return the correct product price.");
    }

    /*  3. Передаём пустое название продукта. Например, " ".
       Проверяем, действительно ли метод выбрасывает ожидаемый эксепшен.
    */
    @Test
    public void expectExceptionIfProductNameIsBlank() {
        Product product = createProduct(" ", 3.7);
        assertThrows(
                EmptyProductTitleException.class,
                () -> service.addProduct(product),
                "The method did not throw the expected exception when the product name is blanc."
        );
    }

    /*  4. Передаём название продукта. Например,"Orange".
       Проверяем, действительно ли метод вернул правильный продукт.
    */
    @Test
    public void checkWhenFindByTitleShouldReturnSameProduct() throws ProductNotFoundException, EmptyProductTitleException, NegativeProductPriceException {
        Product expectedResult = createProduct("Orange", 3.7);
        service.addProduct(expectedResult);
        Product actualResult = service.findByTitle("Orange");
        assertSame(expectedResult, actualResult, "The method did not return the correct product.");
    }

    /*
    5. если продукт не найден → кидается ProductNotFoundException
    */
    @Test
    public void expectExceptionWhenProductNotFound() {
        assertThrows(
                ProductNotFoundException.class,
                () -> service.findByTitle("Banana"),
                "The method did not throw the expected exception when the product was not found."
        );
    }

    @Test
    public void findByTitleShouldReturnCorrectProductWhenMultipleProductsExist() throws EmptyProductTitleException, NegativeProductPriceException, ProductNotFoundException {
        Product orange = createProduct("Orange", 3.7);
        Product apple = createProduct("Apple", 2.1);
        service.addProduct(orange);
        service.addProduct(apple);
        Product foundProduct = service.findByTitle("Apple");
        assertSame(apple, foundProduct, "The method did not return the correct product.");
    }

    @Test
    public void findByTitleShouldBeCaseSensitive() throws EmptyProductTitleException, NegativeProductPriceException {
        Product orange = createProduct("Orange", 3.7);
        service.addProduct(orange);
        assertThrows(
                ProductNotFoundException.class,
                () -> service.findByTitle("orange"),
                "The method did not throw ProductNotFoundException for different case."
        );
    }

    private Product createProduct(String title, double price) {
        return new Product(title, price);
    }
}