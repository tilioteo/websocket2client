/**
 * Apache Licence Version 2.0
 */
package org.vaadin.websocket.client.ui;

/**
 * @author Kamil Morong, Tilioteo Ltd
 * 
 * Vaadin WebSocket client add-on
 */
public interface WebSocketHandler {

	public void onMessage(String message);

	public void onError(String message);

	public void onOpen();

	public void onClose();

	public void onFail();

}
