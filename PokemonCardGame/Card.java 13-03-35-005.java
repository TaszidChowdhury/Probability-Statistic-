package PokemonCardGame;

public class Card {
    private String type;  // "Pokemon", "Trainer", "Energy"
    
    public Card(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
