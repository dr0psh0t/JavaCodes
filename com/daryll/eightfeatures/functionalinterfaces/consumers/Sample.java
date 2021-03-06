package com.daryll.eightfeatures.functionalinterfaces.consumers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Sample {

    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_DOWN;
    private static final int DECIMALS = 2;

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("A", new BigDecimal("2.54")));
        products.add(new Product("B", new BigDecimal("3.89")));
        products.add(new Product("C", new BigDecimal("5.99")));
        products.add(new Product("D", new BigDecimal("9.99")));

        //  increases the prices of products by 10%
        Consumer<Product> incPrice = p -> p.setPrice(rounded(p.getPrice().multiply(new BigDecimal("1.1"))));

        //  The consumer increases the product price by 10% and rounds the value.
        process(products, incPrice.andThen(System.out::println));
    }

    private static BigDecimal rounded(BigDecimal number) {
        return number.setScale(DECIMALS, ROUNDING_MODE);
    }

    //  We increase the prices and then print the modified products.
    private static void process(List<Product> data, Consumer<Product> cons) {
        for (Product e : data) {
            cons.accept(e);
        }
    }

    private static class Product {
        private String name;
        private BigDecimal price;

        public Product(String name, BigDecimal price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Product{" + "name='" + name + '\'' + ", price=" + price + '}';
        }
    }
}
