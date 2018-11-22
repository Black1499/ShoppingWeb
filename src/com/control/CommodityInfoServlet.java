package com.control;

import com.bo.CommodityInfoBo;
import com.dao.CommodityInfoDao;
import com.dao.CommodityTypeDao;
import com.util.JsonUtil;
import com.vo.CommodityInfo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/CommodityInfoServlet")
public class CommodityInfoServlet extends BaseServlet {
    private CommodityInfoDao commodityInfoDao = new CommodityInfoDao();
    private CommodityInfoBo commodityInfoBo = new CommodityInfoBo();

    public void getAll(HttpServletRequest request, HttpServletResponse response) {
        if (commodityInfoBo.getAll()) {
            try {
                response.getWriter().write(JsonUtil.toJson(commodityInfoDao.getAll()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void findByType(HttpServletRequest request, HttpServletResponse response) {
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        if (commodityInfoBo.findById(typeId)) {
            try {
                response.getWriter().write(JsonUtil.toJson(commodityInfoDao.findByType(typeId)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void findByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        if (commodityInfoBo.findByName(name)) {
            try {
                response.getWriter().write(JsonUtil.toJson(commodityInfoDao.findByName(name)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addCmd(HttpServletRequest request, HttpServletResponse response) {
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        String cmdPicture = request.getParameter("cmdPicture");
        String cmdName = request.getParameter("cmdName");
        BigDecimal cmdPrice = BigDecimal.valueOf(Integer.parseInt(request.getParameter("cmdPrice")));
        String cmdDescribe = request.getParameter("cmdDescribe");
        boolean state = Boolean.parseBoolean(request.getParameter("cmdState"));
        CommodityInfo cmd = new CommodityInfo(typeId, cmdPicture, cmdName, cmdPrice, cmdDescribe, state);
        try {
            if (commodityInfoBo.addCdi(cmd)) {
                response.getWriter().write("{\"msg\":\"Ìí¼Ó³É¹¦\"}");
            } else {
                response.getWriter().write("{\"msg\":\"Ìí¼ÓÊ§°Ü\"}");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updCmd(HttpServletRequest request, HttpServletResponse response) {
        int cmdId= Integer.parseInt(request.getParameter("cmdId"));
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        String cmdPicture = request.getParameter("cmdPicture");
        String cmdName = request.getParameter("cmdName");
        BigDecimal cmdPrice = BigDecimal.valueOf(Integer.parseInt(request.getParameter("cmdPrice")));
        String cmdDescribe = request.getParameter("cmdDescribe");
        boolean state = Boolean.parseBoolean(request.getParameter("cmdState"));
        CommodityInfo cmd = new CommodityInfo(cmdId,typeId, cmdPicture, cmdName, cmdPrice, cmdDescribe, state);
        try {
            if (commodityInfoBo.updCdi(cmd)) {
                response.getWriter().write("{\"msg\":\"ÐÞ¸Ä³É¹¦\"}");
            } else {
                response.getWriter().write("{\"msg\":\"ÐÞ¸ÄÊ§°Ü\"}");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delOne(HttpServletRequest request, HttpServletResponse response) {
        int cmdId= Integer.parseInt(request.getParameter("cmdId"));
        try {
            if(commodityInfoBo.delOneCdi(cmdId)){
                response.getWriter().write("{\"msg\":\"É¾³ý³É¹¦\"}");
            } else {
                response.getWriter().write("{\"msg\":\"É¾³ýÊ§°Ü\"}");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delPart(HttpServletRequest request, HttpServletResponse response) {
        String[] cmdId=request.getParameterValues("cmdId");
        int[] id=new int[cmdId.length];
        for (int i = 0; i <cmdId.length ; i++) {
            id[i]=Integer.parseInt(cmdId[i]);
        }
        try {
            if(commodityInfoBo.delPartCdi(id)){
                response.getWriter().write("{\"msg\":\"É¾³ý³É¹¦\"}");
            } else {
                response.getWriter().write("{\"msg\":\"É¾³ýÊ§°Ü\"}");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
