import { Box, Typography, Button } from '@mui/material';
import React from 'react';


export default function CaseComment({text, deleteComment, index}) {
   
    return (
        <>
        <Box sx={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }} >
            <Typography>
                {index + 1}. {text}
            </Typography>
            <Button variant='contained' onClick={deleteComment}>Delete</Button>
        </Box>
        </>
    );
}