package bl;



import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader implements Reader{

    private  final static Logger logger_log4J = Logger.getLogger(FileReader.class);

    @Override
    public String read() {
        DOMConfigurator.configure("/home/alex/Hardy/Log4j-KuidreS/src/main/resources/log4j.xml");

        String message = "";
        try {
            URI url = ClassLoader.getSystemResource("message.txt").toURI();

            logger_log4J.info(" File URL have been gotten (URL-адрес файла был получен)");
            logger_log4J.debug( url.getPath());

            byte[] fileBute = Files.readAllBytes(Paths.get(url));
            logger_log4J.info(" Bute array from file have been gotten (Массив байтов из файла получен)");
            logger_log4J.debug( fileBute.toString());

            message = new String(fileBute);
            logger_log4J.info(" Message from file have been gotten (Cообщение из файла было получено)");
            logger_log4J.debug( message);

        }catch ( URISyntaxException | NullPointerException | IOException  exception ) {
            logger_log4J.error(exception.getMessage() , exception);
        }

        return message;
    }

    private String getToString(URI url) {
        return url.toString();
    }
}
