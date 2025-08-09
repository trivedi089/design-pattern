package main.StructuralPattern.BridgePattern;

// Implementation interface
interface TV {
    void on();
    void off();
    void tuneChannel(int channel);
}

class SonyTV implements TV {
    public void on() {
        System.out.println("Sony TV is ON");
    }

    public void off() {
        System.out.println("Sony TV is OFF");
    }

    public void tuneChannel(int channel) {
        System.out.println("Sony TV tuned to channel " + channel);
    }
}

class SamsungTV implements TV {
    public void on() {
        System.out.println("Samsung TV is ON");
    }

    public void off() {
        System.out.println("Samsung TV is OFF");
    }

    public void tuneChannel(int channel) {
        System.out.println("Samsung TV tuned to channel " + channel);
    }
}

// Abstraction
abstract class RemoteControl {
    protected TV implementor;

    public RemoteControl(TV implementor) {
        this.implementor = implementor;
    }

    public abstract void on();
    public abstract void off();
    public abstract void setChannel(int channel);
}

class BasicRemote extends RemoteControl {

    public BasicRemote(TV implementor) {
        super(implementor);
    }

    public void on() {
        implementor.on();
    }

    public void off() {
        implementor.off();
    }

    public void setChannel(int channel) {
        implementor.tuneChannel(channel);
    }
}


public class BridgePatternExample {
    public static void main(String[] args) {
        TV sony = new SonyTV();
        RemoteControl remote1 = new BasicRemote(sony);
        remote1.on();
        remote1.setChannel(10);
        remote1.off();

        TV samsung = new SamsungTV();
        RemoteControl remote2 = new BasicRemote(samsung);
        remote2.on();
        remote2.setChannel(5);
        remote2.off();
    }
}
