/*
 * @filename  WebPage.java
 * @author MinyiYang, 040847473
 * @course CST8284 - OOP (java)
 * @Assignment 2
 * @date January 12th, 2018
 * @professor DaveHoutman
 * @purpose  This class is used for getting different menu items which have different function. 
 */
package assignment2;

import java.net.MalformedURLException;
import java.net.URL;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
/**
 * This class is used for getting webEngine and webView and change the browser's title and catch MalformedURLException,IllegalArgumentException.
 *
 * @author Minyi Yang
 * @version 1.0 
 * @see package assignment2;
 * @see java.net.MalformedURLException;
 * @see java.net.URL;
 * @see javafx.beans.value.ChangeListener;
 * @see javafx.beans.value.ObservableValue;
 * @see javafx.concurrent.Worker;
 * @see javafx.concurrent.Worker.State;
 * @see javafx.scene.control.Alert;
 * @see javafx.scene.control.Button;
 * @see javafx.scene.control.ListView;
 * @see javafx.scene.control.TextField;
 * @see javafx.scene.control.Alert.AlertType;
 * @see javafx.scene.web.WebEngine;
 * @see javafx.scene.web.WebView;
 * @see javafx.stage.Stage;
 * @since 1.8.0_144
 */
public class WebPage {
	/**
	 * Create a WebView object named webview
	 */
	private WebView webview = new WebView();
	
	/**
	 * Create a WebEngine object named engine
	 */
	private WebEngine engine;
	
	/**
	 * Return a WebEngine which has a ChangeListener when the state changes the title of browser and content of textfield will change too.
	 * @param stage         the Stage which is top level of container
	 * @param input_address a TextField is used to get input from users
	 * @param listView      a String type listView stores the titles of web history
	 * @param backwards     a Button is used to go back web page
	 * @param forwards      a Button is used to go forward web page
	 * @return a WebEngine object which will load title of current page and refresh the content of textfield and catch exception.
	 */
	public WebEngine createWebEngine(Stage stage,TextField input_address,ListView<String> listView,Button backwards,Button forwards) {
		WebView wv = getWebView();
		engine = wv.getEngine();		
		//Change title when loading successful
		engine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
			@Override
			public void changed(ObservableValue<? extends State> ov, State oldState, State newState) {
				if (newState == Worker.State.RUNNING) {
					//MalformedURLException
					try {
						 new URL(input_address.getText());
					}
					catch(StringIndexOutOfBoundsException ex)
					{
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("StringIndexOutOfBoundsException");
						alert.setHeaderText(null);
						alert.setContentText("There is 'StringIndexOutOfBoundsException'");
						alert.showAndWait();
					}
					catch (MalformedURLException ex){
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("MalformedURLException");
						alert.setHeaderText(null);
						alert.setContentText("There is 'MalformedURLException'");
						alert.showAndWait();
					}
					catch (IllegalArgumentException ex){
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("IllegalArgumentException");
						alert.setHeaderText(null);
						alert.setContentText("There is 'IllegalArgumentException'");
						alert.showAndWait();
					}
					stage.setTitle(engine.getLocation());
					input_address.setText(stage.getTitle());
				}
			}
		});
		return engine;
	}
	
	/**
	 * Get the webview
	 * @return a WebView object
	 */
	public WebView getWebView() {
		return webview;
	}
	
	/**
	 * Get the webengine
	 * @return a WebEngine object
	 */
	public WebEngine getWebEngine() {
		return engine;
	}
}
