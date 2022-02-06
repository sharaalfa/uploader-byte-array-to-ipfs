import React, { Component } from 'react';
import { Web3Storage } from 'web3.storage';
import Name from "./name";
import logo from './logo.svg';
import './App.css';

const client = new Web3Storage({ token: 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJkaWQ6ZXRocjoweDhjODYwODI0ZTAwMkI0RTlkNGM1NzU1MUFjZDgwQ2NlRDVFZEVlQjciLCJpc3MiOiJ3ZWIzLXN0b3JhZ2UiLCJpYXQiOjE2NDQwNjY1Mzk5MDAsIm5hbWUiOiJhcnR1ciJ9.2qdiBjqeQoJzmtuwBjW8Nfs5mOCBb0sxWyza9rynU0g' })

export const name = async () =>
    async (dispatch) => {
        await Name.create()
    }
const value = '/ipfs/bafkreiem4twkqzsq2aj4shbycd4yvoj2cx72vezicletlhi7dijjciqpui'
export const revision = async () => {
    await Name.v0(name, value)
}
async () => {
    await Name.publish(client, revision, name.key)
}


// ...later

const nextValue = '/ipfs/bafybeiauyddeo2axgargy56kwxirquxaxso3nobtjtjvoqu552oqciudrm'
// Make a revision to the current record (increments sequence number and sets value)
export const nextRevision = async () => {
    await Name.increment(revision, nextValue)
}

async () => {
    await Name.publish(client, nextRevision, name.key)
}
class App extends Component {
  constructor() {
    super();
    this.state = { message: "No server found!" };
  }

  componentDidMount() {
    fetch("/api/greetings")
      .then(result => result.json())
      .then(json => {
        this.setState({ message: json })
      })
      .catch(error => {}) // ignore error for now
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <p className="App-intro">
          This is a message from server: <b>{ this.state.message }</b>
        </p>
      </div>
    );
  }
}

export default App;
