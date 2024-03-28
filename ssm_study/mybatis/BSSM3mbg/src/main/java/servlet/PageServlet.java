package servlet;

import com.bc.mybatis.pojo.Emp;
import com.bc.mybatis.test.MBGTest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "PageServlet", value = "/PageServlet")
public class PageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MBGTest mbgTest=new MBGTest();
       PageInfo<Emp> emppage=mbgTest.testPage();
       HttpSession session= request.getSession();
       session.setAttribute("emppage", emppage);
       response.sendRedirect(request.getContextPath()+"/aaaaaaaaaaaa.jsp");

        response.setContentType("text/html;charset=utf-8");

        response.setContentType("pagejson/json");//返回的文件（名字是我起的）
        Gson gson=new Gson();
        String json=gson.toJson(emppage);
        System.out.println(json);

        PrintWriter writer= response.getWriter();
        writer.println(json);
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doGet(request, response);
    }
}
