package ss7_abstract_interface.bai_tap.trien_khai_interface_resizeable;

public class Square extends Rectangle implements IResizeable {

    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public String toString() {
        return "A Square with side="
            + getSide()
            + ", which is a subclass of "
            + super.toString();
    }

    @Override
    public void resize(double percent) {
        setSide(getSide() * (1 + percent / 100));
    }
}
