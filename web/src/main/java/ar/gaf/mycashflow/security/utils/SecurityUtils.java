package ar.gaf.mycashflow.security.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import ar.gaf.mycashflow.utils.JSONUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * @author Enzo D. Grosso
 *
 */
public final class SecurityUtils {

    /**
     * Get the login of the current user.
     */
    public static String getCurrentLogin() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        UserDetails springSecurityUser = null;
        String userName = null;

        if (authentication != null) {
            if (authentication.getPrincipal() instanceof UserDetails) {
                springSecurityUser = (UserDetails) authentication.getPrincipal();
                userName = springSecurityUser.getUsername();
            } else if (authentication.getPrincipal() instanceof String) {
                userName = (String) authentication.getPrincipal();
            }
        }

        return userName;
    }


    public static void sendError(HttpServletResponse response, Exception exception, int status, String message) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(status);
        PrintWriter writer = response.getWriter();
        Error error = new Error("authError", exception.getMessage());
        writer.write(JSONUtils.getMapper().writeValueAsString(new Response(status, message, error)));
        writer.flush();
        writer.close();
    }


    public static void sendResponse(HttpServletResponse response, int status, Object object) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(JSONUtils.getMapper().writeValueAsString(object));
        response.setStatus(status);
        writer.flush();
        writer.close();
    }

}