import { useState } from 'react'
import './App.css'
import HelloWorld from './HelloWorld'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
     <HelloWorld />
    </>
  )
}

export default App
