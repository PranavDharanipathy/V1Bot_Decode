package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.hardware.lynx.LynxModule;

@Config
public final class Constants {

    public static class DriveConstants {

    }

    public static class CameraSystemConstants {

    }

    ///for bot motor/servo/sensor setting (excluding camera, camera will be in it's own constants nested class
    /// no traits such as Direction or ZeroPowerBehavior
    public static class MapSetterConstants {

        public static String leftFrontMotorDeviceName = "lf";
        public static String rightFrontMotorDeviceName = "rf";
        public static String leftBackMotorDeviceName = "lb";
        public static String rightBackMotorDeviceName = "rb";
        public static String rightShooterMotorDeviceName = "right_shooter";
        public static String leftShooterMotorDeviceName = "left_shooter";
        public static String intakeBeltMotorDeviceName = "intake_belt";
        public static String intakeMotorDeviceName = "intake";

        public static String feederServoDeviceName = "feeder";
        public static String aimServoDeviceName = "shooter_servo";

        public static LynxModule.BulkCachingMode bulkCachingMode = LynxModule.BulkCachingMode.MANUAL;
    }

    //OTHER CONSTANTS

    public static double FEEDER_RESET_POSITION = 0;
    public static double FEEDER_FEED_TO_SHOOTER_POSITION = 1;

    /// As high of an angle bot can shoot at.
    public static double AIM_MIN_POSSIBLE_POSITION = 0.36;
    /// As low of an angle bot can shoot at.
    public static double AIM_MAX_POSSIBLE_POSITION = 0.425;
    /// As high of an angle bot is allowed to shoot at.
    public static double AIM_MIN_POSITION = 0.16;
    /// As low of an angle bot is allowed shoot at.
    public static double AIM_MAX_POSITION = 0.425;

    //                                              {p,i,d,f}
    public static double[] SHOOTER_COEFFICIENTS = {24,1.2,1,1};
    public static double[] INTAKE_COEFFICIENTS = {38,0.1,2,1};
    public static double[] INTAKE_BELT_COEFFICIENTS = {25,0.08,3,2};

    public static double INTAKE_VELOCITY = 2000;
    public static double INTAKE_BELT_VELOCITY = 1300;

    public static double SHOOTER_VELOCITY = 3000;

    public static float JOYSTICK_MINIMUM = 0.02f;

    public static float OPTIMIZED_GAMEPAD_RT_THRESHOLD = 0.2f;
    public static float OPTIMIZED_GAMEPAD_LT_THRESHOLD = 0.2f;

}
