import { LitElement, html } from 'https://cdn.jsdelivr.net/gh/lit/dist@3/core/lit-core.min.js';

import StudentComponent from './StudentComponent.js';

export default class MyElement extends LitElement {
    createRenderRoot() {
        // skip shadow dom
        return this;
    }

    render() {
        return html`<p>Hello, World!
            <hr>
            <thws-student></thws-student>
        </p>`;
    }
}

customElements.define('thws-app', MyElement);

