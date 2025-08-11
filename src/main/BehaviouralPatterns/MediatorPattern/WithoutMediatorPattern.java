package main.BehaviouralPatterns.MediatorPattern;

// BAD CODE: Tight coupling
class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void sendMessage(User to, String message) {
        System.out.println(this.name + " to " + to.getName() + ": " + message);
    }

    public String getName() {
        return name;
    }
}

public class WithoutMediatorPattern {
    public static void main(String[] args) {
        User alice = new User("Alice");
        User bob = new User("Bob");

        // Users talk to each other directly
        alice.sendMessage(bob, "Hello Bob!");
        bob.sendMessage(alice, "Hey Alice!");
    }
}
