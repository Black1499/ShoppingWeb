package com.control;

import com.bo.AddressInfoBo;
import com.dao.AddressInfoDao;
import com.util.JsonUtil;
import com.vo.AddressInfo;
import com.vo.UserInfo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddressInfoServlet")
public class AddressInfoServlet extends BaseServlet {
    private AddressInfoDao addressInfoDao = new AddressInfoDao();
    private AddressInfoBo addressInfoBo = new AddressInfoBo();

    public void findByUser(HttpServletRequest request, HttpServletResponse response) {
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("user");
        if (addressInfoBo.findByUser(userInfo.getUserId())) {
            try {
                response.getWriter().write(JsonUtil.toJson(addressInfoDao.findByUser(userInfo.getUserId())));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addAddress(HttpServletRequest request, HttpServletResponse response) {
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("user");
        String place = request.getParameter("receiveAddr");
        String name = request.getParameter("receiveUser");
        String phone = request.getParameter("receiveTell");
        AddressInfo addressInfo = new AddressInfo(userInfo.getUserId(), place, name, phone);

        try {
            if (addressInfoBo.addAri(addressInfo)) {
                response.getWriter().write("{\"code\":1}");
            } else {
                response.getWriter().write("{\"code\":0}");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
