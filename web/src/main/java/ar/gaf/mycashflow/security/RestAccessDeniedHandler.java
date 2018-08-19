package ar.gaf.mycashflow.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.gaf.mycashflow.security.utils.SecurityUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;


/**
 * @author Enzo D. Grosso
 *
 */
@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {

    /* (non-Javadoc)
     * @see org.springframework.security.web.access.AccessDeniedHandler#handle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.access.AccessDeniedException)
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        SecurityUtils.sendError(response, accessDeniedException, HttpServletResponse.SC_FORBIDDEN, "Not authorized resources");
    }

}
