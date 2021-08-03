import React, { Component } from 'react';
import axios from 'axios';

class EmployeeService extends Component {

    getEmployees(){
        return axios.get("http://localhost:9090/employee/employees/selectAll")
    }
    addEmployee(employee){
        return axios.post("http://localhost:9090/employee/employees/addEmployee",employee)
    }
    getEmployeeById(employeeId){
        return axios.get("http://localhost:9090/employee/employees/getEmployee"+"/"+ employeeId)
    }
    deleteEmployee(employeeId){
        return axios.delete('http://localhost:9090/employee/employees/removeEmployee'+'/'+ employeeId)
    }
    
}

export default new EmployeeService()