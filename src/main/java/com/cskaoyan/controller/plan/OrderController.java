package com.cskaoyan.controller;

import com.cskaoyan.bean.C_order;
import com.cskaoyan.service.OrderService;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("order/find{id}")
    public String orderManager(@PathVariable("id") String id) {
        return "/WEB-INF/jsp/order_list.jsp";
    }

    @RequestMapping("order/list")
    @ResponseBody
    public List<C_order> orderList(int page, int rows) {
        List<C_order> orderList = orderService.orderPage(page, rows);
        return orderList;
    }

    @RequestMapping("order/add{id}")
    public String orderAdd(@PathVariable("id") String id) {
        return "/WEB-INF/jsp/order_add.jsp";
    }

    @RequestMapping("order/add_judge")
    public String orderAddItem() { return "/WEB-INF/jsp/order_add.jsp"; }

    @RequestMapping("order/insert")
    @ResponseBody
    public ResponseVo orderInsert(C_order order) {
        int i = orderService.orderAdd(order);
        if (i == 1) {
            return new ResponseVo(200, order, "ok");
        }
        return new ResponseVo(400, null, "bad request");
    }

    @RequestMapping("order/edit{id}")
    public String orderEdit(@PathVariable("id") String id) {
        return "/WEB-INF/jsp/order_edit.jsp";
    }

    @RequestMapping("order/edit_judge")
    public String orderEditItem() { return "/WEB-INF/jsp/order_edit.jsp"; }

    @RequestMapping("order/update_all")
    @ResponseBody
    public ResponseVo orderUpdate(C_order order) {
        int i = orderService.orderUpdate(order);
        if (i == 1) {
            return new ResponseVo(200, order, "ok");
        }
        return new ResponseVo(400, null, "bad request");
    }

    @RequestMapping("order/delete_judge")
    public String orderDeleteItem() { return "/WEB-INF/jsp/order_edit.jsp"; }

    @RequestMapping("order/delete_batch")
    @ResponseBody
    public ResponseVo orderDelete(String ids) {
        int i = orderService.orderDelete(ids);
        if (i == 1) {
            return new ResponseVo(200, null, "ok");
        }
        return new ResponseVo(400, null, "bad request");
    }
}
