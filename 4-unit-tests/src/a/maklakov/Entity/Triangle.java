package a.maklakov.Entity;

import java.security.InvalidParameterException;

public class Triangle {
    public static boolean canBuildTriangle(double a, double b, double c) throws InvalidParameterException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new InvalidParameterException("One of parameters is less or equal to zero");
        }

        return a + b > c && a + c > b && b + c > a;
    }
}
