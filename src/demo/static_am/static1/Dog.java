package demo.static_am.static1;

public class Dog {

    public String name;
    protected int weight;
    protected int height;
    Dog() {

    }
    public Dog(String name, int weight, int height) {
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    public void bark() {
        System.out.println("go go " + this.name);
    }

    @Override
    public String toString() {
        bark();
        return "Dog{" +
            "name='" + name + '\'' +
            ", weight=" + weight +
            ", height=" + height +
            '}';

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight < 0) {
            this.weight = 1;
        } else {
            this.weight = weight;
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
