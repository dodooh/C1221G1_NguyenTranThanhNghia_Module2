package ss4_lop_va_doi_tuong.bai_tap.lop_fan;

public class Fan {
    /***********************
     *         Fan          *
     * ---------------------*
     * +SLOW: int           *
     * +MEDIUM: int         *
     * +FAST: int           *
     * -speed: int          *
     * -on: boolean         *
     * -radius: double      *
     * -color: String       *
     *----------------------*
     * +Fan()               *
     * +setRadius(double):  *
     * +getRadius(): double *
     * +setColor(String):   *
     * +getColor(): String  *
     * +setSpeed(int)       *
     * +getSpeed(): String  *
     * +isOn(): boolean     *
     * +turnOn()            *
     * +turnOff()           *
     * +toString(): String  *
     ***********************/
    private int speed;
    private boolean on;
    private double radius;
    private String color;
    public static final int SLOW = 1;		// Fan speed slow
    public static final int MEDIUM = 2;	// Fan speed medium
    public static final int FAST = 3;		// Fan speed fast
    Fan() {
        speed = SLOW;
        on = false;
        radius = 5;
        color = "blue";
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void turnOn() {
        this.on = true;
    }

    public void turnOff() {
        this.on = false;
    }
    public String toString() {
        return on
            ? "Fan is on. Speed: " + this.speed + ".Color: " + this.color + ". Radius: " + this.radius
            : "Fan is off. Color: " + this.color + ". Radius: " + this.radius;
    }
}
