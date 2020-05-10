import React, { Component } from 'react';

import cache from '../../cache'


class LeftMenu extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
                <nav id="sidebar">
                    <div className="sidebar-header">
                        <h2>Menu</h2>
                    </div>
                    <ul className="list-unstyled components">
                        <li className="active">
                            <button onClick={() => this.props.handleClick("newClient")}>
                                Новый клиент
                            </button>
                        </li>
                        <li>
                            <button onClick={() => this.props.handleClick("newEmployee")}>
                                Новый сотрудник
                            </button>
                        </li>
                        <li>
                            <button onClick={() => this.props.handleClick("newService")}>
                                Новый вид услуг
                            </button>
                        </li>
                    </ul>
                </nav>
      
        );
    }

}

export default LeftMenu;