public class GameController {
    private String controllerBrand;
    private String connectionType;
    private boolean hasVibration;
    private int batteryLevel;
    private double sensitivity;

    // Default constructor - standard gaming setup
    public GameController() {
        this.controllerBrand = "GenericPad";
        this.connectionType = "USB";
        this.hasVibration = true;
        this.batteryLevel = 100;
        this.sensitivity = 1.0;
    }

    // Full parameterized constructor with validation
    public GameController(String controllerBrand, String connectionType,
                          boolean hasVibration, int batteryLevel, double sensitivity) {
        this.controllerBrand = controllerBrand;
        this.connectionType = connectionType;
        this.hasVibration = hasVibration;
        // Validate battery level (0-100)
        if (batteryLevel < 0) {
            this.batteryLevel = 0;
        } else if (batteryLevel > 100) {
            this.batteryLevel = 100;
        } else {
            this.batteryLevel = batteryLevel;
        }
        // Validate sensitivity (0.1 - 3.0)
        if (sensitivity < 0.1) {
            this.sensitivity = 0.1;
        } else if (sensitivity > 3.0) {
            this.sensitivity = 3.0;
        } else {
            this.sensitivity = sensitivity;
        }
    }

    // Two-parameter convenience constructor (brand + connectionType)
    // Other fields set to default standard values
    public GameController(String controllerBrand, String connectionType) {
        this.controllerBrand = controllerBrand;
        this.connectionType = connectionType;
        this.hasVibration = true;
        this.batteryLevel = 100;
        this.sensitivity = 1.0;
    }

    // Method to calibrate controller
    public void calibrateController() {
        System.out.println("Calibrating " + controllerBrand + " controller...");
    }

    // Method to display configuration
    public void displayConfiguration() {
        System.out.println("Controller Brand: " + controllerBrand);
        System.out.println("Connection Type: " + connectionType);
        System.out.println("Vibration Enabled: " + (hasVibration ? "Yes" : "No"));
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Sensitivity: " + sensitivity);
    }

    // Method to test vibration
    public void testVibration() {
        if (hasVibration) {
            System.out.println("*BUZZ* Vibration test successful!");
        } else {
            System.out.println("Vibration disabled on this controller.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== GAMING CONTROLLER SETUP ===");

        // Create controller with default constructor
        GameController defaultController = new GameController();

        // Create controller with full parameterized constructor
        GameController customController = new GameController("ProGamerX", "Wireless", false, 85, 2.5);

        // Create controller with convenience constructor
        GameController convenienceController = new GameController("SpeedyPad", "Bluetooth");

        // Test all methods on each controller
        System.out.println("\nDefault Controller:");
        defaultController.calibrateController();
        defaultController.displayConfiguration();
        defaultController.testVibration();

        System.out.println("\nCustom Controller:");
        customController.calibrateController();
        customController.displayConfiguration();
        customController.testVibration();

        System.out.println("\nConvenience Controller:");
        convenienceController.calibrateController();
        convenienceController.displayConfiguration();
        convenienceController.testVibration();

        // Compare configurations (example: battery level)
        System.out.println("\nComparing battery levels:");
        System.out.println("Default Controller Battery: " + defaultController.batteryLevel);
        System.out.println("Custom Controller Battery: " + customController.batteryLevel);
        System.out.println("Convenience Controller Battery: " + convenienceController.batteryLevel);
    }
}
