package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@Config
@TeleOp (group = "testing")
public class SpinServoToZero extends OpMode {

    public static String servoName;

    public static Servo.Direction servoDirection;

    private Servo servo;

    @Override
    public void init() {

        servo = hardwareMap.get(Servo.class, servoName);
        servo.setDirection(servoDirection);
    }

    @Override
    public void start() {

        servo.setPosition(0);
    }

    public void loop() {}
}
