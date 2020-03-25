import React, { Component } from 'react';
import axios from 'axios';

import cache from '../../cache';

class ChangeEvent extends Component {
    constructor() {
        super();
        this.state = {
            date: '',
            description: '',
            error: '',
        };

        this.handleDescriptionChange = this.handleDescriptionChange.bind(this);
        this.handleDateChange = this.handleDateChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.dismissError = this.dismissError.bind(this);
    }

    dismissError() {
        this.setState({ error: '' });
    }

    handleSubmit(evt) {
        evt.preventDefault();

        const event = {
            "id": cache.eventId,
            "date": this.state.date,
            "description": this.state.description,
        }

        console.log(event);

        axios.post("http://localhost:8080/api/change_event", event,
           { headers: {  "Content-Type": "application/json"}})

        return this.setState({ error: '' });
    }

    handleDateChange(evt) {
        this.setState({
            date: evt.target.value,
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
            <h3>{cache.service}</h3>
              
            <form onSubmit={this.handleSubmit}>
              {
                this.state.error &&
                <h3 data-test="error" onClick={this.dismissError}>
                  <button onClick={this.dismissError}>✖</button>
                  {this.state.error}
                </h3>
              }
              <label>Дата</label>
              <input type="text" data-test="date" 
              value={this.state.date} onChange={this.handleDateChange} />

              <label>Описание</label>
              <input type="text" data-test="description" 
              value={this.state.description} onChange={this.handleDescriptionChange} />

              <input type="submit" value="Редактировать событие"
               data-test="submit" />
            </form>
            <br/>
            <br/>
            <button onClick = {() =>{
                const event = {
                     eventId: cache.eventId
                }
                axios.post("http://localhost:8080/api/delete_event", event,
                    { headers: {  "Content-Type": "application/json"}})
                }}>
                 Удалить событие
            </button>
        </div>
        );
    }
}

export default ChangeEvent;