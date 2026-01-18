package com.marotodiego.hytale.homecrystal.interactions;

import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.math.vector.Vector3d;
import com.hypixel.hytale.math.vector.Vector3f;
import com.hypixel.hytale.protocol.InteractionType;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.InteractionContext;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.modules.entity.teleport.Teleport;
import com.hypixel.hytale.server.core.modules.interaction.interaction.CooldownHandler;
import com.hypixel.hytale.server.core.modules.interaction.interaction.config.SimpleInstantInteraction;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import com.marotodiego.hytale.homecrystal.store.PlayerStore;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class HomeCrystalInteraction extends SimpleInstantInteraction {
  public static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();
  public static final BuilderCodec<HomeCrystalInteraction> CODEC =
      BuilderCodec.builder(HomeCrystalInteraction.class, HomeCrystalInteraction::new, SimpleInstantInteraction.CODEC)
          .build();

  @Override
  protected void firstRun(@NonNullDecl InteractionType interactionType,
                          @NonNullDecl InteractionContext interactionContext,
                          @NonNullDecl CooldownHandler cooldownHandler) {
    Ref<EntityStore> ref = interactionContext.getEntity();
    LOGGER.atInfo().log("HomeCrystal Interaction triggered");
    Store<EntityStore> store = ref.getStore();
    PlayerRef playerRef = store.getComponent(ref, PlayerRef.getComponentType());
    if (playerRef == null)
      return;
    playerRef.sendMessage(Message.raw("You have used the HOMECRYSTAL item."));
    Player player = PlayerStore.get(playerRef.getUuid()).player();
    World world = player.getWorld();
    if (world == null)
      return;
    final Vector3d position = Player.getRespawnPosition(ref, world.getName(), store).getPosition();
    final Vector3f rotation = Player.getRespawnPosition(ref, world.getName(), store).getRotation();
    LOGGER.atInfo().log("All data before executing the command are ready");
    store.addComponent(playerRef.getReference(), Teleport.getComponentType(), new Teleport(position, rotation));
  }
}
