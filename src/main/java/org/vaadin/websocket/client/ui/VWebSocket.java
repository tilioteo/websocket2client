/**
 * Apache Licence Version 2.0
 */
package org.vaadin.websocket.client.ui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Kamil Morong, Tilioteo Ltd
 * 
 * Vaadin WebSocket client add-on
 */
public class VWebSocket extends Widget {

	private WebSocketHandler handler = null;
	private WebSocketObject webSocketObject = null;

	private String url = "";

	private boolean opening = false;

	public static final String CLASSNAME = "v-websocket";

	public VWebSocket() {
		setElement(Document.get().createDivElement());
		setStyleName(CLASSNAME);
		setVisible(false);
	}

	private void initWebSocketObject() {
		if (webSocketObject != null) {
			webSocketObject.close();
			webSocketObject = null;
		}

		if (url != null && !url.isEmpty()) {
			opening = true;
			initWebSocketObject(this, url);
		}
	}

	private static native void initWebSocketObject(VWebSocket widget, String url) /*-{
		try {
			var obj = new $wnd.WebSocket(url);
			
			obj.onopen = function() {
				widget.@org.vaadin.websocket.client.ui.VWebSocket::onOpen()();
			}
			obj.onclose = function() {
				widget.@org.vaadin.websocket.client.ui.VWebSocket::onClose()();
			}
			obj.onmessage = function(evt) {
				var message = evt.data;
				widget.@org.vaadin.websocket.client.ui.VWebSocket::onMessage(Ljava/lang/String;)(message);
			}
			obj.onerror = function(evt) {
				var message = evt.data;
				widget.@org.vaadin.websocket.client.ui.VWebSocket::onError(Ljava/lang/String;)(message);
			}
			
			widget.@org.vaadin.websocket.client.ui.VWebSocket::webSocketObject = obj;
			
			} catch(e) {
		}
	}-*/;

	public void setUrl(String url) {
		if (this.url != url) {
			this.url = url;
			initWebSocketObject();
		}
	}

	public void send(String message) {
		if (webSocketObject != null) {
			webSocketObject.send(message);
		}
	}

	public void close() {
		if (webSocketObject != null) {
			webSocketObject.close();
		}
	}

	public void setHandler(WebSocketHandler handler) {
		this.handler = handler;
	}

	public void onMessage(String message) {
		if (handler != null) {
			handler.onMessage(message);
		}
	}

	public void onError(String message) {
		if (handler != null) {
			handler.onError(message);
		}
	}

	public void onOpen() {
		opening = false;
		if (handler != null) {
			handler.onOpen();
		}
	}

	public void onClose() {
		if (handler != null) {
			if (opening) {
				opening = false;
				this.url = null;
				webSocketObject = null;
				handler.onFail();
			} else {
				handler.onClose();
			}
		}
	}

}