/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
public class PrintTester1 extends Command {



  // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  
  private int numPrints = 0;
  public PrintTester1() {
    
	}

// Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("INIT");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      System.out.println("EXECUTE");
      numPrints++;
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
