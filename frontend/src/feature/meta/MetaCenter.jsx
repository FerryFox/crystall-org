import Controller from "../core/Controller";
import React from "react";
import Toolbar from "@mui/material/Toolbar";  
import { useState, useEffect } from "react";
import axios from "axios";  
import DescribeDetail from "./DescribeDetail";
import { Paper } from "@mui/material";

export default function MetaCenter()
{
    const [sobject, setSobject] = useState(null);

    useEffect(() => {
      axios.get('/api/meta') // Relative path, Vite proxy will handle this
        .then(response => {
            console.log(JSON.stringify(response.data.payload, null, 2));
            setSobject(response.data.payload);
        })
        .catch(error => {
            console.error('There was an error fetching the data!', error);
        });
    }, []);

    return (
        <>
          <Controller title="Meta Data Center"/>
          <Toolbar />
          <Paper sx={{p : 2}} elevation={10}>
            <h1>Using Crystall Ball</h1>
            
            {sobject && <DescribeDetail sobject={sobject} />}
        </Paper>
        </>
    );
}