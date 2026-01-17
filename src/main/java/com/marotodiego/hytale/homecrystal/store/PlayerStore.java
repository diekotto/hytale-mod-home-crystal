package com.marotodiego.hytale.homecrystal.store;

import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.universe.PlayerRef;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerStore {

    public record PlayerEntry(Player player, PlayerRef ref) {}

    private static final Map<UUID, PlayerEntry> players = new ConcurrentHashMap<>();

    public static void add(UUID uuid, Player player, PlayerRef ref) {
        players.put(uuid, new PlayerEntry(player, ref));
    }

    public static PlayerEntry get(UUID uuid) {
        return players.get(uuid);
    }

    public static void remove(UUID uuid) {
        players.remove(uuid);
    }

    public static boolean contains(UUID uuid) {
        return players.containsKey(uuid);
    }

    public static Collection<PlayerEntry> getAll() {
        return players.values();
    }
}
