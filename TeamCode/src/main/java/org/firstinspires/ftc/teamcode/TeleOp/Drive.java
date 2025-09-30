package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.EnhancedFunctions_SELECTED.OptimizedGamepad;

public class Drive {

    private DcMotor left_front, right_front, left_back, right_back;

    private OptimizedGamepad controller;

    public void provideComponents(DcMotor left_front, DcMotor right_front, DcMotor left_back, DcMotor right_back, OptimizedGamepad controller) {

        this.controller = controller;

        this.left_front = left_front;
        this.left_back = left_back;
        this.right_back = right_back;
        this.right_front = right_front;
    }

    public void update(boolean enabled) {

        double lfPower = -controller.floats.left_stick_y() + controller.floats.right_stick_x() + controller.floats.left_stick_x();
        double lbPower = -controller.floats.left_stick_y() + controller.floats.right_stick_x() - controller.floats.left_stick_x();
        double rfPower = -controller.floats.left_stick_y() - controller.floats.right_stick_x() - controller.floats.left_stick_x();
        double rbPower = -controller.floats.left_stick_y() - controller.floats.right_stick_x() + controller.floats.left_stick_x();

        if (enabled) {
            left_front.setPower(Math.abs(lfPower) > Constants.DriveConstants.JOYSTICK_MINIMUM ? lfPower : 0);
            left_back.setPower(Math.abs(lbPower) > Constants.DriveConstants.JOYSTICK_MINIMUM ? lbPower : 0);
            right_front.setPower(Math.abs(rfPower) > Constants.DriveConstants.JOYSTICK_MINIMUM ? rfPower : 0);
            right_back.setPower(Math.abs(rbPower) > Constants.DriveConstants.JOYSTICK_MINIMUM ? rbPower : 0);
        }
    }
}
