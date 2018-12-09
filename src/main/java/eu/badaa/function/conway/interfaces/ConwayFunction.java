package eu.badaa.function.conway.interfaces;

import eu.badaa.function.conway.exceptions.ConwayException;

import java.util.List;

public interface ConwayFunction {

    /**
     * Generate lines between from the Conway Function for the lines between 2 linesNumber
     * @param minNumberLine
     * @param maxNumberLine
     * @return
     * @throws ConwayException
     */
    List<String> generate(int minNumberLine, int maxNumberLine) throws ConwayException;

}
