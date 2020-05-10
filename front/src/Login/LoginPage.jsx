import React, { Component } from 'react';
import Login from './Login'
import Form from './Form'

class LoginPage extends Component {

    render() {
        return (
            <div>
                <h1>
                    KRAKEN - Customer relationship management system for Lawyers
                </h1>
                <h2>
                    Since 2020
                </h2>
                <Login handleChange={this.props.handleChange}/>
                <Form/>
            </div>
        )
    }
}

export default LoginPage;