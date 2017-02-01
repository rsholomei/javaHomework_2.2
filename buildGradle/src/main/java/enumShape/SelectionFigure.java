package enumShape;

import java.util.Scanner;

public class SelectionFigure {
    private static boolean flag;
    private static Shape corrected;
    private static String typeFigure;


    public static boolean validator()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть тип фігури:");
        typeFigure = scanner.next();
        Shape [] valueShape = Shape.values();
        for (Shape shape : valueShape){
            if (typeFigure.toUpperCase().equals(shape.toString()))
            {
                flag = true;
                corrected = shape;
                break;
            }else
            {
                flag = false;
            }
        }
        return flag;
    }

    public static void inputFigure()
    {
        while (!flag)
        {
            validator();
        }
    }

    public static Shape correctedFigure()
    {
        return corrected;
    }
}

