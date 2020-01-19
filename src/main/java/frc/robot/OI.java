package frc.robot;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.WheelRotationSequence;


public class OI {
    private final XboxController driveController = new XboxController(RobotMap.DRIVER_CONTROLLER);
    Button xButton = new JoystickButton(driveController, RobotMap.BUTTON_X);


    public OI() {
        xButton.whenPressed(new WheelRotationSequence());
    }


    public double getDriverRawAxis(int axis) {
        return driveController.getRawAxis(axis);
    }

}