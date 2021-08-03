import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch, Link } from 'react-router-dom'
import EmployeeService from './Services/EmployeeService';


class Add extends Component {
    constructor(props){
        super(props)

        this.state={
            employeeName:'',
            employeeContact:'',
            employeeProfile:''

        }
        this.changeEmployeeNameHandler=this.changeEmployeeNameHandler.bind(this);
        this.changeEmployeeContactHandler=this.changeEmployeeContactHandler.bind(this);
        this.changeEmployeeProfileHandler=this.changeEmployeeProfileHandler.bind(this);
        this.saveEmployee=this.saveEmployee.bind(this);
        this.cancel=this.cancel.bind(this);
    }

    changeEmployeeNameHandler=(event) =>{
        this.setState({employeeName: event.target.value});
    }
    changeEmployeeContactHandler=(event) =>{
        this.setState({employeeContact: event.target.value});
    }
    changeEmployeeProfileHandler=(event) =>{
        this.setState({employeeProfile: event.target.value});
    }
    saveEmployee =(e) =>{
        e.preventDefault();
        let employee ={employeeName:this.state.employeeName,
                       employeeContact:this.state.employeeContact,
                       employeeProfile:this.state.employeeProfile};
        console.log('employee =>' +JSON.stringify(employee));

        EmployeeService.addEmployee(employee).then(res => {
            this.props.history.push('/');


        })
    }
    cancel(){
        this.props.history.push('/');
    }
    
    render() {
        return (
            <div>
               <Link to={"/"} >
                  Home
                  </Link> 
                  <div className="container">
                      <div className="row">
                          <div className="card col-md-6 offset-md-3 offset-md 3">
                              <h2 className="text-center">Add Employee</h2>
                              <div classname="card-body">
                                  <from>
                                      <div className="form-group">
                                          <label> Employee Name :</label>
                                          <input placeholder="Employee Name" name="employeeName" className="form-control"
                                          value={this.state.employeeName} onChange={this.changeEmployeeNameHandler}></input>
                                      </div>
                                      <div className="form-group">
                                          <label> Employee Contact :</label>
                                          <input placeholder="Employee Contact" name="employeeContact" className="form-control"
                                          value={this.state.employeeContact} onChange={this.changeEmployeeContactHandler}></input>
                                      </div>
                                      <div className="form-group">
                                          <label> Employee Profile :</label>
                                          <input placeholder="Employee Profile" name="employeeProfile" className="form-control"
                                          value={this.state.employeeProfile} onChange={this.changeEmployeeProfileHandler}></input>
                                      </div>
                                      <button className="btn btn-success" onClick={this.saveEmployee}>Save</button>
                                      <button className="btn btn-danger" onClick={this.cancel} style={{marginleft:"10px"}}>Cancel</button>
                                  </from>
                              </div>
                          </div>
                      </div>
                  </div>
            </div>
        );
    }
}

export default Add;