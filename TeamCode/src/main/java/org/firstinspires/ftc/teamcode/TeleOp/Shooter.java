package org.firstinspires.ftc.teamcode.TeleOp;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.EnhancedFunctions_SELECTED.BasicVeloMotor;
import org.firstinspires.ftc.teamcode.EnhancedFunctions_SELECTED.OptimizedGamepad;
import org.firstinspires.ftc.teamcode.commands.ShooterCommand;

@Config
public class Shooter {


    private BasicVeloMotor leftShooter;
    private BasicVeloMotor rightShooter;

    private BasicVeloMotor intakeBelt;

    private Servo aim;
    private Servo feeder;

    private OptimizedGamepad controller;

    private ShooterCommand shootCommand = new ShooterCommand();

    public void provideComponents(BasicVeloMotor leftShooter, BasicVeloMotor rightShooter, BasicVeloMotor intakeBelt, Servo aim, Servo feeder, OptimizedGamepad controller) {

        this.controller = controller;

        this.leftShooter = leftShooter;
        this.rightShooter = rightShooter;

        this.intakeBelt = intakeBelt;

        this.aim = aim;
        this.feeder = feeder;
    }

    private boolean spinToggle = true;


    public void update() {

        shootCommand.checkTriggered(controller.booleans.hasJustBeenPressed(OptimizedGamepad.GAMEPAD_BOOLS.Y));

        if (controller.booleans.dpad_up()) aim.setPosition(aim.getPosition() + Constants.AIM_POSITION_INCREMENT);
        else if (controller.booleans.dpad_down()) aim.setPosition(aim.getPosition() - Constants.AIM_POSITION_INCREMENT);

        if (controller.booleans.hasJustBeenPressed(OptimizedGamepad.GAMEPAD_BOOLS.X)) {

            if (spinToggle) {

                spin(Constants.SHOOTER_VELOCITY);
            }
            else {

                spin(0);
            }

            spinToggle = !spinToggle;
        }

        shootCommand.runInstance(intakeBelt, feeder);
    }

    private void spin(double shooterVelocity) {

        leftShooter.setVelocity(shooterVelocity);
        rightShooter.setVelocity(shooterVelocity);
    }

}
