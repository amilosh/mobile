package by.it.milosh.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * The servlet container is going to pick up the 404 before it can get to Spring,
 * so you'll need to define an error page at servlet container level,
 * which forwards to your custom controller.
 */
@Component
public class CustomizationBean implements EmbeddedServletContainerCustomizer {

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"),
                                new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"));
    }
}
