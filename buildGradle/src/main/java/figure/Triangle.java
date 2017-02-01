package figure;

import iShape.IShape;

import java.util.Scanner;

public class Triangle implements IShape {

    private double area;
    private double perimeter;
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(){};
    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public static Triangle createAndInitializationFigure()
    {
        Triangle triangle = new Triangle();
        triangle.inputParams(new Scanner(System.in));
        return triangle;
    }

    @Override
    public double calculateArea() {
        double halfperimeter = (getSideA() + getSideB() + getSideC()) / 2;
        area = Math.sqrt(halfperimeter * (halfperimeter - getSideA()) * (halfperimeter - getSideB())
                * (halfperimeter - getSideC()));
        return area;
    }

    @Override
    public double calculatePerimeter() {
        perimeter = getSideA() + getSideB() + getSideC();
        return perimeter;
    }

    public void inputParams(Scanner scanner) {
        System.out.println("Введіть сторони трикутника:");
        System.out.println("Сторона А:");
        this.sideA = scanner.nextDouble();
        System.out.println("Сторона B:");
        this.sideB = scanner.nextDouble();
        System.out.println("Сторона C:");
        this.sideC = scanner.nextDouble();

        while (getSideA() < 0 || getSideB() < 0 || getSideC() < 0)
        {
            System.out.println("Ви ввели некоректні параметри трикутника. Спробуйте ще:");
            System.out.println("Сторона А:");
            this.sideA = scanner.nextDouble();
            System.out.println("Сторона B:");
            this.sideB = scanner.nextDouble();
            System.out.println("Сторона C:");
            this.sideC = scanner.nextDouble();
        }
    }
    public boolean conditionExistenceTriangle()
    {
        if (getSideA() + getSideB() > getSideC() && getSideA() + getSideC() > getSideB()
                && getSideB() + getSideC() > getSideA())
        {
            return false;
        }
        return true;
    }
    @Override
    public String resultAfterCalculation() {
        if(conditionExistenceTriangle())
            return String.format("Трикутник не може існувати з такими сторонами!");
        return String.format("Площа трикутника = %.3f " + "Периметр трикутника = %.3f%n",
                area, perimeter);
    }
}

