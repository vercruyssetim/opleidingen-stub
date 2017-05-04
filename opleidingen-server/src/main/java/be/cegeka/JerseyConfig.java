package be.cegeka;

import be.cegeka.opleidingen.OpleidingenResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        registerClasses(OpleidingenResource.class);
        property(ServerProperties.WADL_FEATURE_DISABLE, true);
    }
}
