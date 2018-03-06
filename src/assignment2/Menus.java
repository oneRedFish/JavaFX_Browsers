/*
 * @filename  Menus.java
 * @author Minyi Yang, 040847473
 * @course CST8284 - OOP (java)
 * @Assignment 2
 * @date January 12th, 2018
 * @professor Dave Houtman
 * @purpose  This file is used for Representing Menus 
 */
package assignment2;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.io.File;
import java.io.StringWriter;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.ArrayList;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
/**
 * This class is used for getting different menu items which have different function.
 *
 * @author Minyi Yang
 * @version 1.0 
 * @see package assignment2;
 * @see javafx.scene.web.WebEngine;
 * @see javafx.scene.web.WebHistory;
 * @see javafx.scene.web.WebView;
 * @see javafx.stage.Stage;
 * @see javafx.scene.control.Alert;
 * @see javafx.scene.control.Button;
 * @see javafx.scene.control.ContextMenu;
 * @see javafx.scene.control.CustomMenuItem;
 * @see javafx.scene.control.Label;
 * @see javafx.scene.control.ListView;
 * @see javafx.scene.control.Menu;
 * @see javafx.scene.control.MenuBar;
 * @see javafx.scene.control.MenuItem;
 * @see javafx.scene.control.ScrollPane;
 * @see javafx.scene.control.TextField;
 * @see javafx.scene.input.KeyCode;
 * @see javafx.scene.input.KeyCombination;
 * @see javafx.scene.input.MouseEvent;
 * @see javafx.scene.control.Alert.AlertType;
 * @see javafx.scene.layout.BorderPane;
 * @see javafx.scene.layout.FlowPane;
 * @see javafx.scene.layout.HBox;
 * @see javafx.scene.layout.VBox;
 * @see javafx.scene.text.Text;
 * @see java.io.File;
 * @see java.io.StringWriter;
 * @see javafx.application.Platform;
 * @see javafx.beans.binding.Bindings;
 * @see javafx.beans.value.ChangeListener;
 * @see javafx.beans.value.ObservableValue;
 * @see javafx.collections.FXCollections;
 * @see javafx.collections.ObservableList;
 * @see javafx.concurrent.Worker;
 * @see javafx.concurrent.Worker.State;
 * @see javafx.event.ActionEvent;
 * @see javafx.event.EventHandler;
 * @see java.util.ArrayList;
 * @see javax.xml.transform.Transformer;
 * @see javax.xml.transform.TransformerFactory;
 * @see javax.xml.transform.dom.DOMSource;
 * @see javax.xml.transform.stream.StreamResult;
 * @since 1.8.0_144
 */
public class Menus {
	/**
	 * Create a static private Object of MenuBar named menuBar
	 */
	private static MenuBar menuBar;
	/**
	 * Create a static private Object of Menu named mnuFile
	 */
	private static Menu mnuFile;
	/**
	 * Create a static private Object of Menu named mnuSettings
	 */
	private static Menu mnuSettings;
	/**
	 * Create a static private Object of Menu named mnuBookmarks
	 */
	private static Menu mnuBookmarks;
	/**
	 * Create a static private Object of Menu named mnuHelp
	 */
	private static Menu mnuHelp;
	/**
	 * Create a static private Object of MenuItem named mnuItemRefresh
	 */
	private static MenuItem mnuItemRefresh;
	/**
	 * Create a static private Object of MenuItem named mnuItemExit
	 */
	private static MenuItem mnuItemExit;
	/**
	 * Create a static private Object of MenuItem named mnuItemToggleAddressBar
	 */
	private static MenuItem mnuItemToggleAddressBar;
	/**
	 * Create a static private Object of MenuItem named mnuItemChangeStartup
	 */
	private static MenuItem mnuItemChangeStartup;
	/**
	 * Create a static private Object of MenuItem named mnuItemAddBookmark
	 */
	private static MenuItem mnuItemAddBookmark;
	/**
	 * Create a static private Object of MenuItem named mnuItemAbout
	 */
	private static MenuItem mnuItemAbout;
	/**
	 * Create a static private Object of MenuItem named mnuItemHistory
	 */
	private static MenuItem mnuItemHistory;
	/**
	 * Create a static private Object of MenuItem named mnuItemDisplayCode
	 */
	private static MenuItem mnuItemDisplayCode;
	
	/**
	 * Returns an MenuItem object that can reload the web page through the web engine.
	 * The WebView argument which comes from MyJavaFXBrower class.
	 * @param wv  a WebView object which is used get web engine
	 * @return    a MenuItem object which handles web engine reload event.
	 */
	public static MenuItem getMnuItemRefresh(WebView wv) {
		mnuItemRefresh.setOnAction((ActionEvent e) -> wv.getEngine().reload());
		return mnuItemRefresh;
	}
	
	/**
	 * Returns an MenuItem object that can exit the program.
	 * @return      the MenuItem object which handles Platform exit event.
	 */
	public static MenuItem getMnuItemExit() {
		mnuItemExit.setOnAction((ActionEvent e) -> Platform.exit());
		return mnuItemExit;
	}
	
	/**
	 * Returns an MenuItem object that can pop up a Alert window.
	 * @return      the MenuItem object which handles Alert window event.
	 */
	public static MenuItem getmnuItemAbout() {
		mnuItemAbout.setOnAction((ActionEvent e) -> {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Alert Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Minyi Yang 040847473");
				alert.showAndWait();
			}
		);
		return mnuItemAbout;
	}
	
	/**
	 * Returns an MenuItem object that can add or remove AddressBar.
	 * @param vbox VBox which is used to store Menus and AddressBar
	 * @param hbox HBox which is used to store AddressBar
	 * @return a MenuItem object which handles add or remove ActionEvent.
	 */
	public static MenuItem getmnuItemToggleAddressBar(VBox vbox, HBox hbox) {
		mnuItemToggleAddressBar.setOnAction((ActionEvent e) -> {
				if(vbox.getChildren().contains(hbox)) {
					vbox.getChildren().remove(hbox);
				}
				else {
					vbox.getChildren().addAll(hbox);
				}
			}
		);
		return mnuItemToggleAddressBar;
	}
	
	/**
	 * Returns an MenuItem object that can add or remove a FlowPane from BorderPane.
	 * @param root	The BorderPane which is used to store all other sub-nodes
	 * @param flow  The FlowPane which is used to store History list and (backwards,forwards) buttons
	 * @return a MenuItem object which handles add or remove ActionEvent.
	 */
	public static MenuItem getmnuItemHistory(BorderPane root,FlowPane flow) {
		mnuItemHistory.setOnAction((ActionEvent e) -> {
				if(root.getChildren().contains(flow)) {
					root.getChildren().remove(flow);				
				}
				else {
				    	root.setRight(flow);
				}
			}
		);
		return mnuItemHistory;
	}
	 
	/**
	 * Add and Refresh the history listView which stores the titles of history pages when there is change of the state.
	 * @param webEngine  a WebEngine object which is used to get web history
	 * @param listView   a String type listView stores the titles of web history
	 * @param backwards  a Button is used to go back web page
	 * @param forwards   a Button is used to go forward web page
	 */
	public static void refreshhistory(WebEngine webEngine,ListView<String> listView,Button backwards,Button forwards) {
		webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
			@Override
			public void changed(ObservableValue<? extends State> ov, State oldState, State newState) {
		    if (newState == Worker.State.SUCCEEDED) {
				    WebHistory history=webEngine.getHistory();
					ObservableList<WebHistory.Entry> items =FXCollections.observableArrayList (history.getEntries());
				 	ObservableList<String> names = FXCollections.observableArrayList();
					    	for(int i=0; i<items.size(); i++) {
					    		String title =items.get(i).getTitle()+"\n";
					    		names.add(title); 
					    	}
				    	listView.setPrefWidth(150);
				    	listView.setItems(names);
				    	listView.getSelectionModel().select(history.getCurrentIndex());
				    backwards.disableProperty().bind(history.currentIndexProperty().isEqualTo(0));
					forwards.disableProperty().bind(history.currentIndexProperty().greaterThanOrEqualTo(Bindings.size(items).subtract(1)));
				}
			}
		});
	}
	
	/**
	 * Set the backwards button with go to backward page function.
	 * @param forwards  a Button is used to go forward web page
	 * @param backwards a Button is used to go back web page
	 * @param webEngine a WebEngine object which is used to get web history
	 * @param listView  a String type listView stores the titles of web history
	 */
	public static void backwards (Button forwards,Button backwards,WebEngine webEngine,ListView<String> listView) {
			//backwards function
		    backwards.setOnAction((ActionEvent e) -> {
				 WebHistory history=webEngine.getHistory();
				 int currentIndex=history.getCurrentIndex();
						 Platform.runLater(new Runnable() { 
							 public void run() { 
								 history.go(history.getEntries().size() > 1  && currentIndex > 0 ? -1 : 0);
								 listView.getSelectionModel().selectIndices(currentIndex-1);
								 } 
						 });
			});		
		}
	 /**
	  * Set the forwards button with go to forward page function.
	  * @param forwards  a Button is used to go forward web page
	  * @param backwards a Button is used to go back web page
	  * @param webEngine a WebEngine object which is used to get web history
	  * @param listView  a String type listView stores the titles of web history
	  */
	 public static void forwards (Button forwards,Button backwards,WebEngine webEngine,ListView<String> listView) {
			//forwards function
		  	forwards.setOnAction((ActionEvent e) -> {
				 WebHistory history=webEngine.getHistory();
				 int currentIndex=history.getCurrentIndex();
					Platform.runLater(new Runnable() { 
							 public void run() { 
								 history.go(history.getEntries().size() > 1  && currentIndex < history.getEntries().size()-1 ? 1 : 0);
								 listView.getSelectionModel().select(currentIndex+1);
							 } 
					});
			});		
		}
	/**
	 * Return an MenuItem object that can add or remove a FlowPane from BorderPane and display the source code from web page
	 * @param root       The BorderPane which is used to store all other sub-nodes
	 * @param webEngine  a WebEngine object which is used to get web history
	 * @param sp         a ScrollPane which stores MenuItem
	 * @return a MenuItem object which stores the html, javascript code and can be added or removed from BorderPane
	 */
	public static MenuItem getmnuItemDisplayCode(BorderPane root,WebEngine webEngine, ScrollPane sp) {
		mnuItemDisplayCode.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(root.getChildren().contains(sp)) {
					root.getChildren().remove(sp);				
				}
				else {
					Text code_list = new Text();
					try {
		                  TransformerFactory transformerFactory = TransformerFactory.newInstance();
		                  Transformer transformer = transformerFactory.newTransformer();
		                  StringWriter stringWriter = new StringWriter();
		                  transformer.transform(new DOMSource(webEngine.getDocument()),new StreamResult(stringWriter));
		                  String xml = stringWriter.getBuffer().toString();
		                  code_list = new Text(xml);
		                } catch (Exception m) {
		                  m.printStackTrace();
		                }
					sp.setMaxHeight(200);
				    	sp.setContent(code_list);
					root.setBottom(sp);
				}
			}
		});
		return mnuItemDisplayCode;
	}
	/**
	 * Return a MenuItem object which can add Bookmarks or remove them.
	 * @param webEngine    a WebEngine object which is used to get web history
	 * @param markFile     a File object which stores book mark
	 * @param primaryStage the Stage which is top level of container
	 * @return a MenuItem object which adds Bookmarks or removes them.
	 */
	public static MenuItem getmnuItemAddBookmark(WebEngine webEngine,File markFile,Stage primaryStage) {
		mnuItemAddBookmark.setOnAction((ActionEvent e) -> {
				FileUtils fu = new FileUtils();
				fu.setFileName(markFile.getName());
				fu.setPath(markFile.getPath());
				ArrayList<String> arraylist = new ArrayList<String>();
				arraylist.add(webEngine.getLocation());
				FileUtils.saveFilrContents(markFile, arraylist);
				for(int i=FileUtils.getFileContentsAsArrayList(markFile).size()-1; i<FileUtils.getFileContentsAsArrayList(markFile).size(); i++) {
					Bookmark(markFile,i,webEngine);
				}
			}
		);
		return mnuItemAddBookmark;
	}
	/**
	 * Set the items with mouse event load page with right click and delete with left click.
	 * @param markFile   a File object which stores book mark
	 * @param i          an integer which is the index of an ArrayList
	 * @param webEngine  a WebEngine object which is used to get web history
	 */
	public static void Bookmark(File markFile, int i,WebEngine webEngine) {
		String url = FileUtils.getFileContentsAsArrayList(markFile).get(i);
		ContextMenu cm = new ContextMenu();
		MenuItem cmItem = new MenuItem("Delete Page");
		CustomMenuItem address = new CustomMenuItem(new Label(url));
		address.setHideOnClick(false);
		cmItem.setOnAction((ActionEvent e) -> {
		    		mnuBookmarks.getItems().remove(address);
				FileUtils.deleteFilrContents(markFile, url);
		    }
		);
		cm.getItems().add(cmItem);
		//right click book mark list and show the custom menu item 
		address.getContent().setOnMousePressed((MouseEvent event) -> {
		        if (event.isSecondaryButtonDown()) {
		        		cm.show(address.getContent(), event.getScreenX(), event.getScreenY());
		        }
		        else {
			           webEngine.load(url);	
		        }
		    }
		);
		mnuBookmarks.getItems().add(address);
	}
	/** 
	 * Get the last item in the Bookmark list and add the function to it
	 * @param webEngine a WebEngine object which is used to get web history
	 * @param markFile  a File object which stores Bookmark
	 */
	public static void getmenuItemList(WebEngine webEngine,File markFile) {
		if(markFile.exists()) {
			//get the last book mark
			for(int i=0; i<FileUtils.getFileContentsAsArrayList(markFile).size(); i++) {
				Bookmark(markFile,i,webEngine);
			}
		}
	}
	
	/**
	 * Return MenuItem and stores the current page to a file
	 * @param webEngine a WebEngine object which is used to get web history
	 * @param file a File that is used to store the current page
	 * @return a MenuItem changes the content in file document 
	 */
	public static MenuItem getmnuItemChangeStartup(WebEngine webEngine,File file) {
		mnuItemChangeStartup.setOnAction((ActionEvent e) -> {
				FileUtils fu = new FileUtils();
				fu.setFileName(file.getName());
				fu.setPath(file.getPath());
				ArrayList<String> arraylist = new ArrayList<String>();
				arraylist.add(webEngine.getLocation());
				FileUtils.saveFilrContents(file, arraylist);
			}
		);
		return mnuItemChangeStartup;
	}
	
	/**
	 * Set the load address from textfield function to the Button click
	 * @param btn_go        a Button which can load the address from TextField
	 * @param input_address a TextField is used to get input from users
	 * @param webEngine     a WebEngine object which is used to get web history
	 */
	public static void buttonFunction (Button btn_go,TextField input_address,WebEngine webEngine) {
		//go function
		btn_go.setOnAction((ActionEvent e) -> webEngine.load(input_address.getText()));		
	}
	
	/**
	 * Set the load address from textfield function to the Button with ENTER key press
	 * @param input_address a TextField is used to get input from users
	 * @param webEngine     a WebEngine object which is used to get web history
	 */
	public static void press (TextField input_address,WebEngine webEngine) {
		//press function
		input_address.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER){
				webEngine.load(input_address.getText());
			}
		});	
	}
	
	/**
	 * Instantiate menusBar, menus, menuitems, set the shortcut to each menuitem and add them into the menus, and put menus into menubar
	 * @param webEngine    a WebEngine object which is used to get web history
	 * @param webView      a WebView object which is used get web engine
	 * @param vbox         VBox which is used to store Menus and AddressBar
	 * @param hbox         HBox which is used to store AddressBar
	 * @param markFile     a File object which stores book mark
	 * @param file         a File that is used to store the current page
	 * @param root         The BorderPane which is used to store all other sub-nodes
	 * @param sp           a ScrollPane which stores MenuItem
	 * @param flow         The FlowPane which is used to store History list and (backwards,forwards) buttons
	 * @param listView     a String type listView stores the titles of web history
	 * @param forwards     a Button is used to go forward web page
	 * @param backwards    a Button is used to go back web page
	 * @param primaryStage the Stage which is top level of container
	 * @return a MenuBar object which contains menus and menuitems with their functions.
	 */
	public static MenuBar getMenuBar(WebEngine webEngine,WebView webView,VBox vbox,HBox hbox,File markFile,File file,BorderPane root,ScrollPane sp,FlowPane flow,ListView<String> listView,Button forwards ,Button backwards,Stage primaryStage) {
		//create menus
		menuBar = new MenuBar();
		mnuFile = new Menu("_Files");
		mnuSettings = new Menu("_Settings");
		mnuBookmarks = new Menu("_Bookmarks");
		mnuHelp = new Menu("_Help");
		//create file items
		mnuItemRefresh = new MenuItem("Refresh");
		mnuItemRefresh.setAccelerator(KeyCombination.keyCombination("Shortcut+F"));
		mnuItemExit=new MenuItem("Exit");
		mnuItemExit.setAccelerator(KeyCombination.keyCombination("Shortcut+E"));
		mnuFile.getItems().addAll(getMnuItemRefresh(webView),getMnuItemExit());
		//create set items
		mnuItemToggleAddressBar= new MenuItem("Toggle Address Bar");
		mnuItemToggleAddressBar.setAccelerator(KeyCombination.keyCombination("Shortcut+T"));
		mnuItemChangeStartup= new MenuItem("Change Start-up Page");
		mnuItemChangeStartup.setAccelerator(KeyCombination.keyCombination("Shortcut+S"));
		mnuItemHistory= new MenuItem("History");
		mnuItemHistory.setAccelerator(KeyCombination.keyCombination("Shortcut+H"));
		mnuItemDisplayCode=new MenuItem("DisplayCode");
		mnuItemDisplayCode.setAccelerator(KeyCombination.keyCombination("Shortcut+D"));
		mnuSettings.getItems().addAll(getmnuItemToggleAddressBar(vbox, hbox),getmnuItemChangeStartup(webEngine, file),getmnuItemHistory(root, flow),getmnuItemDisplayCode(root, webEngine, sp));
		backwards (forwards,backwards, webEngine,listView);
		forwards (forwards, backwards,webEngine,listView);
		//create book marks items
		mnuItemAddBookmark= new MenuItem("Add Bookmark");
		mnuItemAddBookmark.setAccelerator(KeyCombination.keyCombination("Shortcut+B"));
		mnuBookmarks.getItems().add(getmnuItemAddBookmark(webEngine, markFile, primaryStage));
		getmenuItemList(webEngine, markFile);//reload the list 
		//create help items
		mnuItemAbout= new MenuItem("About");
		mnuItemAbout.setAccelerator(KeyCombination.keyCombination("Shortcut+A"));
		mnuHelp.getItems().addAll(getmnuItemAbout());
		//add mens to bar
		menuBar.getMenus().addAll(mnuFile,mnuSettings,mnuBookmarks,mnuHelp);
		return menuBar;
	}	
}
