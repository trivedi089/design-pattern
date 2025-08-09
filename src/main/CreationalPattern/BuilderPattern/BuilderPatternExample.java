package main.CreationalPattern.BuilderPattern;

class User1{

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phone;

    private User1(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.email = builder.email;
        this.phone = builder.phone;
    }


    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private int age;
        private String email;
        private String phone;

        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public User1 build() {
            return new User1(this);
        }
    }
}
public class BuilderPatternExample {

    public static void main(String[] args) {
        User1 user = new User1.UserBuilder()
                .setFirstName("John")
                .setLastName("Doe")
                .setAge(30)
                .setEmail("john@example.com")
                .setPhone("1234567890")
                .build();
    }
}
