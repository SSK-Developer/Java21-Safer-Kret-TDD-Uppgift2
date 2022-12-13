package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {


    static Coordinates c = new Coordinates();
    static ArrayList<Coordinates> coordinates1 = new ArrayList<>();
    static double distanceAB = 0;
    static double distanceBC = 0;
    static double distanceDC = 0;
    static double distanceAD = 0;

    public static void main(String[] args) {

        /*
        //Dot
        coordinates1.add(new Coordinates(0, 0, 0));
        //*/

        /*
        //Line
        coordinates1.add(new Coordinates(0, 0, 0));
        coordinates1.add(new Coordinates(1, 1, 0));
        //*/

        /*
        //Triangle
        coordinates1.add(new Coordinates(0, 0, 0));
        coordinates1.add(new Coordinates(1, 1, 0));
        coordinates1.add(new Coordinates(2, 0, 0));
        //*/

        /*
        //Square
        coordinates1.add(new Coordinates(-1, -1, 0));
        coordinates1.add(new Coordinates(-1, -5, 0));
        coordinates1.add(new Coordinates(-5, -5, 0));
        coordinates1.add(new Coordinates(-5, -1, 0));

        //*/

     /*
        //Rectangle
        coordinates1.add(new Coordinates(5, 1, 0));
        coordinates1.add(new Coordinates(5, 3, 0));
        coordinates1.add(new Coordinates(1, 3, 0));
        coordinates1.add(new Coordinates(1, 1, 0));

        //*/

//     /*
        //Parallelogram
        coordinates1.add(new Coordinates(0, 0, 0));
        coordinates1.add(new Coordinates(9, 0, 0));
        coordinates1.add(new Coordinates(16, 5, 0));
        coordinates1.add(new Coordinates(7, 5, 0));

        //*/

        /*
        //Pyramid
        coordinates1.add(new Coordinates(-1, -1, 0));
        coordinates1.add(new Coordinates(-1, 1, 0));
        coordinates1.add(new Coordinates(1, 1, 0));
        coordinates1.add(new Coordinates(1, -1, 0));
        coordinates1.add(new Coordinates(0, 0, 1));
        //*/

        /*
        //Cube
        coordinates1.add(new Coordinates(0, 0, 0));
        coordinates1.add(new Coordinates(4, 0, 0));
        coordinates1.add(new Coordinates(4, 4, 0));
        coordinates1.add(new Coordinates(0, 4, 0));
        //*/

        Collections.sort(coordinates1, Comparator.comparing(Coordinates::getX));
        System.out.println("Amount of coordinates: " + coordinates1.size());
        getShape(coordinates1);
    }


    public static String getShape(ArrayList<Coordinates> coordinates) {

        //if there is 0 coordinates.
        if (coordinates.size() == 0) {
            System.out.println("None");
            return "None";
        }

        double x = coordinates.get(0).getX();
        double y = coordinates.get(0).getY();
        double z = coordinates.get(0).getZ();
        boolean isX_2D = false;
        boolean isY_2D = false;
        boolean isZ_2D = false;

        //check if all z,x,y values are the same, if it is, it's 2D. Otherwise:
        // one of the z-,x-,y- axis has higher/lower value and therefore is 3D.
        for (var item : coordinates) {
            if (item.getZ() != z) {
                isZ_2D = true;
            }
            if (item.getX() != x) {
                isX_2D = true;
            }
            if (item.getY() != y) {
                isY_2D = true;
            }
        }
        System.out.println(isX_2D);
        System.out.println(isY_2D);
        System.out.println(isZ_2D);

        //check if it's 2D
        if (!isX_2D || !isY_2D || !isZ_2D) {

            //if there is 1 coordinate.
            if (coordinates.size() == 1) {
                System.out.println("Dot");
                return "Dot";
            }

            //if there is 2 coordinates.
            else if (coordinates.size() == 2) {
                System.out.println("Line");
                return "Line";
            }

            //if there is 3 coordinates.
            else if (coordinates.size() == 3) {
                System.out.println("Triangle");
                return "Triangle";
            }

            //if there is 4 coordinates.
            else if (coordinates.size() == 4) {

                double[] A = {coordinates.get(0).getX(), coordinates.get(0).getY(), coordinates.get(0).getZ()};
                double[] B = {coordinates.get(1).getX(), coordinates.get(1).getY(), coordinates.get(1).getZ()};
                double[] C = {coordinates.get(2).getX(), coordinates.get(2).getY(), coordinates.get(2).getZ()};
                double[] D = {coordinates.get(3).getX(), coordinates.get(3).getY(), coordinates.get(3).getZ()};

                if (!isZ_2D) {
                    System.out.println("Z is 3D");

                    distanceAB = Math.round(calcDistance(A[0], A[1], B[0], B[1]));
                    distanceBC = Math.round(calcDistance(B[0], B[1], C[0], C[1]));
                    distanceDC = Math.round(calcDistance(D[0], D[1], C[0], C[1]));
                    distanceAD = Math.round(calcDistance(A[0], A[1], D[0], D[1]));

                    if (!((distanceAB == distanceBC && distanceBC == distanceDC && distanceDC == distanceAD) || distanceAB == distanceDC && distanceAD == distanceBC)) {
                        System.out.println("2nd perm");
                        distanceAB = Math.round(calcDistance(B[0], B[1], A[0], A[1]));
                        distanceBC = Math.round(calcDistance(A[0], A[1], C[0], C[1]));
                        distanceDC = Math.round(calcDistance(D[0], D[1], C[0], C[1]));
                        distanceAD = Math.round(calcDistance(B[0], B[1], D[0], D[1]));
                    }

                    if (!((distanceAB == distanceBC && distanceBC == distanceDC && distanceDC == distanceAD) || distanceAB == distanceDC && distanceAD == distanceBC)) {
                        System.out.println("3th perm");
                        distanceAB = Math.round(calcDistance(A[0], A[1], B[0], B[1]));
                        distanceBC = Math.round(calcDistance(B[0], B[1], D[0], D[1]));
                        distanceDC = Math.round(calcDistance(C[0], C[1], D[0], D[1]));
                        distanceAD = Math.round(calcDistance(A[0], A[1], C[0], C[1]));
                    }

                    if (!((distanceAB == distanceBC && distanceBC == distanceDC && distanceDC == distanceAD) || distanceAB == distanceDC && distanceAD == distanceBC)) {
                        System.out.println("4th perm");
                        distanceAB = Math.round(calcDistance(B[0], B[1], A[0], A[1]));
                        distanceBC = Math.round(calcDistance(A[0], A[1], D[0], D[1]));
                        distanceDC = Math.round(calcDistance(C[0], C[1], D[0], D[1]));
                        distanceAD = Math.round(calcDistance(B[0], B[1], C[0], C[1]));
                    }

                } else if (!isY_2D) {
                    System.out.println("Y is 3D");
                    distanceAB = Math.round(calcDistance(A[0], A[2], B[0], B[2]));
                    distanceBC = Math.round(calcDistance(B[0], B[2], C[0], C[2]));
                    distanceDC = Math.round(calcDistance(D[0], D[2], C[0], C[2]));
                    distanceAD = Math.round(calcDistance(A[0], A[2], D[0], D[2]));

                    if (!((distanceAB == distanceBC && distanceBC == distanceDC && distanceDC == distanceAD) || distanceAB == distanceDC && distanceAD == distanceBC)) {
                        System.out.println("2nd perm");
                        distanceAB = Math.round(calcDistance(B[0], B[2], A[0], A[2]));
                        distanceBC = Math.round(calcDistance(A[0], A[2], C[0], C[2]));
                        distanceDC = Math.round(calcDistance(D[0], D[2], C[0], C[2]));
                        distanceAD = Math.round(calcDistance(B[0], B[2], D[0], D[2]));
                    }

                    if (!((distanceAB == distanceBC && distanceBC == distanceDC && distanceDC == distanceAD) || distanceAB == distanceDC && distanceAD == distanceBC)) {
                        System.out.println("3th perm");
                        distanceAB = Math.round(calcDistance(A[0], A[2], B[0], B[2]));
                        distanceBC = Math.round(calcDistance(B[0], B[2], D[0], D[2]));
                        distanceDC = Math.round(calcDistance(C[0], C[2], D[0], D[2]));
                        distanceAD = Math.round(calcDistance(A[0], A[2], C[0], C[2]));
                    }

                    if (!((distanceAB == distanceBC && distanceBC == distanceDC && distanceDC == distanceAD) || distanceAB == distanceDC && distanceAD == distanceBC)) {
                        System.out.println("4th perm");
                        distanceAB = Math.round(calcDistance(B[0], B[2], A[0], A[2]));
                        distanceBC = Math.round(calcDistance(A[0], A[2], D[0], D[2]));
                        distanceDC = Math.round(calcDistance(C[0], C[2], D[0], D[2]));
                        distanceAD = Math.round(calcDistance(B[0], B[2], C[0], C[2]));
                    }

                } else {
                    System.out.println("X is 3D");
                    //sides
                    distanceAB = Math.round(calcDistance(A[1], A[2], B[1], B[2]));
                    distanceBC = Math.round(calcDistance(B[1], B[2], C[1], C[2]));
                    distanceDC = Math.round(calcDistance(D[1], D[2], C[1], C[2]));
                    distanceAD = Math.round(calcDistance(A[1], A[2], D[1], D[2]));

                    if (!((distanceAB == distanceBC && distanceBC == distanceDC && distanceDC == distanceAD) || distanceAB == distanceDC && distanceAD == distanceBC)) {
                        System.out.println("2nd perm");
                        distanceAB = Math.round(calcDistance(B[1], B[2], A[1], A[2]));
                        distanceBC = Math.round(calcDistance(A[1], A[2], C[1], C[2]));
                        distanceDC = Math.round(calcDistance(D[1], D[2], C[1], C[2]));
                        distanceAD = Math.round(calcDistance(B[1], B[2], D[1], D[2]));
                    }

                    if (!((distanceAB == distanceBC && distanceBC == distanceDC && distanceDC == distanceAD) || distanceAB == distanceDC && distanceAD == distanceBC)) {
                        System.out.println("3th perm");
                        distanceAB = Math.round(calcDistance(A[1], A[2], B[1], B[2]));
                        distanceBC = Math.round(calcDistance(B[1], B[2], D[1], D[2]));
                        distanceDC = Math.round(calcDistance(C[1], C[2], D[1], D[2]));
                        distanceAD = Math.round(calcDistance(A[1], A[2], C[1], C[2]));
                    }

                    if (!((distanceAB == distanceBC && distanceBC == distanceDC && distanceDC == distanceAD) || distanceAB == distanceDC && distanceAD == distanceBC)) {
                        System.out.println("4th perm");
                        distanceAB = Math.round(calcDistance(B[1], B[2], A[1], A[2]));
                        distanceBC = Math.round(calcDistance(A[1], A[2], D[1], D[2]));
                        distanceDC = Math.round(calcDistance(C[1], C[2], D[1], D[2]));
                        distanceAD = Math.round(calcDistance(B[1], B[2], C[1], C[2]));
                    }

                }

                System.out.println("AB: " + distanceAB);
                System.out.println("BC: " + distanceBC);
                System.out.println("DC: " + distanceDC);
                System.out.println("AD: " + distanceAD);

                double slopeAB = calcSlope(B[0], B[1], A[0], A[1]);
                double slopeBC = calcSlope(A[0], A[1], C[0], C[1]);
                double slopeDC = calcSlope(D[0], D[1], C[0], C[1]);
                double slopeAD = calcSlope(B[0], B[1], D[0], D[1]);

                System.out.println(slopeAB);
                System.out.println(slopeBC);
                System.out.println(slopeDC);
                System.out.println(slopeAD);

                //if the distance between all 4 points are equal, it's a square
                if (distanceAB == distanceBC && distanceBC == distanceDC && distanceDC == distanceAD) {
                    System.out.println("Square");
                    return "Square";
                }

                //if the two opposite sides are equal it's a rectangle or parallelogram
                if (distanceAB == distanceDC && distanceAD == distanceBC) {

                    //if the slope is infinite on 2 sides, it's a rectangle
                    if (Double.isInfinite(slopeAB) || Double.isInfinite(slopeBC) || Double.isInfinite(slopeDC) || Double.isInfinite(slopeAD)) {
                        System.out.println("Rectangle");
                        return "Rectangle";
                    }
                    ////if the slope is not infinite on 2 sides, it's a rectangle
                    else {
                        System.out.println("Parallelogram");
                        return "Parallelogram";
                    }
                }
            } else {
                System.out.println("2D shape");
                return "2D shape";
            }
        }

        //will enter this statement when it's 3D and has least 5 points.
        if (coordinates.size() == 5) {

            if (distanceAB == distanceBC && distanceBC == distanceDC && distanceDC == distanceAD || (distanceAB == distanceDC && distanceAD == distanceBC)) {
                System.out.println("Pyramid");
                return "Pyramid";
            }
        }

        if (coordinates.size() == 8) {
            System.out.println("Cube");
            return "Cube";
        }

        return null;
    }

    public static double calcDistance(double x1, double y1, double x2, double y2) {
        //calc distance between points : with distance formula d=√((x_2-x_1)²+(y_2-y_1)²)
        return Math.sqrt(Math.pow(2, x2 - x1) + Math.pow(2, y2 - y1));
    }

    public static double calcSlope(double x1, double y1, double x2, double y2) {
        return (y2 - y1) / (x2 - x1);
    }
}