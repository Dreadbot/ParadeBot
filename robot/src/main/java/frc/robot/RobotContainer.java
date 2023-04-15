// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Constants.DriveConstants;
import frc.robot.commands.drive.DriveCommand;
import frc.robot.commands.sound.RickRollSound;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.SoundSystem;
import util.controls.DreadbotController;

public class RobotContainer {
  DreadbotController primaryController = new DreadbotController(0);
  Drive drive = new Drive(DriveConstants.LEFT_MOTOR_ID, DriveConstants.RIGHT_MOTOR_ID);
  SoundSystem soundSystem = new SoundSystem();

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    DriveCommand driveCommand = new DriveCommand(drive, primaryController::getYAxis, primaryController::getZAxis);
    drive.setDefaultCommand(driveCommand);
    primaryController.getAButton().onTrue(new RickRollSound(soundSystem));
  }
}
