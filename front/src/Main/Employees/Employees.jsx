import React, { Component } from 'react';
import axios from 'axios';

import Employee from './Employee';


function* getEmployees (data) {
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

let indices_employees = [];
let list_employees = [];




class Employees extends Component {
    constructor(props) {
        super(props);
        this.state = {
            employees: false
        };
    }

    componentDidMount() {
        axios.get("http://localhost:8080/api/employees")
            .then(res => { console.log(res.data);
                let it = getEmployees(res.data);
                let key_it = getKeys(res.data);
                let result = it.next();
                while (!result.done) {
                    indices_employees.push(key_it.next().value);
                    list_employees.push(result.value);
                    result = it.next();
                }
                this.setState({employees: !this.state.employees});  
            });
    }

    render() {
        let indices_employees1 = indices_employees.slice();
        let employees = list_employees.slice();
        list_employees = [];
        indices_employees = [];

        return (
        <div>
            <div>
                {employees.map(function(object, i){
                    return <Employee obj={object} key={indices_employees1[i]}
                    id={indices_employees1[i]}
                    handleClick={this.props.handleClick}/>;
                }, this )}
            </div>
        </div>

        );
    }
}

export default Employees;