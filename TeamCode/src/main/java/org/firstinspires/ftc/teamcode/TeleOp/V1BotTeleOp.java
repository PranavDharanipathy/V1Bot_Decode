package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.EnhancedFunctions_SELECTED.OptimizedGamepad;
import org.firstinspires.ftc.teamcode.EnhancedFunctions_SELECTED.TeleOpBaseOpMode;
import org.firstinspires.ftc.teamcode.EnhancedFunctions_SELECTED.TickrateChecker;

@TeleOp (name = "V1BotTeleOp", group = "AAAA_Robot")
public class V1BotTeleOp extends TeleOpBaseOpMode {

    private final Intake intake = new Intake();
    private final Shooter shooter = new Shooter();

    @Override
    public void runOpMode() {

        initializeDevices();
        applyComponentTraits();

        intake.provideComponents(super.intake, intakeBelt, controller2);
        shooter.provideComponents(leftShooter, rightShooter, intakeBelt, aim, feeder, controller2);

        setUpLynxModule();

        if (isStopRequested()) return;
        waitForStart();

        runRobotReset();

        while (opModeIsActive()) {

            TickrateChecker.startOfLoop();

            intake.update();
            shooter.update();

            /*lynx module*/ clearCacheOfLynxModule();

            TickrateChecker.endOfLoop();
            telemetry.addData("Tick rate", TickrateChecker.getTimePerTick());

            telemetry.update();
        }

        //end
        closeLynxModule();
    }
}
