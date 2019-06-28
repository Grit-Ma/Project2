package com.cskaoyan.controller.plan;

import com.cskaoyan.bean.Order;
import com.cskaoyan.service.OrderService;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
    public List<Order> orderList(int page, int rows) {
        List<Order> orderList = orderService.orderPage(page, rows);
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
    public ResponseVo orderInsert(Order order) {
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
    public ResponseVo orderUpdate(Order order) {
        int i = orderService.orderUpdate(order);
        if (i == 1) {
            return new ResponseVo(200, order, "ok");
        }
        return new ResponseVo(400, null, "bad request");
    }

    @RequestMapping("order/delete_judge")
    public String orderDeleteItem() { return "/WEB-INF/jsp/order_edit.jsp"; }

    @RequestMapping("order/search_order_by_orderId")
    @ResponseBody
    public List<Order> searchByOrderId(String searchValue, int page, int rows) {
        List<Order> orderList = orderService.searchByOrderId(searchValue, page, rows);
        return orderList;
    }

    @RequestMapping("order/search_order_by_orderCustom")
    @ResponseBody
    public List<Order> searchByOrderCustom(String searchValue, int page, int rows) {
        return null;
    }

    @RequestMapping("order/search_order_by_orderProduct")
    @ResponseBody
    public List<Order> searchByOrderProduct(String searchValue, int page, int rows) {
        return null;
    }

    @RequestMapping("order/delete_batch")
    @ResponseBody
    public ResponseVo orderDelete(String[] ids) {
        List<String> list = new ArrayList<>();
        for (String id : ids) {
            list.add(id);
        }
        int i = orderService.orderDelete(list);
        if (i == 1) {
            return new ResponseVo(200, null, "ok");
        }
        return new ResponseVo(400, null, "bad request");
    }

    @RequestMapping("order/get_data")
    @ResponseBody
    public List<Order> orderGetData() {
        List<Order> orderList = orderService.orderGetData();
        return orderList;
    }
}
