package MiniWeb;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MiniWebController implements Initializable {

    @FXML
    private Hyperlink hlBackward;

    @FXML
    private Hyperlink hlForward;
    @FXML
    private TextField searchTextField;

    @FXML
    private Hyperlink hlReload;

    @FXML
    private Hyperlink hlHome;

    @FXML
    private Hyperlink hlSearch;

    @FXML
    private Hyperlink hlZin;

    @FXML
    private Hyperlink hlZout;

    @FXML
    private Hyperlink hlAbout;

    @FXML
    private WebView webView;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        WebEngine webEngine = webView.getEngine();
        webEngine.load("https://www.google.com");
        System.out.println(webEngine.getUserAgent());

        //Go Backward

        //Go Forward

        //Reload link
        hlReload.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webEngine.reload();
            }
        });


        //Home link
        hlHome.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webEngine.load("https://www.google.com");

            }
        });

        //Search link
        hlSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                webEngine.load(searchTextField.getText());;

            }
        });


        //Zoom in link
        hlZin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double size =1.0;
                size=webView.getZoom()+0.3;
                webView.setZoom(size); //100%
            }
        });


        //Zoom out link
        hlZout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double size =1.0;
                size=webView.getZoom()-0.1;
                webView.setZoom(size); //100%
            }
        });


        //About link
        hlAbout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String content = "Heeey! There is nothing to tell about this web page :) Have a nice winter break";
               webEngine.loadContent(content, "text/html");
            }
        });
        WebHistory webHistory = webEngine.getHistory();

       hlForward.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    webHistory.go(1);
                }catch (Exception e){
                    webEngine.load("https://www.google.com");
                }

            }
        });
       hlBackward.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    webHistory.go(-1);
                }catch (Exception e){
                    webEngine.load("https://www.google.com");
                }
            }
        });





    }
}


