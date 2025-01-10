import { LitElement, html } from 'https://cdn.jsdelivr.net/gh/lit/dist@3/core/lit-core.min.js';


export default class ChatComponent extends LitElement {

    static properties = {

    }

    createRenderRoot() {
        // skip shadow dom
        return this;
    }

    constructor() {
        super();

        this.connected = false;
        this.socket = null;
    };

    scrollToBottom() {
        // $('#chat').scrollTop($('#chat')[0].scrollHeight);
    }


    wsConnect() {
        const name = document.querySelector('#name').value
        console.log('wsConnect', name);

        if (true) {

            console.log("Val: " + name);
            this.socket = new WebSocket("ws://" + location.host + "/chat/" + name);
            this.socket.onopen = function () {

                console.log("Connected to the web socket");

            };
            this.socket.onmessage = function (m) {
                console.log("Got message: " + m.data);
                document.querySelector('#chat').value += m.data + "\n";

            };
        }
    }

    sendNewMessage() {
        const message = document.querySelector('#msg').value
        console.log('sendNewMessage', message);

        const value = document.querySelector('#msg').value;
        console.log("Sending " + value);
        this.socket.send(value);
        document.querySelector('#msg').value = "";

    }

    render() {


        return html`
        <h3>Chat</h3>

        <div class="container">
      <br/>
      <div class="row">
          <input id="name" class="col-md-4" type="text" placeholder="your name">
          <button id="connect" class="col-md-1 btn btn-primary" type="button" @click="${_ => this.wsConnect()}">connect</button>
          <br/>
          <br/>
      </div>
      <div class="row">
          <textarea class="col-md-8" id="chat"></textarea>
      </div>
      <div class="row">
          <input class="col-md-6" id="msg" type="text" placeholder="enter your message">
          <button class="col-md-1 btn btn-primary" id="send" type="button" @click="${_ => this.sendNewMessage()}">send</button>
      </div>
      
      </div>
        `;
    }
}

customElements.define('thws-chat', ChatComponent);

