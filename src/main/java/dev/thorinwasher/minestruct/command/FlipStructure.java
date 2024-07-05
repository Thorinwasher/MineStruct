package dev.thorinwasher.minestruct.command;

import dev.thorinwasher.minestruct.Registry;
import dev.thorinwasher.minestruct.struct.StructSession;
import dev.thorinwasher.minestruct.vector.Axis;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.ArgumentEnum;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FlipStructure extends Command {
    public FlipStructure(@NotNull String name, @Nullable String... aliases) {
        super(name, aliases);

        setDefaultExecutor(((sender, context) -> {
            sender.sendMessage("Command syntax:\n\t" + name + " <flip-axis>");
        }));

        ArgumentEnum<Axis> argumentAxis = new ArgumentEnum<>("flip-axis", Axis.class).setFormat(ArgumentEnum.Format.LOWER_CASED);

        addSyntax(((sender, context) -> {
            if (!(sender instanceof Player player)) {
                throw new IllegalArgumentException("Only player can execute this command!");
            }
            StructSession session = Registry.STRUCTURE_SESSION_REGISTRY.get(player.getUuid().toString());
            if (session == null) {
                throw new IllegalArgumentException("You're not in an active session!");
            }
            Axis axis = context.get(argumentAxis);
            session.flip(axis);
        }), argumentAxis);
    }
}
