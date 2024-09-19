package edu.dgtic.lsp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LiskovTest {
    Rectangle rectangle = null;
    Square square = null;

    @Test
    void testRectangle() {
        rectangle = new Rectangle(10, 20);
        System.out.println(rectangle.computeArea());
        useRectangle(rectangle);
    }

    @Test
    void testSquare() {
        square = new Square(10);
        System.out.println(square.computeArea());
        useRectangle(square);
    }

    private static void useRectangle(Rectangle rectangle) {
        rectangle.setHeight(20);
        rectangle.setWidth(30);
        assertEquals(rectangle.getHeight(), 20, "Height Not equal to 20");
        assertEquals(rectangle.getWidth(), 30, "Width Not equal to 30");
    }
}
