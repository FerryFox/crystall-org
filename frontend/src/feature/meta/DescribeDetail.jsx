import React from 'react';
import FieldDetail from './FieldDetail';
import { Divider, Typography } from '@mui/material';

export default function DescribeDetail({sobject})
{
    return (
        <>
            <Typography variant="h4">{sobject.name}</Typography>
            <Divider color="primary"/>

            {sobject.fields.sort((a, b) => b.custom - a.custom).map(field => (
                <FieldDetail key={field.name} field={field} />
            ))}
        </>
    );
}