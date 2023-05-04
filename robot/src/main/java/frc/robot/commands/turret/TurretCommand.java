package frc.robot.commands.turret;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.TurretConstants;
import frc.robot.subsystems.Turret;

public class TurretCommand extends CommandBase {
    private Turret turret;
    private final DoubleSupplier turnAxis;
    public TurretCommand(Turret turret, DoubleSupplier turnAxis) {
        this.turnAxis = turnAxis;
        this.turret = turret;
        addRequirements(turret);
    }
    @Override
    public void execute() {
        turret.rotateTurret(turnAxis.getAsDouble() * TurretConstants.SPEED_LIMITER);
    }
    
}
