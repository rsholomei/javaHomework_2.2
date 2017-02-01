package figure;

import iShape.IShape;

import java.util.Scanner;

public class Rectangle implements IShape {

    private double length;
    private double width;
    private double area;
    private double perimeter;
    private Scanner scanner;
    Triangle triangle;

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public Rectangle createAndInitializationFigure(int length, int width)
    {
        Rectangle rectangle = new Rectangle();
        rectangle.inputParams(length, width);
        return rectangle;
    }

    @Override
    public double calculateArea() {
        area = getLength() * getWidth();
        return area;
    }

    @Override
    public double calculatePerimeter() {
        perimeter = (getLength() * 2) + (getWidth() * 2);
        return perimeter;
    }

    public void inputParams(int length, int width) {
        this.length = length;
        this.width = width;

        while (getLength() < 0 || getWidth() < 0)
        {
            System.out.println("Ви ввели некоректний параметри прямокутника. Спробуйте ще:");
            System.out.println("Введіть довжину прямокутника:");
            this.length = scanner.nextDouble();
            System.out.println("Введіть ширину прямокутника:");
            this.width = scanner.nextDouble();
        }

        triangle = new Triangle(getLength(), getWidth(), Math.sqrt(Math.pow(getLength(), 2) +
                Math.pow(getWidth(), 2)));

    }

    @Override
    public String resultAfterCalculation() {
        triangle.calculateArea();
        triangle.calculatePerimeter();
        return String.format("Площа прямокутника = %.3f " + "Периметр прямокутника = %.3f%n"
                        + "Прямокутник складається з двох рівних трикутників %n" + triangle.resultAfterCalculation(),
                area, perimeter);
    }
}

