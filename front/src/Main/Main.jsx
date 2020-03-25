import React, { Component } from 'react';

import TopPanel from './TopPanel/TopPanel';
import LeftMenu from './LeftMenu/LeftMenu';
import Services from './Services/Services';
import NewEvent from './Events/NewEvent'; 
import ChangeEvent from './Events/ChangeEvent'; 
import NewService from './Services/NewService';
import Clients from './Clients/Clients';
import Employees from './Employees/Employees';
import NewClient from './Clients/NewClient';
import NewEmployee from './Employees/NewEmployee';
import ChangeClient from './Clients/ChangeClient';
import ChangeEmployee from './Employees/ChangeEmployee';

import './LeftMenu/LeftMenu.css';

class Main extends Component {
    constructor(props) {
        super(props);
        this.state = {
            content: "services"
        };
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick(value) {
        this.setState({content: value});       
    }

    render() {
        if (this.state.content == "newClient") {
            return (
                <div>
                    <TopPanel handleClick={this.handleClick}/>
                    <div className="wrapper">
                        <LeftMenu handleClick={this.handleClick}/>
                        <NewClient/>
                    </div>
                </div>
            );
        } else if (this.state.content == "newEmployee") {
            return (
                <div>
                    <TopPanel handleClick={this.handleClick}/>
                    <div className="wrapper">
                        <LeftMenu handleClick={this.handleClick}/>
                        <NewEmployee/>
                    </div>
                </div>
            );
        } else if (this.state.content == "newService") {
            return (
                <div>
                    <TopPanel handleClick={this.handleClick}/>
                    <div className="wrapper">
                        <LeftMenu handleClick={this.handleClick}/>
                        <NewService/>
                    </div>
                </div>
            );
        } else if (this.state.content == "employees") {
            return (
                <div>
                    <TopPanel handleClick={this.handleClick}/>
                    <div className="wrapper">
                        <LeftMenu handleClick={this.handleClick}/>
                        <Employees handleClick={this.handleClick}/>
                    </div>
                </div>
            );
        } else if (this.state.content == "clients") {
            return (
                <div>
                    <TopPanel handleClick={this.handleClick}/>
                    <div className="wrapper">
                        <LeftMenu handleClick={this.handleClick}/>
                        <Clients handleClick={this.handleClick}/>
                    </div>
                </div>
            );
        } else if (this.state.content == "profile") {
            return (
                <div>
                    <TopPanel handleClick={this.handleClick}/>
                    <div className="wrapper">
                        <LeftMenu handleClick={this.handleClick}/>
                        <div>Профиль</div>
                    </div>
                </div>
            );
        } else if (this.state.content == "newEvent") {
            return (
                <div>
                    <TopPanel handleClick={this.handleClick}/>
                    <div className="wrapper">
                        <LeftMenu handleClick={this.handleClick}/>
                        <NewEvent/>
                    </div>
                </div>
            );
        } else if (this.state.content == "changeEvent") {
            return (
                <div>
                    <TopPanel handleClick={this.handleClick}/>
                    <div className="wrapper">
                        <LeftMenu handleClick={this.handleClick}/>
                        <ChangeEvent/>
                    </div>
                </div>
            );
        } else if (this.state.content == "changeClient") {
            return (
                <div>
                    <TopPanel handleClick={this.handleClick}/>
                    <div className="wrapper">
                        <LeftMenu handleClick={this.handleClick}/>
                        <ChangeClient/>
                    </div>
                </div>
            );
        } else if (this.state.content == "changeEmployee") {
            return (
                <div>
                    <TopPanel handleClick={this.handleClick}/>
                    <div className="wrapper">
                        <LeftMenu handleClick={this.handleClick}/>
                        <ChangeEmployee/>
                    </div>
                </div>
            );
        } else {
            return (
                <div>
                    <TopPanel handleClick={this.handleClick}/>
                    <div className="wrapper">
                        <LeftMenu handleClick={this.handleClick}/>
                        <Services handleClick={this.handleClick}/>
                    </div>
                </div>
            );
        }
    }

}

export default Main;