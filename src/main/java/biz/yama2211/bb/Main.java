/*
 * Dev:yamagami2211( https://yama2211.biz/ )
 * Thank: yuttyann44581 ( @yuttyann44581 )[Advice]
 */

package biz.yama2211.bb;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.vehicle.VehicleCreateEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		saveDefaultConfig();
	}

	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		if (getConfig().getBoolean("break") == true) {
			Player player = event.getPlayer();
			if (player.hasPermission("buildblock.ignore.break")) {
				return;
			} else {
				event.setCancelled(true);
				if (getConfig().getBoolean("breakmessage") == true) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&',
							getConfig().getString("bream").replaceAll("%n%", "\n")));
				}
			}
		}
	}

	@EventHandler
	public void onPut(BlockPlaceEvent event) {
		if (getConfig().getBoolean("put") == true) {
			Player player = event.getPlayer();
			if (player.hasPermission("buildblock.ignore.put")) {
				return;
			} else {
				event.setCancelled(true);
				if (getConfig().getBoolean("putmessage") == true) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&',
							getConfig().getString("putm").replaceAll("%n%", "\n")));
				}
			}
		}
	}

	@EventHandler
	public void onPDrop(PlayerDropItemEvent event) {
		if (getConfig().getBoolean("drop") == true) {
			Player player = event.getPlayer();
			if (player.hasPermission("buildblock.ignore.drop")) {
				return;
			} else {
				event.setCancelled(true);
				if (getConfig().getBoolean("dropmessage") == true) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&',
							getConfig().getString("dropm").replaceAll("%n%", "\n")));
				}
			}
		}
	}

	@EventHandler
	public void onPick(PlayerPickupItemEvent event) {
		if (getConfig().getBoolean("pickup") == true) {
			Player player = event.getPlayer();
			if (player.hasPermission("buildblock.ignore.pickup")) {
				return;
			} else {
				event.setCancelled(true);
				if (getConfig().getString("pickupmessage") == "true") {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&',
							getConfig().getString("pickupm").replaceAll("%n%", "\n")));
				}
			}
		}
	}

	//1.0.1追加項目

	@EventHandler
	public void onBedin(PlayerBedEnterEvent event) {
		if (getConfig().getBoolean("bed") == true) {
			Player player = event.getPlayer();
			if (player.hasPermission("buildblock.ignore.bed")) {
				return;
			} else {
				event.setCancelled(true);
				if (getConfig().getBoolean("bedmessage") == true) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&',
							getConfig().getString("bedm").replaceAll("%n%", "\n")));
				}
			}
		}
	}

	@EventHandler
	public void onBookEdit(PlayerEditBookEvent event) {
		if (getConfig().getBoolean("book") == true) {
			Player player = event.getPlayer();
			if (player.hasPermission("buildblock.ignore.book")) {
				return;
			} else {
				event.setCancelled(true);
				if (getConfig().getBoolean("bookmessage") == true) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&',
							getConfig().getString("bookm").replaceAll("%n%", "\n")));
				}
			}
		}
	}

	@EventHandler
	public void onBucke(PlayerBucketEmptyEvent event) {
		if (getConfig().getBoolean("bucket") == true) {
			Player player = event.getPlayer();
			if (player.hasPermission("buildblock.ignore.bucket")) {
				return;
			} else {
				event.setCancelled(true);
				if (getConfig().getBoolean("bucketmessage") == true) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&',
							getConfig().getString("bucketm").replaceAll("%n%", "\n")));
				}
			}
		}
	}

	//1.0.2追加項目

	@EventHandler
	public void onGrow(BlockGrowEvent event) {
		if (getConfig().getBoolean("grow") == true) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onFrom(BlockFromToEvent event) {
		if (getConfig().getBoolean("from") == true) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onEnchant(EnchantItemEvent event) {
		if (getConfig().getBoolean("enchant") == true) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlayerVelocity(VehicleEnterEvent event) {
		if (getConfig().getBoolean("velocity") == true) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onDestroy(VehicleDestroyEvent event) {
		if (getConfig().getBoolean("destroy") == true) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onCreate(VehicleCreateEvent event) {
		if (getConfig().getBoolean("create") == true) {
			event.setCancelled(true);
		}
	}

	//1.0.3追加項目
	@EventHandler
	public void onFish(PlayerFishEvent event) {
		if (getConfig().getBoolean("fish") == true) {
			Player player = event.getPlayer();
			if (player.hasPermission("buildblock.ignore.fish")) {
				return;
			} else {
				event.setCancelled(true);
				if (getConfig().getBoolean("fishmessage") == true) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&',
							getConfig().getString("fishm").replaceAll("%n%", "\n")));
				}
			}
		}
	}

	@EventHandler
	public void onSplash(PotionSplashEvent event) {
		if (getConfig().getBoolean("splash") == true) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onFurnace(FurnaceSmeltEvent event) {
		if (getConfig().getBoolean("furnace") == true) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onBrew(BrewEvent event) {
		if (getConfig().getBoolean("brew") == true) {
			event.setCancelled(true);
		}
	}

	//参考というなの丸パクリ:https://www.spigotmc.org/threads/chest-open-event.145369/#post-1546089
	@EventHandler
	public void catchChestOpen(InventoryOpenEvent event) {
		if (getConfig().getBoolean("chestopen")) {
			if (event.getInventory().getType().equals(InventoryType.CHEST)) {
				Player player = (Player) event.getPlayer();

				if (player.hasPermission("buildblock.ignore.chestopen")) {
					return;
				} else {
					event.setCancelled(true);
					if (getConfig().getBoolean("chestopenmessage") == true) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&',
								getConfig().getString("chestopenm").replaceAll("%n%", "\n")));
					}
				}

			}
		}
	}

	//コマンド
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("buildblock")) {
			if (args.length == 0) {
				PluginDescriptionFile yml = getDescription();
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "===buildblock===");
				sender.sendMessage(ChatColor.GREEN + "PluginVersion : " + ChatColor.DARK_PURPLE + yml.getVersion());
				sender.sendMessage(ChatColor.AQUA + "/buildblock reload" + ChatColor.WHITE + ": Configをリロードします。");
			}
		}
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("reload")) {
				if ((sender.hasPermission("buildblock.admin")) || (sender.isOp())) {
					reloadConfig();
					sender.sendMessage(ChatColor.LIGHT_PURPLE + "Configのリロードしました。");
					return true;
				} else {
					sender.sendMessage(ChatColor.RED + "権限がないので実行できません。");
					return true;
				}
			}
		}

		return false;
	}
}