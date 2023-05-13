package frc.robot.commands.drive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.Drive;
import util.math.DreadbotMath;

public class DriveCommand extends CommandBase {
    private Drive drive;
    private final DoubleSupplier joystickForwardAxis;
    private final DoubleSupplier joystickRotationalAxis;
    private final SlewRateLimiter driveSlew = new SlewRateLimiter(DriveConstants.SLEW_RATE);

    public DriveCommand(Drive drive, DoubleSupplier joystickForwardAxis, DoubleSupplier joystickRotationalAxis) {
        this.drive = drive;
        this.joystickForwardAxis = joystickForwardAxis;
        this.joystickRotationalAxis = joystickRotationalAxis;
        addRequirements(drive);
    }

    @Override
    public void execute() {
        
        double forwardSpeed = drive.brushedDriveSlew(joystickForwardAxis.getAsDouble());
        SmartDashboard.putNumber("speed", forwardSpeed);
        SmartDashboard.putNumber("turn", joystickRotationalAxis.getAsDouble() * DriveConstants.SPEED_LIMITER);

        drive.arcadeDrive(forwardSpeed, joystickRotationalAxis.getAsDouble() * DriveConstants.SPEED_LIMITER);
    }
}
