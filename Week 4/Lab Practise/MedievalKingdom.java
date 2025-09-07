import java.util.*;

abstract class MagicalStructure {
    String structureName;
    int magicPower;
    String location;
    boolean isActive;

    // 🔹 Main constructor
    MagicalStructure(String structureName, int magicPower, String location, boolean isActive) {
        this.structureName = structureName;
        this.magicPower = magicPower;
        this.location = location;
        this.isActive = isActive;
    }

    // 🔹 Overloaded constructors using this()
    MagicalStructure(String structureName, int magicPower) {
        this(structureName, magicPower, "Unknown", true);
    }

    MagicalStructure(String structureName) {
        this(structureName, 50, "Unknown", true);
    }

    // 🔹 Abstract method
    abstract void castMagicSpell();
}

// 🔹 WizardTower
class WizardTower extends MagicalStructure {
    int spellCapacity;
    List<String> knownSpells;

    WizardTower(String name) {
        super(name);
        this.spellCapacity = 5;
        this.knownSpells = new ArrayList<>();
    }

    WizardTower(String name, List<String> spells) {
        super(name, 100);
        this.spellCapacity = 10;
        this.knownSpells = new ArrayList<>(spells);
    }

    WizardTower(String name, int power, String location, int capacity, List<String> spells) {
        super(name, power, location, true);
        this.spellCapacity = capacity;
        this.knownSpells = new ArrayList<>(spells);
    }

    @Override
    void castMagicSpell() {
        if (!knownSpells.isEmpty())
            System.out.println(structureName + " casts " + knownSpells.get(new Random().nextInt(knownSpells.size())));
        else
            System.out.println(structureName + " has no spells to cast!");
    }
}

// 🔹 EnchantedCastle
class EnchantedCastle extends MagicalStructure {
    int defenseRating;
    boolean hasDrawbridge;

    EnchantedCastle(String name) {
        super(name, 80);
        this.defenseRating = 100;
        this.hasDrawbridge = true;
    }

    EnchantedCastle(String name, int rating, boolean drawbridge) {
        super(name, 120, "Valley", true);
        this.defenseRating = rating;
        this.hasDrawbridge = drawbridge;
    }

    @Override
    void castMagicSpell() {
        System.out.println(structureName + " fortifies defenses with magical shields!");
    }
}

// 🔹 MysticLibrary
class MysticLibrary extends MagicalStructure {
    int bookCount;
    String ancientLanguage;

    MysticLibrary(String name) {
        super(name);
        this.bookCount = 50;
        this.ancientLanguage = "Latin";
    }

    MysticLibrary(String name, int bookCount, String language) {
        super(name, 90);
        this.bookCount = bookCount;
        this.ancientLanguage = language;
    }

    @Override
    void castMagicSpell() {
        System.out.println(structureName + " unleashes knowledge magic from " + bookCount + " books!");
    }
}

// 🔹 DragonLair
class DragonLair extends MagicalStructure {
    String dragonType;
    int treasureValue;

    DragonLair(String name) {
        super(name, 150);
        this.dragonType = "Fire Dragon";
        this.treasureValue = 1000;
    }

    DragonLair(String name, String dragonType, int treasureValue) {
        super(name, 200, "Mountain", true);
        this.dragonType = dragonType;
        this.treasureValue = treasureValue;
    }

    @Override
    void castMagicSpell() {
        System.out.println(structureName + " dragon breathes fire across the land!");
    }
}

// 🔹 Interaction System
class StructureInteractions {
    static boolean canStructuresInteract(MagicalStructure s1, MagicalStructure s2) {
        return s1.isActive && s2.isActive;
    }

    static String performMagicBattle(MagicalStructure attacker, MagicalStructure defender) {
        if (attacker.magicPower > defender.magicPower) {
            return attacker.structureName + " defeats " + defender.structureName + "!";
        } else if (attacker.magicPower < defender.magicPower) {
            return defender.structureName + " withstands " + attacker.structureName + "!";
        } else {
            return attacker.structureName + " and " + defender.structureName + " are equally matched!";
        }
    }

    static int calculateKingdomMagicPower(MagicalStructure[] structures) {
        int sum = 0;
        for (MagicalStructure s : structures) {
            sum += s.magicPower;
        }
        return sum;
    }

    // 🔹 Special combinations
    static void applySpecialEffects(MagicalStructure s1, MagicalStructure s2) {
        if (s1 instanceof WizardTower && s2 instanceof MysticLibrary) {
            ((WizardTower) s1).spellCapacity *= 2;
            System.out.println("✨ Knowledge Boost! " + s1.structureName + " spell capacity doubled!");
        }
        if (s1 instanceof EnchantedCastle && s2 instanceof DragonLair) {
            ((EnchantedCastle) s1).defenseRating *= 3;
            System.out.println("🐉 Dragon Guard! " + s1.structureName + " defense tripled!");
        }
    }
}

// 🔹 Kingdom Manager
class KingdomManager {
    static void categorize(MagicalStructure s) {
        if (s instanceof WizardTower) System.out.println(s.structureName + " is a Wizard Tower!");
        else if (s instanceof EnchantedCastle) System.out.println(s.structureName + " is an Enchanted Castle!");
        else if (s instanceof MysticLibrary) System.out.println(s.structureName + " is a Mystic Library!");
        else if (s instanceof DragonLair) System.out.println(s.structureName + " is a Dragon Lair!");
    }

    static double calculateTax(MagicalStructure s) {
        if (s instanceof WizardTower) return 100.0;
        if (s instanceof EnchantedCastle) return 200.0;
        if (s instanceof MysticLibrary) return 150.0;
        if (s instanceof DragonLair) return 300.0;
        return 50.0;
    }

    static String determineSpecialization(MagicalStructure[] structures) {
        int magic = 0, defense = 0;
        for (MagicalStructure s : structures) {
            if (s instanceof WizardTower || s instanceof MysticLibrary) magic++;
            if (s instanceof EnchantedCastle || s instanceof DragonLair) defense++;
        }
        if (magic > defense) return "Magic-Focused Kingdom";
        else if (defense > magic) return "Defense-Focused Kingdom";
        else return "Balanced Kingdom";
    }
}

// 🔹 Main Simulation
public class MedievalKingdom {
    public static void main(String[] args) {
        MagicalStructure tower = new WizardTower("Arcane Spire", Arrays.asList("Fireball", "Lightning"));
        MagicalStructure castle = new EnchantedCastle("Royal Fortress", 200, true);
        MagicalStructure library = new MysticLibrary("Ancient Archives", 500, "Runic");
        MagicalStructure lair = new DragonLair("Smaug's Den", "Shadow Dragon", 5000);

        MagicalStructure[] kingdom = {tower, castle, library, lair};

        // Categorize
        for (MagicalStructure s : kingdom) {
            KingdomManager.categorize(s);
            s.castMagicSpell();
            System.out.println("Tax: " + KingdomManager.calculateTax(s));
        }

        // Battle Example
        System.out.println("\nBattle: " + StructureInteractions.performMagicBattle(tower, lair));

        // Special effects
        StructureInteractions.applySpecialEffects(tower, library);
        StructureInteractions.applySpecialEffects(castle, lair);

        // Total power
        System.out.println("\nTotal Kingdom Magic Power: " + StructureInteractions.calculateKingdomMagicPower(kingdom));

        // Specialization
        System.out.println("Kingdom Type: " + KingdomManager.determineSpecialization(kingdom));
    }
}
