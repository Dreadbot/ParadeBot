// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Constants.DriveConstants;
import frc.robot.commands.drive.DriveCommand;
import frc.robot.commands.smokestack.ElectromagnetCommand;
import frc.robot.commands.smokestack.ElectromagnetPull;
import frc.robot.commands.smokestack.ElectromagnetPush;
import frc.robot.commands.sound.CannonSound;
import frc.robot.commands.sound.RickRollSound;
import frc.robot.commands.sound.BattleReadySound;
import frc.robot.commands.sound.SetToCourseSound;
import frc.robot.commands.turret.TurretCommand;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Electromagnet;
import frc.robot.subsystems.SoundSystem;
import frc.robot.subsystems.Turret;
import util.controls.DreadbotController;

public class RobotContainer {
  DreadbotController primaryController = new DreadbotController(0);
  Electromagnet electromagnet = new Electromagnet();
  DreadbotController secondaryController = new DreadbotController(1);
  Drive drive = new Drive(DriveConstants.LEFT_MOTOR_ID, DriveConstants.RIGHT_MOTOR_ID);
  Turret turret = new Turret();
  SoundSystem soundSystem = new SoundSystem();

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    DriveCommand driveCommand = new DriveCommand(drive, primaryController::getYAxis, primaryController::getZAxis);
    drive.setDefaultCommand(driveCommand);
    TurretCommand turretComand = new TurretCommand(turret, secondaryController::getXAxis);
    turret.setDefaultCommand(turretComand);
    ElectromagnetCommand electromagnetCommand = new ElectromagnetCommand(electromagnet);
    electromagnet.setDefaultCommand(electromagnetCommand);
    primaryController.getBButton().whileTrue(new CannonSound(soundSystem));
    primaryController.getXButton().whileTrue(new BattleReadySound(soundSystem));
    primaryController.getYButton().whileTrue(new SetToCourseSound(soundSystem));
    primaryController.getAButton().whileTrue(new RickRollSound(soundSystem));
    secondaryController.getAButton().whileTrue(new ElectromagnetPull(electromagnet));
    secondaryController.getBButton().whileTrue(new ElectromagnetPush(electromagnet));
  }
}
