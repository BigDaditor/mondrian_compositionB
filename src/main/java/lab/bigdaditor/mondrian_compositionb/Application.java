package lab.bigdaditor.mondrian_compositionb;

import lab.bigdaditor.mondrian_compositionb.handler.HdfsHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception{
        HdfsHandler hdfsHandler = new HdfsHandler();
        /*hdfsHandler.createDirectory();*/
        SpringApplication.run(Application.class, args);
    }

}
