import static java.lang.Math.*;

//Описать класс, представляющий треугольник.
//Предусмотреть методы для создания объектов, вычисления площади, периметра и точки пересечения медиан.

public class Triangle {
    private static double side_a;
    private static double side_b;
    private static double side_c;
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle() {
        x1 = -4;
        x2 = 0;
        x3 = 2;
        y1 = -1;
        y2 = -3;
        y3 = 1;
        side_a = calculateSide(x1, x2, y1, y2);
        side_b = calculateSide(x2, x3, y2, y3);
        side_c = calculateSide(x1, x3, y1, y3);
    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) throws TriangleException {
        double a = calculateSide(x1, x2, y1, y2);
        double b = calculateSide(x2, x3, y2, y3);
        double c = calculateSide(x1, x3, y1, y3);
        boolean flag = isTriangle(a, b, c);
        if(flag) {
            this.x1 = x1;
            this.x2 = x2;
            this.x3 = x3;
            this.y1 = y1;
            this.y2 = y2;
            this.y3 = y3;
            side_a = a;
            side_b = b;
            side_c = c;
        } else throw new TriangleException("It's not triangle");
    }

    private static double calculateSide(double x1, double x2, double y1, double y2) {
        return sqrt(pow((x2 - x1), 2) + (pow((y2 - y1), 2)));
    }

    private static boolean isTriangle(double a, double b, double c) {
        boolean flag = false;
        if((a + b > c && a + c != b && b + c != a)
                || (a + c > b && a + b != c && c + b != a)
                || (b + c > a && b + a != c && c + a != b)) {
            flag = true;
        }
        return flag;
    }

    public double getPerimeter() {
        return side_a + side_b + side_c;
    }

    public double getArea() {
        double half_meter = calculateHalfMeter();
        return calculateArea(half_meter);
    }

    public double[] getPointOfIntersectionOfMedians() {
        double[]coordinatesOfPointOfIntersection = new double[2];
        double x_midpointOf_b_side = calculateMidpoint(x2, x3);
        double y_midpointOf_b_side = calculateMidpoint(y2, y3);
        coordinatesOfPointOfIntersection[0] = calculatePointOfIntersection(x1, x_midpointOf_b_side);
        coordinatesOfPointOfIntersection[1] = calculatePointOfIntersection(y1, y_midpointOf_b_side);
        return coordinatesOfPointOfIntersection;
    }

    private static double calculateHalfMeter() {
        return (side_a + side_b + side_c) / 2;
    }

    private static double calculateArea(double half_meter) {
        return sqrt(half_meter * (half_meter - side_a) *
                (half_meter - side_b) * (half_meter - side_c));
    }

    private static double calculateMidpoint(double a, double b) {
        return (a + b) / 2;
    }

    private static double calculatePointOfIntersection(double a, double b) {
        return ((1 * a) + (2 * b)) / 3;
    }

}
