import React, { Component } from 'react';
import cache from '../../cache';

class Client extends Component {
    constructor(props) {
        super(props);
    }
    render() {
        return (
        <div>
            <button onClick={() => {cache.client = this.props.obj;
                cache.clientId = this.props.id;
                this.props.handleClick("changeClient");
            }}>
                {this.props.obj}
            </button>
            <br/>
            <br/>
        </div>
        );
    }
}

export default Client;