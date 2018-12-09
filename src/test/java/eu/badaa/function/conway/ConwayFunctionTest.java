package eu.badaa.function.conway;

import eu.badaa.function.conway.exceptions.ConwayException;
import eu.badaa.function.conway.impl.ConwayFunctionImpl;
import eu.badaa.function.conway.interfaces.ConwayFunction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConwayFunctionTest {

    private ConwayFunction conwayFunction;

    @BeforeEach
    void init() {
        conwayFunction = new ConwayFunctionImpl();
    }

    @Test
    void testForTheLine0ResultShouldBe11() throws ConwayException {
        assertEquals("1", conwayFunction.generate(0, 1).get(0));
    }

    @Test
    void testForTheLine1ResultShouldBe11() throws ConwayException {
        assertEquals("1", conwayFunction.generate(1, 1).get(0));
    }

    @Test
    void testForTheLine2ResultShouldBe21() throws ConwayException {
        assertEquals("11", conwayFunction.generate(2, 2).get(0));
    }

    @Test
    void testForTheLine3ResultShouldBe1211() throws ConwayException {
        assertEquals("21", conwayFunction.generate(3, 3).get(0));
    }

    @Test
    void testForTheLine4ResultShouldBe111221() throws ConwayException {
        assertEquals("1211", conwayFunction.generate(4, 4).get(0));
    }

    @Test
    void testForTheLines1To4() throws ConwayException {
        List<String> conwayLines = conwayFunction.generate(1, 4);
        assertEquals("1", conwayLines.get(0));
        assertEquals("11", conwayLines.get(1));
        assertEquals("21", conwayLines.get(2));
        assertEquals("1211", conwayLines.get(3));
    }

}
