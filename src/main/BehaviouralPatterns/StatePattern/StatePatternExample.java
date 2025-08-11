package main.BehaviouralPatterns.StatePattern;

// State interface
interface State {
    void pullChain(Fan1 fan);
}

// Concrete States
class OffState implements State {
    public void pullChain(Fan1 fan) {
        System.out.println("Fan is now on LOW speed.");
        fan.setState(new LowState());
    }
}

class LowState implements State {
    public void pullChain(Fan1 fan) {
        System.out.println("Fan is now on HIGH speed.");
        fan.setState(new HighState());
    }
}

class HighState implements State {
    public void pullChain(Fan1 fan) {
        System.out.println("Fan is now OFF.");
        fan.setState(new OffState());
    }
}

// Context
class Fan1 {
    private State state;

    public Fan1() {
        state = new OffState(); // initial state
    }

    public void setState(State state) {
        this.state = state;
    }

    public void pullChain() {
        state.pullChain(this);
    }
}

// Client
public class StatePatternExample {
    public static void main(String[] args) {
        Fan1 fan = new Fan1();
        fan.pullChain();
        fan.pullChain();
        fan.pullChain();
    }
}
