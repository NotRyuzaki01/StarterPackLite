# SimpleStarterKit

**SimpleStarterKit** is a lightweight Minecraft plugin for Paper/Spigot servers.  
It automatically gives new players a starter kit with items you specify in the configuration when they join the server for the first time.

## Features
- Automatically detects if a player is joining for the first time.
- Gives the player a set of predefined starter items.
- Easy to configure through a simple config file.
- Lightweight and easy to install.

## Installation
1. Download the latest version of SimpleStarterKit.
2. Place the `.jar` file into your server's `plugins` folder.
3. Restart or reload your server.
4. Edit the `config.yml` file inside the `SimpleStarterKit` folder to customize the starter items.
5. Reload or restart the server again to apply changes.

## Configuration
After the first launch, a `config.yml` will be generated.  
You can specify the items you want new players to receive. `items:` for unstachable items like tools/armor, `consumables:` for stackable items like food/blocks etc.  
Example:

```yaml
items:
  - CHAINMAIL_HELMET
  - CHAINMAIL_CHESTPLATE
  - CHAINMAIL_LEGGINGS
  - CHAINMAIL_BOOTS
  - IRON_SWORD
  - IRON_PICKAXE
consumables:
  BREAD: 10
