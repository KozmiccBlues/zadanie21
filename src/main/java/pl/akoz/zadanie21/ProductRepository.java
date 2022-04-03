package pl.akoz.zadanie21;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class ProductRepository {

    private Set<Product> products;

    public ProductRepository() {
        products = new HashSet<>();
        products.add(new Product("Deska do krojenia", 9.99, Category.HOUSEHOLD));
        products.add(new Product("Rondelek", 15.99, Category.HOUSEHOLD));
        products.add(new Product("Wyciskarka do czosnku", 7.99, Category.HOUSEHOLD));
        products.add(new Product("Masło irlanadzkie", 9.99, Category.GROCERIES));
        products.add(new Product("Mleko migdałowe", 11.99, Category.GROCERIES));
        products.add(new Product("Ser gouda 150 g", 3.99, Category.GROCERIES));
        products.add(new Product("Lep na muchy", 2.99, Category.OTHER));
        products.add(new Product("Lampa stołowa", 55.00, Category.OTHER));
        products.add(new Product("Żelazko", 139.90, Category.OTHER));

    }

    public Set<Product> findByCategory(Category category) {
        Set<Product> filtered = new HashSet<>();
        for (Product product : products) {
            if(product.getCategory()== category) {
                filtered.add(product);

            }
        }
        return filtered;
    }

    public Set<Product>findAll() {
        return products;
    }

    public void add(Product product) {
        products.add(product);
    }
}
