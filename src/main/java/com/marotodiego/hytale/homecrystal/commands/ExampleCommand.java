package com.marotodiego.hytale.homecrystal.commands;

import com.hypixel.hytale.protocol.GameMode;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.AbstractCommand;
import com.hypixel.hytale.server.core.command.system.CommandContext;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ExampleCommand extends AbstractCommand {

  public ExampleCommand(String name, String description) {
    super(name, description);
    setPermissionGroup(GameMode.Adventure);
    setPermissionGroup(GameMode.Creative);
  }

  @Nullable
  @Override
  protected CompletableFuture<Void> execute(@Nonnull CommandContext context) {
    context.sendMessage(Message.raw("Hello from ExampleCommand!"));
    return CompletableFuture.completedFuture(null);
  }

}
