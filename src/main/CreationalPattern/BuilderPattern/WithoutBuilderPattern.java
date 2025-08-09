package main.CreationalPattern.BuilderPattern;

class User{

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phone;

    public User(String firstName, String lastName, int age, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }
}
public class WithoutBuilderPattern {

    public static void main(String[] args){
        // Huge constructor, hard to read & remember parameter order
        User Bob = new User("John", "Doe", 30, "john@example.com", "1234567890");
    }
}
