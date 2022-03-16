package hello.springmvc.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // WEB-INF 밑에 있으면 디스패쳐를 통해서만 불러짐
        // 그냥 127.0.0.1/WEB-INF/views/new-form.jsp 하면 안불러짐
        // 항상 이 /servlet-mvc/members/new-form을 통해서 들어가야함
        String viewPath = "/WEB-INF/views/new-form.jsp";
        // 리다이렉트 : 실제 클ㄹ아ㅣ언트에 응답이 나갔다가 클라이언트가 리다이렉트 경로로 다시 요청 클라이언트가 인지할 수 있고 URL도 실제로 변경됨
        // 포워드 : 서버 내부에서 일어나는 호출이기 때문에 클라이언트가 인식하지 못함
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
