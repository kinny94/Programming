// OPEN CLOSED PRINCIPLE
// Its a specifiaction design pattern
// Its a way to add new functionality to the existing code without modifying the existing code
// Open for extension, closed for modification
// Its ok for you to inherit classes or implement interfaces to add new functionality
// but you should not modify the existing code - filters in this case
import java.util.List;
import java.util.stream.Stream;

enum Color {
    RED, GREEN, BLUE;
}

enum Size {
    SMALL, MEDIUM, LARGE;
}

class Product {
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }
}

class ProductFilter {
    public Stream<Product> filterByColor(List<Product> products, Color color) {
        return products.stream().filter(p -> p.color == color);
    }

    public Stream<Product> filterBySize(List<Product> products, Size size) {
        return products.stream().filter(p -> p.size == size);
    }

    public Stream<Product> filterByColorAndSize(List<Product> products, Color color, Size size) {
        return products.stream().filter(p -> p.color == color && p.size == size);
    }
}


interface Specification<T> {
    boolean isSatisfied(T item);
}

interface Filter<T> {
    Stream<T> filter(List<T> items, Specification<T> specification);
}

class ColorSpecification implements Specification<Product> {
    private Color color;
    public ColorSpecification(Color color) {
        this.color = color;
    }
    
    @Override
    public boolean isSatisfied(Product item) {
        return item.color == color;
    }
}

class SizeSpecification implements Specification<Product> {
    private Size size;
    public SizeSpecification(Size size) {
        this.size = size;
    }
    @Override
    public boolean isSatisfied(Product item) {
        return item.size == size;
    }
}

class BetterFilter implements Filter<Product> {
    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> specification) {
        return items.stream().filter(specification::isSatisfied);
    }
}

class AndSpecification<T> implements Specification<T> {
    private Specification<T> first, second;
    public AndSpecification(Specification<T> first, Specification<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item);
    }
}

public class OCP {
    public static void main(String[] args) {
        Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.LARGE);

        List<Product> products = List.of(apple, tree, house);

        ProductFilter productFilter = new ProductFilter();

        System.out.println("Green products:");
        productFilter.filterByColor(products, Color.GREEN).forEach(p -> System.out.println(" - " + p.name + " is green"));
        
        System.out.println("Large products:");
        productFilter.filterBySize(products, Size.LARGE).forEach(p -> System.out.println(" - " + p.name + " is large"));
        
        System.out.println("Green and large products:");
            productFilter.filterByColorAndSize(products, Color.GREEN, Size.LARGE).forEach(p -> System.out.println(" - " + p.name + " is green and large"));
    
        BetterFilter betterFilter = new BetterFilter();
        betterFilter.filter(products, new ColorSpecification(Color.GREEN)).forEach(p -> System.out.println(" - " + p.name + " is green"));
        betterFilter.filter(products, new SizeSpecification(Size.LARGE)).forEach(p -> System.out.println(" - " + p.name + " is large"));
        betterFilter.filter(products, new AndSpecification<>(new ColorSpecification(Color.GREEN), new SizeSpecification(Size.LARGE))).forEach(p -> System.out.println(" - " + p.name + " is green and large"));
    }
}
