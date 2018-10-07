package a.maklakov.Entity;

import java.security.InvalidParameterException;

public class Triangle {
    public static boolean canBuildTriangle(double a, double b, double c) throws InvalidParameterException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new InvalidParameterException("One of parameters is less or equal to zero");
        }

        boolean canBuild = true;

        if (a + b <= c) {
            canBuild = false;
        }

        if (a + c <= b) {
            canBuild = false;
        }

        if (b + c <= a) {
            canBuild = false;
        }

        return canBuild;
    }
}
