/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author gorod
 */
public class GetPriceByModelController implements Controller{
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView modelAndView = new ModelAndView("getPriceByModel");
        modelAndView.setViewName("getPriceByModel.jsp");
        if(hsr.getMethod()=="POST")
        {
            CarManager cm = new CarManager();
            String model = hsr.getParameter("model");
            Integer price = cm.GetPriceByModel(model);
            if(price != 0)
                modelAndView.addObject("price", "Price is "+price.toString());
            else 
                modelAndView.addObject("price", "No cars found.");
        }
        
        return modelAndView;
    }
}
