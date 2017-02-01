package figure;

import iShape.IShape;

import java.util.Scanner;

public class Square implements IShape {
    Triangle triangle;

    private double lengthSide;
    private double area;
    private double perimeter;
    private Scanner scanner;

    public double getLengthSide() {
        return lengthSide;
    }

    public Square createAndInitializationFigure(int lengthSide)
    {
        Square square = new Square();
        square.inputParams(lengthSide);
        return square;
    }

    @Override
    public double calculateArea() {
        area = Math.pow(getLengthSide(), 2);
        return area;
    }

    @Override
    public double calculatePerimeter() {
        perimeter = getLengthSide() * 4;
        return perimeter;
    }

    public void inputParams(int lengthSide) {
        this.lengthSide = lengthSide;
        while (getLengthSide() < 0)
        {
            System.out.println("Ви ввели некоректну довжину сторони квадрата. Спробуйте ще:");
            System.out.println("Введіть довжину сторони квадрата:");
            lengthSide = scanner.nextInt();
        }
        triangle = new Triangle(getLengthSide(), getLengthSide(), Math.sqrt(Math.pow(getLengthSide(), 2) +
                Math.pow(getLengthSide(), 2)));

    }

    @Override
    public String resultAfterCalculation() {
        triangle.calculateArea();
        triangle.calculatePerimeter();
        return String.format("Площа прямокутника = %.3f " + "Периметр прямокутника = %.3f%n"
                        + "Прямокутник складається з двох рівних трикутників %n" +
                        triangle.resultAfterCalculation(),
                area, perimeter);
    }
}

