package servlet;

import com.bc.mybatis.pojo.Emp;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "HelloServlet", value = "/HelloServlet")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Emp emp = new Emp(1001, "aaa", "bbb", 123, new Date(), 50f, 50f, 100);
        Emp emp2 = new Emp(1002, "aaa", "bbb", 123, new Date(), 50f, 50f, 100);
        List<Emp> empList=new ArrayList<>();
        empList.add(emp);
        empList.add(emp2);
        response.getWriter().write(new Gson().toJson(empList));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
