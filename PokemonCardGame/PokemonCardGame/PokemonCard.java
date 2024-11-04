// PokemonCard class
package PokemonCardGame;

public class PokemonCard extends Card {
    private int hp;
    private String attack1;
    private int attack1Damage;
    private String attack2;
    private int attack2Damage;

    public PokemonCard(String name, int hp, String attack1, int attack1Damage, String attack2, int attack2Damage) {
        super(name);
        this.hp = hp;
        this.attack1 = attack1;
        this.attack1Damage = attack1Damage;
        this.attack2 = attack2;
        this.attack2Damage = attack2Damage;
    }

    @Override
    public void play() {
        System.out.println(name + " is played with HP: " + hp);
    }

    public void useAttack(PokemonCard target, int attackChoice) {
        if (attackChoice == 1) {
            System.out.println(name + " uses " + attack1 + ":");
            System.out.println(name + " used " + attack1 + "!");
            target.receiveDamage(attack1Damage);
        } else if (attackChoice == 2) {
            System.out.println(name + " uses " + attack2 + ":");
            System.out.println(name + " used " + attack2 + "!");
            target.receiveDamage(attack2Damage);
        } else {
            System.out.println("Invalid attack choice.");
        }
    }

    public void receiveDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
        System.out.println(name + " - HP: " + hp);
    }

    public boolean isKnockedOut() {
        return hp <= 0;
    }

    public int getHp() {
        return hp;
    }

    public boolean isBasic() {
        return true; // Assuming all instances are basic for simplicity
    }

    public String getName() {
        return name;
    }
}
