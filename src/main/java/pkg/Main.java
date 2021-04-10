package pkg;

import org.apache.logging.log4j.*;


public class Main {

    private static final Logger logger = LogManager.getLogger();
    private static final Marker QUACK = MarkerManager.getMarker("QUACK_QUACK");
    private static final Marker DUCKS = MarkerManager.getMarker("DUCKS");
    private static final Marker LITTLE = MarkerManager.getMarker("LITTLE_DUCKS");

    public static void main(String[] args) {

        String ryhme = """
                Five little ducks went out one day,
                Over the hills and far away.
                Mother duck said, "quack quack quack quack,"
                But only four little ducks came back.     
                Four little ducks went out one day,
                Over the hills and far away.
                Mother duck said, "quack quack quack quack,"
                But only three little ducks came back.
                Three little ducks went out one day,
                Over the hills and far away2.
                Mother duck said, "quack quack quack quack,"
                But only two little ducks came back.
                Two little ducks went out one day,
                Over the hills and far away.
                Mother duck said, "quack quack quack quack,"
                But only one little duck came back.
                One little duck went out one day,
                Over the hills and far away.
                Mother duck said, "quack quack quack quack,"
                But none of the five little ducks came back.
                So sad Mother duck went out one day,
                Over the hills and far away.
                Mother duck said, "quack quack quack quack,"
                And all of the five little ducks came back
                """;

        String[] ryhmes = ryhme.split("\n", 0);

        for (int i=0; i < Integer.parseInt(args[0]); i++){
            ThreadContext.put("iteration",String.valueOf(i));
            if (i == Integer.parseInt(args[0]) - 1){
                logger.info(ryhmes[i]);
            }
            else if (i%2 == 0) {
                logger.debug(DUCKS,ryhmes[i]);
            }
            else if (i%7 == 0){
                logger.fatal(QUACK, ryhmes[i]);
            }
            else {
                logger.warn(LITTLE,ryhmes[i]);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
