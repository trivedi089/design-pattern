package main.StructuralPattern.FlyweightPattern;

import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface Character {
    void display(int fontSize);
}

// Concrete Flyweight: shared character shape
class ConcreteCharacter implements Character {
    private char symbol; // intrinsic state (shared)

    public ConcreteCharacter(char symbol) {
        this.symbol = symbol;
    }

    public void display(int fontSize) { // extrinsic state (not shared)
        System.out.println("Displaying '" + symbol + "' in font size " + fontSize);
    }
}

// Flyweight Factory to reuse Character objects
class CharacterFactory {
    private Map<java.lang.Character, Character> characters = new HashMap<>();

    public Character getCharacter(char key) {
        if (!characters.containsKey(key)) {
            characters.put(key, new ConcreteCharacter(key));
        }
        return characters.get(key);
    }
}

// Client usage
public class FlyweightPatternExample {
    public static void main(String[] args) {
        String document = "ABAC";
        CharacterFactory factory = new CharacterFactory();

        int[] fontSizes = {12, 14, 10, 12};

        for (int i = 0; i < document.length(); i++) {
            Character character = factory.getCharacter(document.charAt(i)); // reuse existing
            character.display(fontSizes[i]); // pass extrinsic state
        }
    }
}
