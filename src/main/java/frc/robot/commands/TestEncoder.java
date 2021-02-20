/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import frc.robot.subsystems.Climb;


public class TestEncoder extends Command {


//public Encoder encoder = new Encoder(RobotMap.ENCODER2_PORT_A, RobotMap.ENCODER2_PORT_B, true, EncodingType.k4X);
  public static double startTime = 0;
  public static boolean done = false;
  public boolean initialized = false;
  public Encoder liftEncoder;
  public Encoder winchEncoder;
  public VictorSPX liftMotor;
  public VictorSPX winchMotor;
  public int direction=0;
  private double minsetpoint;
  private double maxsetpoint;
  private int iterations = 0;
  private double setpoint = 2;
  private double previousDistance = 0;
  private double distance = 0;
  private double rate = 0;
  private double lastTimestamp = 0;
  public TestEncoder(/*Encoder encoder1, Encoder encoder2, VictorSPX lift, VictorSPX winch, int d, double minsetpoint, double maxsetpoint*/){
    System.out.println("Constructing");
    /*this.liftEncoder = encoder1;
    this.winchEncoder = encoder2;
    this.liftMotor = lift;
    this.winchMotor = winch;
    if(d==0){
      liftEncoder.reset();
      winchEncoder.reset();
    } else {
      this.direction = d;
    }
    this.minsetpoint = minsetpoint;
    this.maxsetpoint = maxsetpoint;
    */
    requires(Robot.testClimb);

  }

  @Override
  public void start() {
    //System.out.println(Timer.getFPGATimestamp());
    if(!initialized){
      liftEncoder = Climb.getLiftEncoder();
      // Encoder now counts the number of revolutions
      liftEncoder.setDistancePerPulse(1/2048);
    }
    //Test Two: Testing if encoder counts the absolute value of the distance traveled or is direction-based
    /*
    if(iterations < 10) {
      Climb.getLiftMotor().set(ControlMode.PercentOutput, 0.75); // remember to comment out the other set
    } else if (iterations < 20 && iterations >= 10) {
      Climb.getLiftMotor().set(ControlMode.PercentOutput, -0.75);
    }
    */
    Climb.getLiftMotor().set(ControlMode.PercentOutput, 0.75);
    
    //Test One: Testing if encoder counts revolutions, rate, and sees what the motor's -1.0 to 1.0 sets the velocity to
    System.out.println("Distance: " + liftEncoder.getDistance());
    System.out.println("Rate: " + liftEncoder.getRate());

    //Test Three: Begin to use PID to simulate motion + movement - assuming it is not absolute value
    /*distance = liftEncoder.getDistance() * RobotMap.kDriveTick2Feet;

    rate = (distance - previousDistance) / (Timer.getFPGATimestamp() - lastTimestamp);
    lastTimestamp = Timer.getFPGATimestamp();

    //We can add the Integral term later - that one will need more knowledge of what we're doing and how encoders work
    double outputSpeed = RobotMap.kP * distance + RobotMap.kD * rate;
    Climb.getLiftMotor().set(ControlMode.PercentOutput, outputSpeed)
    distance = previousDistance;
    */
    iterations++;
  }

  @Override
  public void cancel(){
    Climb.getLiftMotor().set(ControlMode.PercentOutput, 0);
    liftEncoder.reset();
    super.cancel();
    //once we get to testing PID, set all the values here to 0
  }

  @Override
  protected boolean isFinished() {
   
    return false;
  }


}
