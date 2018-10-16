package a.maklakov;

import a.maklakov.entity.Triangle;
import a.maklakov.util.TriangleValidation;

public class Main {

    public static void main(String[] args) {
        Triangle triangle = new Triangle(5, 5, 5);
        boolean canBuild = TriangleValidation.canBuildTriangle(triangle);

        System.out.println("Can I draw a triangle with sides: 5, 5, 5?");

        if (canBuild) {
            System.out.println("--> Yes, you can!");
        } else {
            System.out.println("--> No! =(");
        }
    }
}
