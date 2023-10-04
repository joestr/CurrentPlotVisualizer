// CurrentPlotVisualizer (c) by Joel "joestr" Strasser
//
// CurrentPlotVisualizer is licensed under a
// Creative Commons Attribution-ShareAlike 4.0 International License.
//
// You should have received a copy of the license along with this
// work. If not, see <https://creativecommons.org/licenses/by-sa/4.0/>.
package at.priv.joestr.currentplotvisualizer;

import at.priv.joestr.currentplotvisualizer.listeners.PlayerJoinListener;
import at.priv.joestr.currentplotvisualizer.listeners.PlotChangeListener;
import com.plotsquared.core.PlotAPI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.boss.BossBar;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author joestr
 */
public class CurrentPlotVisualizerPlugin extends JavaPlugin {

  public static CurrentPlotVisualizerPlugin instance;

  private PlotAPI plotApi;

  private Map<UUID, BossBar> playerBossBars = new HashMap<>();

  @Override
  public void onEnable() {
    super.onEnable();

    instance = this;

    this.loadExternalPluginIntegrations();

    if (plotApi != null) {
      this.registerPlotsquaredEventListeners(instance);
    }

    this.registerEventListeners(instance);
  }

  private void loadExternalPluginIntegrations() {
    this.loadPlotSquaredPluginIntegration();
  }

  private void loadPlotSquaredPluginIntegration() {
    if (Bukkit.getPluginManager().getPlugin("PlotSquared") != null) {
      this.plotApi = new PlotAPI();
    }
  }

  private void registerPlotsquaredEventListeners(CurrentPlotVisualizerPlugin plugin) {
    this.plotApi.registerListener(new PlotChangeListener(plugin));
  }

  private void registerEventListeners(CurrentPlotVisualizerPlugin instance) {
    this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(instance), instance);
  }

  @Override
  public void onDisable() {
    super.onDisable();
  }

  public Map<UUID, BossBar> getPlayerBossBars() {
    return playerBossBars;
  }
}
