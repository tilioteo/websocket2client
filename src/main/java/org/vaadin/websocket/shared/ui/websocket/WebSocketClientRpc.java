/**
 * Apache Licence Version 2.0
 */
package org.vaadin.websocket.shared.ui.websocket;

import com.vaadin.shared.communication.ClientRpc;

/**
 * @author Kamil Morong, Tilioteo Ltd
 * 
 * Vaadin WebSocket client add-on
 */
public interface WebSocketClientRpc extends ClientRpc {

	public void send(String message);

}