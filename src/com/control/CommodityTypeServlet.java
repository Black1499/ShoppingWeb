package com.control;

import com.bo.CommodityInfoBo;
import com.bo.CommodityTypeBo;
import com.dao.CommodityTypeDao;
import com.util.JsonUtil;
import com.vo.CommodityType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CommodityTypeServlet")
public class CommodityTypeServlet extends BaseServlet {
    private CommodityTypeDao commodityTypeDao = new CommodityTypeDao();
    private CommodityTypeBo commodityTypeBo = new CommodityTypeBo();

    public void getAll(HttpServletRequest request, HttpServletResponse response) {
        if (commodityTypeBo.getAll()) {
            try {
                response.getWriter().write(JsonUtil.toJson(commodityTypeDao.getAll()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addType(HttpServletRequest request, HttpServletResponse response) {
        String typeName = request.getParameter("typeName");
        try {
            if (commodityTypeBo.addCmt(typeName)) {
                response.getWriter().write("{\"msg\":\"Ìí¼Ó³É¹¦\"}");
            } else {
                response.getWriter().write("{\"msg\":\"Ìí¼ÓÊ§°Ü\"}");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updType(HttpServletRequest request, HttpServletResponse response) {
        String typeName = request.getParameter("typeName");
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        try {
            if (commodityTypeBo.updCmt(new CommodityType(typeId, typeName))) {
                response.getWriter().write("{\"msg\":\"ÐÞ¸Ä³É¹¦\"}");
            } else {
                response.getWriter().write("{\"msg\":\"ÐÞ¸ÄÊ§°Ü\"}");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delOne(HttpServletRequest request, HttpServletResponse response) {
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        try {
            if (commodityTypeBo.delOneCmt(typeId)) {
                response.getWriter().write("{\"msg\":\"É¾³ý³É¹¦\"}");
            } else {
                response.getWriter().write("{\"msg\":\"É¾³ýÊ§°Ü\"}");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delPart(HttpServletRequest request, HttpServletResponse response) {
        String[] id = request.getParameterValues("typeId");
        int[] typeId = new int[id.length];
        for (int i = 0; i < id.length; i++) {
            typeId[i] = Integer.parseInt(id[i]);
        }
        try {
            if(commodityTypeBo.delPartCmt(typeId)){
                response.getWriter().write("{\"msg\":\"É¾³ý³É¹¦\"}");
            } else {
                response.getWriter().write("{\"msg\":\"É¾³ýÊ§°Ü\"}");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
