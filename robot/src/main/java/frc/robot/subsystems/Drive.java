package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants.DriveConstants;
import util.math.DreadbotMath;
import util.misc.DreadbotSubsystem;

public class Drive extends DreadbotSubsystem {
    private DifferentialDrive diffDrive;
    private WPI_TalonSRX leftMotor;
    private WPI_TalonSRX rightMotor;
    private SlewRateLimiter driveSlew;

    public Drive(int leftMotorId, int rightMotorId) {
        leftMotor = new WPI_TalonSRX(leftMotorId);
        rightMotor = new WPI_TalonSRX(rightMotorId);
        leftMotor.setInverted(true);
        diffDrive = new DifferentialDrive(this.leftMotor, this.rightMotor);
        driveSlew = new SlewRateLimiter(DriveConstants.SLEW_RATE);
    }

    public void arcadeDrive(double xSpeed, double zRotation) {
        diffDrive.arcadeDrive(xSpeed, zRotation);
    }
    public double brushedDriveSlew(double joystickSpeed) {
        double interpolatedJoystick = Math.signum(joystickSpeed) * DreadbotMath.linearInterpolation(DriveConstants.MIN_SPEED, DriveConstants.SPEED_LIMITER, Math.abs(joystickSpeed));
        double forwardSpeed = driveSlew.calculate(interpolatedJoystick);
        if(Math.signum(joystickSpeed) > 0 && forwardSpeed > -DriveConstants.MIN_SPEED && forwardSpeed < DriveConstants.MIN_SPEED) {
            driveSlew.reset(DriveConstants.MIN_SPEED);
        } else if(Math.signum(joystickSpeed) < 0 && forwardSpeed > -DriveConstants.MIN_SPEED && forwardSpeed < DriveConstants.MIN_SPEED) {
            driveSlew.reset(-DriveConstants.MIN_SPEED);
        }
        return forwardSpeed;

    }
    @Override
    public void close() {
        stopMotors();
        leftMotor.close();
        rightMotor.close();
    }
    
    @Override
    public void stopMotors() {
        arcadeDrive(0, 0);
    }
}
