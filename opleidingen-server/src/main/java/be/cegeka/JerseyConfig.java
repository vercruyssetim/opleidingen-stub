package be.cegeka;

import be.cegeka.helloWorld.HelloWorldResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        registerClasses(HelloWorldResource.class);
        property(ServerProperties.WADL_FEATURE_DISABLE, true);
    }
}
