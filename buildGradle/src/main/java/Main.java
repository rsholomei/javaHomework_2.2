import enumShape.NewFigure;
import figure.Circle;
import figure.Rectangle;
import figure.Square;
import figure.Triangle;
import iShape.IShape;

public class Main {
    public double sumAllAreaFigure(Circle circle, Rectangle rectangle, Square square, Triangle triangle){
        return circle.calculateArea() + rectangle.calculateArea() + square.calculateArea() + triangle.calculateArea();
    }
    public double sumAllPerimeterFigure(Circle circle, Rectangle rectangle, Square square, Triangle triangle){
        return circle.calculatePerimeter() + rectangle.calculatePerimeter() + square.calculatePerimeter() + triangle.calculatePerimeter();
    }
    public static void main(String[] args){
        try {
            IShape figure = NewFigure.selectionFigure();
            figure.calculateArea();
            figure.calculatePerimeter();
            System.out.println(figure.resultAfterCalculation());
        }catch (Exception e)
        {
            System.err.println("Параметр фігури не може містити літер: " + e.getClass());
        }
    }
}

