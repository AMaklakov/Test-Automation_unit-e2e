package Test;

import a.maklakov.Entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.InvalidParameterException;


/**
 * Here I will use TestNG, because I want DataProviders
 */
public class TriangleTest {

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
    public void Triangle_CanMakeTriangle_ShouldReturnTrueWhenDataIsValid() {
        Assert.assertTrue(Triangle.canBuildTriangle(3, 4, 5));
    }

    @Test
    public void Triangle_CanMakeTriangle_ShouldReturnFalseWhenDataIsNotValid() {
        Assert.assertFalse(Triangle.canBuildTriangle(1, 1, 100));
    }

    @Test()
    public void Triangle_CanMakeTriangle_ShouldReturnTrueIfSidesAreEqual() {
        boolean expectedException = Triangle.canBuildTriangle(5, 5, 5);
    }

    @Test(dataProvider = "triangleEqualTwoSides")
    public void Triangle_CanMakeTriangle_ShouldReturnTrueIfTwoSidesAreEqualAndThirdSideIsValid(int a, int b, int c) {
        Assert.assertTrue(Triangle.canBuildTriangle(a, b, c));
    }

    @Test(dataProvider = "triangleTwoSidesEqualToThird")
    public void Triangle_CanMakeTriangle_ShouldReturnFalseIfTwoSidesAreEqualToThird(int a, int b, int c) {
        Assert.assertFalse(Triangle.canBuildTriangle(a, b, c));
    }

    @Test(expectedExceptions = {InvalidParameterException.class}, dataProvider = "triangleZeroSides")
    public void Triangle_CanMakeTriangle_ShouldReturnFalseWhenAnySideEqualsToZero(int a, int b, int c) {
        boolean assertException = Triangle.canBuildTriangle(a, b, c);
    }

    @Test(expectedExceptions = {InvalidParameterException.class}, dataProvider = "triangleNegativeSides")
    public void Triangle_CanMakeTriangle_ShouldReturnFalseWhenAnyOfSidesLessThanZero(int a, int b, int c) {
        boolean assertException = Triangle.canBuildTriangle(a, b, c);
    }

}
