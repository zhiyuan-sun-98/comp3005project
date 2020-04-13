package com.itheima.action;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.commom.AddShopItem;
import com.itheima.commom.OItem;
import com.itheima.commom.OrderBook;
import com.itheima.commom.OrdersResult;
import com.itheima.commom.SearchOrderResult;
import com.itheima.commom.ShopItem;
import com.itheima.commom.UserResult;
import com.itheima.domain.OrderItem;
import com.itheima.domain.User;
import com.itheima.service.OrderService;
import com.itheima.utils.FastJsonUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OrderAction extends ActionSupport implements ModelDriven<OrderItem>{

	private static final long serialVersionUID = -590082120739640792L;

	private OrderItem order = new OrderItem();
	public OrderItem getModel() {
		return order;
	}
	
	
	private int id;
	private int count;
	

	private OrderService orderService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}



	public String addShop(){

		    HashMap<Integer, Integer> map = new HashMap<>();
		    map.put(Integer.parseInt(order.getBookId()), count);
		    int code = orderService.addShop(id,map);
		    UserResult r = new UserResult();
			r.setCode(code);
			String jsonString = FastJsonUtil.toJSONString(r);
			System.out.println(jsonString);
			HttpServletResponse response = ServletActionContext.getResponse();
			FastJsonUtil.write_json(response,jsonString);	
		    return NONE;		 
		
	} 
	
	public String orderNumber(){
		    OrderItem order = orderService.orderDetailById(id);
            SearchOrderResult s = new SearchOrderResult();
		    s.setCode(1);
		 
            s.setLocation(order.getLocation());	
            s.setOrderDate(order.getOrderDate());
		    String jsonString = FastJsonUtil.toJSONString(s);
			System.out.println(jsonString);
			HttpServletResponse response = ServletActionContext.getResponse();
			FastJsonUtil.write_json(response,jsonString);	
		   
			return NONE;
		
	} 
	
	public String order(){
		    List<OrderItem> orderList = orderService.allOrder();
		   
		    LinkedList<OItem> list = new LinkedList<>();
            for(OrderItem s : orderList){
            	OItem oItem = new OItem();
            	oItem.setOrderNumber(s.getOrderId());
            	oItem.setOrderDate(s.getOrderDate());
            	oItem.setPrice(s.getPrice());    
            	list.add(oItem);
		    }
		    OrdersResult ordersResult = new OrdersResult();
		    ordersResult.setCode(1);
		    ordersResult.setList(list);
		    
		    
		    String jsonString = FastJsonUtil.toJSONString(ordersResult);
			System.out.println(jsonString);
			HttpServletResponse response = ServletActionContext.getResponse();
			FastJsonUtil.write_json(response,jsonString);		
		   
			return NONE;
		
	} 
}
