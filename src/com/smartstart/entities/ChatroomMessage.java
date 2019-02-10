/*
 * This application shows how to use websockets with the embedded Jetty
 * web server.
 */

package com.smartstart.entities;

import java.util.Date;

/**
 * This class represents a very simple chatroom message.
 *
 * @author Mike Arace
 */
public class ChatroomMessage {

    /**
     * The IP address the message came from.
     */
    String fromAddress = null;
    
    private int id_message;
    private int message_from;
    private int message_to;
    private String content;
    private String attachment;
    private Date date_message;
    private int viewed;

    /**
     * The message itself.
     */
    String message = null;

    public ChatroomMessage(String fromAddress, String message) {
        this.fromAddress = fromAddress;
        this.message = message;
    }

    /**
     * Returns a formatted version of the message.
     *
     * @return
     */
    public String print() {
        return "<p>[" + this.fromAddress + "] " + this.message + "</p>";
    }
}
