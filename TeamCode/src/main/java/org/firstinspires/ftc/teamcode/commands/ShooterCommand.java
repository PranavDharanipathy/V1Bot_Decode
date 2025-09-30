package org.firstinspires.ftc.teamcode.commands;

import com.acmerobotics.dashboard.config.Config;
import com.chaigptrobotics.specifics.CommandDaddy;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.EnhancedFunctions_SELECTED.BasicVeloMotor;

import java.util.concurrent.atomic.AtomicBoolean;

@Config
public class ShooterCommand extends CommandDaddy {

    public static double[] INTAKE_BELT_TIMES = {150, 400};

    public static double[] SHOOT_COMMAND_TIMES = {1450, 1450};

    private int shootStages;
    private ElapsedTime shootTimer = new ElapsedTime();

    private AtomicBoolean shootCommand = new AtomicBoolean(false);

    @Override
    public synchronized void checkTriggered(boolean commandTrigger) {

        shootCommand.set(commandTrigger);
    }

    public synchronized void runInstance(BasicVeloMotor intakeBelt, Servo feeder) {

        double shootTime = shootTimer.milliseconds();


        switch (shootStages) {

            case 1:

                feeder.setPosition(Constants.FEEDER_FEED_TO_SHOOTER_POSITION);

                if (shootTime >= INTAKE_BELT_TIMES[0] && shootTime <= INTAKE_BELT_TIMES[1]) intakeBelt.setVelocity(Constants.INTAKE_BELT_FEED_VELOCITY);
                else intakeBelt.setVelocity(0);

                if (shootTime >= SHOOT_COMMAND_TIMES[0]) shootStages++;

                break;

            case 2:

                intakeBelt.setVelocity(0);

                feeder.setPosition(Constants.FEEDER_RESET_POSITION);

                if (shootTime >= SHOOT_COMMAND_TIMES[1]) shootStages++;

                break;

            case 0: //case run when shoot has not been commanded

                if (feeder.getPosition() != Constants.FEEDER_RESET_POSITION) {
                    feeder.setPosition(Constants.FEEDER_RESET_POSITION);
                }
            //triggering
            default:

                if (shootCommand.get()) {

                    shootTimer.reset();
                    shootStages = 1;
                }
                else {
                    shootStages = 0;
                }
        }

    }

}
