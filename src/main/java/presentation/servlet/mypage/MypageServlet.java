package presentation.servlet.mypage;

import dataaccess.dao.UserDAO;
import dataaccess.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/mypage")
public class MypageServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // セッションチェック
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        // ログインチェック
        if (user == null) {
            // 未ログインならログインページへ
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // ユーザー情報をリクエストに設定
        request.setAttribute("user", user);
            
        // マイページ表示
        request.getRequestDispatcher("/WEB-INF/views/mypage/index.jsp")
               .forward(request, response);
    }
}