package models;

import com.github.javafaker.Faker;

public class WorkoutQuickAddFactory {

    static Faker faker = new Faker();

    public static WorkoutQuickAdd fillWorkoutQuickData() {
        return WorkoutQuickAdd.builder()
                .date("24/07/2024")
                .time("06:15 AM")
                .activityType("Run")
                .workoutName(faker.gameOfThrones().character())
                .workoutDescription(faker.gameOfThrones().quote())
                .showPlanned(faker.random().nextBoolean())
                .plannedDistanceType("mi")
                .plannedDistance(faker.random().nextInt(2, 15).toString())
                .plannedDuration("01:48:22")
                .distance(faker.random().nextInt(2, 15).toString())
                .distType("mi")
                .duration("01:22:22")
                .pace("15:47")
                .paceType("kph")
                .howIFelt("Good")
                .perceivedEffort("1 (Very Light)")
                .postDesc(faker.gameOfThrones().quote())
                .saveLibrary(true)
                .build();
    }
}
