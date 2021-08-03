import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch, Link } from 'react-router-dom'
import EmployeeService from './Services/EmployeeService';


class List extends Component {
    constructor(props) {
        super(props)

        this.state = {
            employees: []
        }
        // this.bookAppointment = this.bookAppointment.bind(this);
        // this.deleteAppointment = this.deleteAppointment.bind(this);
        // this.Home = this.Home.bind(this);
        this.editEmployee=this.editEmployee.bind(this);
        this.deleteEmployee=this.deleteEmployee.bind(this);
    }
    deleteEmployee(employeeId){
        console.log(typeof(employeeId))
        EmployeeService.deleteEmployee(employeeId).then(res =>{
            this.setState({employees:this.state.employees.filter(employee =>employee.employeeId !==employeeId)});

        });
    }
    editEmployee(id){
        this.props.history.push(`/Update/${id}`)

    }

    componentDidMount(){
        EmployeeService.getEmployees().then((res) =>{
            this.setState({ employees:res.data});
        });
    }
    render() {
        return (
            <div>
               <Link to={"/"} >
                  Home
                </Link> 

                <h2 className="text-center"> Employee List</h2>
                <div className="row">
                    <table className="table table-stripped table-borderd">

                        <thead>
                            <tr>
                                <th>Employee ID</th>
                                <th> Employee Name</th>
                                <th> Employee Contact</th>
                                <th> Employee Post</th>
                                <th>Actions</th>

                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.employees.map(
                                    employee=>
                                    <tr key={employee.employeeId}>
                                        <td>{employee.employeeId}</td>
                                        <td> {employee.employeeName}</td>
                                        <td>{employee.employeeContact}</td>
                                        <td>{employee.employeeProfile}</td>
                                        <td>
                                            <button onClick ={ () => this.editEmployee(employee.employeeId)} className="btn btn-info"> Update </button>&nbsp;
                                            <button onClick={ () => this.deleteEmployee(( employee.employeeId))} className="btn btn-danger">Delete</button>
                                        </td>


                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default List;