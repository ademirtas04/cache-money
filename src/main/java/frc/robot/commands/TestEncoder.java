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


  public Encoder encoder = new Encoder(RobotMap.ENCODER2_PORT_A, RobotMap.ENCODER2_PORT_B);
   
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
 
  public TestEncoder(Encoder encoder1, Encoder encoder2, VictorSPX lift, VictorSPX winch, int d, double minsetpoint, double maxsetpoint){
    System.out.println("Constructing");
    this.liftEncoder = encoder1;

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
    
    
    
    requires(Robot.testClimb);

  }

  @Override
  public void start(){


    
    
   
    //System.out.println(Timer.getFPGATimestamp());
    if(!initialized){
      liftEncoder = Climb.getLiftEncoder();
    }
    Climb.getLiftMotor().set(ControlMode.PercentOutput, 0.75);
    System.out.println(liftEncoder.get());
  }

  @Override
  public void cancel(){
    Climb.getLiftMotor().set(ControlMode.PercentOutput, 0);
    liftEncoder.reset();
    super.cancel();
  }

  @Override
  protected boolean isFinished() {
    //TODO Auto-generated method stub 
    return false;
  }

}
