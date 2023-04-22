package frc.robot.commands.smokestack;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Electromagnet;

public class ElectromagnetPull extends CommandBase {
    Electromagnet electromagnet;

    public ElectromagnetPull(Electromagnet electromagnet) {
        this.electromagnet = electromagnet;
    }

    @Override
    public void initialize() {
        electromagnet.pull();
    }

    @Override
    public void end(boolean isInterrupted) {
        electromagnet.neutral();
    }
}
