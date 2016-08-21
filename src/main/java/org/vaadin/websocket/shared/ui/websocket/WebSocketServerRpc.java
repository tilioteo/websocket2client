/**
 * Apache Licence Version 2.0
 */
package org.vaadin.websocket.shared.ui.websocket;

import com.vaadin.shared.communication.ServerRpc;

/**
 * @author Kamil Morong, Tilioteo Ltd
 * 
 * Vaadin WebSocket client add-on
 */
public interface WebSocketServerRpc extends ServerRpc {

	public void message(String message);

	public void error(String message);

	public void open();

	public void close();

	public void fail();

}
