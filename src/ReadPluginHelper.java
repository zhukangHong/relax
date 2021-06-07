import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.ide.plugins.PluginManagerCore;
import com.intellij.openapi.extensions.PluginId;

/**
 * @author hzk
 * @Classname ReadPluginHelper
 * @create 2021-06-03 13:57
 * @Description
 */
public class ReadPluginHelper {
    private static final IdeaPluginDescriptor PLUGIN_DESCRIPTOR = PluginManagerCore.getPlugin(getPluginId());

    public ReadPluginHelper() {
    }

    public static PluginId getPluginId() {
        return PluginId.getId("cn.iamkb");
    }

    public static IdeaPluginDescriptor getPluginDescriptor() {
        return PLUGIN_DESCRIPTOR;
    }

    public static String getPluginName() {
        return PLUGIN_DESCRIPTOR == null ? "UNKNOWN" : PLUGIN_DESCRIPTOR.getName();
    }

    public static String getPluginVersion() {
        return PLUGIN_DESCRIPTOR == null ? "UNKNOWN" : PLUGIN_DESCRIPTOR.getVersion ();
    }

}
