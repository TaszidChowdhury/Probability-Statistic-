// EnergyCard.java
package PokemonCardGame;

public class EnergyCard extends Card {
    public EnergyCard(String type) {
        super(type + " Energy");
    }

    @Override
    public void play() {
        System.out.println(name + " card played.");
    }
}
