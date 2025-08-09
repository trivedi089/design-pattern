package main.StructuralPattern.FacadeDesignPattern;

//subsystem classes
class DVDPlayer {
    public void on() { System.out.println("DVD Player on"); }
    public void play(String movie) { System.out.println("Playing movie: " + movie); }
    public void off() { System.out.println("DVD Player off"); }
}

class Projector {
    public void on() { System.out.println("Projector on"); }
    public void wideScreenMode() { System.out.println("Projector in widescreen mode"); }
    public void off() { System.out.println("Projector off"); }
}

class SoundSystem {
    public void on() { System.out.println("Sound system on"); }
    public void setVolume(int level) { System.out.println("Sound system volume set to " + level); }
    public void off() { System.out.println("Sound system off"); }
}

//Facade Class
class HomeTheaterFacade {
    private DVDPlayer dvd;
    private Projector projector;
    private SoundSystem soundSystem;

    public HomeTheaterFacade(DVDPlayer dvd, Projector projector, SoundSystem soundSystem) {
        this.dvd = dvd;
        this.projector = projector;
        this.soundSystem = soundSystem;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        projector.on();
        projector.wideScreenMode();
        soundSystem.on();
        soundSystem.setVolume(10);
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        dvd.off();
        soundSystem.off();
        projector.off();
    }
}

public class FacadeDesignPatternExample {

    public static void main(String[] args) {
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvd, projector, soundSystem);
        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }
}
