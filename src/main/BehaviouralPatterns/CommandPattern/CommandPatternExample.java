package main.BehaviouralPatterns.CommandPattern;

//Working Principle : Invoker(Command) -> Command(Receiver) -> Receiver

//Receiver
class Light1{

    public void turnOn(){
        System.out.println("Light is turned on");
    }

    public void turnOff(){
        System.out.println("Light is turned off");
    }
}

//Command
interface Command{
    void execute();
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

//Invoker
class RemoteControl{

    private Command buttonCommand;

    public void setButtonCommand(Command command){
        this.buttonCommand=command;
    }

    public void pressButton(){
        buttonCommand.execute();
    }
}

public class CommandPattern {

    public static void main(String[] args){

        //Light
        Light1 livingRoomLight = new Light1();

        //Turn On Command
        LightOnCommand lightOnCommand = new LightOnCommand(livingRoomLight);

        //Turn off Command
        LightOffCommand lightOffCommand = new LightOffCommand(livingRoomLight);

        //Remote
        RemoteControl remoteControl = new RemoteControl();

        //Turn on
        remoteControl.setButtonCommand(lightOnCommand);
        remoteControl.pressButton();

        //Turn off
        remoteControl.setButtonCommand(lightOffCommand);
        remoteControl.pressButton();


    }
}
