import React, { Component } from 'react';
import cache from '../../cache';

class Service extends Component {
    constructor(props) {
        super(props);
    }
    render() {
        return (
            <button onClick={() => {cache.service = this.props.obj;
                cache.serviceId = this.props.id;
                this.props.handleClick("newEvent");
            }}>
                {this.props.obj}
            </button>
        );
    }
}

export default Service;