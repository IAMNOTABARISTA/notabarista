package com.notabarista.authentication;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    // overriding the method handler to customise the redirect in relation to the roles

    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
   throws IOException {
        //calling the redirect method bellow
        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()){
            return;
        }
        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        redirectStrategy.sendRedirect(request,response,targetUrl);
    }
    protected String determineTargetUrl( Authentication authentication){
        String url= "/login?errror=true";
        // fetching the roles from the authentication object
        Collection<?extends GrantedAuthority> authorities= authentication.getAuthorities();
        List<String> roles= new ArrayList<String>();
        for (GrantedAuthority a : authorities)
        {
            roles.add(a.getAuthority());
        }
        // cheking user role and decide the redirect url
        if (roles.contains("ADMIN_USER")){
            url="/admin";
        }
        else if (roles.contains("SITE_USER")){
            url ="/home";
        }
        return url;
  }
    }

