package eu.badaa.function.conway.impl;

import eu.badaa.function.conway.exceptions.ConwayException;
import eu.badaa.function.conway.interfaces.ConwayFunction;

import java.util.ArrayList;
import java.util.List;

public class ConwayFunctionImpl implements ConwayFunction {


    public static final int MAX_LINE_CALCULABLE = 40;

    @Override
    public List<String> generate(int minNumberLine, int maxNumberLine) throws ConwayException {
        String currentConwayLine = "1";
        List<String> result = new ArrayList<>();
        checkMinAndMax(minNumberLine, maxNumberLine);
        for (int i = 1; i <= maxNumberLine; i++) {
            if (i >= minNumberLine && i <= maxNumberLine) {
                result.add(currentConwayLine);
            }
            currentConwayLine = getConwayStringFrom(currentConwayLine);
        }
        return result;
    }

    private void checkMinAndMax(int minNumberLine, int maxNumberLine) throws ConwayException {
        if (minNumberLine < 0) {
            throw new ConwayException("the minimum line should be 0 at least");
        }
        //Should limit the maximum line because of the limited size of the memory
        if (maxNumberLine > MAX_LINE_CALCULABLE) {
            throw new ConwayException("the maximum line should be "+MAX_LINE_CALCULABLE+" at most");
        }
    }

    private String getConwayStringFrom(String previousConwayLine) throws ConwayException {
        StringBuffer sb = new StringBuffer();
        char lastNumberRead;
        int indexInString = 0;
        //read the whole line
        while (indexInString < previousConwayLine.length()) {
            char actualNumberRead = previousConwayLine.charAt(indexInString);
            lastNumberRead = previousConwayLine.charAt(indexInString);
            int countSameNumberRead = 0;
            //read while the number is the same
            while (actualNumberRead == lastNumberRead && indexInString < previousConwayLine.length()) {
                lastNumberRead = previousConwayLine.charAt(indexInString);
                countSameNumberRead++;
                indexInString++;
                //read the next number
                if (indexInString < previousConwayLine.length()) {
                    actualNumberRead = previousConwayLine.charAt(indexInString);
                }
            }
            try {
                sb.append(countSameNumberRead);
                sb.append(lastNumberRead);
            } catch (Exception e) {
                throw new ConwayException("The maximum line you mentioned is too big");
            }
        }
        return sb.toString();
    }
}
