package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.EnhancedFunctions_SELECTED.OptimizedGamepad;
import org.firstinspires.ftc.teamcode.EnhancedFunctions_SELECTED.TeleOpBaseOpMode;
import org.firstinspires.ftc.teamcode.EnhancedFunctions_SELECTED.TickrateChecker;

@TeleOp (name = "V1BotTeleOp", group = "AAAA_Robot")
public class V1BotTeleOp extends TeleOpBaseOpMode {

    private final Intake intake = new Intake();
    private final Shooter shooter = new Shooter();
    private final Drive mecanumDrive = new Drive();

    public static boolean PLAYER_DRIVE_ENABLE_STATE = true;

    @Override
    public void runOpMode() {

        initializeDevices();

        controller1 = new OptimizedGamepad(gamepad1);
        controller2 = new OptimizedGamepad(gamepad2);

        applyComponentTraits();

        intake.provideComponents(super.intake, intakeBelt, controller2);
        shooter.provideComponents(leftShooter, rightShooter, intakeBelt, aim, feeder, controller2);
        mecanumDrive.provideComponents(left_front, right_front, left_back, right_back, controller1);

        setUpLynxModule();

        if (isStopRequested()) return;
        waitForStart();

        runRobotReset();

        while (opModeIsActive()) {

            TickrateChecker.startOfLoop();

            intake.update();
            shooter.update();
            mecanumDrive.update(PLAYER_DRIVE_ENABLE_STATE);

            /*lynx module*/ clearCacheOfLynxModule();

            TickrateChecker.endOfLoop();
            telemetry.addData("Tick rate", TickrateChecker.getTimePerTick());

            telemetry.update();

            if(isStopRequested()) {
                //end
                closeLynxModule();
            }
        }
    }
}
