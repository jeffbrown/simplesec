// src/groovy/demo/MyEntryPoint.groovy
package demo

import grails.plugin.springsecurity.web.authentication.AjaxAwareAuthenticationEntryPoint
import org.springframework.security.core.AuthenticationException

import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED

class MyEntryPoint extends AjaxAwareAuthenticationEntryPoint {

    MyEntryPoint(String loginFormUrl) {
        super(loginFormUrl)
    }

    @Override
    public void commence(
            final HttpServletRequest req,
            final HttpServletResponse res, final AuthenticationException e) throws IOException, ServletException {
        super.commence req, res, e

        if(res.status == SC_UNAUTHORIZED && req.xhr) {
            // do it here...
        }
    }
}
