package main.BehaviouralPatterns.ObserverPattern;


class WeatherStation{

    private int temperature;

    //tight coupling
    private PhoneDisplay phoneDisplay;
    private WebDisplay webDisplay;

    WeatherStation(PhoneDisplay phoneDisplay,WebDisplay webDisplay){
        this.phoneDisplay=phoneDisplay;
        this.webDisplay=webDisplay;
    }

    public void setTemperature(int temperature){
        this.temperature=temperature;
        phoneDisplay.update(temperature);
        webDisplay.update(temperature);
    }

}

class PhoneDisplay{
    public void update(int temperature){
        System.out.println("PhoneDisplay :"+temperature+"Celsius");
    }
}
class WebDisplay{
    public void update(int temperature){
        System.out.println("WebDisplay :"+temperature+"Celsius");
    }
}
public class WithoutObserverPattern {

    public static void main(String[] args) {

        PhoneDisplay phoneDisplay = new PhoneDisplay();
        WebDisplay webDisplay = new WebDisplay();

        WeatherStation weatherStation = new WeatherStation(phoneDisplay,webDisplay);
        weatherStation.setTemperature(20);
    }
}

