import React, { Component } from 'react';
import cache from '../../cache';

class Event extends Component {
    constructor(props) {
        super(props);
    }
    render() {
        return (
        <div>
            <button onClick={() => {cache.event = this.props.obj;
                cache.eventId = this.props.id;
                this.props.handleClick("changeEvent");
            }}>
                {this.props.obj}
            </button>
            <br/>
            <br/>
        </div>
        );
    }
}

export default Event;