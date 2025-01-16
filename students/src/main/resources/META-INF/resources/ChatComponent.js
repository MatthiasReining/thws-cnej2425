import { LitElement, html } from 'https://cdn.jsdelivr.net/gh/lit/dist@3/core/lit-core.min.js';

export default class ChatComponent extends LitElement {
  static properties = {
    _connected: { type: Boolean },
  };

  createRenderRoot() {
    // skip shadow dom
    return this;
  }

  constructor() {
    super();

    this._connected = false;
    this._socket = null;
  }

  scrollToBottom() {
    // $('#chat').scrollTop($('#chat')[0].scrollHeight);
  }

  wsConnect() {
    const name = this.querySelector('#name').value;
    console.log('wsConnect', name);

    this._socket = new WebSocket('ws://' + location.host + '/chat/' + name);
    this._socket.onopen = (_) => (this._connected = true);
    this._socket.onmessage = (message) => this.messageReceived(message);
  }

  messageReceived(message) {
    console.log('Got message: ' + message.data);
    this.querySelector('#chat').value += message.data + '\n';
  }

  sendNewMessage() {
    const message = this.querySelector('#msg').value;
    console.log('sendNewMessage', message);

    this._socket.send(message);
    this.querySelector('#msg').value = '';
  }

  render() {
    return html`
      <h3>Chat</h3>

      <div class="container">
        <div class="row">
          <div class="col-8">
            <input id="name" .disabled=${this._connected} class="form-control" type="text" placeholder="your name" />
          </div>
          <div class="col-4">
            <button
              id="connect"
              .disabled=${this._connected}
              class="form-control btn btn-primary"
              type="button"
              @click="${(_) => this.wsConnect()}"
            >
              connect
            </button>
          </div>
        </div>
        <div class="row mt-3">
          <div class="col-12">
            <textarea readonly class="form-control" style="height: 200px" id="chat"></textarea>
          </div>
        </div>
        <div class="row mt-3">
          <div class="col-8">
            <input id="msg" class="form-control" type="text" placeholder="enter your message" />
          </div>
          <div class="col-4">
            <button
              class="btn btn-primary form-control"
              .disabled=${!this._connected}
              type="button"
              @click="${(_) => this.sendNewMessage()}"
            >
              send
            </button>
          </div>
        </div>
      </div>
    `;
  }
}

customElements.define('thws-chat', ChatComponent);
