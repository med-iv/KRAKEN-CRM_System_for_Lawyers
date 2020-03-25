import React, { Component } from 'react';
import axios from 'axios';

import Client from './Client';


function* getClients (data) {
  for (let [key, value] of Object.entries(data)) {
    yield value[0] + ' ' + value[1] + ' ' + value[2] + 
    ' | ' + value[3] + ' | ' + value[4] + ' | ' + value[5]; 
  }
}

function* getKeys (data) {
  for (let [key, value] of Object.entries(data)) {
    yield key;
  }
}

let indices_clients = [];
let list_clients = [];




class Clients extends Component {
    constructor(props) {
        super(props);
        this.state = {
            clients: false
        };
    }

    componentDidMount() {
        axios.get("http://localhost:8080/api/clients")
            .then(res => { console.log(res.data);
                let it = getClients(res.data);
                let key_it = getKeys(res.data);
                let result = it.next();
                while (!result.done) {
                    indices_clients.push(key_it.next().value);
                    list_clients.push(result.value);
                    result = it.next();
                }
                this.setState({clients: !this.state.clients});  
            });
    }

    render() {
        let indices_clients1 = indices_clients.slice();
        let clients = list_clients.slice();
        list_clients = [];
        indices_clients = [];

        return (
        <div>
            <div>
                {clients.map(function(object, i){
                    return <Client obj={object} key={indices_clients1[i]}
                    id={indices_clients1[i]}
                    handleClick={this.props.handleClick}/>;
                }, this )}
            </div>
        </div>

        );
    }
}

export default Clients;