package Test;

import a.maklakov.entity.Triangle;
import a.maklakov.util.TriangleValidation;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;


/**
 * Here I will use TestNG, because I want DataProviders
 */
public class TriangleValidationTest {

    @DataProvider
    public static Object[][] triangleZeroSides() {
        return new Object[][]{
                {0, 1, 2},
                {1, 0, 2},
                {1, 2, 0}
        };
    }

    @DataProvider
    public static Object[][] triangleNegativeSides() {
        return new Object[][]{
                {-1, 1, 2},
                {1, -1, 2},
                {1, 2, -1}
        };
    }

    @DataProvider
    public static Object[][] triangleEqualTwoSides() {
        return new Object[][]{
                {5, 5, 6},
                {5, 6, 5},
                {6, 5, 5}
        };
    }

    @DataProvider
    public static Object[][] triangleTwoSidesEqualToThird() {
        return new Object[][]{
                {5, 5, 10},
                {5, 10, 5},
                {10, 5, 5}
        };
    }

    @Test
    public void canBuildTriangleWhenSidesAreValid() {
        Triangle triangle = new Triangle(3, 4, 5);

        Assert.assertTrue(TriangleValidation.canBuildTriangle(triangle));
    }

    @Test
    public void canNotBuildTriangleWhenSidesAreNotValid() {
        Triangle triangle = new Triangle(1, 1, 100);

        Assert.assertFalse(TriangleValidation.canBuildTriangle(triangle));
    }

    @Test()
    public void oneCanMakeTriangleWhenAllSidesAreEqualAndGreaterThanZero() {
        Triangle triangle = new Triangle(5, 5, 5);

        Assert.assertTrue(TriangleValidation.canBuildTriangle(triangle));
    }

    @Test(dataProvider = "triangleEqualTwoSides")
    public void oneCanBuildTriangleIfTwoSidesAreEqualAndThirdSideIsValid(int a, int b, int c) {
        Triangle triangle = new Triangle(a, b, c);

        Assert.assertTrue(TriangleValidation.canBuildTriangle(triangle));
    }

    @Test(dataProvider = "triangleTwoSidesEqualToThird")
    public void canNotBuildTriangleIfTwoSidesAreEqualToThird(int a, int b, int c) {
        Triangle triangle = new Triangle(a, b, c);

        Assert.assertFalse(TriangleValidation.canBuildTriangle(triangle));
    }

    @Test(expectedExceptions = {InvalidParameterException.class}, dataProvider = "triangleZeroSides")
    public void canNotBiuldTriangleWhenAnySideEqualsToZero(int a, int b, int c) {
        Triangle triangle = new Triangle(a, b, c);

        boolean assertException = TriangleValidation.canBuildTriangle(triangle);
    }

    @Test(expectedExceptions = {InvalidParameterException.class}, dataProvider = "triangleNegativeSides")
    public void canNotBiuldTriangleWhenAnyOfSidesLessThanZero(int a, int b, int c) {
        Triangle triangle = new Triangle(a, b, c);

        boolean assertException = TriangleValidation.canBuildTriangle(triangle);
    }

}
