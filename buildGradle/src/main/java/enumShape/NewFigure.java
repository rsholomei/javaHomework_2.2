package enumShape;

import figure.Circle;
import figure.Rectangle;
import figure.Square;
import figure.Triangle;
import iShape.IShape;

public class NewFigure {
    public static IShape selectionFigure()
    {
        SelectionFigure.inputFigure();
        switch (SelectionFigure.correctedFigure())
        {
            case CIRCLE:
                return new Circle().createAndInitializationFigure(6);
            case SQUARE:
                return new Square().createAndInitializationFigure(5);
            case RECTANGLE:
                return new Rectangle().createAndInitializationFigure(3, 7);
            case TRIANGLE:
                return Triangle.createAndInitializationFigure();
            default:
                return null;
        }
    }
}
