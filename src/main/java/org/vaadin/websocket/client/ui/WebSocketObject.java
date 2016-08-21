/**
 * Apache Licence Version 2.0
 */
package org.vaadin.websocket.client.ui;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Kamil Morong, Tilioteo Ltd
 * 
 * Vaadin WebSocket client add-on
 */
public class WebSocketObject extends JavaScriptObject {

	protected WebSocketObject() {
	}

	public final native void send(String message) /*-{
		this.send(message);
	}-*/;

	public final native void close() /*-{
		this.close();
	}-*/;
}
