package com.nikolaymalykhin.marsrover;

import com.nikolaymalykhin.marsrover.exceptions.CoordinatesCreateException;
import com.nikolaymalykhin.marsrover.model.Coordinates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoordinatesTest {
    @Test
    void whenCreateCoordinatesWithoutXThenThrow() {
        Assertions.assertThrows(CoordinatesCreateException.class, () -> Coordinates.builder().y(0).build());
    }

    @Test
    void whenCreateCoordinatesWithoutYThenThrow() {
        Assertions.assertThrows(CoordinatesCreateException.class, () -> Coordinates.builder().x(0).build());
    }

    @Test
    // void whenTwoCoordinatesHaveTheSameXAndYThenTheyAreEqual
    void whenCoordinateXAndYEqualsOtherCoordinateXAndYThenTrue() {
        Coordinates coordinates1 = Coordinates.builder().x(0).y(0).build();
        Coordinates coordinates2 = Coordinates.builder().x(0).y(0).build();
        Assertions.assertEquals(coordinates1, coordinates2);
    }

    @Test
    //в рамках шаринга разных подходов я обычно стараюсь сравнивать объекты 
    void whenIncreaseXThenXPlus1() {
        
        // вот так
        // когда 2 поля у объекта то разницы конечно нет, а вот если их больше, то сравнение всего объекта выглядит более элегентно
        Assertions.assertEquals(
            Coordinates.builder().x(1).y(0).build(),
            Coordinates.builder().x(0).y(0).build().increaseX()
        )
        Coordinates coordinates = Coordinates.builder().x(0).y(0).build();
        coordinates = coordinates.increaseX();
        Assertions.assertEquals(1, coordinates.getX());
        Assertions.assertEquals(0, coordinates.getY());
    }

    @Test
    void whenDecreaseXThenXMinus1() {
        Coordinates coordinates = Coordinates.builder().x(0).y(0).build();
        coordinates = coordinates.decreaseX();
        Assertions.assertEquals(-1, coordinates.getX());
        Assertions.assertEquals(0, coordinates.getY());
    }

    @Test
    void whenIncreaseYThenYPlus1() {
        Coordinates coordinates = Coordinates.builder().x(0).y(0).build();
        coordinates = coordinates.increaseY();
        Assertions.assertEquals(0, coordinates.getX());
        Assertions.assertEquals(1, coordinates.getY());
    }

    @Test
    void whenDecreaseYThenYMinus1() {
        Coordinates coordinates = Coordinates.builder().x(0).y(0).build();
        coordinates = coordinates.decreaseY();
        Assertions.assertEquals(0, coordinates.getX());
        Assertions.assertEquals(-1, coordinates.getY());
    }
}
