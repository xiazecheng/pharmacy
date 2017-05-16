package com.yaojie.shiro.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by madao on 2017/5/15.
 */
public class MyURLPermissionFilter extends PermissionsAuthorizationFilter {
    private Logger log = LoggerFactory.getLogger(MyURLPermissionFilter.class);

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletRequest req = WebUtils.toHttp(request);
        HttpServletResponse res = WebUtils.toHttp(response);
        String path = WebUtils.getRequestUri(req);
        if (path.startsWith("/my/")) {
            res.sendError(401);
            return false;
        } else {
            PrintWriter out = response.getWriter();
            out.println("{\"error_info\":\"permission denied.\"}");
            out.flush();
            out.close();
            return false;
        }
    }

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        Subject subject = this.getSubject(request, response);
        HttpServletRequest req = WebUtils.toHttp(request);
        String path = WebUtils.getRequestUri(req);
        String method = req.getMethod();
        String permission = path + ":" + method;
        if (!subject.isPermitted(permission)) { //与上文MyRealm的getAuthorizationInfo方法返回的AuthorizationInfo中的权限集合匹配
            return false;
        }
        return true;
    }
}
