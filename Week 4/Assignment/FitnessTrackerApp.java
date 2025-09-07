public class FitnessTrackerApp {

    // Workout class
    static class Workout {
        String activityName;
        int durationInMinutes;
        int caloriesBurned;

        // 1. Default constructor
        public Workout() {
            this.activityName = "Walking";
            this.durationInMinutes = 30;
            this.caloriesBurned = 100;
        }

        // 2. Constructor with activity name
        public Workout(String activityName) {
            this.activityName = activityName;
            this.durationInMinutes = 30;
            this.caloriesBurned = 150; // example default calories
        }

        // 3. Constructor with activity name and duration
        public Workout(String activityName, int durationInMinutes) {
            this.activityName = activityName;
            this.durationInMinutes = durationInMinutes;
            this.caloriesBurned = durationInMinutes * 5; // 5 calories per minute
        }

        // Method: displayWorkout()
        public void displayWorkout() {
            System.out.println("🏋️ Workout Summary:");
            System.out.println("Activity Name     : " + activityName);
            System.out.println("Duration (minutes): " + durationInMinutes);
            System.out.println("Calories Burned   : " + caloriesBurned);
            System.out.println("--------------------------------");
        }
    }

    // main method
    public static void main(String[] args) {
        // Workout 1: Default
        Workout w1 = new Workout();
        w1.displayWorkout();

        // Workout 2: Activity name only
        Workout w2 = new Workout("Cycling");
        w2.displayWorkout();

        // Workout 3: Activity and duration
        Workout w3 = new Workout("Running", 45);
        w3.displayWorkout();

        // Workout 4: Custom workout
        Workout w4 = new Workout("Swimming", 60);
        w4.displayWorkout();
    }
}
