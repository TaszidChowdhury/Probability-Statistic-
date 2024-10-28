package PokemonCardGame;

public class Pokemon extends Card {
    private int hp;

    public Pokemon(int hp) {
        super("Pokemon");
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
