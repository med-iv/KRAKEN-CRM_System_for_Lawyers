import React, { Component } from 'react';
import cache from '../../cache';

class Employee extends Component {
    constructor(props) {
        super(props);
    }
    render() {
        return (
        <div>
            <button onClick={() => {cache.employee = this.props.obj;
                cache.employeeId = this.props.id;
                this.props.handleClick("changeEmployee");
            }}>
                {this.props.obj}
            </button>
            <br/>
            <br/>
        </div>
        );
    }
}

export default Employee;