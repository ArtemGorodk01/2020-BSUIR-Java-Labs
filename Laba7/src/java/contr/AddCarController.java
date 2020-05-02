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
public class AddCarController implements Controller{
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView modelAndView = new ModelAndView("addCar"); 
        modelAndView.setViewName("addCar.jsp");
        CarManager carManager = new CarManager();
        if(hsr.getMethod() == "POST")
        {
            String model = hsr.getParameter("model");
            Integer price = Integer.parseInt(hsr.getParameter("price"));
            if(carManager.AddCar(model, price))
            {
                modelAndView.addObject("addInfo", "Car was added.");
            }
            else
            {
                modelAndView.addObject("addInfo", "Some error occured.");
            }
        }
        
        return modelAndView;
    }
    
}
