package a.maklakov;

import a.maklakov.Entity.Triangle;

public class Main {

    public static void main(String[] args) {
        boolean canBuild = Triangle.canBuildTriangle(5,5,5);

        System.out.println("Can I draw a triangle with sides: 5, 5, 5?");

        if(canBuild) {
            System.out.println("--> Yes, you can!");
        } else {
            System.out.println("--> No! =(");
        }
    }
}
