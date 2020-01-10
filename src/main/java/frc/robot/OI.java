package frc.robot;

import edu.wpi.first.wpilibj.Joystick;


public class OI {

    private Joystick driverController = new Joystick(RobotMap.DRIVER_CONTROLLER);

    public double getDriverRawAxis(int axis){
        return driverController.getRawAxis(axis);
    }

}