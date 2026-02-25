package homework;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private List<Product> dataBase = new ArrayList<>();

    public void addProduct(Product product) throws EmptyProductTitleException, NegativeProductPriceException {

        if (product.getName().isBlank()) {
            throw new EmptyProductTitleException("Product title must not be empty");
        }

        if (product.getPrice() < 0) {
            throw new NegativeProductPriceException("Product price must not be negative");
        }

        dataBase.add(product);
    }

    public Product findByTitle(String title) throws ProductNotFoundException {
        for (Product product : dataBase) {
            if (product.getName().equals(title)) {
                return product;
            }
        }
//        return null;

//        throw new IllegalArgumentException("Product " + title + " not found");

        throw new ProductNotFoundException("Product " + title + " not found");

//        return dataBase
//                .stream()
//                .filter(product -> product.getName().equals(title))
//                .findFirst()
//                .orElse(null);
    }
}

