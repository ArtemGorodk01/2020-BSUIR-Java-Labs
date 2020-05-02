package contr;

import java.util.LinkedList;
import java.util.List;
import model.Car; 
 
public class CarManager 
{ 
    private static List<Car> carList; 
    private static long maxId = 4;
    static
    {    
        Car car1 = new Car((long)1, "SL 500", 20000);  
        Car car2 = new Car((long)2, "607", 35000);  
        Car car3 = new Car((long)3, "KIA", 15000); 
        Car car4 = new Car((long)4, "Toyota", 25000);  
        carList = new LinkedList<Car>(); 
        carList.add(car1); 
        carList.add(car2); 
        carList.add(car3); 
        carList.add(car4); 
    } 
    
    public List<Car> getCarList()
    { 
        return carList;
    } 
    
    public Boolean AddCar(String model, Integer price)
    {
        maxId++;
        carList.add(new Car(maxId, model, price));
        return true;
    }
    
    public Integer GetPriceByModel(String model)
    {
        Integer sum = 0;
        Integer amount = 0;
        for(Car car : carList)
        {
            if(car.getModel().equalsIgnoreCase(model))
            {
                sum += car.getPrice();
                amount++;
            }
        }
        
        if(amount!=0)
            return sum/amount;
        else
            return 0;
    }
    
    public List<Car> GetCarsLowerPrice(Integer price)
    {
        List<Car> newCars = new LinkedList<Car>();
        for(Car car : carList)
        {
            if(car.getPrice()<price)
            {
                newCars.add(car);
            }
        }
        
        return newCars;
    }
}