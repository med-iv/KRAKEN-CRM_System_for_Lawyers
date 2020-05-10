import React, { Component } from 'react';
import axios from 'axios';

import cache from '../../cache';


class NewService extends Component {
    constructor() {
        super();
        this.state = {
            name: '',
            description: '',
            error: '',
        };

        this.handleDescriptionChange = this.handleDescriptionChange.bind(this);
        this.handleNameChange = this.handleNameChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.dismissError = this.dismissError.bind(this);
    }

    dismissError() {
        this.setState({ error: '' });
    }

    handleSubmit(evt) {
        evt.preventDefault();

        const service = {
            "name": this.state.name,
            "description": this.state.description,
        }

        console.log(service);

        axios.post("http://localhost:8080/api/add_service", service,
           { headers: {  "Content-Type": "application/json"}})

        return this.setState({ error: '' });
    }

    handleNameChange(evt) {
        this.setState({
            name: evt.target.value,
        });
    };

    handleDescriptionChange(evt) {
        this.setState({
            description: evt.target.value,
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
              <label>Название вида услуг</label>
              <input type="text" data-test="date" 
              value={this.state.name} onChange={this.handleNameChange} />

              <label>Описание</label>
              <input type="text" data-test="description" 
              value={this.state.description} onChange={this.handleDescriptionChange} />

              <input type="submit" value="Создать" data-test="submit" />
            </form>
          </div>
        );
    };

}

export default NewService;