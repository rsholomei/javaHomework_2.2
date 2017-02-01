package figure;

import iShape.IShape;

import java.util.Scanner;

public class Circle implements IShape {

    private int radius;
    private double area;
    private double perimeter;
    private Scanner scanner;

    public double getRadius() {
        return radius;
    }

    public Circle createAndInitializationFigure(int radius)
    {
        Circle circle = new Circle();
        circle.inputParams(radius);
        return circle;
    }
    @Override
    public double calculateArea() {
        area = Math.PI * Math.pow(getRadius(), 2);
        return area;
    }

    @Override
    public double calculatePerimeter() {
        perimeter = (2 * Math.PI) * getRadius();
        return perimeter;
    }

    public void inputParams(int radius) {
        this.radius = radius;

        while (radius < 0)
        {
            System.out.println("Ви ввели некоректний радіус. Спробуйте ще:");
            System.out.println("Введіть радіус кола:");
            radius = scanner.nextInt();
        }

    }

    @Override
    public String resultAfterCalculation() {
        return String.format("Площа кола = %.3f " + "Довжина кола = %.3f", area, perimeter);
    }
}

