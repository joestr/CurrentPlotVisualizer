// CurrentPlotVisualizer (c) by Joel "joestr" Strasser
//
// CurrentPlotVisualizer is licensed under a
// Creative Commons Attribution-ShareAlike 4.0 International License.
//
// You should have received a copy of the license along with this
// work. If not, see <https://creativecommons.org/licenses/by-sa/4.0/>.
package at.priv.joestr.currentplotvisualizer.listeners;

import at.priv.joestr.currentplotvisualizer.CurrentPlotVisualizerPlugin;
import com.plotsquared.core.plot.Plot;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 *
 * @author joestr
 */
public class PlayerJoinListener implements Listener {

  CurrentPlotVisualizerPlugin plugin;

  public PlayerJoinListener(CurrentPlotVisualizerPlugin plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent e) {
    UUID playerUuid = e.getPlayer().getUniqueId();

    if (!plugin.getPlayerBossBars().containsKey(playerUuid)) {
      BossBar b = Bukkit.createBossBar(plugin.getNamespacedKey(), "Hier ist kein Plot", BarColor.GREEN, BarStyle.SOLID);
      b.addPlayer(e.getPlayer());
      plugin.getPlayerBossBars().put(playerUuid, b);
    }
    Plot plot = plugin.getPlotApi()
      .wrapPlayer(playerUuid)
      .getLocation()
      .getPlot();
    if (plot != null) {
      OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(plot.getOwner());
      plugin.getPlayerBossBars().get(playerUuid).setTitle(offlinePlayer.getName());
    }
  }
}
