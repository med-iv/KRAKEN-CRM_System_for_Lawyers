import React, { Component } from 'react';
import axios from 'axios';

import Service from './Service';
import Event from '../Events/Event';

function* getServices (data) {
  for (let [key, value] of Object.entries(data)) {
    yield value[0];
  }
}


function* getEvents (data) {
  for (let [key, value] of Object.entries(data)) {
    yield value[0] + ' | ' + value[1] + ' | ' + value[2]; 
  }
}

function* getKeys (data) {
  for (let [key, value] of Object.entries(data)) {
    yield key;
  }
}

let indices_services = [];
let list_services = [];

let indices_events = [];
let list_events = [];



class Services extends Component {
    constructor(props) {
        super(props);
        this.state = {
            objects: false,
            events: false
        };
    }

    componentDidMount() {
        axios.get("http://localhost:8080/api/services")
            .then(res => { console.log(res.data);
                let it = getServices(res.data);
                let key_it = getKeys(res.data);
                let result = it.next();
                while (!result.done) {
                    indices_services.push(key_it.next().value);
                    list_services.push(result.value);
                    result = it.next();
                }
                //this.setState({objects: !this.state.objects});  
            });
        axios.get("http://localhost:8080/api/events")
            .then(res => { console.log(res.data);
                let it = getEvents(res.data);
                let key_it = getKeys(res.data);
                let result = it.next();
                while (!result.done) {
                    indices_events.push(key_it.next().value);
                    list_events.push(result.value);
                    result = it.next();
                }
                this.setState({events: !this.state.events});  
            });
    }

    render() {
        let indices_services1 = indices_services.slice();
        let objects = list_services.slice();
        list_services = [];
        indices_services = [];

        let indices_events1 = indices_events.slice();
        let events = list_events.slice();
        list_events = [];
        indices_events = [];

        return (
        <div>

            <div>
                {objects.map(function(object, i){
                    return <Service obj={object} key={indices_services1[i]}
                    id={indices_services1[i]}
                    handleClick={this.props.handleClick}/>;
                }, this )}
            </div>
            <br/>
            <br/>
            <h1>#########################################</h1>
            <br/>
            <br/>
            <div>
                {events.map(function(object, i){
                    return <Event obj={object} key={indices_events1[i]}
                    id={indices_events1[i]}
                    handleClick={this.props.handleClick}/>;
                }, this )}
            </div>
        </div>

        );
    }
}

export default Services;