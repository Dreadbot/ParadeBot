package frc.robot.commands.smokestack;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Electromagnet;

public class ElectromagnetCommand extends CommandBase {
    private Electromagnet electromagnet;

    private long lastCycleTime = System.currentTimeMillis();
    private int skippedCycles = 0;
    private boolean pushing = true;

    public ElectromagnetCommand(Electromagnet electromagnet) {
        this.electromagnet = electromagnet;
        addRequirements(electromagnet);
    }

    @Override
    public void execute() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastCycleTime < 300)
            return;
        lastCycleTime = currentTime;
        if (pushing && skippedCycles == 2) {
            electromagnet.pull();
            skippedCycles = 0;
            pushing = false;
        } else {
            electromagnet.push();
            pushing = true;
            skippedCycles++;
        }
    }
}
