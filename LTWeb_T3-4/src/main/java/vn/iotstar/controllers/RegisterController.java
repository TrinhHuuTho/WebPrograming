package vn.iotstar.controllers;

import java.sql.Date;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserService;

@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IUserService service = new UserService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // mã hóa UTF-8
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        
        // Lấy tham sô từ view
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String fullname = req.getParameter("fullname");

        // Kiểm tra
        String alertMsg = "";
        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            alertMsg = "Các trường không được để trống";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            return;
        }

        // Tạo user mới
        UserModel newUser = new UserModel();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setPhone(phone);
        newUser.setFullname(fullname);
        newUser.setRoleid(1);  // Role mặc định là user
        newUser.setCreatedate(new Date(System.currentTimeMillis()));
        
        
        service.insert(newUser);

        //Trả về form đăng nhập khi đăng ký thành công
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
