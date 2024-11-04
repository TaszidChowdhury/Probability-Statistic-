package PokemonCardGame;

// TrainerCard class
abstract class TrainerCard extends Card {
    private String description;
    private String type;

    public TrainerCard(String name, String description, String type) {
        super(name);
        this.description = description;
        this.type = type;
    }

    public abstract void useAbility(Player player, Deck deck);
}
