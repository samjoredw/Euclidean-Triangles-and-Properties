package triangles;
/******************************************************************************
 * Triangle.java
 * By: Samuel Edwards
 * Creates a triangle based on a set of three sides and calculates
 * its characteristics and perimeter based on user input.
 * Finds total count and total perimeter of specified number of triangles.
 ******************************************************************************/

public class Triangle {
    private int s1,s2,s3;
    private static int total = 0;
    private static int triangleCount = 0;

    //-----------------------------------------------------------------------
    // Takes in three integers representing the sides of a triangle.
    // Sets invalid input to side lengths of 1. Increments total
    // perimeter and the number of triangles entered.
    //-----------------------------------------------------------------------
    public Triangle (int a,int b,int c) {
        this.s1 = a;
        this.s2 = b;
        this.s3 = c;
        if (!isValid()) {
            System.out.println("This is not a valid triangle :(\n");
        }
        triangleCount++;
        total += calcPerim();
    }

    // PRE: Must have initialized side lengths.
    // POST: Finds perimeter of specified triangle.
    public int calcPerim() {
        return s1 + s2 + s3;
    }

    // PRE: Perimeter of triangle has been initialized.
    // POST: Adds perimeter to the total perimeter.
    public void addTotalPerim() {
        total += calcPerim();
    }

    // PRE: Perimeter of triangle has been initialized.
    // POST: Reduces given perimeter off of the total perimeter.
    public void reduceTotalPerim() {
        total -= calcPerim();
    }

    // PRE: Side lengths have been initialized.
    // POST: Determines whether given triangle contains a right angle
    // based on side lengths.
    public boolean isRight() {
        return Math.pow(s1,2) + Math.pow(s2,2) == Math.pow(s3,2)
                ||Math.pow(s2,2) + Math.pow(s3,2) == Math.pow(s1,2)
                ||Math.pow(s3,2) + Math.pow(s1,2) == Math.pow(s2,2);
    }

    // PRE: Side lengths have been initialized.
    // POST: Determines whether given triangle contains an obtuse angle
    // based on side lengths.
    public boolean isObtuse() {
        double max = Math.pow(Math.max(s3,(Math.max(s1, s2))),2);
        double min = Math.pow(Math.min(s3,(Math.min(s1, s2))),2);
        double mid = Math.pow(s3,2);

        if ((s1 <= s2&&s2 <= s3)||(s3 <= s2&&s2 <= s1))
            mid = Math.pow(s2,2);
        else if ((s2 <= s1&&s1 <= s3)||(s3 <= s1&&s1 <= s2))
            mid = Math.pow(s1,2);

        return !isRight() && (max > min + mid);
    }

    // PRE: Side lengths have been initialized.
    // POST: Determines whether given triangle contains an acute angle
    // based on side lengths.
    public boolean isAcute() {
        return !isRight() && !isObtuse();
    }

    // PRE: Side lengths have been initialized.
    // POST: Determines if given triangle contains no angles of equal
    // degree.
    public boolean isScalene() {
        return s1 != s2 && s2 != s3 && s3!= s1;
    }

    // PRE: Side lengths have been initialized.
    // POST: Determines if given triangle has 3 angles of equal
    // degree.
    public boolean isEquilateral() {
        return s1 == s2 && s1 == s3;
    }

    // PRE: Side lengths have been initialized.
    // POST: Determines if given triangle has exactly 2 angles of
    // equal degree.
    public boolean isIsosceles() {
        return !isScalene() && !isEquilateral();
    }

    // PRE: Side lengths have been initialized.
    // POST: Determines if side lengths form a valid triangle.
    public boolean isValid() {
        if (s1 >= s2+s3
                || s2 >= s1+s3
                || s3 >= s2+s1
                || (s1 <= 0 || s2 <= 0 || s3 <=0)) {
            return false;
        }
        return true;
    }

    // PRE: Takes in a Triangle t to compare to current triangle.
    // POST: Determines whether triangles have the same perimeter.
    public boolean equals(Triangle t) {
        return calcPerim() == t.calcPerim();
    }

    //GETTERS:

    public void getQualities(Triangle tri) {

        System.out.println("Triangle Qualities:");
        if (tri.isRight())
            System.out.println("Right Triangle");
        if (tri.isObtuse())
            System.out.println("Obtuse");
        if (tri.isAcute())
            System.out.println("Acute");
        if (tri.isScalene())
            System.out.println("Scalene");
        if (tri.isIsosceles())
            System.out.println("Isosceles");
        if (tri.isEquilateral())
            System.out.println("Equilateral");

    }

    // Returns first side length of referenced triangle.
    public int getSideA() {
        return s1;
    }

    // Returns second side length of referenced triangle.
    public int getSideB() {
        return s2;
    }

    // Returns third side length of referenced triangle.
    public int getSideC() {
        return s3;
    }

    // Returns perimeter of given triangle.
    public int getPerim() {
        return calcPerim();
    }

    // Returns the number of triangles entered.
    public static int getNumTriangles() {
        return triangleCount;
    }

    // Returns the total perimeter of all triangles entered.
    public static int getTotalPerim() {
        return total;
    }

    // Returns string identifying each side length.
    public String toString() {
        return "Side a: "+ s1 +"\nSide b: "+ s2 +"\nSide c: "+ s3 + "\n";
    }
}
