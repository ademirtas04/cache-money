package frc.robot;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.Autonomous;
import frc.robot.commands.WheelColorIdentification;

//XYAB will be used for the pixycam, bumpers and triggers for arm control
public class OI {
    private XboxController driveController;
    private Button greenButton;
    private Button redButton;
    private Button blueButton;
    private Button yellowButton;
    private Button LeftTrigButton;
    private Button RightTrigButton;
    private Button LeftBumpButton;
    private Button RightBumpButton;



    public OI() {
        driveController = new XboxController(RobotMap.DRIVER_CONTROLLER);

        //COLOR BUTTONS
        greenButton = new JoystickButton(driveController, RobotMap.BUTTON_GREEN);
        greenButton.whenPressed(new WheelColorIdentification(1));

        redButton = new JoystickButton(driveController, RobotMap.BUTTON_RED);
        redButton.whenPressed(new WheelColorIdentification(2));

        blueButton = new JoystickButton(driveController, RobotMap.BUTTON_BLUE);
        blueButton.whenPressed(new WheelColorIdentification(3));

        yellowButton = new JoystickButton(driveController, RobotMap.BUTTON_YELLOW);
        yellowButton.whenPressed(new WheelColorIdentification(4));

        //MISCELLANEOUS BUTTONS
        LeftTrigButton = new JoystickButton(driveController, RobotMap.BUTTON_LEFTTRIG);
        RightTrigButton = new JoystickButton(driveController, RobotMap.BUTTON_RIGHTTRIG);
        LeftBumpButton = new JoystickButton(driveController, RobotMap.BUTTON_LEFTBUMP);
        RightBumpButton = new JoystickButton(driveController, RobotMap.BUTTON_RIGHTBUMP);
    }

}