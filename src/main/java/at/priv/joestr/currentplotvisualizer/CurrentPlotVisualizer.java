// CurrentPlotVisualizer (c) by Joel "joestr" Strasser
//
// CurrentPlotVisualizer is licensed under a
// Creative Commons Attribution-ShareAlike 4.0 International License.
//
// You should have received a copy of the license along with this
// work. If not, see <https://creativecommons.org/licenses/by-sa/4.0/>.
package at.priv.joestr.currentplotvisualizer;

import at.priv.joestr.currentplotvisualizer.listeners.PlotChangeListener;
import com.plotsquared.core.PlotAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author joestr
 */
public class CurrentPlotVisualizer extends JavaPlugin {

  public static CurrentPlotVisualizer instance;

  private PlotAPI plotApi;

  @Override
  public void onEnable() {
    instance = this;

    this.loadExternalPluginIntegrations();

    if (plotApi != null) {
      this.registerPlotsquaredEventListeners(instance);
    }

    super.onEnable(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
  }

  public void loadExternalPluginIntegrations() {
    this.loadPlotSquaredPluginIntegration();
  }

  public void loadPlotSquaredPluginIntegration() {
    if (Bukkit.getPluginManager().getPlugin("PlotSquared") != null) {
      this.plotApi = new PlotAPI();
    }
  }

  public void registerPlotsquaredEventListeners(CurrentPlotVisualizer plugin) {
    this.plotApi.registerListener(new PlotChangeListener(plugin));
  }

  @Override
  public void onDisable() {
    super.onDisable(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
  }

}
