package presentation.servlet.users;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ユーザーのログアウト処理を行うサーブレット
 */
@WebServlet("/logout")
public class LogoutUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * POSTリクエストを処理しログアウトを実行
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // セッションを取得（新規作成はしない）
            HttpSession session = request.getSession(false);
            
            if (session != null) {
                // セッションにユーザー情報が存在するか確認
                if (session.getAttribute("user") != null) {
                    // セッションを無効化
                    session.invalidate();
                    // ホームページにリダイレクト
                    response.sendRedirect(request.getContextPath() + "/home");
                    return;
                }
            }
            
            // セッションが存在しない場合やユーザー情報が存在しない場合
            response.sendRedirect(request.getContextPath() + "/home");
            
        } catch (Exception e) {
            // エラーページへリダイレクト
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

    /**
     * GETリクエストの場合はホームページにリダイレクト
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // GETリクエストは受け付けない
        response.sendRedirect(request.getContextPath() + "/home");
    }
}