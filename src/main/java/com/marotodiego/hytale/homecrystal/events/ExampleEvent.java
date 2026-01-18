package com.marotodiego.hytale.homecrystal.events;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.ecs.BreakBlockEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerDisconnectEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import com.marotodiego.hytale.homecrystal.store.PlayerStore;

public class ExampleEvent {
  public static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

  public static void onPlayerReady(PlayerReadyEvent event) {
    Player player = event.getPlayer();
    player.sendMessage(Message.raw("Welcome " + player.getDisplayName()));
    Ref<EntityStore> ref = event.getPlayerRef();
    Store<EntityStore> store = ref.getStore();

    PlayerRef playerRef = store.getComponent(ref, PlayerRef.getComponentType());
    if (playerRef == null)
      return;

    PlayerStore.add(playerRef.getUuid(), player, playerRef);
    player.sendMessage(
        Message.raw("Your ref has been stored: " + PlayerStore.get(playerRef.getUuid()).ref().getUsername()));
  }

  public static void onPlayerDisconnect(PlayerDisconnectEvent event) {
    PlayerRef playerRef = event.getPlayerRef();
    PlayerStore.remove(playerRef.getUuid());
    LOGGER.atInfo().log("Player " + playerRef.getUuid() + " disconnected");
  }

  public static void onBreakBlock(BreakBlockEvent event) {
    String meta = event.getItemInHand().toString();

    for (PlayerStore.PlayerEntry entry : PlayerStore.getAll()) {
      entry.player().sendMessage(Message.raw("Block broken with: " + meta));
    }
  }
}
