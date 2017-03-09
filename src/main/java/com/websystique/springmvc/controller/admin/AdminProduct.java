 package com.websystique.springmvc.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.websystique.springmvc.model.Product;
import com.websystique.springmvc.service.ProductService;

/**
 * Created by pchapman on 1/24/2017.
 */

@Controller
@RequestMapping("/admin")
public class AdminProduct {

	static final Logger logger = LoggerFactory.getLogger(AdminProduct.class);
    private Path path;

    @Autowired
    private ProductService productService;

    @RequestMapping(value="/product/addProduct", method=RequestMethod.GET)
    public String addProduct(Model model) {
        Product product = new Product();
        product.setProductCategory("instrument");
        product.setProductCondition("new");
        product.setProductStatus("active");

        model.addAttribute("product", product);

        return "addProduct";
    }

    @RequestMapping(value="/product/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
                                 HttpServletRequest request) {
        if(result.hasErrors()) {
        	logger.info("addProductPost has errors...........");
            return "addProduct";
        }
        
        logger.info("Adding file...........");
        productService.addProduct(product);

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\prod_images\\"+product.getProductId()+".png");
        /*path=Paths.get("C:\\apps\\SpringMVCHibernateWithSpringSecurity\\src\\main\\webapp\\WEB-INF\\resources\\prod_images\\"
        		+product.getProductId()+".png");*/

        logger.info("Path: "+path);
        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed.", e);
            }
        }

        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/product/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);

        model.addAttribute("product", product);

        return "editProduct";
    }

    @RequestMapping(value="/product/editProduct", method = RequestMethod.POST)
    public String editProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
                                 HttpServletRequest request) {
        if(result.hasErrors()) {
            return "editProduct";
        }

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\prod_images\\"+product.getProductId()+".png");
        /*path=Paths.get("C:\\apps\\SpringMVCHibernateWithSpringSecurity\\src\\main\\webapp\\WEB-INF\\resources\\prod_images\\"
        		+product.getProductId()+".png");*/
        
        logger.info("Path: "+path);
        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed.", e);
            }
        }

        productService.editProduct(product);

        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/product/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\prod_images\\" + id + ".png");
        /*path=Paths.get("C:\\apps\\SpringMVCHibernateWithSpringSecurity\\src\\main\\webapp\\WEB-INF\\resource\\prod_images\\"
        		+id+".png");*/

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Product product = productService.getProductById(id);
        productService.deleteProduct(product);

        return "redirect:/admin/productInventory";
    }
}
