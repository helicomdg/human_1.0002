import configuration.JPAConfiguration;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.HashMap;
import java.util.Map;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {

    //Voorbeeld van meneer. Alles zetten in een package met sr.unasat.
     //parameter van een string(parent path) -->//Localhost:8080/api
        @Override
        public Map<String, Object> getProperties(){
            Map<String, Object> properties = new HashMap<>();
            properties.put("jersey.config.server.provider.packages","controller");
            JPAConfiguration.getEntityManager();
            return properties;
        }
}
