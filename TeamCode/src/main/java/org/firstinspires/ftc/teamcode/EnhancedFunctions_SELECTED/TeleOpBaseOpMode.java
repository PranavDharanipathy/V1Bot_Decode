package org.firstinspires.ftc.teamcode.EnhancedFunctions_SELECTED;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;

import java.util.List;

public abstract class TeleOpBaseOpMode extends LinearOpMode {

    public TeleOpBaseOpMode() {}

    public OptimizedGamepad controller1;
    public OptimizedGamepad controller2;

    //drive
    public volatile DcMotor left_front, right_front, left_back, right_back;

    //other
    public volatile BasicVeloMotor rightShooter, leftShooter, intake, intakeBelt;

    public volatile Servo feeder, aim;

    private volatile List<LynxModule> robotHubs;

    /// initializes/creates LynxModule
    public void setUpLynxModule() {

        robotHubs = hardwareMap.getAll(LynxModule.class);

        for (LynxModule hub : robotHubs) {
            hub.setBulkCachingMode(Constants.MapSetterConstants.bulkCachingMode);
        }
    }

    /// Clears cache of LynxModule
    public void clearCacheOfLynxModule() {

        for (LynxModule hub : robotHubs) {
            hub.clearBulkCache();
        }
    }

    /// Closes LynxModule
    public void closeLynxModule() {

        for (LynxModule hub : robotHubs) {
            hub.close();
        }
    }

    /// Initializing devices
    public void initializeDevices() {

        controller1 = new OptimizedGamepad(gamepad1);
        controller2 = new OptimizedGamepad(gamepad2);

        left_front = hardwareMap.get(DcMotor.class, Constants.MapSetterConstants.leftFrontMotorDeviceName);
        right_front = hardwareMap.get(DcMotor.class, Constants.MapSetterConstants.rightFrontMotorDeviceName);
        left_back = hardwareMap.get(DcMotor.class, Constants.MapSetterConstants.leftBackMotorDeviceName);
        right_back = hardwareMap.get(DcMotor.class, Constants.MapSetterConstants.rightBackMotorDeviceName);

        intake = new BasicVeloMotor(hardwareMap, Constants.MapSetterConstants.intakeMotorDeviceName);
        intakeBelt = new BasicVeloMotor(hardwareMap, Constants.MapSetterConstants.intakeBeltMotorDeviceName);
        leftShooter = new BasicVeloMotor(hardwareMap, Constants.MapSetterConstants.leftShooterMotorDeviceName);
        rightShooter = new BasicVeloMotor(hardwareMap, Constants.MapSetterConstants.rightShooterMotorDeviceName);

        feeder = hardwareMap.get(Servo.class, Constants.MapSetterConstants.feederServoDeviceName);
        aim = hardwareMap.get(Servo.class, Constants.MapSetterConstants.aimServoDeviceName);
    }

    /// Provide traits
    public void applyComponentTraits() {

        intake.setVelocityPIDFCoefficients(
                Constants.INTAKE_COEFFICIENTS[0],
                Constants.INTAKE_COEFFICIENTS[1],
                Constants.INTAKE_COEFFICIENTS[2],
                Constants.INTAKE_COEFFICIENTS[3]
        );
        intakeBelt.setVelocityPIDFCoefficients(
                Constants.INTAKE_BELT_COEFFICIENTS[0],
                Constants.INTAKE_BELT_COEFFICIENTS[1],
                Constants.INTAKE_BELT_COEFFICIENTS[2],
                Constants.INTAKE_BELT_COEFFICIENTS[3]
        );

        leftShooter.setVelocityPIDFCoefficients(
                Constants.SHOOTER_COEFFICIENTS[0],
                Constants.SHOOTER_COEFFICIENTS[1],
                Constants.SHOOTER_COEFFICIENTS[2],
                Constants.SHOOTER_COEFFICIENTS[3]
        );
        rightShooter.setVelocityPIDFCoefficients(
                Constants.SHOOTER_COEFFICIENTS[0],
                Constants.SHOOTER_COEFFICIENTS[1],
                Constants.SHOOTER_COEFFICIENTS[2],
                Constants.SHOOTER_COEFFICIENTS[3]
        );

        intake.setDirection(DcMotorSimple.Direction.REVERSE);
        intakeBelt.setDirection(DcMotorSimple.Direction.REVERSE);

        leftShooter.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    /// resets robot components to their proper starting positions
    public void runRobotReset() {

        aim.setPosition(Constants.AIM_MAX_POSITION);

        sleep(1000);

        feeder.setPosition(Constants.FEEDER_RESET_POSITION);

        sleep(200);
    }

}