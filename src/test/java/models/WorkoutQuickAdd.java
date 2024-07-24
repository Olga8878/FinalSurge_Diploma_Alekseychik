package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class WorkoutQuickAdd {
    String date;
    String time;
    String activityType;
    String workoutName;
    String workoutDescription;
    boolean showPlanned;
    String plannedDistance;
    String plannedDistanceType;
    String plannedDuration;
    String distance;
    String distType;
    String duration;
    String pace;
    String paceType;
    String howIFelt;
    String perceivedEffort;
    String postDesc;
    boolean saveLibrary;

}

