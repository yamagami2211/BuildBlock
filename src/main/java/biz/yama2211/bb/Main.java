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
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
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
		if(getConfig().getString("break") == "true") {
		Player player = event.getPlayer();
		if(player.hasPermission("buildblock.ignore.break")) {
		return;
		} else {
				event.setCancelled(true);
				if(getConfig().getString("breakmessage") == "true") {
					player.sendMessage(ChatColor.translateAlternateColorCodes( '&' ,getConfig().getString("bream").replaceAll("%n%", "\n")));
				}
		}
		}
	}

	@EventHandler
	public void onPut(BlockPlaceEvent event) {
		if(getConfig().getString("put") == "true") {
		Player player = event.getPlayer();
		if(player.hasPermission("buildblock.ignore.put")) {
		return;
		} else {
				event.setCancelled(true);
				if(getConfig().getString("putmessage") == "true") {
					player.sendMessage(ChatColor.translateAlternateColorCodes( '&' ,getConfig().getString("putm").replaceAll("%n%", "\n")));
				}
		}
		}
}

	@EventHandler
	public void onPDrop(PlayerDropItemEvent event) {
		if(getConfig().getString("drop") == "true") {
		Player player = event.getPlayer();
		if(player.hasPermission("buildblock.ignore.drop")) {
		return;
		} else {
				event.setCancelled(true);
				if(getConfig().getString("dropmessage") == "true") {
					player.sendMessage(ChatColor.translateAlternateColorCodes( '&' ,getConfig().getString("dropm").replaceAll("%n%", "\n")));
				}
		}
		}
	}

	@EventHandler
	public void onPick(PlayerPickupItemEvent event) {
		if(getConfig().getString("pickup") == "true") {
		Player player = event.getPlayer();
		if(player.hasPermission("buildblock.ignore.pickup")) {
		return;
		} else {
				event.setCancelled(true);
				if(getConfig().getString("pickupmessage") == "true") {
					player.sendMessage(ChatColor.translateAlternateColorCodes( '&' ,getConfig().getString("pickupm").replaceAll("%n%", "\n")));
				}
		}
		}
	}


	@EventHandler
	public void onBedin(PlayerBedEnterEvent event) {
		if(getConfig().getString("bed") == "true") {
		Player player = event.getPlayer();
		if(player.hasPermission("buildblock.ignore.bed")) {
		return;
		} else {
				event.setCancelled(true);
				if(getConfig().getString("bedmessage") == "true") {
					player.sendMessage(ChatColor.translateAlternateColorCodes( '&' ,getConfig().getString("bedm").replaceAll("%n%", "\n")));
				}
		}
		}
	}

	@EventHandler
	public void onBookEdit(PlayerEditBookEvent event) {
		if(getConfig().getString("book") == "true") {
		Player player = event.getPlayer();
		if(player.hasPermission("buildblock.ignore.book")) {
		return;
		} else {
				event.setCancelled(true);
				if(getConfig().getString("bookmessage") == "true") {
					player.sendMessage(ChatColor.translateAlternateColorCodes( '&' ,getConfig().getString("bookm").replaceAll("%n%", "\n")));
				}
		}
		}
	}

	@EventHandler
	public void onBucke(PlayerBucketEmptyEvent event) {
		if(getConfig().getString("bucket") == "true") {
		Player player = event.getPlayer();
		if(player.hasPermission("buildblock.ignore.bucket")) {
		return;
		} else {
				event.setCancelled(true);
				if(getConfig().getString("bucketmessage") == "true") {
					player.sendMessage(ChatColor.translateAlternateColorCodes( '&' ,getConfig().getString("bucketm").replaceAll("%n%", "\n")));
				}
		}
		}
	}


	@EventHandler
	public void onGrow(BlockGrowEvent event) {
		if(getConfig().getString("grow") == "true") {
				event.setCancelled(true);
		}
	}

	@EventHandler
	public void onFrom(BlockFromToEvent event) {
		if(getConfig().getString("from") == "true") {
				event.setCancelled(true);
		}
	}

	@EventHandler
	public void onEnchant(EnchantItemEvent event) {
		if(getConfig().getString("enchant") == "true") {
				event.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlayerVelocity(VehicleEnterEvent event) {
		if(getConfig().getString("velocity") == "true") {
					event.setCancelled(true);
			}
	}

	@EventHandler
	public void onDestroy(VehicleDestroyEvent event) {
		if(getConfig().getString("destroy") == "true") {
					event.setCancelled(true);
			}
	}

	@EventHandler
	public void onCreate(VehicleCreateEvent event) {
		if(getConfig().getString("create") == "true") {
					event.setCancelled(true);
			}
	}

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {

	    if(cmd.getName().equalsIgnoreCase("buildblock"))
	    {
	 	       if(args.length == 0)
	 	       {
	    	  PluginDescriptionFile yml = getDescription();
	    	  sender.sendMessage(ChatColor.LIGHT_PURPLE + "===buildblock===");
	    	  sender.sendMessage(ChatColor.GREEN + "PluginVersion : " + ChatColor.DARK_PURPLE + yml.getVersion());
	    	  sender.sendMessage(ChatColor.AQUA + "/buildblock reload"+ChatColor.WHITE +": Configをリロードします。");
	 	       }
	    }
	    if(args.length == 1)
	       {
	    	  if(args[0].equalsIgnoreCase("reload"))
	    	  {
		         if ((sender.hasPermission("buildblock.admin")) || (sender.isOp()))
		         {
		        	reloadConfig();
	                  sender.sendMessage(ChatColor.LIGHT_PURPLE+ "Configのリロードしました。");
	                  return true;
		         }else{
		        	 sender.sendMessage(ChatColor.RED+"権限がないので実行できません。");
		        	 return true;
		 			}
	    	  }
	       }

		return false;
    }
}