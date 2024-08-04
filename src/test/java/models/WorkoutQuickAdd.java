package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class WorkoutQuickAdd {
    private String date;
    private String time;
    private String activityType;
    private String workoutName;
    private String workoutDescription;
    private boolean showPlanned;
    private String plannedDistance;
    private String plannedDistanceType;
    private String plannedDuration;
    private String distance;
    private String distType;
    private String duration;
    private String pace;
    private String paceType;
    private String howIFelt;
    private String perceivedEffort;
    private String postDesc;
    private boolean saveLibrary;
}

