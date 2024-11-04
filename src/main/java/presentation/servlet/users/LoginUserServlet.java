package presentation.servlet.users;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ログイン処理を行うサーブレット
 */
@WebServlet("/login")
public class LoginUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ログインページにフォワード
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // リクエストパラメータの取得
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // try {
        //     // フォームオブジェクトの作成
        //     LoginForm form = new LoginForm(email, password);
            
        //     // ログインサービスの実行
        //     LoginService loginService = new LoginService();
        //     LoginResultDTO result = loginService.execute(form);

        //     // セッションの取得（なければ作成）
        //     HttpSession session = request.getSession();
            
        //     // ログイン成功時の処理
        //     session.setAttribute("user", result.getUser());
            
        //     // ホームページへリダイレクト
        //     response.sendRedirect(request.getContextPath() + "/");

        // } catch (Failure failure) {
        //     // ログイン失敗時の処理
        //     request.setAttribute("error", failure.getMessage());
        //     request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        // }
    }
}