package ua.training.controller.filter;

import ua.training.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterAuthorization implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        isRoleEmpty(session);
        HashMap<Pattern, Set<User.Role>> pathAccess = getAuthorizationMap();
        String path = req.getRequestURI();
        Pattern pattern = isCorrectPath(pathAccess, path);
        if (pattern == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, path);
            return;
        }
        if (!redirect(req, pattern)) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        chain.doFilter(request, response);
    }

    private HashMap<Pattern, Set<User.Role>> getAuthorizationMap() {

        return Authorization.getInstances().getAuthorization();
    }

    private void isRoleEmpty(HttpSession session) {
        if (session.getAttribute("role") == null) {
            session.setAttribute("role", User.Role.GUEST);
        }
    }

    private boolean redirect(HttpServletRequest req, Pattern pattern) {
        HttpSession session = req.getSession();
        HashMap<Pattern, Set<User.Role>> pathAccess = getAuthorizationMap();
        Set<User.Role> role = pathAccess.get(pattern);
        if (role == null) return false;
        User.Role current = (User.Role) session.getAttribute("role");
        return role.contains(current);
    }

    private Pattern isCorrectPath(HashMap<Pattern, Set<User.Role>> pathAccess, String path) {
        Matcher matcher;
        for (Pattern pattern : pathAccess.keySet()) {
            matcher = pattern.matcher(path);
            if (matcher.matches()) {
                return pattern;
            }
        }
        return null;
    }

    @Override
    public void destroy() {

    }
}
