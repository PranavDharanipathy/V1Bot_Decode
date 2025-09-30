package org.firstinspires.ftc.teamcode.TeleOp;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.EnhancedFunctions_SELECTED.BasicVeloMotor;
import org.firstinspires.ftc.teamcode.EnhancedFunctions_SELECTED.OptimizedGamepad;

public class Intake {

    private BasicVeloMotor intake;
    private BasicVeloMotor intakeBelt;

    private OptimizedGamepad controller;

    public void provideComponents(BasicVeloMotor intake, BasicVeloMotor intakeBelt, OptimizedGamepad controller) {

        this.controller = controller;

        this.intake = intake;
        this.intakeBelt = intakeBelt;
    }

    private boolean hasStopped = true;

    public void update() {

        if (controller.booleans.right_trigger(Constants.OPTIMIZED_GAMEPAD_RT_THRESHOLD)) {

            hasStopped = false;
            spin(Constants.INTAKE_VELOCITY, Constants.INTAKE_BELT_VELOCITY);
        }
        else if (controller.booleans.left_trigger(Constants.OPTIMIZED_GAMEPAD_LT_THRESHOLD)) {

            hasStopped = false;
            spin(Constants.REVERSE_INTAKE_VELOCITY, Constants.REVERSE_INTAKE_BELT_VELOCITY);
        }
        else if (!hasStopped) {
            spin(0,0); // only stops once
            hasStopped = true;
        }
    }

    private void spin(double intakeVelocity, double intakeBeltVelocity) {

        intake.setVelocity(intakeVelocity);
        intakeBelt.setVelocity(intakeBeltVelocity);
    }

}
