package kr.or.kosta.leaf.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;
import kr.or.kosta.leaf.common.web.PageBuilder;
import kr.or.kosta.leaf.common.web.Params;
import kr.or.kosta.leaf.product.domain.ListDomain;
import kr.or.kosta.leaf.product.domain.Product;
import kr.or.kosta.leaf.product.service.ProductService;
import kr.or.kosta.leaf.product.service.ProductServiceImpl;

public class ProductListController implements Controller {

   ModelAndView mav = new ModelAndView();
   ProductService service = new ProductServiceImpl();
   
   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      
      String pageNo = request.getParameter("page");
         if(pageNo==null) pageNo="1";
      int page = Integer.parseInt(pageNo);
      
      
      if(request.getParameter("category_no") != null) {
         int categoryNo = Integer.parseInt(request.getParameter("category_no"));
         
         Params params = new Params(page, null, null, 12, 5);
         
         int totalRowCount = service.pageCountctn(categoryNo);
         
         List<Product> products = service.listByParams(params, categoryNo);
         ListDomain category = new ListDomain(categoryNo);
         System.out.println(category.toString());
         PageBuilder pageBuilder = new PageBuilder(params, totalRowCount);
         pageBuilder.build();
         
         mav.addObject("tone", category);
         mav.addObject("list", products);
         mav.addObject("pageBuilder", pageBuilder);
         mav.setView("category.leaf");
      
      }else if(request.getParameter("tone") != null) {
         String tone = request.getParameter("tone");
         int categoryNo = 0;
         
         Params params = new Params(page, null, null, 12, 5);
         
         List<Product> products = service.listByTone(params, tone);
         ListDomain productTone = new ListDomain(tone, categoryNo);
         
         int totalRowCount = service.pageCounttone(tone);
         System.out.println(productTone.toString());
         PageBuilder pageBuilder = new PageBuilder(params, totalRowCount);
         pageBuilder.build();
         
         mav.addObject("tone", productTone);
         mav.addObject("list", products);
         mav.addObject("pageBuilder", pageBuilder);
         mav.setView("category.leaf");
      }
      
      return mav;
   }
}