import { LitElement, html } from 'https://cdn.jsdelivr.net/gh/lit/dist@3/core/lit-core.min.js';


export default class StudentComponent extends LitElement {

    static properties = {
        students: [],
        _newStudentFormuala: false,
        _newStudent: {}
    }


    createRenderRoot() {
        // skip shadow dom
        return this;
    }

    constructor() {
        super();
        this.#loadData();
        this._newStudent = {}
    };


    async #loadData() {
        let resp = await fetch('http://localhost:8080/students');
        let data = await resp.json();
        console.log(data);

        this.students = data;
    }

    async #createNewStudent() {
        console.log('createNewStudent');



        const response = await fetch("http://localhost:8080/students", {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify(this._newStudent)
        });
        // TODO validation and error handling

        this.#loadData();
    }

    #renderNewStudentFormula() {
        return html`
        <div class="container m-4 p-5">
            <h3>New Student</h3>
        <div class="card p-4">

            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="firstName" placeholder="first name" @input="${e => this._newStudent = { ...this._newStudent, firstname: e.target.value }}">
                <label for="firstName">First Name</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="lastname" placeholder="last name" @input="${e => this._newStudent = { ...this._newStudent, lastname: e.target.value }}">
                <label for= "lastName" > Last Name</label>
            </div >
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="email" placeholder="last name" @input="${e => this._newStudent = { ...this._newStudent, email: e.target.value }}">
                <label for= "email" > Email</label>
            </div >
            <div class="form-floating mb-3">
                <input type="date" class="form-control" id="email" @input="${e => this._newStudent = { ...this._newStudent, birthdate: e.target.value }}">
                <label for= "birthdate" > Birthdate</label>
            </div >
            

        </div >
        <hr>
        Student <pre>${JSON.stringify(this._newStudent)}</pre>
        <hr>
        <div class="container">
            <button type="button" class="btn btn-primary" @click="${_ => this._newStudentFormuala = false}">Cancel</button>
            <button type="button" class="btn btn-success" @click="${_ => this.#createNewStudent()}">Create Student</button>
        </div>
        </div >
        `;
    }

    render() {
        if (!this.students) return html`< b > Loading...</b > `;

        return html`
        <div class="container m-4 p-5">
        <h2> Students</h2 >

            <table class="table align-middle mb-0 bg-white">
            <thead class="bg-light">
                <tr>
                <th>Name</th>
                <th>Title</th>
                <th>Status</th>
                <th>Position</th>
                <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                ${this.students.map(student => html`
                <tr>
                <td>
                    <div class="d-flex align-items-center">
                    <img
                        src="https://mdbootstrap.com/img/new/avatars/8.jpg"
                        alt=""
                        style="width: 45px; height: 45px"
                        class="rounded-circle"
                        />
                    <div class="ms-3">
                        <p class="fw-bold mb-1">${student.firstname} ${student.lastname}</p>
                        <p class="text-muted mb-0">${student.email}</p>
                    </div>
                    </div>
                </td>
                <td>
                    <p class="fw-normal mb-1">${student.majorName}</p>
                    <p class="text-muted mb-0">${student.degree}</p>
                </td>
                <td>
                    <span class="badge text-bg-primary rounded-pill">${student.status}</span>
                </td>
                <td>${student.position}</td>
                <td>
                    <button type="button" class="btn btn-link btn-sm btn-rounded">
                    Edit
                    </button>
                </td>
                </tr>
                `)}                
            </tbody>
            </table>
            <hr>
            ${this._newStudentFormuala ?
                html`${this.#renderNewStudentFormula()}` :
                html`<button type="button" class="btn btn-primary" @click="${_ => this._newStudentFormuala = true}">New Student</button>`}
            
            </div>
            `;
    }
}

customElements.define('thws-student', StudentComponent);

