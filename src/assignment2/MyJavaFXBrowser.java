/*
 * @filename  MyJavaFXBrower.java
 * @author MinyiYang, 040847473
 * @course CST8284 - OOP (java)
 * @Assignment 2
 * @date January 12th, 2018
 * @professor DaveHoutman
 * @purpose  This class is used for getting different menu items which have different function. 
 */
package assignment2;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


import javafx.geometry.Insets;
/**
 * This class is used for creating nodes and objects which are needed for application.
 *
 * @author Minyi Yang
 * @version 1.0 
 * @see package assignment2;
 * @see java.io.File;
 * @see javafx.application.Application;
 * @see javafx.scene.Scene;
 * @see javafx.scene.control.Button;
 * @see javafx.scene.control.Label;
 * @see javafx.scene.control.ListView;
 * @see javafx.scene.control.ScrollPane;
 * @see javafx.scene.control.SelectionMode;
 * @see javafx.scene.control.TextField;
 * @see javafx.scene.layout.BorderPane;
 * @see javafx.scene.layout.FlowPane;
 * @see javafx.scene.layout.HBox;
 * @see javafx.scene.layout.VBox;
 * @see javafx.scene.web.WebEngine;
 * @see javafx.scene.web.WebView;
 * @see javafx.stage.Stage;
 * @see javafx.geometry.Insets;
 * @since 1.8.0_144
 */
public class MyJavaFXBrowser extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		//SET TOP MENU
		VBox vbox=new VBox();
		//SET FILE TEXT
		File file=new File("default.web.txt");
		File markFile=new File("bookmarks.web.txt");
		//CREATE ADDRESS BAR
		HBox hbox=new HBox();
		Label lb_address = new Label("Enter Address");
		TextField input_address=new TextField(FileUtils.getFileContentsAsArrayList(file).get(0));
		lb_address.setPadding(new Insets(5,3,0,0));
		input_address.setPrefWidth(650);
		Button btn_go=new Button("Go");
		hbox.setPadding(new Insets(2,0,2,7));
		//CREATE RIGHT BORDER PANE
		FlowPane flow = new FlowPane();
	    flow.setVgap(2);
	    flow.setHgap(5);
	    flow.setPrefWrapLength(150);
		ListView<String> listView = new ListView<>();
		listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);	 
		Button backwards=new Button("<");
	    	Button forwards=new Button(">");
	    backwards.setStyle("-fx-padding: 8; -fx-margin-left: 5;-fx-background-color: #fff;-fx-border: 1; -fx-border-color: #666;-fx-border-radius: 10;");
	    	forwards.setStyle("-fx-padding: 8; -fx-margin-left: 5;-fx-background-color: #fff;-fx-border: 1; -fx-border-color: #666;-fx-border-radius: 10;");
		flow.getChildren().addAll(listView,backwards,forwards);
		//SET CENTER WEB OBJECT
	    WebPage currentPage = new WebPage();
		WebView webView = currentPage.getWebView();
		WebEngine webEngine = currentPage.createWebEngine(primaryStage,input_address,listView,backwards,forwards);
		webEngine.load(FileUtils.getFileContentsAsArrayList(file).get(0));
		//CREATE BOTTOM BORDER PANE
		ScrollPane sp=new ScrollPane();
		//SET BUTTON FUNCTION
		Menus.buttonFunction(btn_go, input_address, webEngine);
		Menus.press(input_address, webEngine);
		//Menus.setTextField(input_address, primaryStage, webEngine, listView);
		//SET ADDRESS BAR
		hbox.getChildren().addAll(lb_address,input_address,btn_go);
		//CREATE ROOT BORDER PANE
		BorderPane root = new BorderPane();
		//SET MENUS BAR AND FUNCTION
		vbox.getChildren().addAll(Menus.getMenuBar(webEngine,webView,vbox,hbox,markFile,file,root,sp ,flow,listView, forwards, backwards, primaryStage));
		//SET ROOT PANE		
		root.setCenter(webView);
		root.setTop(vbox);
		Menus.refreshhistory(webEngine,listView,backwards,forwards);
		Scene scene = new Scene(root, 800, 500);
		primaryStage.setScene(scene);
		primaryStage.show();	
	}
	/**
	 * Print out "Stop" in the Console
	 */
	public void stop() {
		System.out.println("Stop");
	}
	/**
	 * Define the main method application launch from here
	 * @param args a String array holds all parameter arguments
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

}
