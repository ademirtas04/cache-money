package frc.robot;

import edu.wpi.first.wpilibj.Joystick;


public class OI {

    private final Joystick driveController = new Joystick(RobotMap.DRIVER_CONTROLLER);

    public double getDriverRawAxis(int axis) {
        return driveController.getRawAxis(axis);
    }

}