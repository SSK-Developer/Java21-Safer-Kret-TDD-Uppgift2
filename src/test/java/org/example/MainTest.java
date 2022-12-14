package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    ArrayList<Coordinates> coordinates;

    @BeforeEach
    void setUp() {

        coordinates = new ArrayList<>();

    }

    @Test
    void Zero_Points_Should_Return_None(){

        String actual = Main.getShape(coordinates);

        assertEquals("None", actual);
    }

    @Test
    void One_Point_Should_Return_Dot(){

        coordinates.add(new Coordinates(0, 0, 0));
        String actual = Main.getShape(coordinates);

        assertEquals("Dot", actual);
    }

    @Test
    void Two_Points_Should_Return_Line(){

        coordinates.add(new Coordinates(0, 0, 0));
        coordinates.add(new Coordinates(1, 1, 0));
        String actual = Main.getShape(coordinates);

        assertEquals("Line", actual);
    }

    @Test
    void Three_Points_Should_Return_Triangle(){

        coordinates.add(new Coordinates(0, 0, 0));
        coordinates.add(new Coordinates(1, 1, 0));
        coordinates.add(new Coordinates(2, 0, 0));
        String actual = Main.getShape(coordinates);

        assertEquals("Triangle", actual);
    }

    @Test
    void Four_XYPoints_Shaping_A_Square_Should_Return_Square(){

        coordinates.add(new Coordinates(-1, -1, 0));
        coordinates.add(new Coordinates(-1, -5, 0));
        coordinates.add(new Coordinates(-5, -5, 0));
        coordinates.add(new Coordinates(-5, -1, 0));
        String actual = Main.getShape(coordinates);

        assertEquals("Square", actual);
    }

    @Test
    void Four_XZPoints_Shaping_A_Square_Should_Return_Square(){

        coordinates.add(new Coordinates(-1, 0, -1));
        coordinates.add(new Coordinates(-1, 0, -5));
        coordinates.add(new Coordinates(-5, 0, -5));
        coordinates.add(new Coordinates(-5, 0, -1));
        String actual = Main.getShape(coordinates);

        assertEquals("Square", actual);
    }

    @Test
    void Four_YZPoints_Shaping_A_Square_Should_Return_Square(){

        coordinates.add(new Coordinates(0, -1, -1));
        coordinates.add(new Coordinates(0, -1, -5));
        coordinates.add(new Coordinates(0, -5, -5));
        coordinates.add(new Coordinates(0, -5, -1));
        String actual = Main.getShape(coordinates);

        assertEquals("Square", actual);
    }

    @Test
    void Four_Unordered_XYPoints_Shaping_A_Square_Should_Return_Square(){
        coordinates.add(new Coordinates(-5, -5, 0));
        coordinates.add(new Coordinates(-5, -1, 0));
        coordinates.add(new Coordinates(-1, -1, 0));
        coordinates.add(new Coordinates(-1, -5, 0));

        String actual = Main.getShape(coordinates);

        assertEquals("Square", actual);
    }

    @Test
    void Four_Points_Shaping_A_Rectangle_Should_Return_Rectangle(){

        coordinates.add(new Coordinates(5, 1, 0));
        coordinates.add(new Coordinates(5, 3, 0));
        coordinates.add(new Coordinates(1, 3, 0));
        coordinates.add(new Coordinates(1, 1, 0));
        String actual = Main.getShape(coordinates);

        assertEquals("Rectangle", actual);
    }

    @Test
    void Four_Unordered_Points_Shaping_A_Rectangle_Should_Return_Rectangle(){

        coordinates.add(new Coordinates(1, 3, 0));
        coordinates.add(new Coordinates(1, 1, 0));
        coordinates.add(new Coordinates(5, 1, 0));
        coordinates.add(new Coordinates(5, 3, 0));

        String actual = Main.getShape(coordinates);

        assertEquals("Rectangle", actual);
    }

    @Test
    void Four_Points_Shaping_A_Parallelogram_Should_Return_Parallelogram(){

        coordinates.add(new Coordinates(9, 0, 0));
        coordinates.add(new Coordinates(0, 0, 0));
        coordinates.add(new Coordinates(7, 5, 0));
        coordinates.add(new Coordinates(16, 5, 0));
        String actual = Main.getShape(coordinates);

        assertEquals("Parallelogram", actual);
    }

    @Test
    void Four_Unordered_Points_Shaping_A_Parallelogram_Should_Return_Parallelogram(){

        coordinates.add(new Coordinates(7, 5, 0));
        coordinates.add(new Coordinates(16, 5, 0));
        coordinates.add(new Coordinates(9, 0, 0));
        coordinates.add(new Coordinates(0, 0, 0));

        String actual = Main.getShape(coordinates);

        assertEquals("Parallelogram", actual);
    }

    @Test
    void A_2D_shape_With_No_Recognizable_Shape_Should_Return_2D(){

        coordinates.add(new Coordinates(-3, -5, 0));
        coordinates.add(new Coordinates(-5, -1, 0));
        coordinates.add(new Coordinates(-1, -1, 0));
        coordinates.add(new Coordinates(-1, -5, 0));

        String actual = Main.getShape(coordinates);

        assertEquals("2D shape", actual);

    }

    @Test
    void Five_Points_Shaping_A_Pyramid_Should_Return_Pyramid(){

        coordinates.add(new Coordinates(-1, -1, 0));
        coordinates.add(new Coordinates(-1, 1, 0));
        coordinates.add(new Coordinates(1, 1, 0));
        coordinates.add(new Coordinates(1, -1, 0));
        coordinates.add(new Coordinates(0, 0, 1));
        String actual = Main.getShape(coordinates);

        assertEquals("Pyramid", actual);
    }

    @Test
    void Five_Unordered_Points_Shaping_A_Pyramid_Should_NOT_return_Pyramid(){

        coordinates.add(new Coordinates(0, 0, 1));
        coordinates.add(new Coordinates(-1, 1, 0));
        coordinates.add(new Coordinates(-1, -1, 0));
        coordinates.add(new Coordinates(1, 1, 0));
        coordinates.add(new Coordinates(1, -1, 0));

        String actual = Main.getShape(coordinates);

        assertNotEquals("Pyramid", actual);
    }

    @Test
    void A_3D_shape_With_No_Recognizable_Shape_Should_Return_3D(){

        coordinates.add(new Coordinates(-1, -1, 0));
        coordinates.add(new Coordinates(-1, -1, 0));
        coordinates.add(new Coordinates(-1, 1, 0));
        coordinates.add(new Coordinates(1, 1, 0));
        coordinates.add(new Coordinates(1, -1, 0));
        coordinates.add(new Coordinates(0, 0, 1));
        String actual = Main.getShape(coordinates);

        assertEquals("3D shape", actual);
    }
}