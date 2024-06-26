import { Container, Paper, Toolbar } from "@mui/material";
import Controller from "../core/Controller";
import React from "react";


export default function CaseReport(){
    return (
        <>
        <Controller title="Case Report" />
        <Toolbar/>
   
        <Paper elevation={10} sx={{ width: "100vh" , height: '50vh' }}>
                <h3>Case Report</h3>
            </Paper>
        </>
    );
}