package ss6_inheritance.bai_tap.lop_point_va_movablepoint;

public class MovablePoint extends Point {

    private float xSpeed;
    private float ySpeed;

    public MovablePoint() {
        xSpeed = 0.0f;
        ySpeed = 0.0f;
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed(float v, float v1) {
        return new float[]{xSpeed, ySpeed};
    }

    @Override
    public String toString() {
        return super.toString() + ",speed=(" + xSpeed + "," + ySpeed + ")";
    }

    public MovablePoint move() {
        setX(getX() + xSpeed);
        setY(getY() + xSpeed);
        return this;
    }
}
