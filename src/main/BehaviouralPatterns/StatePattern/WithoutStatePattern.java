package main.BehaviouralPatterns.StatePattern;

class Fan {
    private String state = "OFF"; // Possible states: OFF, LOW, HIGH

    public void pullChain() {
        if (state.equals("OFF")) {
            System.out.println("Fan is now on LOW speed.");
            state = "LOW";
        } else if (state.equals("LOW")) {
            System.out.println("Fan is now on HIGH speed.");
            state = "HIGH";
        } else if (state.equals("HIGH")) {
            System.out.println("Fan is now OFF.");
            state = "OFF";
        }
    }
}

public class WithoutStatePattern {
    public static void main(String[] args) {
        Fan fan = new Fan();
        fan.pullChain();
        fan.pullChain();
        fan.pullChain();
    }
}