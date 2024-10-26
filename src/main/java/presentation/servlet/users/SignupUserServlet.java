package presentation.servlet.users;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignupUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp").forward(request, response);
    }
    
    // POSTメソッドの処理は別途実装
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストのエンコーディングを行う. 
        request.setCharacterEncoding("UTF-8");

        // リクエストに含まれるパラメータの値を得て, コントロールへの入力用のオブジェクトにまとめる. 
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        SignUpForm form = new SignUpForm(name, email, password, confirmPassword);

        // // エラーをまとめて管理するリストを作成する. 
        // List<String> errors = form.validate();

        // // フォーム内容のバリデーションを行う. （確認用パスワードが一致しているかなど、フォームの内容確認をする。）
        // if (errors.isEmpty()) {
        //     try {
        //         SignUpDTO signUpDTO = new SignUpDTO(form.getName(), form.getEmail(), form.getPassword());
        //         SignUpUserService signUpUserService = new SignUpUserService();
        //         SignUpResultDTO result = signUpUserService.execute(signUpDTO);

        //         if (result.isSuccess()) {
        //             request.getSession().setAttribute("user", result.getUserDTO());
        //             request.getRequestDispatcher("/WEB-INF/jsp/signup-success.jsp").forward(request, response);
        //             return;
        //         } else {
        //             errors = result.getErrors();
        //         }
        //     } catch (Failure failure) {
        //         errors.add(failure.getMessage());
        //     }
        // }

        // // エラーがある場合の処理
        // request.setAttribute("form", form);
        // request.setAttribute("errors", errors);
        // request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp").forward(request, response);
    }
}