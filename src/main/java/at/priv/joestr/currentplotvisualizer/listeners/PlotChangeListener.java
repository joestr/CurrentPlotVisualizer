// CurrentPlotVisualizer (c) by Joel "joestr" Strasser
//
// CurrentPlotVisualizer is licensed under a
// Creative Commons Attribution-ShareAlike 4.0 International License.
//
// You should have received a copy of the license along with this
// work. If not, see <https://creativecommons.org/licenses/by-sa/4.0/>.
package at.priv.joestr.currentplotvisualizer.listeners;

import at.priv.joestr.currentplotvisualizer.CurrentPlotVisualizer;
import com.google.common.eventbus.Subscribe;
import com.plotsquared.core.events.PlayerEnterPlotEvent;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author joestr
 */
public class PlotChangeListener {

  private CurrentPlotVisualizer plugin;

  public PlotChangeListener(CurrentPlotVisualizer plugin) {
    this.plugin = plugin;
  }

  @Subscribe
  public void on(PlayerEnterPlotEvent e) {

  }
}
