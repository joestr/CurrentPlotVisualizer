// CurrentPlotVisualizer (c) by Joel "joestr" Strasser
//
// CurrentPlotVisualizer is licensed under a
// Creative Commons Attribution-ShareAlike 4.0 International License.
//
// You should have received a copy of the license along with this
// work. If not, see <https://creativecommons.org/licenses/by-sa/4.0/>.
package at.priv.joestr.currentplotvisualizer.listeners;

import at.priv.joestr.currentplotvisualizer.CurrentPlotVisualizerPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 *
 * @author joestr
 */
public class PlayerLeaveListener implements Listener {

  CurrentPlotVisualizerPlugin plugin;

  public PlayerLeaveListener(CurrentPlotVisualizerPlugin plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent e) {
    if (plugin.getPlayerBossBars().containsKey(e.getPlayer().getUniqueId())) {
      plugin.getPlayerBossBars().remove(e.getPlayer().getUniqueId());
    }
  }
}
