package anticope.rejects.modules;

import anticope.rejects.MeteorRejectsAddon;
import meteordevelopment.meteorclient.events.world.CollisionShapeEvent;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.shape.VoxelShapes;

public class Prone extends Module {

    public Prone() {
        super(MeteorRejectsAddon.CATEGORY, "prone", "Become prone on demand.");
    }

    @EventHandler
    private void onCollisionShape(CollisionShapeEvent event) {
        if (mc.world == null || mc.player == null || event.pos == null) return;
        if (event.state == null) return;
    
        if (event.pos.getY() != mc.player.getY() + 1) return;

        event.shape = VoxelShapes.fullCube();
    }
}
