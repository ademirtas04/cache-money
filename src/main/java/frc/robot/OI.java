package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.WheelColorIdentification;
import frc.robot.commands.WheelColorRotation;
import frc.robot.commands.WheelRotation;

//XYAB will be used for the pixycam, bumpers and triggers for arm control
public class OI {
    private XboxController xbox;
    private Joystick joystick;
    private Button greenButton;
    private Button redButton;
    private Button blueButton;
    private Button yellowButton;
    private Button LeftTrigButton;
    private Button RightTrigButton;
    private Button LeftBumpButton;
    private Button RightBumpButton;



    public OI() {
        //Drive Controllers
        xbox = new XboxController(RobotMap.DRIVER_CONTROLLER);
        joystick = new Joystick(RobotMap.BUTTON_CONTROLLER);

        //COLOR BUTTONS
        greenButton = new JoystickButton(xbox, RobotMap.BUTTON_GREEN);
        greenButton.whenPressed(new WheelColorIdentification(1));

        redButton = new JoystickButton(xbox, RobotMap.BUTTON_RED);
        redButton.whenPressed(new WheelColorIdentification(2));

        blueButton = new JoystickButton(xbox, RobotMap.BUTTON_BLUE);
        blueButton.whenPressed(new WheelColorIdentification(3));

        yellowButton = new JoystickButton(xbox, RobotMap.BUTTON_YELLOW);
        yellowButton.whenPressed(new WheelColorIdentification(4));

        //WHEEL ROTATION BUTTONS
        LeftTrigButton = new JoystickButton(xbox, RobotMap.BUTTON_LEFTTRIG);
        LeftTrigButton.whenPressed(new WheelColorRotation());
        RightTrigButton = new JoystickButton(xbox, RobotMap.BUTTON_RIGHTTRIG);
        RightTrigButton.whenPressed(new WheelRotation(4));


        LeftBumpButton = new JoystickButton(xbox, RobotMap.BUTTON_LEFTBUMP);
        RightBumpButton = new JoystickButton(xbox, RobotMap.BUTTON_RIGHTBUMP);
    }

}