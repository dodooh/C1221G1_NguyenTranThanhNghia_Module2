package ss6_inheritance.bai_tap.lop_triangle;

public class Shape {

    protected String color = "red";
    private boolean filled = true;

    public Shape() {
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    //trần ngọc luật C0222G2 chào chào anh nghĩa C1221G1

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "A Shape with color of "
            + getColor()
            + " and "
            + (isFilled() ? "filled" : "not filled");
    }
}
