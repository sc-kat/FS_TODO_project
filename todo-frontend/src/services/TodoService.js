import axios from "axios";

const BASE_REST_API_URL = 'http://localhost:7000/api/todos';

export const getAllTodos = () => axios.get(BASE_REST_API_URL);