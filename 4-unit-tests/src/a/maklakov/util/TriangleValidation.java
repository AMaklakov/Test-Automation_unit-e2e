package a.maklakov.util;

import a.maklakov.entity.Triangle;

import java.security.InvalidParameterException;

public class TriangleValidation {
    public static boolean canBuildTriangle(Triangle triangle) throws InvalidParameterException {
        if (triangle.getA() <= 0 || triangle.getB() <= 0 || triangle.getC() <= 0) {
            throw new InvalidParameterException("One of parameters is less or equal to zero");
        }

        return triangle.getA() + triangle.getB() > triangle.getC() && 
                triangle.getA() + triangle.getC() > triangle.getB() && 
                triangle.getB() + triangle.getC() > triangle.getA();
    }
}
