package main.BehaviouralPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

//observer interface
interface Observer{
    void update(int temperature);
}
class WeatherStationIn{
    private int temperature;

    //maintaining list of observers to update
    private List<Observer> observerList = new ArrayList<>();

    //adding observer
    public void addObserver(Observer o){
        observerList.add(o);
    }

    //removing observer
    public void removeObserver(Observer o){
        observerList.remove(o);
    }

    //setting temperatutre and calling notify observers
    public void setTemperature(int temperature){
        this.temperature=temperature;
        notifyObservers();
    }

    //notifying observers
    public void notifyObservers(){
        for(Observer o : observerList)
                o.update(temperature);
    }

}

class PhoneDisplayIn implements Observer{

    @Override
    public void update(int temperature){
        System.out.println("PhoneDisplay : "+temperature+"celsius");
    }
}

class WebDisplayIn implements Observer{

    @Override
    public void  update(int temperature){
        System.out.println("WebDisplay :"+temperature+"celsius");
    }
}
public class ObserverPatternExample {

    public static void main(String[] args){

        WeatherStationIn weatherStationIn = new WeatherStationIn();
        PhoneDisplayIn phoneDisplayIn = new PhoneDisplayIn();
        WebDisplayIn webDisplayIn = new WebDisplayIn();

        //adding observers to the observers list
        weatherStationIn.addObserver(webDisplayIn);
        weatherStationIn.addObserver(phoneDisplayIn);

        //setting temperature
        weatherStationIn.setTemperature(25);


    }
}
