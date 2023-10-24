// CurrentPlotVisualizer (c) by Joel "joestr" Strasser
//
// CurrentPlotVisualizer is licensed under a
// Creative Commons Attribution-ShareAlike 4.0 International License.
//
// You should have received a copy of the license along with this
// work. If not, see <https://creativecommons.org/licenses/by-sa/4.0/>.
package at.priv.joestr.currentplotvisualizer.listeners;

import at.priv.joestr.currentplotvisualizer.CurrentPlotVisualizerPlugin;
import com.google.common.eventbus.Subscribe;
import com.plotsquared.core.events.PlayerEnterPlotEvent;
import com.plotsquared.core.events.PlayerLeavePlotEvent;
import org.bukkit.Bukkit;
import org.bukkit.boss.BossBar;

/**
 *
 * @author joestr
 */
public class PlotChangeListener {

  private CurrentPlotVisualizerPlugin plugin;

  public PlotChangeListener(CurrentPlotVisualizerPlugin plugin) {
    this.plugin = plugin;
  }

  @Subscribe
  public void on(PlayerEnterPlotEvent e) {
    if (plugin.getPlayerBossBars().containsKey(e.getPlotPlayer().getUUID())) {
      BossBar b = plugin.getPlayerBossBars().get(e.getPlotPlayer().getUUID());
      String playerName = Bukkit.getOfflinePlayer(e.getPlot().getOwner()).getName();
      b.setTitle(playerName);
    }
  }

  @Subscribe
  public void on(PlayerLeavePlotEvent e) {
    if (plugin.getPlayerBossBars().containsKey(e.getPlotPlayer().getUUID())) {
      BossBar b = plugin.getPlayerBossBars().get(e.getPlotPlayer().getUUID());
      b.setTitle("Hier ist kein Plot");
    }
  }
}
