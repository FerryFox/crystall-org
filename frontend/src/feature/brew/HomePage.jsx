import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Button from '@mui/material/Button';

export default function HomePage()
{
    const [greeting, setGreeting] = useState('');
    const [counter, setCounter] = useState(0);

    useEffect(() => {
      axios.get('/api/greeting') // Relative path, Vite proxy will handle this
        .then(response => {
          setGreeting(response.data);
        })
        .catch(error => {
          console.error('There was an error fetching the data!', error);
        });
    }, []);

    const increase = () => {
      setCounter(prevCounter => prevCounter + 1);
  }
  
        
    return (
        <>
            <p> Hey Counter {counter} </p>
            <p> {greeting} </p>
            <Button variant="contained" color="primary" onClick={increase} >Press this mui button</Button>
        </>
    );
}