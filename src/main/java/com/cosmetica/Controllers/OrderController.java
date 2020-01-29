package com.cosmetica.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetica.Entities.Cart;
import com.cosmetica.Entities.Order;
import com.cosmetica.Entities.Product;
import com.cosmetica.Entities.User;
import com.cosmetica.Exceptions.CosmeticaException;
import com.cosmetica.IServices.IOrderService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class OrderController {
	@Autowired
	IOrderService orderservice;
	
	 @GetMapping("/orders")
	 public List<Order > allOrders() {
		List<Order> orders = orderservice.getAll();
		return orders;
		 
	 }
	 
	 @GetMapping("/order/{order_id}")
	 public Optional <Order> oneOrder(@PathVariable("order_id")int order_id){
		 
		 if(!orderservice.getOneById(order_id).isPresent())
	         throw new CosmeticaException(order_id );
		 return orderservice.getOneById(order_id);
		 
	 }

	 @PostMapping("/add/order")
	 public void addOrder(@RequestBody Order order) {
		 orderservice.saveOrUpdate(order);
		 
	 }
	 @PutMapping("/modify/Order")
	 public void modifyOrder(@RequestBody Order Order) {
		 orderservice.saveOrUpdate(Order);
		 
	 }
	 
	 @DeleteMapping("/remove/order/{order_id}")
	 public void removeOrder(@PathVariable("order_id")int order_id) {
		 if(!orderservice.getOneById(order_id).isPresent())
	         throw new CosmeticaException(order_id );
		 Order order=orderservice.getOneById(order_id).get();
		 orderservice.delete(order); 
		 
	 }
	
	 @GetMapping("/order/user/{order_id}")
	 public User OrderUser(@PathVariable("order_id")int order_id) {
		 if(!orderservice.getOneById(order_id).isPresent())
			 throw new CosmeticaException(order_id );
		 Order order=orderservice.getOneById(order_id).get();
		 return orderservice.getOrderUser(order);
	        	 
	 }

	 @GetMapping("/order/product/{order_id}")
	 public Product OrderProduct(@PathVariable("order_id")int order_id) {
		 if(!orderservice.getOneById(order_id).isPresent())
			 throw new CosmeticaException(order_id );
		 Order order=orderservice.getOneById(order_id).get();
		 return orderservice.getOrderProduct(order);
			
		}
	 
	 @GetMapping("/order/cart/{order_id}")
	 public Cart getOrderCart(@PathVariable("order_id")int order_id) {
		 if(!orderservice.getOneById(order_id).isPresent())
			 throw new CosmeticaException(order_id );
		 Order order=orderservice.getOneById(order_id).get();
		 return orderservice.getOrderCart(order);
			
		}

}