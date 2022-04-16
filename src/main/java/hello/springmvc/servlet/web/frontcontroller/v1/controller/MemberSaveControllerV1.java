package hello.springmvc.servlet.web.frontcontroller.v1.controller;

import hello.springmvc.servlet.domain.member.Member;
import hello.springmvc.servlet.domain.member.MemberRepository;
import hello.springmvc.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV1 implements ControllerV1 {

    private MemberRepository memberRepository = MemberRepository.getInstance();


    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        // Model에 데이터를 보관한다
        request.setAttribute("member", member);

        // 이부분에 중복이 많음..
        // ViewPath에도 /WEB-INF/view가 중복되고 jsp도 항상 입력해 주어야 함
        String viewPath = "/WEB-INF/views/save-result.jsp";
        // view로 갈때마다 이 두줄은 공통 부분인데 호출해주어야 함
        // 이걸 메소드로 분리한다고 해도  view로 갈때마다 그 메소드를 호출해주어야 함
        // 공통 로직을 먼저 처리해주는 프론트 컨트롤러 도입!
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);

    }
}
