import React, { Component } from 'react';

import cache from '../../cache';


class TopPanel extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
        <div>
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <a className="navbar-brand"><h1>Kraken</h1></a>
                <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav">
                        <li className="nav-item active">
                            <button onClick={() => this.props.handleClick("services")}>
                                <h1>Домой</h1> 
                            </button>
                        </li>
                        <li className="nav-item active">
                            <button onClick={() => this.props.handleClick("employees")}>
                                <h1>Сотрудники</h1>
                            </button>
                        </li>
                        <li className="nav-item active">
                            <button onClick={() => this.props.handleClick("clients")}>
                                <h1>Клиенты</h1>
                            </button>
                        </li>
                        <li className="nav-item active">
                            <button onClick={() => this.props.handleClick("profile")}>
                                <h1>{cache.login}</h1>
                            </button>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        );
    }

}

export default TopPanel;