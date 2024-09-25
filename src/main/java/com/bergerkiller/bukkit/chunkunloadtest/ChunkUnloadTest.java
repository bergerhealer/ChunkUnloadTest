package com.bergerkiller.bukkit.chunkunloadtest;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.Chunk;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ChunkUnloadTest extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
    }

    @EventHandler
    public void onChunkUnload(ChunkUnloadEvent event) {
        Chunk c = event.getChunk();

        System.out.println("Unloading chunk [" + c.getX() + " / " + c.getZ() + "]");
        System.out.println("  Number of tile entities: " + c.getTileEntities().length);
        System.out.println("  Material of block at 0,64,0: " + c.getBlock(c.getX() << 4, 0, c.getZ() << 4).getType());
    }
}
