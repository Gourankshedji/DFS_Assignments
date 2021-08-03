import React, { Component } from "react";
import { BrowserRouter as Router, Route, Switch, Link } from 'react-router-dom'
import List from "./List";
export default class Home extends Component {
    constructor(props) {
      super(props);
  
      
    }
    render(){
        return(
        <div>
                      <nav className="navbar navbar-expand navbar-dark bg-dark">
                          <Link to={"/"} className="navbar-brand">
                              Employee Database
                          </Link>
                          <div className="navbar-nav mr-auto">
              <li className="nav-item">

            <Link to={"/Add"} className="nav-link" >
                  Add
            </Link> </li>&nbsp;
            <div className="navbar-nav mr-auto">
                <li className="nav-item"></li>
            <Link to={"/View"}  className="nav-link">
                  View
            </Link>&nbsp;
            <div className="navbar-nav mr-auto">
                <li className="nav-item"></li>
            <Link to={"/List"} className="nav-link">
                Edit
            </Link>
            </div>
            </div>
            </div>

</nav>
<img src="https://www.h-f.co.uk/sites/default/files/inline-images/Illustration-of-data-being-processed_0.jpg" alt="Chania" width="100%" height="500" />

<br></br><br></br> <br></br>
<div className="oppo text-center">
          <h1>Employee Management System</h1>
          <p>Now you can check any of the employee in our orgnization. </p>
          <p>Your Time is imporatant to us </p>
        </div>
        <br></br><br></br>
        </div>
        
        )
    }
}