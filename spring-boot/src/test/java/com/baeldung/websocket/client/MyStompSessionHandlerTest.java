package com.baeldung.websocket.client;

import org.baeldung.websocket.client.MyStompSessionHandler;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;

/**
 * Test class for MyStompSessionHandler
 * @author Kalyan
 *
 */
public class MyStompSessionHandlerTest {

    @Test
    public void testAfterConnectedSuccessfull() {
        StompSession mockSession = Mockito.mock(StompSession.class);
        StompHeaders mockHeader = Mockito.mock(StompHeaders.class);
        MyStompSessionHandler sessionHandler = new MyStompSessionHandler();
        sessionHandler.afterConnected(mockSession, mockHeader);
        Mockito.verify(mockSession).subscribe("/topic/messages", sessionHandler);
        Mockito.verify(mockSession).send(Mockito.anyString(), Mockito.anyObject());
    }
}

