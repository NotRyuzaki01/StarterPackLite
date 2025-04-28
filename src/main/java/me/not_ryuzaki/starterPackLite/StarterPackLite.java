package me.not_ryuzaki.starterPackLite;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class StarterPackLite extends JavaPlugin implements Listener {
    private final List<String> items = new ArrayList();
    private final List<ItemStack> consumableItems = new ArrayList();

    public void onEnable() {
        this.saveDefaultConfig();
        this.Load();
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPlayedBefore()) {
            Inventory inventory = player.getInventory();

            for(String itemName : this.items) {
                Material material = Material.matchMaterial(itemName);
                if (material != null) {
                    inventory.addItem(new ItemStack[]{new ItemStack(material)});
                }
            }

            for(ItemStack item : this.consumableItems) {
                inventory.addItem(new ItemStack[]{item});
            }

            player.sendMessage("Welcome to the server! Here's your starter pack.");
        }

    }

    private void Load() {
        List<String> itemNames = this.getConfig().getStringList("items");
        this.items.addAll(itemNames);
        ConfigurationSection consumables = this.getConfig().getConfigurationSection("consumables");
        if (consumables != null) {
            for(String key : consumables.getKeys(false)) {
                Material material = Material.matchMaterial(key);
                int amount = consumables.getInt(key);
                if (material != null && amount > 0) {
                    ItemStack item = new ItemStack(material, amount);
                    this.consumableItems.add(item);
                }
            }
        }

    }
}
