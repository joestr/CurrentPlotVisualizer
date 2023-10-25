// CurrentPlotVisualizer (c) by Joel "joestr" Strasser
//
// CurrentPlotVisualizer is licensed under a
// Creative Commons Attribution-ShareAlike 4.0 International License.
//
// You should have received a copy of the license along with this
// work. If not, see <https://creativecommons.org/licenses/by-sa/4.0/>.
package at.priv.joestr.currentplotvisualizer.settings;

import at.priv.joestr.currentplotvisualizer.CurrentPlotVisualizerPlugin;
import de.cubbossa.commonsettings.NamespacedKey;
import de.cubbossa.commonsettings.Setting;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import net.kyori.adventure.text.Component;

/**
 *
 * @author joestr
 */
public class BossBarVisualizationSetting implements Setting<Boolean> {

  CurrentPlotVisualizerPlugin plugin;

  public BossBarVisualizationSetting(CurrentPlotVisualizerPlugin plugin) {
    this.plugin = plugin;
  }

  @Override
  public Class<Boolean> getType() {
    return Boolean.class;
  }

  @Override
  public NamespacedKey getKey() {
    return new NamespacedKey(this.plugin.getNamespacedKey().getNamespace(), this.plugin.getNamespacedKey().getKey());
  }

  @Override
  public Flags getFlags() {
    return new FlagsImpl();
  }

  @Override
  public Collection<String> getTags() {
    return List.of("CPV");
  }

  @Override
  public DisplayOptions getDisplayOptions() {
    return new DisplayOptionsImpl();
  }

  @Override
  public String getPermission() {
    return Setting.super.getPermission(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
  }

  @Override
  public Boolean getValue(UUID uuid) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  public CompletableFuture<Boolean> requestValue(UUID uuid) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  public CompletableFuture<SettingChangeResult> setValue(UUID uuid, Boolean t) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  public CompletableFuture<SettingChangeResult> reset(UUID uuid) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  private class FlagsImpl implements Flags {

    @Override
    public boolean readonly() {
      return true;
    }

    @Override
    public boolean nullable() {
      return false;
    }

    @Override
    public boolean threadSafe() {
      return true;
    }
  }

  private class DisplayOptionsImpl implements DisplayOptions {

    @Override
    public Component getTitle() {
      return Component.text("Plot in Boss-Leiste anzeigen");
    }

    @Override
    public Component getShortDescription() {
      return Component.text("Aktuellen Plot in einer Boss-Leiste anzeigen.");
    }

    @Override
    public Component getLongDescription() {
      return Component.text("Zeigt den Aktuellen Plot auf dem du stehst in einer extra Boss-Leiste an.");
    }

  }
}
