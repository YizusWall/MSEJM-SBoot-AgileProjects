
package org.yizus.microservices.generics;

public class MessageToException extends Exception{

     public MessageToException(String message) {
    super(message);
}
    public MessageToException(String message, Exception ex) {
        super(message, ex);
    }
}