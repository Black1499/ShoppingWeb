package com.control;

import com.bo.ShoppingCartBo;
import com.dao.ShoppingCartDao;
import com.util.JsonUtil;
import com.vo.ShoppingCart;
import com.vo.UserInfo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/ShoppingCartServlet")
public class ShoppingCartServlet extends BaseServlet {
    private ShoppingCartBo shoppingCartBo = new ShoppingCartBo();
    private ShoppingCartDao shoppingCartDao = new ShoppingCartDao();
    private ShoppingCart shoppingCart = null;

    //�ж��û��Ƿ��½
    public boolean judgeLogin(HttpServletRequest request) {
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("user");
        return userInfo != null ? true : false;
    }

    //�����Ʒ�����ﳵ
    public void addCart(HttpServletRequest request, HttpServletResponse response) {
        int cmdId = Integer.parseInt(request.getParameter("id"));
        int cmdPrice = Integer.parseInt(request.getParameter("price"));
        try {
            if (judgeLogin(request)) {
                UserInfo userInfo = (UserInfo) request.getSession().getAttribute("user");
                ShoppingCart shoppingCart = new ShoppingCart(cmdId, userInfo.getUserId(), BigDecimal.valueOf(cmdPrice));
                if (shoppingCartBo.addCart(shoppingCart)) {
                    Long num=shoppingCartDao.count(userInfo.getUserId());
                    response.getWriter().write("{\"code\":1,\"msg\":\"��ӳɹ�\",\"count\":"+num+"}");
                } else {
                    response.getWriter().write("{\"code\":0,\"msg\":\"���ʧ��\"}");
                }
            } else {
                response.getWriter().write("{\"code\":2,\"msg\":\"��δ��¼�����¼!\"}");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findByUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            if (judgeLogin(request)) {
                UserInfo userInfo = (UserInfo) request.getSession().getAttribute("user");
                if (shoppingCartBo.findByUser(userInfo.getUserId(),0)) {
                    response.getWriter().write(JsonUtil.toJson(shoppingCartDao.findByUser(userInfo.getUserId(),0)));
                }
            } else {
                response.getWriter().write("{\"code\":2,\"msg\":\"��δ��¼�����¼!\"}");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delOne(HttpServletRequest request,HttpServletResponse response){
        int cartId= Integer.parseInt(request.getParameter("cartId"));
        try{
            if(shoppingCartBo.delOneCart(cartId)){
                response.getWriter().write("{\"msg\":\"ɾ���ɹ�!\"}");
            }else{
                response.getWriter().write("{\"msg\":\"ɾ��ʧ��!\"}");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void delPart(HttpServletRequest request,HttpServletResponse response){
        String[] cartId=request.getParameterValues("cartId");
        int[] ids=new int[cartId.length];
        for (int i = 0; i <cartId.length ; i++) {
            ids[i]= Integer.parseInt(cartId[i]);
        }
        try{
            if(shoppingCartBo.delPartCart(ids)){
                response.getWriter().write("{\"msg\":\"ɾ���ɹ�!\"}");
            }else{
                response.getWriter().write("{\"msg\":\"ɾ��ʧ��!\"}");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void updCart(HttpServletRequest request,HttpServletResponse response){
        int cartId= Integer.parseInt(request.getParameter("cartId"));
        int num= Integer.parseInt(request.getParameter("num"));
        BigDecimal price=  BigDecimal.valueOf(Long.parseLong(request.getParameter("price")));
        ShoppingCart shoppingCart=new ShoppingCart(cartId,num,price,false);
        if(shoppingCartBo.updCart(shoppingCart)){
            System.out.println("�޸ĳɹ�");
        }
    }



    public void findByOrder(HttpServletRequest request,HttpServletResponse response){
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("user");
        if (shoppingCartBo.findByUser(userInfo.getUserId(),1)) {
            try {
                response.getWriter().write(JsonUtil.toJson(shoppingCartDao.findByUser(userInfo.getUserId(),1)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
