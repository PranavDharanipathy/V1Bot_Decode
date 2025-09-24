package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.EnhancedFunctions_SELECTED.BasicVeloMotor;
import org.firstinspires.ftc.teamcode.EnhancedFunctions_SELECTED.OptimizedGamepad;

public class Shooter {


    private BasicVeloMotor leftShooter;
    private BasicVeloMotor rightShooter;

    private BasicVeloMotor intakeBelt;

    private Servo aim;
    private Servo feeder;

    private OptimizedGamepad controller;

    public void provideComponents(BasicVeloMotor leftShooter, BasicVeloMotor rightShooter, BasicVeloMotor intakeBelt, Servo aim, Servo feeder, OptimizedGamepad controller) {

        this.leftShooter = leftShooter;
        this.rightShooter = rightShooter;

        this.intakeBelt = intakeBelt;

        this.aim = aim;
        this.feeder = feeder;
    }

    private boolean spinToggle = true;

    public void update() {

        if (controller.booleans.hasJustBeenPressed(OptimizedGamepad.GAMEPAD_BOOLS.X)) {

            if (spinToggle) {

                spin(Constants.SHOOTER_VELOCITY);
            }
            else {

                spin(0);
            }

            spinToggle = !spinToggle;
        }
    }

    private void spin(double shooterVelocity) {

        leftShooter.setVelocity(shooterVelocity);
        rightShooter.setVelocity(shooterVelocity);
    }

}
