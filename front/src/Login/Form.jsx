import React, { Component } from 'react';

class Form extends Component {
    render() {
        return (
            <div>
                <div className="container">
                <div className="row">
                    <div className="login-panel panel panel-default">
                        <div className="panel-heading">
                            <h3 className="panel-title">Вы можете обратиться к нам через эту форму</h3>
                        </div>
                    <div className="panel-body">
                        <form role="form">
                            <fieldset>
                                <div className="form-group">
                                    <input className="form-control" placeholder="e-mail" name="email" type="email"/>
                                </div>
                                <div className="form-group">
                                    <label>Text area</label>
                                    <textarea className="form-control" rows="5"></textarea>
                                </div>
                                        
                                
                                <a href="login.html" className="btn btn-lg btn-primary btn-block">Оставить заявку</a>
                            </fieldset>
                        </form>
                    </div>
            </div>
        </div>
    </div>
            </div>
        )
    }
}

export default Form;