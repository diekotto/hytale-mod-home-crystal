package com.marotodiego.hytale.homecrystal.store;

import com.hypixel.hytale.server.core.universe.PlayerRef;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerStore {
    private static final Map<UUID, PlayerRef> players = new ConcurrentHashMap<>();

    public static void add(UUID uuid, PlayerRef ref) {
        players.put(uuid, ref);
    }

    public static PlayerRef get(UUID uuid) {
        return players.get(uuid);
    }

    public static void remove(UUID uuid) {
        players.remove(uuid);
    }

    public static boolean contains(UUID uuid) {
        return players.containsKey(uuid);
    }
}
