package demo.static_am.static2;

import demo.static_am.static1.Dog;

public class DogCon extends Dog{

    public DogCon(String name, int weight, int height) {
        super(name, weight, height);
    }

    void can() {
        this.bark();
        this.weight = 10;
    }
}
