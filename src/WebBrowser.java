import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

public class WebBrowser extends JPanel {

    WebEngine webEngine;
    WebView webView;
    JFrame frame = new JFrame();

    public WebBrowser() {
        frame.add(this);
        frame.setSize(720, 576);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // Here you can give your own implementation according to you.
                //webView.getEngine().load(null);
                clear();
                //System.exit(0);
            }
        });

        final JFXPanel fxPanel = new JFXPanel();
        setLayout(new BorderLayout());
        add(fxPanel, BorderLayout.CENTER);
        //add(toolbar, BorderLayout.NORTH);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
        });
    }

    public void setSize(int w, int h) {
        frame.setSize(w, h);
    }

    public void setTitle(String str) {
        frame.setTitle(str.trim());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //initAndShowGUI();
            }
        });
    }

    public void loadPage(String url) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                webEngine.setJavaScriptEnabled(true);
                webEngine.load(url);
            }
        });

    }

    public void loadLocalPage(String path) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                URL url = this.getClass().getResource(path);
                webEngine.setJavaScriptEnabled(true);
                webEngine.load(url.toString());
            }
        });
    }

    public void clear() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                webView.getEngine().load(null);
            }
        });
    }

    private void initFX(JFXPanel fxPanel) {
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    private Scene createScene() {
        webView = new WebView();
        webEngine = webView.getEngine();
        webEngine.getLoadWorker().progressProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                System.out.println("Process changed: " + arg0 + ", arg1: " + arg1 + ", arg2: " + arg2);
            }
        });

        webEngine.getLoadWorker().messageProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                System.out.println("message changed: " + arg0 + ", arg1: " + arg1 + ", arg2: " + arg2);
            }
        });

        webEngine.getLoadWorker().exceptionProperty().addListener(new ChangeListener<Throwable>() {
            @Override
            public void changed(ObservableValue<? extends Throwable> arg0, Throwable arg1, Throwable arg2) {
                System.out.println(arg0);
                System.out.println(arg1);
                System.out.println(arg2);
            }
        });

        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> arg0, Worker.State arg1, Worker.State arg2) {
                System.out.println("old state: " + arg1 + ", new state: " + arg2 + ", arg0: " + arg0);
            }
        });

        //webEngine.load("http://www.google.com");

        BorderPane bp = new BorderPane();
        bp.setCenter(webView);

        Scene scene = new Scene(bp);

        return (scene);
    }
}