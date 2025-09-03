public class AudioMixer {
    private String mixerModel;
    private int numberOfChannels;
    private boolean hasBluetoothConnectivity;
    private double maxVolumeDecibels;
    private String[] connectedDevices;
    private int deviceCount;

    // No-argument constructor
    public AudioMixer() {
        // Call three-parameter constructor with default values
        this("StandardMix-8", 8, false);
        System.out.println("No-arg constructor executed.");
    }

    // Two-parameter constructor
    public AudioMixer(String mixerModel, int numberOfChannels) {
        // Call three-parameter constructor with bluetooth disabled
        this(mixerModel, numberOfChannels, false);
        System.out.println("Two-parameter constructor executed.");
    }

    // Three-parameter constructor
    public AudioMixer(String mixerModel, int numberOfChannels, boolean hasBluetoothConnectivity) {
        // Call main constructor with default max volume (120.0 dB)
        this(mixerModel, numberOfChannels, hasBluetoothConnectivity, 120.0);
        System.out.println("Three-parameter constructor executed.");
    }

    // Main constructor - all parameters
    public AudioMixer(String mixerModel, int numberOfChannels, boolean hasBluetoothConnectivity, double maxVolumeDecibels) {
        this.mixerModel = mixerModel;
        this.numberOfChannels = numberOfChannels;
        this.hasBluetoothConnectivity = hasBluetoothConnectivity;
        this.maxVolumeDecibels = maxVolumeDecibels;
        this.connectedDevices = new String[numberOfChannels];
        this.deviceCount = 0;
        System.out.println("Main constructor executed with model: " + mixerModel);
    }

    public void connectDevice(String deviceName) {
        if (deviceCount < connectedDevices.length) {
            connectedDevices[deviceCount] = deviceName;
            deviceCount++;
            System.out.println("Connected: " + deviceName);
        } else {
            System.out.println("All channels occupied!");
        }
    }

    public void displayMixerStatus() {
        System.out.println("\n=== " + mixerModel + " STATUS ===");
        System.out.println("Channels: " + numberOfChannels);
        System.out.println("Bluetooth: " + (hasBluetoothConnectivity ? "Enabled" : "Disabled"));
        System.out.println("Max Volume: " + maxVolumeDecibels + " dB");
        System.out.println("Connected Devices: " + deviceCount + "/" + numberOfChannels);
        for (int i = 0; i < deviceCount; i++) {
            System.out.println(" Channel " + (i + 1) + ": " + connectedDevices[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== AudioMixer Test ===");

        AudioMixer mixer1 = new AudioMixer(); // No-arg
        mixer1.connectDevice("Microphone");
        mixer1.connectDevice("Guitar");
        mixer1.displayMixerStatus();

        AudioMixer mixer2 = new AudioMixer("ProMix-16", 16); // Two-parameter
        mixer2.connectDevice("Keyboard");
        mixer2.displayMixerStatus();

        AudioMixer mixer3 = new AudioMixer("UltraMix-24", 24, true); // Three-parameter
        mixer3.connectDevice("Drums");
        mixer3.displayMixerStatus();

        AudioMixer mixer4 = new AudioMixer("MaxMix-32", 32, true, 130.0); // Main constructor
        mixer4.displayMixerStatus();
    }
}
