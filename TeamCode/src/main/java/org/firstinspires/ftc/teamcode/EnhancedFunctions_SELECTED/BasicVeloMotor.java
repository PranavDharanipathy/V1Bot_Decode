package org.firstinspires.ftc.teamcode.EnhancedFunctions_SELECTED;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

/// uses default PIDF because that is sufficient for a basic velocity
/// motor for spinning at a constant, stable, velocity efficiently
public class BasicVeloMotor {

    private DcMotorEx motor;

    public BasicVeloMotor(HardwareMap hardwareMap, String deviceName) {

        motor = hardwareMap.get(DcMotorEx.class, deviceName);
        motor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER); //enables velocity with PIDF ('i' (integral) is not used though)
    }

    /// not using integral
    public void setVelocityPDFCoefficients(double kp, double kd, double kf) {
        motor.setVelocityPIDFCoefficients(kp, 0, kd, kf);
    }

    public void setVelocity(double angularRate) {
        motor.setVelocity(angularRate); //ticks per second
    }

    public double getVelocity() {
        return motor.getVelocity(); //ticks per second
    }

    public double getPower() {
        return motor.getPower();
    }
}
