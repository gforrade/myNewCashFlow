package ar.gaf.mycashflow.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.gaf.mycashflow.security.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


/**
 * @author Enzo D. Grosso
 *
 */
@Component
public class SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private AuthenticationUserDetailsService<Authentication> userDetailsService;

    /* (non-Javadoc)
     * @see org.springframework.security.web.authentication.AuthenticationSuccessHandler#onAuthenticationSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication auth) throws IOException, ServletException {
        SecurityUtils.sendResponse(response, HttpServletResponse.SC_OK,
                userDetailsService.loadUserDetails(auth));
    }
}

