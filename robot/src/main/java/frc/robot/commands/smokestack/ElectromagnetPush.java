package frc.robot.commands.smokestack;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Electromagnet;

public class ElectromagnetPush extends CommandBase {
    Electromagnet electromagnet;

    public ElectromagnetPush(Electromagnet electromagnet) {
        this.electromagnet = electromagnet;
    }
    
    @Override
    public void initialize() {
        electromagnet.push();
    }

    @Override
    public void end(boolean isInterrupted) {
        electromagnet.neutral();
    }
}
