/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contr;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Car;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author gorod
 */
public class GetCarsLowerPriceController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView modelAndView = new ModelAndView("getCarsLowerPrice");
        modelAndView.setViewName("getCarsLowerPrice.jsp");
        if(hsr.getMethod()=="POST")
        {
            CarManager cm = new CarManager();
            Integer price = Integer.parseInt(hsr.getParameter("price"));
            List<Car> cars = cm.GetCarsLowerPrice(price);
            modelAndView.addObject("carList", cars);
            if(cars.isEmpty())
                modelAndView.addObject("info", "No cars found.");
            else
                modelAndView.addObject("info", "Cars:");
        }
        
        return modelAndView;
    }
    
}
