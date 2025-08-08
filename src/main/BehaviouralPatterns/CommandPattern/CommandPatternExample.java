package main.BehaviouralPatterns.CommandPattern;

interface Command{
    void execute();
}
class Light1{

    public void turnOn(){
        System.out.println("Light is turned on");
    }

    public void turnOff(){
        System.out.println("Light is turned off");
    }
}

class LightOnCommand implements Command{

    private Light1 light1;

    LightOnCommand(Light1 light1){
        this.light1=light1;
    }

    @Override
    public void execute(){
        System.out.println("Light is turned on");
    }
}

class LightOffCommand implements Command{

    private Light1 light1;

    LightOffCommand(Light1 light1){
        this.light1=light1;
    }

    public void execute(){
        System.out.print("Light is turned off");
    }
}
class RemoteControl{

    private Command command;

    RemoteControl(Command command){
        this.command=command;
    }

    public void pressButton(){
        command.execute();
    }
}

public class CommandPatternExample {

    public static void main(String[] args){

        Light1 livingRoomLight = new Light1();
        LightOnCommand lightOnCommand = new LightOnCommand(livingRoomLight);

        RemoteControl remoteControl = new RemoteControl(lightOnCommand);

        remoteControl.pressButton();


    }
}
