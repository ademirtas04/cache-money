package frc.robot;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.WheelRotationSequence;

//XYAB will be used for the pixycam
public class OI {
    private XboxController driveController = new XboxController(RobotMap.DRIVER_CONTROLLER);
    Button greenButton = new JoystickButton(driveController, RobotMap.BUTTON_GREEN);
    Button redButton = new JoystickButton(driveController, RobotMap.BUTTON_RED);
    Button blueButton = new JoystickButton(driveController, RobotMap.BUTTON_BLUE);
    Button yellowButton = new JoystickButton(driveController, RobotMap.BUTTON_YELLOW);



    public OI() {
        greenButton.whenPressed(new WheelRotationSequence());
        redButton.whenPressed(new WheelRotationSequence());
        blueButton.whenPressed(new WheelRotationSequence());
        yellowButton.whenPressed(new WheelRotationSequence());

    }


    public double getDriverRawAxis(int axis) {
        return driveController.getRawAxis(axis);
    }

}