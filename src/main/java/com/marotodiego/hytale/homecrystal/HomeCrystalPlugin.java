package com.marotodiego.hytale.homecrystal;

import com.hypixel.hytale.server.core.event.events.player.PlayerDisconnectEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.modules.interaction.interaction.config.Interaction;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.marotodiego.hytale.homecrystal.commands.ExampleCommand;
import com.marotodiego.hytale.homecrystal.ecs.CancelBreakBlock;
import com.marotodiego.hytale.homecrystal.events.ExampleEvent;
import com.marotodiego.hytale.homecrystal.interactions.HomeCrystalInteraction;

import javax.annotation.Nonnull;

public class HomeCrystalPlugin extends JavaPlugin {

  public HomeCrystalPlugin(@Nonnull JavaPluginInit init) {
    super(init);
  }

  @Override
  protected void setup() {
    this.getCommandRegistry().registerCommand(new ExampleCommand("example", "An example command"));
    this.getEventRegistry().registerGlobal(PlayerReadyEvent.class, ExampleEvent::onPlayerReady);
    this.getEventRegistry().registerGlobal(PlayerDisconnectEvent.class, ExampleEvent::onPlayerDisconnect);
    this.getEntityStoreRegistry().registerSystem(new CancelBreakBlock());
    this.getCodecRegistry(Interaction.CODEC)
        .register("interaction_home_crystal", HomeCrystalInteraction.class, HomeCrystalInteraction.CODEC);
  }
}
