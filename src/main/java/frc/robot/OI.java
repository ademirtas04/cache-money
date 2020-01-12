package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import frc.robot.commands.MoveSequence;
import frc.robot.commands.NewMove;

public class OI {


    private final Joystick driveController = new Joystick(RobotMap.DRIVER_CONTROLLER);
    JoystickButton xButton = new JoystickButton(driveController,RobotMap.BUTTON_X);

    public OI(){
        xButton.whenPressed(new MoveSequence());
    }

    public double getDriverRawAxis(int axis) {
        return driveController.getRawAxis(axis);
    }

}