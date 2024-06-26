import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Button from '@mui/material/Button';
import { Typography, TextField, Box, Toolbar, Container, Stack } from '@mui/material';
import Controller from '../core/Controller';


export default function HomePage()
{
    const [greeting, setGreeting] = useState('');
    const [searchResult, setSearchResult] = useState('');
    const [searchText, setSearchText] = useState('');
    const [showSearchResult, setShowSearchResult] = useState(false);

    useEffect(() => {
      axios.get('/api/greeting') // Relative path, Vite proxy will handle this
        .then(response => {
          setGreeting(response.data);
        })
        .catch(error => {
          console.error('There was an error fetching the data!', error);
        });
    }, []);

    const handleSearch = (event) => {
      axios.get(`/api/search?text=${searchText}`)
        .then(response => {
          setSearchResult(response.data);
          setShowSearchResult(true);
        })
        .catch(error => {
         setSearchResult("There was an error fetching the data!");
         setShowSearchResult(false);
        });
    }


    return (
        <>  
        <Controller title="Query Page" />
        <Toolbar />
        <Container>
          <Stack spacing={2}>
            <Typography variant='h3' gutterBottom color="secondary" > {greeting} </Typography> 

            <Typography variant="body1" gutterBottom color="primary"> Try out our new Search Feature</Typography>

            <Button variant="contained" color="secondary" onClick={handleSearch}> Search </Button>

            <TextField id="standard-basic"
                       label="Search Text"
                       variant="filled"
                       color="primary"
                       sx={{ mt: 1, mb: 2 }}
                       style={{ width: '100%' }} 
                       value={searchText}
                       onChange={(e) => setSearchText(e.target.value)}
                       />


            {showSearchResult && (
                <Box sx={{ border: '2px solid grey', borderRadius: 2, p : 1, pt :2}}>
                    <Typography style={{ textAlign: 'left' }} variant="h6">Search Result:</Typography>
                    <hr></hr>
                    <pre style={{ textAlign: 'left' }}>{JSON.stringify(searchResult, null, 2)}</pre>
                </Box>
            )}
          </Stack>
        </Container>
        </>
    );
}