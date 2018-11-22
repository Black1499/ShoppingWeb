package com.control;

import com.bo.UserBo;
import com.dao.UserDao;
import com.vo.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet{
    private UserBo userBo = new UserBo();
    private UserDao userDao = new UserDao();
    private UserInfo userInfo = null;

    public void addUser(HttpServletRequest request, HttpServletResponse response) {
        String account = request.getParameter("account");
        String passwrod = request.getParameter("password");
        String phone = request.getParameter("tel");
        String email = request.getParameter("email");
        userInfo = new UserInfo(account, passwrod, phone, email);
        try {
            if (userBo.addUser(userInfo)) {
                request.getSession().setAttribute("user", userInfo);
                response.getWriter().write("{\"code\":1,\"msg\":\"ע��ɹ�,���Զ���½\"}");
            } else {
                response.getWriter().write("{\"code\":0,\"msg\":\"ע��ʧ��\"}");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        try {
            if (userBo.judgeLogin(account, password)) {
                userInfo = userDao.judgeLogin(account, password);
                request.getSession().setAttribute("user", userInfo);
                response.getWriter().write("{\"code\":1,\"msg\":\"��¼�ɹ�\"}");
            } else {
                response.getWriter().write("{\"code\":0,\"msg\":\"��¼ʧ��\"}");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
