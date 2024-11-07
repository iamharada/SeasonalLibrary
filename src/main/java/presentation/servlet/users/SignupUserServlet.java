package presentation.servlet.users;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import presentation.form.users.SignupUserForm;
import business.service.users.SignupUser;
import business.dto.users.SignupUserResultDTO;
import business.exception.*;

@WebServlet("/signup")
public class SignupUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/auth/signup.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストのエンコーディングを行う. 
        request.setCharacterEncoding("UTF-8");

        // リクエストに含まれるパラメータの値を得て, サービスへの入力用のオブジェクトにまとめる. 
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        SignupUserForm form = new SignupUserForm(name, email, password, confirmPassword);

        // ビジネスロジック層の窓口であるサービスをインスタンス化する.
        SignupUser signupUser = new SignupUser();

        try{
            // サービスに入力用オブジェクトを渡して処理を実行し、その結果を得る
            SignupUserResultDTO result = signupUser.execute(form);

            // 結果をリクエストスコープに保存する
            request.setAttribute("user", result.getUser());

            // 結果を表示するためのJSPにフォワードする
            request.getRequestDispatcher("/WEB-INF/views/auth/signup-success.jsp").forward(request, response);
        }catch(Failure failure){
            // エラーが発生した場合は、エラーメッセージをリクエストスコープに保存して、入力フォームを再表示する
            request.setAttribute("error", failure.getMessage());
            request.setAttribute("form", form);
            request.getRequestDispatcher("/WEB-INF/views/auth/signup.jsp").forward(request, response);
        }
    }
}