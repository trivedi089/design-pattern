package main.BehaviouralPatterns.MediatorPattern;

import java.util.ArrayList;
import java.util.List;

// Mediator Interface
interface ChatMediator {
    void sendMessage(String message, User1 user);
    void addUser(User1 user);
}

// Concrete Mediator
class ChatRoom implements ChatMediator {
    private List<User1> users = new ArrayList<>();

    @Override
    public void sendMessage(String message, User1 user) {
        for (User1 u : users) {
            if (u != user) {
                u.receive(message);
            }
        }
    }

    @Override
    public void addUser(User1 user) {
        users.add(user);
    }
}

// Colleague Class
class User1 {
    private String name;
    private ChatMediator mediator;

    public User1(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void send(String message) {
        System.out.println(this.name + " sends: " + message);
        mediator.sendMessage(message, this);
    }

    public void receive(String message) {
        System.out.println(this.name + " receives: " + message);
    }
}

// Test
public class MediatorPatternExample {
    public static void main(String[] args) {
        ChatMediator chatRoom = new ChatRoom();

        User1 alice = new User1("Alice", chatRoom);
        User1 bob = new User1("Bob", chatRoom);
        User1 charlie = new User1("Charlie", chatRoom);

        chatRoom.addUser(alice);
        chatRoom.addUser(bob);
        chatRoom.addUser(charlie);

        alice.send("Hello everyone!");
        bob.send("Hi Alice!");
    }
}
