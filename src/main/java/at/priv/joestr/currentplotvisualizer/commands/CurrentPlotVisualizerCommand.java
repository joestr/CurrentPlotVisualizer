// CurrentPlotVisualizer (c) by Joel "joestr" Strasser
//
// CurrentPlotVisualizer is licensed under a
// Creative Commons Attribution-ShareAlike 4.0 International License.
//
// You should have received a copy of the license along with this
// work. If not, see <https://creativecommons.org/licenses/by-sa/4.0/>.
package at.priv.joestr.currentplotvisualizer.commands;

import at.priv.joestr.currentplotvisualizer.CurrentPlotVisualizerPlugin;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

/**
 *
 * @author joestr
 */
public class CurrentPlotVisualizerCommand implements TabExecutor {

  CurrentPlotVisualizerPlugin plugin;

  public CurrentPlotVisualizerCommand(CurrentPlotVisualizerPlugin plugin) {
    this.plugin = plugin;
  }

  @Override
  public List<String> onTabComplete(CommandSender cs, Command cmnd, String string, String[] strings) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

}
