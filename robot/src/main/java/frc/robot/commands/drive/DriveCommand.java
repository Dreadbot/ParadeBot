package frc.robot.commands.drive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;
import util.math.DreadbotMath;

public class DriveCommand extends CommandBase {
    private Drive drive;
    private final DoubleSupplier joystickForwardAxis;
    private final DoubleSupplier joystickRotationalAxis;
    private final SlewRateLimiter driveSlew = new SlewRateLimiter(.5);

    public DriveCommand(Drive drive, DoubleSupplier joystickForwardAxis, DoubleSupplier joystickRotationalAxis) {
        this.drive = drive;
        this.joystickForwardAxis = joystickForwardAxis;
        this.joystickRotationalAxis = joystickRotationalAxis;
    }

    @Override
    public void execute() {
        double forwardSpeed = driveSlew.calculate(joystickForwardAxis.getAsDouble());
        drive.arcadeDrive(forwardSpeed, joystickRotationalAxis.getAsDouble());
    }
}
