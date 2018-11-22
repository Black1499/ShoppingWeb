package com.control;

import com.bo.OrderInfoBo;
import com.bo.ShoppingCartBo;
import com.dao.OrderInfoDao;
import com.util.JsonUtil;
import com.vo.OrderInfo;
import com.vo.UserInfo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/OrderInfoServlet")
public class OrderInfoServlet extends BaseServlet {
    private OrderInfoDao orderInfoDao = new OrderInfoDao();
    private OrderInfoBo orderInfoBo = new OrderInfoBo();
    private ShoppingCartBo shoppingCarBo = new ShoppingCartBo();

    public void findByUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            UserInfo userInfo = (UserInfo) request.getSession().getAttribute("user");
            if (orderInfoBo.findByUser(userInfo.getUserId(), 0)) {
                response.getWriter().write(JsonUtil.toJson(orderInfoDao.findByUser(userInfo.getUserId(), 0)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addOrder(HttpServletRequest request, HttpServletResponse response) {
        String[] cartId = request.getParameterValues("cartId");
        OrderInfo orderInfo = null;
        int count = 0;
        for (int i = 0; i < cartId.length; i++) {
            int id = Integer.parseInt(cartId[i]);
            if (orderInfoBo.addOrder(id) && shoppingCarBo.updState(id, true)) {
                count++;
            }
        }
        try {
            if (count == cartId.length) {
                response.getWriter().write("{\"code\":1}");
            } else {
                response.getWriter().write("{\"code\":0}");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void updOrder(HttpServletRequest request, HttpServletResponse response) {
        String[] cartId = request.getParameterValues("cartId");
        int adiId = Integer.parseInt(request.getParameter("adiId"));
        int count = 0;
        for (int i = 0; i < cartId.length; i++) {
            int id = Integer.parseInt(cartId[i]);
            if (orderInfoBo.updOrder(id, adiId)) {
                count++;
            }
        }

        try {
            if (count == cartId.length) {
                response.getWriter().write("{\"code\":1}");
            } else {
                response.getWriter().write("{\"code\":0}");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
