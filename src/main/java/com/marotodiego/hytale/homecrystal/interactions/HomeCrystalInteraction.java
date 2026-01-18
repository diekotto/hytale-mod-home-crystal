package com.marotodiego.hytale.homecrystal.interactions;

import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.protocol.InteractionType;
import com.hypixel.hytale.server.core.entity.InteractionContext;
import com.hypixel.hytale.server.core.modules.interaction.interaction.CooldownHandler;
import com.hypixel.hytale.server.core.modules.interaction.interaction.config.SimpleInstantInteraction;
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
    LOGGER.atInfo().log("First run on Home Crystal Interaction");
  }
}
