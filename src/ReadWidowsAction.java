import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowAnchor;
import com.intellij.openapi.wm.ToolWindowEP;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.openapi.wm.ex.ToolWindowManagerEx;
import com.intellij.psi.codeStyle.arrangement.std.StdArrangementTokens;

public class ReadWidowsAction extends AnAction {

    public ReadWidowsAction() {
        super( "Read", "Read text", AllIcons.General.Information );
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        Project project = e.getData( PlatformDataKeys.PROJECT);
        if (project == null) {
//            MainDialog mainDialog = new MainDialog("Eval Reset");
//            mainDialog.show();
        }else {
            ToolWindow toolWindow = ToolWindowManager.getInstance(project).getToolWindow("Read Text");
            if (null == toolWindow) {
                ToolWindowEP ep = new ToolWindowEP();
                ep.id = "Read Text";
                ep.anchor = ToolWindowAnchor.BOTTOM.toString();
                ep.icon = "AllIcons.General.Information";
                ep.factoryClass = ReadToolWindowsFactory.class.getName();
                ep.setPluginDescriptor(ReadPluginHelper.getPluginDescriptor());
                ToolWindowManagerEx.getInstanceEx(project).initToolWindow(ep);
                toolWindow = ToolWindowManager.getInstance(project).getToolWindow("Read Text");
            }
            toolWindow.show();
        }
    }
}
