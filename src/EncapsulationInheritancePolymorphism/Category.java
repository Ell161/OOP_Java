package EncapsulationInheritancePolymorphism;

import java.util.ArrayList;

public class Category extends ArrayList<Product> {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
