import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Triangle basicTriangle = new Triangle();
        System.out.println("Perimeter of basic triangle: " + basicTriangle.getPerimeter());
        System.out.println("Area of basic triangle: " + basicTriangle.getArea());
        System.out.println("Coordinates of point of intersection of medians: "
                + Arrays.toString(basicTriangle.getPointOfIntersectionOfMedians()));

        System.out.println("Please enter coordinates of triangle vertexes (three pairs, x then y):");
        double x1 = Double.parseDouble(reader.readLine());
        double y1 = Double.parseDouble(reader.readLine());
        double x2 = Double.parseDouble(reader.readLine());
        double y2 = Double.parseDouble(reader.readLine());
        double x3 = Double.parseDouble(reader.readLine());
        double y3 = Double.parseDouble(reader.readLine());
        try {
            Triangle triangle = new Triangle(x1, y1, x2, y2, x3, y3);
        } catch (TriangleException t) {
            System.out.println("Error!");
            System.out.println(t.getMessage());
            System.out.println("Try again.");
        }
    }
}
