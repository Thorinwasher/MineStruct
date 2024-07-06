package dev.thorinwasher.minestruct.command;

import dev.thorinwasher.minestruct.Registry;
import dev.thorinwasher.minestruct.struct.StructSession;
import net.minestom.server.command.builder.Command;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PasteStructureCommand extends Command {
    public PasteStructureCommand(@NotNull String name, @Nullable String... aliases) {
        super(name, aliases);

        setDefaultExecutor(((sender, context) -> {
            if (!(sender instanceof Player player)) {
                throw new IllegalArgumentException("Only player can execute this command!");
            }
            StructSession session = Registry.STRUCTURE_SESSION_REGISTRY.get(player.getUuid().toString()).copy();
            if(session == null){
                throw new IllegalArgumentException("You're not in an active session!");
            }
            session.translate(player.getPosition());
            session.paste(player.getInstance());
        }));
    }
}
