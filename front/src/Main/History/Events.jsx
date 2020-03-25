import React, { Component } from 'react';
import Service from './Service';

class Services extends Component {
    constructor(props) {
        super(props);
    }

    componentDidMount() {
        
    }

    render() {
        let objects = ["gg", "wp"];
        return (
            <div>
                {objects.map(function(object, i){
                    return <Service obj={object} key={i}/>;
                } )}
            </div>

        );
    }
}

export default Services;