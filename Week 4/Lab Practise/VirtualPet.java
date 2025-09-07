import java.util.*;

public class VirtualPet {
    // 🔹 Fields
    final String petId;
    String petName;
    String species;
    int age;
    int happiness;
    int health;
    String currentStage;
    boolean isGhost = false;

    static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder"};
    static int totalPetsCreated = 0;

    // 🔹 Utility to generate unique IDs
    static String generatePetId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    // 🔹 Helper for random species
    private static String getRandomSpecies() {
        String[] speciesList = {"Dragon", "Cat", "Dog", "Phoenix", "Rabbit"};
        return speciesList[new Random().nextInt(speciesList.length)];
    }

    // 🔹 Master constructor
    VirtualPet(String petName, String species, int age, int happiness, int health, String stage) {
        this.petId = generatePetId();
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.currentStage = stage;
        totalPetsCreated++;
    }

    // 🔹 Default constructor → Egg
    VirtualPet() {
        this("Unknown", getRandomSpecies(), 0, 50, 50, EVOLUTION_STAGES[0]);
    }

    // 🔹 Name only → Baby
    VirtualPet(String petName) {
        this(petName, getRandomSpecies(), 1, 60, 60, EVOLUTION_STAGES[1]);
    }

    // 🔹 Name + species → Child
    VirtualPet(String petName, String species) {
        this(petName, species, 3, 70, 70, EVOLUTION_STAGES[2]);
    }

    // 🔹 Actions
    void feedPet() {
        if (!isGhost) {
            health = Math.min(100, health + 10);
            happiness = Math.min(100, happiness + 5);
        }
    }

    void playWithPet() {
        if (!isGhost) {
            happiness = Math.min(100, happiness + 15);
            health = Math.max(0, health - 2); // playing uses energy
        }
    }

    void healPet() {
        if (!isGhost) {
            health = Math.min(100, health + 20);
        }
    }

    void evolvePet() {
        if (isGhost) return; // ghosts don’t evolve
        int stageIndex = Arrays.asList(EVOLUTION_STAGES).indexOf(currentStage);
        if (age > 2 && stageIndex < EVOLUTION_STAGES.length - 1) {
            currentStage = EVOLUTION_STAGES[stageIndex + 1];
        }
    }

    void simulateDay() {
        if (isGhost) return;

        age++;
        // Random fluctuation
        happiness = Math.max(0, happiness + (new Random().nextInt(11) - 5));
        health = Math.max(0, health + (new Random().nextInt(11) - 5));

        if (health <= 0) {
            isGhost = true;
            species = "Ghost";
            currentStage = "Ghost";
        } else {
            evolvePet();
        }
    }

    String getPetStatus() {
        return String.format("[%s] %s (%s) | Age: %d | Health: %d | Happiness: %d | Stage: %s",
                petId, petName, species, age, health, happiness, currentStage);
    }

    // 🔹 Main Program
    public static void main(String[] args) {
        List<VirtualPet> daycare = new ArrayList<>();

        // Different constructors
        daycare.add(new VirtualPet()); // Egg
        daycare.add(new VirtualPet("Fluffy")); // Baby
        daycare.add(new VirtualPet("Sparky", "Dragon")); // Child
        daycare.add(new VirtualPet("Buddy", "Cat", 5, 80, 90, "Teen")); // Full

        // Simulate 5 days
        for (int day = 1; day <= 5; day++) {
            System.out.println("\n🌞 Day " + day);
            for (VirtualPet pet : daycare) {
                pet.simulateDay();
                // Random care
                if (!pet.isGhost) {
                    pet.feedPet();
                    if (new Random().nextBoolean()) pet.playWithPet();
                }
                System.out.println(pet.getPetStatus());
            }
        }

        System.out.println("\nTotal pets created: " + VirtualPet.totalPetsCreated);
    }
}
