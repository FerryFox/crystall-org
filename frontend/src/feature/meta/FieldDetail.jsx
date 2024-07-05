import { Stack, Typography } from '@mui/material';
import Grid2 from '@mui/material/Unstable_Grid2/Grid2';
import React from 'react';

export default function FieldDetail({field})
{
    
    return (
        <>
            <Stack spacing={1} direction="row">
                <Typography >{field.label} | </Typography>
                <Typography >{field.name} |</Typography>
                <Typography >{field.custom ? 'Custom' : 'Standard'}</Typography>
            </Stack>
                
        </>
    );
}