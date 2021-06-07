import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * @author hzk
 * @Classname ReadToolWindowsFactory
 * @create 2021-06-03 13:53
 * @Description
 */
public class ReadToolWindowsFactory implements ToolWindowFactory{


    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ReadMainForm mainForm = null;
        try {
            mainForm = new ReadMainForm();
        } catch (IOException e) {
            e.printStackTrace ( );
        }
        Content content = ContentFactory.SERVICE.getInstance().createContent(mainForm.getContent(), "", true);
        toolWindow.getContentManager().addContent(content);
    }
}
