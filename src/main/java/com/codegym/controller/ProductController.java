package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.impl.productServiceimpl;
import com.codegym.service.productService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

  private productService productService = new productServiceimpl();

  @GetMapping("/")
    public ModelAndView showListProduct(){
      return new ModelAndView("list","products",productService.findAll());
  }
  @GetMapping("/product-edit/{id}")
  public ModelAndView showEditForm(@PathVariable int id){
    return new ModelAndView("edit","product",productService.findById(id));
  }
  @PostMapping("/product-edit")
  public ModelAndView editProduct(@ModelAttribute Product product){
    productService.update(product.getId(),product);
    ModelAndView modelAndView = new ModelAndView("edit");
    modelAndView.addObject("message","Update product success");
    return modelAndView;
  }
  @GetMapping("/product-delete/{id}")
  public ModelAndView showDeleteForm(@PathVariable int id){
    productService.remove(id);
    return new ModelAndView("redirect:/");
  }
  @GetMapping("/product-create")
  public ModelAndView showCreateForm() {
    return new ModelAndView("create", "product", new Product());
  }
  @PostMapping("/product-create")
  public ModelAndView createProduct(@ModelAttribute Product product){
    productServiceimpl.setKey(productServiceimpl.getKey()+1);
    product.setId(productServiceimpl.getKey());
    productService.Add(product);
    return new ModelAndView("create","message","Create new product success");
  }
  @GetMapping("/product-view/{id}")
  public ModelAndView showViewForm(@PathVariable int id){
    return new ModelAndView("view","product",productService.findById(id));
  }
}
