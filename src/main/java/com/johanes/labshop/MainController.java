package com.johanes.labshop;

import com.johanes.labshop.Objects.Category;
import com.johanes.labshop.Objects.Product;
import com.johanes.labshop.Services.CategoryService;
import com.johanes.labshop.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MainController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public MainController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/products")
    public String list(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "products";
    }

    @GetMapping("/products/add")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "products/add";
    }

    @PostMapping("/products/add")
    public String add(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/products/remove")
    public String remove(@RequestParam("id") long id) {
        productService.deleteProductById(id);
        return "redirect:/products";
    }

    @GetMapping("/products/edit")
    public String edit(Model model, @RequestParam("id") long id) {
        model.addAttribute("product", productService.getProductById(id));
        return "/products/edit";
    }

    @PostMapping(value = {"/products/edit"})
    public String edit(@ModelAttribute Product product) {
        productService.updateProduct(product);
        return "redirect:/products";
    }



    @GetMapping("/author")
    public String author() {
        return "/author";
    }

    @GetMapping("/products/details")
    public String details(Model model, @RequestParam("id") long id) {
        model.addAttribute("product", productService.getProductById(id));
        return "/products/details";
    }



    @GetMapping("/categories")
    public String listC(Model model) {
        model.addAttribute("categories", categoryService.getCategories());
        return "categories";
    }

    @GetMapping("/categories/add")
    public String addC(Model model) {
        model.addAttribute("category", new Category());
        return "categories/add";
    }

    @PostMapping("/categories/add")
    public String addC(@ModelAttribute Category category) {
        categoryService.addCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/remove")
    public String removeC(@RequestParam("id") long id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/categories";
    }

    @GetMapping("/categories/edit")
    public String editC(Model model, @RequestParam("id") long id) {
        model.addAttribute("category", categoryService.getCategoryById(id));
        return "/categories/edit";
    }

    @PostMapping(value = {"/categories/edit"})
    public String editC(@ModelAttribute Category category) {
        categoryService.updateCategory(category);
        return "redirect:/categories";
    }
}
