package eu.badaa.function.conway;

import eu.badaa.function.conway.exceptions.ConwayException;
import eu.badaa.function.conway.impl.ConwayFunctionImpl;
import eu.badaa.function.conway.interfaces.ConwayFunction;
import org.apache.log4j.Logger;

import java.util.List;

public class Main {

    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        ConwayFunction conwayFunction = new ConwayFunctionImpl();
        List<String> result;
        try {
            result = conwayFunction.generate(0, 40);
            for (int i = 0; i < result.size(); i++) {
                logger.info(String.format("Line Number %d  : %s",(i+1)  , result.get(i)));
            }
        } catch (ConwayException e) {
            logger.info("An error has append : "+e.getMessage());
        }
    }

}
