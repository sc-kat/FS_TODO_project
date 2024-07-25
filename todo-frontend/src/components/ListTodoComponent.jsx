import React, { useState } from 'react'

const ListTodoComponent = () => {

    const dummyData = [
        {
            "id": 1,
            "title": "Learn Core Java",
            "description": "Watch Udemy tutorials",
            "completed": false
        },
        {
            "id": 2,
            "title": "Learn Spring",
            "description": "Learn from everywhere",
            "completed": false
        }
    ]

    const [todos, setTodos] = useState(dummyData)

  return (
    <div className='container'>
        <h2 className='text-center'>List of Todos</h2>
        <div>
            <table className='table table-bordered table-striped'>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Todo Title</th>
                        <th>Todo Description</th>
                        <th>Completed</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        todos.map(todo => 
                            <tr key={todo.id}>
                                <td>{todo.id}</td>
                                <td>{todo.title}</td>
                                <td>{todo.description}</td>
                                <td>{todo.completed ? 'YES': 'NO'}</td>
                            </tr>
                        )
                    }
                    
                </tbody>
            </table>
        </div>
    </div>
  )
}

export default ListTodoComponent