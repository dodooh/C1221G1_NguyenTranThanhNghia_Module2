package ss21_design_pattern.thuc_hanh.factory_method;

public class AnimalFactory {

    public Animal getAnimal(String type) {
        if ("canine".equals(type)) {
            return new Dog();
        } else {
            return new Cat();
        }
    }
}
