import { LitElement, html } from 'https://cdn.jsdelivr.net/gh/lit/dist@3/core/lit-core.min.js';

import StudentComponent from './StudentComponent.js';
import ChatComponent from './ChatComponent.js';


export default class MyElement extends LitElement {
    createRenderRoot() {
        // skip shadow dom
        return this;
    }

    render() {
        return html`<p>Hello, World!
            <div class="row">
                <div class="col"><thws-student></thws-student></div>
                <div class="col"><thws-chat></thws-chat></div>
            </div>
            
        </p>`;
    }
}

customElements.define('thws-app', MyElement);

