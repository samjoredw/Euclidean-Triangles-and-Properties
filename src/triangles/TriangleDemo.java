package triangles;
/******************************************************************************
 * TriangleDemo.java
 * By: Samuel Edwards
 * This program demonstrates the use and accuracy of Triangle.java
 * by implementing the creation of triangles.
 * Assesses the properties of each triangle and tests perimeter equality.
 ******************************************************************************/
import java.util.Scanner;

public class TriangleDemo {
    //-----------------------------------------------------------------------
    // Creates a user disclosed number of triangles of different lengths and
    // then outputs the explicit information.
    // Tests the use of equals() with chosen integer values.
    //-----------------------------------------------------------------------
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        System.out.println("Hello! Please enter the sides of a triangle: ");
        int s1 = stdin.nextInt();
        int s2 = stdin.nextInt();
        int s3 = stdin.nextInt();

        Triangle f1 = new Triangle(s1, s2, s3);

        System.out.println("Please enter the sides of another triangle: ");
        int ss1 = stdin.nextInt();
        int ss2 = stdin.nextInt();
        int ss3 = stdin.nextInt();

        Triangle f2 = new Triangle(ss1, ss2, ss3);

        int perim1 = f1.getPerim();
        int perim2 = f2.getPerim();

        System.out.println();

        System.out.println("The perimeter of your first triangle is " + perim1);
        System.out.println("The perimeter of your second triangle is " + perim2 + "\n");

        System.out.print("Now lets enter some data on a set of triangles to find some details about each one individually.\n" +
                "How many triangles would you like to make? (enter number): ");
        int number = stdin.nextInt();

        Triangle[] triNum = new Triangle[number];

        for (int j = 0; j < triNum.length; j++) {
            System.out.print("Enter an integer dimension for side a "
                    + "of triangle " + (j+1) + ": ");
            s1 = stdin.nextInt();
            System.out.print("Enter an integer dimension for side b "
                    + "of triangle " + (j+1) + ": ");
            s2 = stdin.nextInt();
            System.out.print("Enter an integer dimension for side c "
                    + "of triangle " + (j+1) + ": ");
            s3 = stdin.nextInt();
            System.out.println();

            triNum[j] = new Triangle(s1,s2,s3);

            triNum[j].addTotalPerim();
            triNum[j].reduceTotalPerim();
        }

        System.out.println();

        for (int k = 0; k < triNum.length; k++) {

            triNum[k].isValid();

            System.out.println("Triangle " + (k+1) + " has sides of:");
            System.out.println(triNum[k]);
            System.out.println("The perimeter is " + triNum[k].calcPerim());
            System.out.println("Triangle Properties:");

            if (triNum[k].isRight())
                System.out.println("Right Triangle");
            if (triNum[k].isObtuse())
                System.out.println("Obtuse");
            if (triNum[k].isAcute())
                System.out.println("Acute");
            if (triNum[k].isScalene())
                System.out.println("Scalene");
            if (triNum[k].isIsosceles())
                System.out.println("Isosceles");
            if (triNum[k].isEquilateral())
                System.out.println("Equilateral");

            System.out.println();
        }

        // Author chosen values (int m,int n) to test accuracy
        // of equals() method:
        System.out.println("My test for equals method:");

        // First entry: Triangles 4 and 5
        int m = 1;
        int n = 2;

        if (triNum[m-1].equals(triNum[n-1])) {
            System.out.println("Triangle " + m + " and " + n
            + " are equal");
        } else {
            System.out.println("Triangle " + m + " and " + n
            + " are not equal");
        }
    }
}