import com.intellij.icons.AllIcons;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.Messages;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author hzk
 * @Classname MainFrom
 * @create 2021-06-03 14:06
 * @Description
 */
public class MainForm {
    private JPanel rootPanel;
    private JLabel lblLastResetTime;
    private JLabel lblFound;
    private JLabel lblLastResetTimeLabel;
    private JLabel lblVersion;
    private final DialogWrapper dialogWrapper;
    private final DefaultListModel<String> listModel;

    public MainForm(DialogWrapper dialogWrapper) {
        this.$$$setupUI$$$();
        this.listModel = new DefaultListModel();
        this.dialogWrapper = dialogWrapper;
    }

    public JPanel getContent() {
        boldFont(this.lblFound);
        boldFont(this.lblLastResetTimeLabel);
        this.lblVersion.setText("v" + ReadPluginHelper.getPluginVersion());
        this.rootPanel.setMinimumSize(new Dimension(600, 240));
        return this.rootPanel;
    }

    private static void boldFont(Component component) {
        Font font = component.getFont();
        component.setFont(font.deriveFont(font.getStyle() | 1));
    }

    private void $$$setupUI$$$() {
        rootPanel = new JPanel ( );
        rootPanel.setLayout ( new FormLayout ( "fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow", "center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow" ) );
        lblLastResetTime = new JLabel ( );
        lblLastResetTime.setText ( "Label" );
        CellConstraints cc = new CellConstraints ( );
        rootPanel.add ( lblLastResetTime, cc.xy ( 1, 1 ) );
        lblLastResetTimeLabel = new JLabel ( );
        lblLastResetTimeLabel.setText ( "Label" );
        rootPanel.add ( lblLastResetTimeLabel, cc.xy ( 3, 1 ) );
        lblFound = new JLabel ( );
        lblFound.setText ( "Label" );
        rootPanel.add ( lblFound, cc.xy ( 1, 3 ) );
        lblVersion = new JLabel ( );
        lblVersion.setText ( "Label" );
        rootPanel.add ( lblVersion, cc.xy ( 3, 3 ) );
    }
}
