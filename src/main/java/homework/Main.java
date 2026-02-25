package homework;

public class Main {
    public static void main(String[] args) {
        /*
        Доработайте сервис продуктов таким образом, чтобы при попытке сохранения продукта с пустым наименованием
        либо некорректной (отрицательной) ценой выбрасывались соответствующие пользовательские проверяемые исключения
        с информативными поясняющими сообщениями внутри.
         */

        ProductService service = new ProductService();

        try {
            service.addProduct(new Product("Banana", 5));
            service.addProduct(new Product("Apple", 3.4));
            service.addProduct(new Product("Lemon", 6.7));
            service.addProduct(new Product("", 6.7));
            service.addProduct(new Product("Peach", -6.7));

        } catch (EmptyProductTitleException | NegativeProductPriceException e) {
            System.out.println("Error! " + e.getMessage());

        }


        try {
            Product product = service.findByTitle("Lemon");
            System.out.println("Price for lemon is: " + product.getPrice());

            product = service.findByTitle("Orange");
            System.out.println("Price for orange is: " + product.getPrice());
        } catch (ProductNotFoundException e) {
            System.out.println("Error! " + e.getMessage());
        }
    }
}
