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
import at.priv.joestr.currentplotvisualizer.settings.BossBarVisualizationSetting;
import com.plotsquared.core.PlotAPI;
import de.cubbossa.commonsettings.SettingsAPI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.lang3.tuple.Pair;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.BossBar;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class CurrentPlotVisualizerPlugin extends JavaPlugin {

  public static CurrentPlotVisualizerPlugin instance;
  private PlotAPI plotApi;
  private SettingsAPI settingsApi;
  private final Map<UUID, BossBar> playerBossBars = new HashMap<>();
  private NamespacedKey namespacedKey;

  @Override
  public void onEnable() {
    super.onEnable();

    instance = this;
    namespacedKey = new NamespacedKey(
      this,
      "cfc3188cb31fe96d5c6ab8b6f1879ecb"
    );

    this.loadExternalPluginIntegrations();

    if (plotApi != null) {
      this.registerPlotsquaredEventListeners(instance);
    }

    if (settingsApi != null) {
      this.registerSettings(instance);
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

  public SettingsAPI getSettingsApi() {
    return settingsApi;
  }

  public Map<UUID, BossBar> getPlayerBossBars() {
    return playerBossBars;
  }

  public NamespacedKey getNamespacedKey() {
    return namespacedKey;
  }

  private void loadExternalPluginIntegrations() {
    this.loadPlotSquaredPluginIntegration();
    this.loadCommonSettingsPluginIntegration();
  }

  private void loadPlotSquaredPluginIntegration() {
    if (Bukkit.getPluginManager().getPlugin("PlotSquared") != null) {
      this.plotApi = new PlotAPI();
    }
  }

  private void loadCommonSettingsPluginIntegration() {
    if (Bukkit.getPluginManager().getPlugin("CommonSettings") != null) {
      this.settingsApi = SettingsAPI.getInstance();
    }
  }

  private void registerPlotsquaredEventListeners(CurrentPlotVisualizerPlugin plugin) {
    this.plotApi.registerListener(new PlotChangeListener(plugin));
  }

  private void registerSettings(CurrentPlotVisualizerPlugin plugin) {
    this.settingsApi.registerSetting(new BossBarVisualizationSetting(plugin));
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
