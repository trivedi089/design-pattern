package main.BehaviouralPatterns.CommandPattern;

class Light{

    public void turnOn(){
        System.out.println("Light is turned on");
    }

    public void turnOff(){
        System.out.println("Light is turned off");
    }
}

class Remote{

    //tight coupling
    private Light light;

    Remote(Light light){
        this.light=light;
    }

    public void pressButton(String action){
        if(action=="ON")
            light.turnOn();
        else if(action=="OFF")
            light.turnOff();
        else
            System.out.println("Pls press the right button");
    }

}

public class WithoutCommandPattern {

    public static void main(String[] args){

        Light light = new Light();
        Remote remote = new Remote(light);

        remote.pressButton("ON");
        remote.pressButton("OFF");
    }
}
