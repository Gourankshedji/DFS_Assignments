import logo from './logo.svg';
import './App.css';
import Home from './Home';
import {BrowserRouter as Router,Route,Switch} from 'react-router-dom'
import Add from './Add';
import View from './View';
import List from './List';
import Update from './Update';


function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
      {/* <Home></Home> */}
      <Route path="/" exact component={Home}></Route>
      <Route path="/Add" exact component={Add}></Route>
      <Route path="/View" exact component={View}></Route>
      <Route path="/List" exact component={List}></Route>
      <Route path="/Update/:id" exact component={Update}></Route>


      </Switch>
      </Router>
    </div>
  );
}

export default App;
