import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import org.h2.util.StringUtils;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Properties;


/**
 * @author hzk
 * @Classname ReadMainForm
 * @create 2021-06-03 14:19
 * @Description
 */
public class ReadMainForm extends JFrame {

    private JPanel rootPanel;
    private JLabel content;
    private JLabel title;
    private JButton btNext;
    private JTextArea contentArea;
    private JTextPane noRecentSnapshotsClickTextPane;
    int offset = 0;
    int size = 40;
    String line = "";
    String bookUrl = "";
    boolean visible = true;
    StringBuilder allText = new StringBuilder ( );
    int allLength = 0;
    static Properties props = new Properties ( );
    String url = "E://config.properties";

    public ReadMainForm() throws IOException {
        this.$$$setupUI$$$ ( );
        System.out.println ( url );
        props.load ( new BufferedReader ( new FileReader ( url, StandardCharsets.UTF_8 ) ) );
        offset = Integer.parseInt ( props.get ( "offset" ).toString ( ) );
        size = Integer.parseInt ( props.get ( "size" ).toString ( ) );
        bookUrl = props.get ( "bookUrl" ).toString ( );
        BufferedReader fileInputStream = new BufferedReader ( new FileReader ( bookUrl, StandardCharsets.UTF_8 ) );


        btNext.addMouseListener ( new MouseAdapter ( ) {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked ( e );
                props.setProperty ( "offset", String.valueOf ( offset ) );
                try {
                    props.store ( new FileOutputStream ( url ), null );
                } catch (IOException ioException) {
                    ioException.printStackTrace ( );
                }
            }
        } );

        noRecentSnapshotsClickTextPane.addKeyListener ( new KeyAdapter ( ) {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed ( e );
                //下翻
                if (e.getKeyCode ( ) == 81) {
                    contentArea.setText ( allText.substring ( offset, Math.min ( offset + size, allLength ) ) );
                    offset += size;
                }
                //上翻
                if (e.getKeyCode ( ) == 87) {
                    offset -= size;
                    contentArea.setText ( allText.substring ( Math.min ( offset - size, allLength ), offset ) );
                }
                //收起
                if (e.getKeyCode ( ) == 65) {
                    contentArea.setVisible ( !visible );
                    visible = !visible;
                }
            }
        } );

        noRecentSnapshotsClickTextPane.addMouseListener ( new MouseAdapter ( ) {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked ( e );
                noRecentSnapshotsClickTextPane.requestFocus ( );
            }
        } );


        while ((line = fileInputStream.readLine ( )) != null) {
            if (StringUtils.isNullOrEmpty ( line )) continue;
            allText.append ( line );
        }
        allLength = allText.length ( );
        fileInputStream.close ( );

    }

    public JPanel getContent() {
        boldFont ( this.title );
        this.rootPanel.setMinimumSize ( new Dimension ( 600, 240 ) );
        return this.rootPanel;
    }

    private static void boldFont(Component component) {
        Font font = component.getFont ( );
        component.setFont ( font.deriveFont ( font.getStyle ( ) | 1 ) );
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }


    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rootPanel = new JPanel ( );
        rootPanel.setLayout ( new FormLayout ( "fill:734px:noGrow,left:4dlu:noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow", "center:max(d;4px):noGrow,top:4dlu:noGrow,center:27px:noGrow,top:4px:noGrow,center:44px:noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow" ) );
        title = new JLabel ( );
        title.setEnabled ( false );
        title.setText ( "内容" );
        title.setVisible ( false );
        CellConstraints cc = new CellConstraints ( );
        rootPanel.add ( title, cc.xy ( 1, 1 ) );
        content = new JLabel ( );
        content.setMaximumSize ( new Dimension ( 500, 24 ) );
        content.setMinimumSize ( new Dimension ( 500, 24 ) );
        content.setPreferredSize ( new Dimension ( 700, 24 ) );
        content.setText ( "文本" );
        rootPanel.add ( content, cc.xy ( 1, 7, CellConstraints.LEFT, CellConstraints.DEFAULT ) );
        contentArea = new JTextArea ( );
        contentArea.setEditable ( false );
        contentArea.setLineWrap ( true );
        contentArea.setMargin ( new Insets ( 0, 10, 0, 0 ) );
        contentArea.setText ( "文本" );
        rootPanel.add ( contentArea, cc.xy ( 1, 3, CellConstraints.FILL, CellConstraints.FILL ) );
        final Spacer spacer1 = new Spacer ( );
        rootPanel.add ( spacer1, cc.xywh ( 2, 3, 1, 5, CellConstraints.DEFAULT, CellConstraints.FILL ) );
        final JPanel panel1 = new JPanel ( );
        panel1.setLayout ( new GridLayoutManager ( 1, 1, new Insets ( 0, 0, 0, 0 ), -1, -1 ) );
        rootPanel.add ( panel1, cc.xywh ( 4, 3, 1, 5 ) );
        noRecentSnapshotsClickTextPane = new JTextPane ( );
        noRecentSnapshotsClickTextPane.setEditable ( false );
        Font noRecentSnapshotsClickTextPaneFont = this.$$$getFont$$$ ( "Arial Black", -1, -1, noRecentSnapshotsClickTextPane.getFont ( ) );
        if (noRecentSnapshotsClickTextPaneFont != null)
            noRecentSnapshotsClickTextPane.setFont ( noRecentSnapshotsClickTextPaneFont );
        noRecentSnapshotsClickTextPane.setText ( "No recent snapshots. Click on the process in the table or  Open snapshot:jft or hprof file" );
        panel1.add ( noRecentSnapshotsClickTextPane, new GridConstraints ( 0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension ( 1000, 200 ), null, 0, false ) );
        btNext = new JButton ( );
        btNext.setPreferredSize ( new Dimension ( 50, 46 ) );
        btNext.setText ( "save" );
        rootPanel.add ( btNext, cc.xy ( 6, 5 ) );
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName ( );
        } else {
            Font testFont = new Font ( fontName, Font.PLAIN, 10 );
            if (testFont.canDisplay ( 'a' ) && testFont.canDisplay ( '1' )) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName ( );
            }
        }
        Font font = new Font ( resultName, style >= 0 ? style : currentFont.getStyle ( ), size >= 0 ? size : currentFont.getSize ( ) );
        boolean isMac = System.getProperty ( "os.name", "" ).toLowerCase ( Locale.ENGLISH ).startsWith ( "mac" );
        Font fontWithFallback = isMac ? new Font ( font.getFamily ( ), font.getStyle ( ), font.getSize ( ) ) : new StyleContext ( ).getFont ( font.getFamily ( ), font.getStyle ( ), font.getSize ( ) );
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource ( fontWithFallback );
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }


}
