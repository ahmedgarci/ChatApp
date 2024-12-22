import * as SockJS from 'sockjs-client';
import { Client, Message } from '@stomp/stompjs';

class WebSocketService {
  private client: Client;

  constructor() {
    this.client = new Client({
      brokerURL: '/ws',
      webSocketFactory: () => new SockJS('http://localhost:8081/ws'), 
    
    });
  }

  connect(onMessageReceived: (message: Message) => void) {
    
    this.client.onConnect = () => {
      console.log('Connected to WebSocket');

      this.client.subscribe('/user/chat', onMessageReceived);
    };

    this.client.activate();
  }

  disconnect() {
    if (this.client.active) {
      this.client.deactivate();
      console.log('Disconnected from WebSocket');
    }
  }

  sendMessage(destination: string, body: string) {
    if (this.client.active) {
      this.client.publish({ destination, body });
    }
  }
}

export default new WebSocketService();
