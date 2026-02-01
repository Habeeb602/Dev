import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OpenClosedPrinciple {

    public static void main(String[] args) {

        Product apple = new Product("Apple", Color.RED, Size.MEDIUM);
        Product house = new Product("House", Color.BLUE, Size.EXTRA_LARGE);
        Product shirt = new Product("Shirt", Color.BLUE, Size.MEDIUM);

        List<Product> products = Arrays.asList(apple, house, shirt);
        ProductFilter pf = new ProductFilter();
        System.out.println("Blue Products: ");
        
        pf.doFilter(products, new ColorSpecification(Color.BLUE))
            .forEach(p -> System.out.println(String.format("- %s is blue", p)));


        System.out.println("Medium-sized Products: ");
        pf.doFilter(products, new SizeSpecification(Size.MEDIUM))
            .forEach(p -> System.out.println(String.format("- %s is medium in size", p)));

        
        System.out.println("Blue Medium-sized Products: ");
        pf.doFilter(products, new AndSpecification<>(new ColorSpecification(Color.BLUE), new SizeSpecification(Size.MEDIUM)))
            .forEach(p -> System.out.println(String.format("- %s is blue and medium in size", p)));
        
    }
    
}


enum Color{
    BLUE, GREEN, RED
}

enum Size{
    SMALL, MEDIUM, LARGE, EXTRA_LARGE
}


class Product{
    String name;
    Color color;
    Size size;
    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }
    
    @Override
    public String toString(){
        return name;
    }
}

interface Specification<T>{
    boolean isSatisfied(T item);
}

interface Filter<T>{
    List<T> doFilter(List<T> items, Specification<T> spec);
}

class ColorSpecification implements Specification<Product>{

    Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.color == color;
    }
    
}

class SizeSpecification implements Specification<Product>{

    Size size;

    public SizeSpecification(Size size){
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.size == size;
    }
    
}

class AndSpecification<T> implements Specification<T>{
    Specification<T> spec1;
    Specification<T> spec2;
    public AndSpecification(Specification<T> spec1, Specification<T> spec2) {
        this.spec1 = spec1;
        this.spec2 = spec2;
    }
    @Override
    public boolean isSatisfied(T item) {
        return spec1.isSatisfied(item) && spec2.isSatisfied(item);
    }
}

class ProductFilter implements Filter<Product>{

    @Override
    public List<Product> doFilter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(p -> spec.isSatisfied(p)).collect(Collectors.toList());
    }
}


