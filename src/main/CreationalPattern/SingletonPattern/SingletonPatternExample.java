package main.CreationalPattern.SingletonPattern;


//1. Eager Initialization
//2. Lazy Initialization (Non Thread-Safe)
//3. Thread-safe Singleton with Synchronized Method
//4. Initialization-on-demand Holder Idiom (Recommended)



//Eager Initialization
class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton(){
        // private constructor
    }

    public static EagerSingleton getInstance(){
        return instance;
    }
}

//Lazy Initialization (Non Thread-Safe)
class LazySinlgeton{

    private static LazySinlgeton instance = new LazySinlgeton();

    private LazySinlgeton(){
        //private constructor
    }

    public static LazySinlgeton getInstance(){
        if(instance!=null){
            instance = new LazySinlgeton();
        }
        return instance;
    }
}

//Thread-safe Singleton with Synchronized Method
class ThreadSafeSingleton{
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){
        //private constructor
    }

    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance!=null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}

//Initialization-on-demand Holder Idiom (Recommended)
class HolderSingleton{

    private HolderSingleton(){
        //private constructor
    }

    // Static nested class — not loaded until needed
    private static class SingletonHolder{
        private static final HolderSingleton INSTANCE = new HolderSingleton();
    }

    public static HolderSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}


public class SingletonPatternExample {

    public static void main(String[] args){

        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        LazySinlgeton lazySinlgeton = LazySinlgeton.getInstance();
        ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();
        HolderSingleton holderSingleton = HolderSingleton.getInstance();

    }
}
