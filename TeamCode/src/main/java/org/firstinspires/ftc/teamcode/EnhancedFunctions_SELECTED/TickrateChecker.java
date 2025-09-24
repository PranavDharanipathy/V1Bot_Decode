package org.firstinspires.ftc.teamcode.EnhancedFunctions_SELECTED;

public class TickrateChecker {

    private static double lastTime = 0;
    private static double currentTime = 0;

    public static void startOfLoop() {
        lastTime = System.nanoTime();
    }

    public static void endOfLoop() {
        currentTime = System.nanoTime();
    }

    public static double getTimePerTick() {
        return currentTime - lastTime;
    }
}
