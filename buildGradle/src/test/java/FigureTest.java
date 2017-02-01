import figure.Circle;
import figure.Rectangle;
import figure.Square;
import figure.Triangle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FigureTest {
    private Circle circle;
    private Rectangle rectangle;
    private Square square;

    @Before
    public void init(){
        circle = new Circle().createAndInitializationFigure(6);
        rectangle = new Rectangle().createAndInitializationFigure(3, 7);
        square = new Square().createAndInitializationFigure(5);
    }
    @After
    public void tearDown(){
        circle = null;
        rectangle = null;
        square = null;
    }
    @Test
    public void circleCalculateAreaTest(){
        double circleArea = new BigDecimal(circle.calculateArea()).setScale(3, RoundingMode.HALF_UP).doubleValue();
        assertNotEquals(100, circleArea);
        assertTrue(113.097 == circleArea);
        assertNotNull(circleArea);
    }
    @Test
    public void circleCalculatePerimeterTest(){
        double circuit = new BigDecimal(circle.calculatePerimeter()).setScale(3,RoundingMode.HALF_UP).doubleValue();
        assertNotEquals(50, circuit);
        assertTrue(37.699 == circuit);
        assertNotNull(circuit);
    }
    @Test
    public void rectangleCalculateAreaTest(){
        double rectangleArea = new BigDecimal(rectangle.calculateArea()).setScale(3, RoundingMode.HALF_UP).doubleValue();
        assertNotEquals(15, rectangleArea);
        assertTrue(21 == rectangleArea);
        assertNotNull(rectangleArea);
    }
    @Test
    public void rectangleCalculatePerimeterTest(){
        double rectanglePerimeter = new BigDecimal(rectangle.calculatePerimeter()).setScale(3, RoundingMode.HALF_UP).doubleValue();
        assertNotEquals(21, rectanglePerimeter);
        assertTrue(20 == rectanglePerimeter);
        assertNotNull(rectanglePerimeter);
    }
    @Test
    public void squareCalculationAreaTest(){
        double squareArea = new BigDecimal(square.calculateArea()).setScale(3, RoundingMode.HALF_UP).doubleValue();
        assertNotEquals(30, squareArea);
        assertTrue(25 == squareArea);
        assertNotNull(squareArea);
    }
    @Test
    public void squareCalculationPerimeterTest(){
        double squarePerimeter = new BigDecimal(square.calculatePerimeter()).setScale(3, RoundingMode.HALF_UP).doubleValue();
        assertNotEquals(19, squarePerimeter);
        assertTrue(20 == squarePerimeter);
        assertNotNull(squarePerimeter);
    }

    @Test
    public void testSumAllAreaFigure(){
        Circle mockedCircle = mock(Circle.class);
        Rectangle mockedRectangle = mock(Rectangle.class);
        Square mockedSquare = mock(Square.class);
        Triangle mockedTriangle = mock(Triangle.class);

        when(mockedCircle.calculateArea()).thenReturn(100D);
        when(mockedRectangle.calculateArea()).thenReturn(150D);
        when(mockedSquare.calculateArea()).thenReturn(50D);
        when(mockedTriangle.calculateArea()).thenReturn(120D);

        double result = new Main().sumAllAreaFigure(mockedCircle, mockedRectangle, mockedSquare, mockedTriangle);
        assertTrue(result == 420D);
        assertNotNull(result);
    }
    @Test
    public void teatSumAllPerimeterFigure(){
        Circle mockedCircle = mock(Circle.class);
        Rectangle mockedRectangle = mock(Rectangle.class);
        Square mockedSquare = mock(Square.class);
        Triangle mockedTriangle = mock(Triangle.class);

        when(mockedCircle.calculatePerimeter()).thenReturn(50D);
        when(mockedRectangle.calculatePerimeter()).thenReturn(75D);
        when(mockedSquare.calculatePerimeter()).thenReturn(125D);
        when(mockedTriangle.calculatePerimeter()).thenReturn(150D);

        double result = new Main().sumAllPerimeterFigure(mockedCircle, mockedRectangle, mockedSquare, mockedTriangle);
        assertTrue(result == 400);
        assertNotNull(result);
    }

    public static void main(String[] args) throws Exception {
        JUnitCore runner = new JUnitCore();
        Result result = runner.run(FigureTest.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }
}
