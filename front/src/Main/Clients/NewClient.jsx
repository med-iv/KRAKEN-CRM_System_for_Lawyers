import React, { Component } from 'react';
import axios from 'axios';

import cache from '../../cache';


class NewClient extends Component {
    constructor() {
        super();
        this.state = {
            name: '',
            middle_name: '',
            last_name: '',
            address: '',
            phone_number: '',
            email: '',
            error: '',
        };


        this.handleNameChange = this.handleNameChange.bind(this);
        this.handleMiddleNameChange = this.handleMiddleNameChange.bind(this);
        this.handleLastNameChange = this.handleLastNameChange.bind(this);
        this.handleAddressChange = this.handleAddressChange.bind(this);
        this.handlePhoneNumberChange = this.handlePhoneNumberChange.bind(this);
        this.handleEmailChange = this.handleEmailChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.dismissError = this.dismissError.bind(this);
    }

    dismissError() {
        this.setState({ error: '' });
    }

    handleSubmit(evt) {
        evt.preventDefault();

        const client = {
            "name": this.state.name,
            "middle_name": this.state.middle_name,
            "last_name": this.state.last_name,
            "address": this.state.address,
            "phone_number": this.state.phone_number,
            "email": this.state.email
        }

        console.log(client);

        axios.post("http://localhost:8080/api/add_client", client,
           { headers: {  "Content-Type": "application/json"}})

        return this.setState({ error: '' });
    }

    handleNameChange(evt) {
        this.setState({
            name: evt.target.value,
        });
    };

    handleMiddleNameChange(evt) {
        this.setState({
            middle_name: evt.target.value,
        });
    };

    handleLastNameChange(evt) {
        this.setState({
            last_name: evt.target.value,
        });
    };

    handleAddressChange(evt) {
        this.setState({
            address: evt.target.value,
        });
    };

    handlePhoneNumberChange(evt) {
        this.setState({
            phone_number: evt.target.value,
        });
    };

    handleEmailChange(evt) {
        this.setState({
            email: evt.target.value,
        });
    };

    render() {
        return (
          <div className="">
              
            <form onSubmit={this.handleSubmit}>
              {
                this.state.error &&
                <h3 data-test="error" onClick={this.dismissError}>
                  <button onClick={this.dismissError}>✖</button>
                  {this.state.error}
                </h3>
              }
              <label>Имя</label>
              <input type="text" data-test="date" 
              value={this.state.name} onChange={this.handleNameChange} />

              <br/>
              <br/>

              <label>Отчество (Второе имя)</label>
              <input type="text" data-test="middle_name" 
              value={this.state.middle_name} onChange={this.handleMiddleNameChange} />

              <br/>
              <br/>

              <label>Фамилия</label>
              <input type="text" data-test="last_name" 
              value={this.state.last_name} onChange={this.handleLastNameChange} />

              <br/>
              <br/>

              <label>Адрес</label>
              <input type="text" data-test="address" 
              value={this.state.address} onChange={this.handleAddressChange} />

              <br/>
              <br/>

              <label>Номер телефона</label>
              <input type="text" data-test="phone_number" 
              value={this.state.phone_number} onChange={this.handlePhoneNumberChange} />

              <br/>
              <br/>

              <label>Email</label>
              <input type="text" data-test="email" 
              value={this.state.email} onChange={this.handleEmailChange} />

              <input type="submit" value="Создать" data-test="submit" />
            </form>
          </div>
        );
    };

}

export default NewClient;