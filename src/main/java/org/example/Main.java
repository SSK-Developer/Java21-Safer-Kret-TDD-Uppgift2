package org.example;

import java.util.ArrayList;

public class Main {


    static Coordinates c = new Coordinates();
    static ArrayList<Coordinates> coordinates1 = new ArrayList<>();

    /*
    double[] coordinates1 = {1.1};

    double[] coordinates2 = {1.1, 2.2};

    double[] coordinates3 = {1.1, 2.2, 3,3};

    coordinates4Square = {1.1, 1.1, 1.1, 1.1};
    coordinates4Rectangle = {1.1, 1.1, 2.2, 2.2};
    coordinates4Parallelogram = {1.1, 2.2, 3,3, 4.4};
    coordinates4scalene = {1.1, 2.2, 3,3, 4.4};
     */

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
        coordinates1.add(new Coordinates(0, 1, 1));
        coordinates1.add(new Coordinates(0, 5, 1));
        coordinates1.add(new Coordinates(0, 5, 5));
        coordinates1.add(new Coordinates(0, 1, 5));
        //*/

        /*
        //Rectangle
        coordinates1.add(new Coordinates(1, 0, 1));
        coordinates1.add(new Coordinates(5, 0, 1));
        coordinates1.add(new Coordinates(5, 0, 3));
        coordinates1.add(new Coordinates(1, 0, 3));
        //*/

        /*
        //Parallelogram
        coordinates1.add(new Coordinates(1, 1, 0));
        coordinates1.add(new Coordinates(5, 1, 0));
        coordinates1.add(new Coordinates(6, 3, 0));
        coordinates1.add(new Coordinates(2, 3, 0));
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

        //check if all z values are the same as the average, if it is. nothing happens, if not,
        // one of the z axis has higher/lower value and therefor is 3D
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

                double distanceAB = 0;
                double distanceBC = 0;
                double distanceDC = 0;
                double distanceAD = 0;

                //calc diagonal distance to see if it's a parallelogram : with distance formula d=√((x_2-x_1)²+(y_2-y_1)²)
                double distanceDB = 0;
                double distanceAC = 0;

                if (!isZ_2D) {
                    System.out.println("Z is 3D");
                    //calc distance between points : with distance formula d=√((x_2-x_1)²+(y_2-y_1)²)
                    distanceAB = Math.round(calcDistance(coordinates.get(0).getX(), coordinates.get(0).getY(), coordinates.get(1).getX(), coordinates.get(1).getY()));
                    distanceBC = Math.round(calcDistance(coordinates.get(1).getX(), coordinates.get(1).getY(), coordinates.get(2).getX(), coordinates.get(2).getY()));
                    distanceDC = Math.round(calcDistance(coordinates.get(3).getX(), coordinates.get(3).getY(), coordinates.get(2).getX(), coordinates.get(2).getY()));
                    distanceAD = Math.round(calcDistance(coordinates.get(0).getX(), coordinates.get(0).getY(), coordinates.get(3).getX(), coordinates.get(3).getY()));

                    //calc diagonal distance to see if it's a parallelogram : with distance formula d=√((x_2-x_1)²+(y_2-y_1)²)
                    distanceDB = Math.round(calcDistance(coordinates.get(3).getX(), coordinates.get(3).getY(), coordinates.get(1).getX(), coordinates.get(1).getY()));
                    distanceAC = Math.round(calcDistance(coordinates.get(0).getX(), coordinates.get(0).getY(), coordinates.get(2).getX(), coordinates.get(2).getY()));

                } else if (!isY_2D) {
                    System.out.println("Y is 3D");
                    distanceAB = Math.round(calcDistance(coordinates.get(0).getX(), coordinates.get(0).getZ(), coordinates.get(1).getX(), coordinates.get(1).getZ()));
                    distanceBC = Math.round(calcDistance(coordinates.get(1).getX(), coordinates.get(1).getZ(), coordinates.get(2).getX(), coordinates.get(2).getZ()));
                    distanceDC = Math.round(calcDistance(coordinates.get(3).getX(), coordinates.get(3).getZ(), coordinates.get(2).getX(), coordinates.get(2).getZ()));
                    distanceAD = Math.round(calcDistance(coordinates.get(0).getX(), coordinates.get(0).getZ(), coordinates.get(3).getX(), coordinates.get(3).getZ()));

                    distanceDB = Math.round(calcDistance(coordinates.get(3).getX(), coordinates.get(3).getZ(), coordinates.get(1).getX(), coordinates.get(1).getZ()));
                    distanceAC = Math.round(calcDistance(coordinates.get(0).getX(), coordinates.get(0).getZ(), coordinates.get(2).getX(), coordinates.get(2).getZ()));

                } else {
                    System.out.println("X is 3D");
                    distanceAB = Math.round(calcDistance(coordinates.get(0).getY(), coordinates.get(0).getZ(), coordinates.get(1).getY(), coordinates.get(1).getZ()));
                    distanceBC = Math.round(calcDistance(coordinates.get(1).getY(), coordinates.get(1).getZ(), coordinates.get(2).getY(), coordinates.get(2).getZ()));
                    distanceDC = Math.round(calcDistance(coordinates.get(3).getY(), coordinates.get(3).getZ(), coordinates.get(2).getY(), coordinates.get(2).getZ()));
                    distanceAD = Math.round(calcDistance(coordinates.get(0).getY(), coordinates.get(0).getZ(), coordinates.get(3).getY(), coordinates.get(3).getZ()));

                    distanceDB = Math.round(calcDistance(coordinates.get(3).getY(), coordinates.get(3).getZ(), coordinates.get(1).getY(), coordinates.get(1).getZ()));
                    distanceAC = Math.round(calcDistance(coordinates.get(0).getY(), coordinates.get(0).getZ(), coordinates.get(2).getY(), coordinates.get(2).getZ()));
                }

                System.out.println("Diagonal DB: " + distanceDB);
                System.out.println("Diagonal AC: " + distanceAC);

                System.out.println("Distance");
                System.out.println("AB " + distanceAB);
                System.out.println("BC " + distanceBC);
                System.out.println("DC " + distanceDC);
                System.out.println("AD " + distanceAD);

                //if the distance between all 4 points are equal, it's a square
                if (distanceAB == distanceBC && distanceBC == distanceDC && distanceDC == distanceAD) {
                    System.out.println("Square");
                    return "Square";
                }

                //if the two opposite sides are equal it's a rectangle or parallelogram
                if (distanceAB == distanceDC && distanceAD == distanceBC) {

                    //if the diagonals are equal in measurement then it's a rectangle
                    if (distanceDB == distanceAC) {
                        System.out.println("Rectangle");
                        return "Rectangle";
                    }
                    //if the diagonals are not equal in measurement then it's a parallelogram
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


            double distanceAB = Math.round(calcDistance(coordinates.get(0).getX(), coordinates.get(0).getY(), coordinates.get(1).getX(), coordinates.get(1).getY()));
            double distanceBC = Math.round(calcDistance(coordinates.get(1).getX(), coordinates.get(1).getY(), coordinates.get(2).getX(), coordinates.get(2).getY()));
            double distanceAD = Math.round(calcDistance(coordinates.get(0).getX(), coordinates.get(0).getY(), coordinates.get(3).getX(), coordinates.get(3).getY()));
            double distanceDC = Math.round(calcDistance(coordinates.get(3).getX(), coordinates.get(3).getY(), coordinates.get(2).getX(), coordinates.get(2).getY()));
            double distanceDB = Math.round(calcDistance(coordinates.get(3).getX(), coordinates.get(3).getY(), coordinates.get(1).getX(), coordinates.get(1).getY()));
            double distanceAC = Math.round(calcDistance(coordinates.get(0).getX(), coordinates.get(0).getY(), coordinates.get(2).getX(), coordinates.get(2).getY()));

            if (distanceAB == distanceBC && distanceBC == distanceDC && distanceDC == distanceAD || (distanceAB == distanceDC && distanceAD == distanceBC && distanceDB == distanceAC)) {
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
        return Math.sqrt(Math.pow(2, x2 - x1) + Math.pow(2, y2 - y1));
    }

    public static double calcSlope(double x1, double y1, double x2, double y2) {
        return (y2 - y1) / (x2 - x1);

                    /*
            //calc slope between points : AD and BC then DC and AB
            double slopeAD = Math.round(calcSlope(coordinates.get(0).getX(),coordinates.get(0).getY(), coordinates.get(3).getX(),coordinates.get(3).getY()));
            double slopeBC = Math.round(calcSlope(coordinates.get(1).getX(),coordinates.get(1).getY(), coordinates.get(2).getX(),coordinates.get(2).getY()));
            double slopeDC = Math.round(calcSlope(coordinates.get(3).getX(),coordinates.get(3).getY(), coordinates.get(2).getX(),coordinates.get(2).getY()));
            double slopeAB = Math.round(calcSlope(coordinates.get(0).getX(),coordinates.get(0).getY(), coordinates.get(1).getX(),coordinates.get(1).getY()));
            System.out.println("Slope");
            System.out.println("AB " + slopeAD);
            System.out.println("BC " + slopeBC);
            System.out.println("DC " + slopeDC);
            System.out.println("AD " + slopeAB);
            */
    }
}