package com.codegym.controller;

import com.codegym.model.bean.Product;
import com.codegym.model.service.ProductServiceImpl;
import com.codegym.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;
//      private final IProductService iProductService = new ProductServiceImpl();

    @GetMapping("")
    public String index(Model model) {

        List<Product> productList = iProductService.findAll();
        model.addAttribute("productList", productList);
        return "/index";
    }

    //find by Name
    @GetMapping("/find-name")
    public String findByNameForm() {
        return "/find_name";
    }
    @PostMapping("/search")
    public String findByName(@RequestParam String name, Model model) {

        List<Product> productList = iProductService.findByName(name);
        model.addAttribute("name",name);
        model.addAttribute("productList", productList);
        return "/find_name";
    }
//create
    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("/create_test", "product", new Product());
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product,
                       RedirectAttributes redirectAttribute) {
        iProductService.create(product);
        redirectAttribute.addFlashAttribute("message", "Create new product successfully!");
        return "redirect:/product";
    }
//

    @GetMapping("{id}/edit")
    public ModelAndView editForm(@PathVariable int id) {
        return new ModelAndView("/edit_test", "product", iProductService.findById(id));
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product,
                       RedirectAttributes redirectAttributes) {

        iProductService.update(product,product.getId());
        redirectAttributes.addFlashAttribute("message", "Edit product successfully!");
        return "redirect:/product";
    }
//
    //delete:
    @GetMapping("{id}/delete")
    public ModelAndView deleteForm(@PathVariable int id) {
        return new ModelAndView("/delete_test", "product", iProductService.findById(id));
    }
//
    @PostMapping("/delete")
    public String delete(@ModelAttribute Product product,
                         RedirectAttributes redirectAttributes) {
        iProductService.delete(product.getId());
        redirectAttributes.addFlashAttribute("message", "Delete product successfully!");
        return "redirect:/product";
    }

//
//
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/view";
    }
}