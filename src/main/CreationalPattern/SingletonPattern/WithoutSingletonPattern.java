package main.CreationalPattern.SingletonPattern;

class BadSingleton{

    public static BadSingleton instance;

    private BadSingleton(){
        // // private constructor to prevent external instantiation
    }

    public static BadSingleton getInstance(){
        if(instance==null){
            instance = new BadSingleton();    // Not thread-safe!
        }
        return instance;
    }
}

public class WithoutSingletonPattern {

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            BadSingleton singleton = BadSingleton.getInstance();
            System.out.println("Instance hashcode: " + singleton.hashCode());
        };

        // Create two threads that call getInstance() simultaneously
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
