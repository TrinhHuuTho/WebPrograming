package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();  // Invalidate the session to log out the user
        
        // Remove cookies (optional)
        if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
        
        // Redirect to login page
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
