// CurrentPlotVisualizer (c) by Joel "joestr" Strasser
//
// CurrentPlotVisualizer is licensed under a
// Creative Commons Attribution-ShareAlike 4.0 International License.
//
// You should have received a copy of the license along with this
// work. If not, see <https://creativecommons.org/licenses/by-sa/4.0/>.
package at.priv.joestr.currentplotvisualizer;

import at.priv.joestr.currentplotvisualizer.commands.CurrentPlotVisualizerCommand;
import at.priv.joestr.currentplotvisualizer.listeners.PlayerJoinListener;
import at.priv.joestr.currentplotvisualizer.listeners.PlayerLeaveListener;
import at.priv.joestr.currentplotvisualizer.listeners.PlotChangeListener;
import com.plotsquared.core.PlotAPI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.lang3.tuple.Pair;
import org.bukkit.Bukkit;
import org.bukkit.boss.BossBar;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class CurrentPlotVisualizerPlugin extends JavaPlugin {

  public static CurrentPlotVisualizerPlugin instance;

  private PlotAPI plotApi;
  private final Map<UUID, BossBar> playerBossBars = new HashMap<>();
  private HashMap<String, TabExecutor> commandMap;

  @Override
  public void onEnable() {
    super.onEnable();

    instance = this;

    this.loadExternalPluginIntegrations();

    if (plotApi != null) {
      this.registerPlotsquaredEventListeners(instance);
    }

    this.registerCommands(
      Pair.of("cpv", new CurrentPlotVisualizerCommand(instance))
    );
    this.registerEventListeners(instance);
  }

  @Override
  public void onDisable() {
    super.onDisable();
  }

  public PlotAPI getPlotApi() {
    return plotApi;
  }

  public Map<UUID, BossBar> getPlayerBossBars() {
    return playerBossBars;
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

  private void registerCommands(Pair<String, TabExecutor>... commands) {
    for (Pair<String, TabExecutor> command : commands) {
      PluginCommand pluginCommand = this.getServer().getPluginCommand(command.getKey());
      if (pluginCommand == null) {
        return;
      }
      pluginCommand.setExecutor(command.getValue());
      pluginCommand.setTabCompleter(command.getValue());
    }
  }

  private void registerEventListeners(CurrentPlotVisualizerPlugin instance) {
    this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(instance), instance);
    this.getServer().getPluginManager().registerEvents(new PlayerLeaveListener(instance), instance);
  }
}
