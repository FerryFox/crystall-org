import { Toolbar, Typography, TextField, Stack, Button, Box, Paper, Divider, Badge } from "@mui/material";
import Controller from "../core/Controller";
import React, { useState } from "react";
import axios from "axios";
import Grid2 from "@mui/material/Unstable_Grid2/Grid2";
import CaseComment from "./CaseComment";
import MailIcon from '@mui/icons-material/Mail';

export default function CaseReport() {
    const [fundingNumber, setFundingNumber] = useState(0);
    const [subject, setSubject] = useState("");
    const [discription, setDiscription] = useState("");
    const [comments, setComments] = useState([]);
    const [currentComment, setCurrentComment] = useState('');
    const [commentCount, setCommentCount] = useState(0);

    const [data, setData] = useState(null);
    const [error, setError] = useState(null);

    const addComment = () => {
        if (currentComment.trim()) {
            setComments([...comments, currentComment]);
            setCurrentComment(''); // Clear the input field
            setCommentCount(commentCount + 1);
        }
    };

    const deleteComment = (index) => {
        setComments(comments.filter((_, i) => i !== index));
        setCommentCount(commentCount - 1);
    };

    const handleSubmit = () => {
        if (!validate()) return;
        const payload = {
            FuningNumber: fundingNumber,
            Subject: subject,
            Discription: discription,
            Comments: comments
        };

        axios.post('/api/case/create', payload).then((response) => {
            const payload = JSON.parse(response.data.payload); 
            setData(payload);
            console.log(payload); 
            setError(null);
            clearFields();
        })
        .catch((error) => {
            setError(error.response.data.message);
            setData(null);
        });
    }

    const validate = () => {
        if (!fundingNumber || !subject || !discription || !comments.length) {
            setError("Please fill in all required fields.");
            return false;
        }
        return true;
    }

    const clearFields = () => {
        setFundingNumber(0);
        setSubject("");
        setDiscription("");
        setComments([]);
        setCurrentComment('');
        setCommentCount(0);
    }

return (
<>
<Controller title="Case Report" />
<Toolbar />

{data && 
    (<Paper elevation={10} sx={{ px: 10, py: 4, my: 2 }}>
        <Typography  color="secondary" variant="h5">
            Created Case With This ID: {data.Id}
        </Typography>
    </Paper>)
}

{error && 
    (<Paper elevation={10} sx={{ px: 10, py: 4, my: 2 }}>
        <Typography variant="h6" color="error">
            {error}
        </Typography>
    </Paper>)
}

<Paper elevation={10} sx={{ px: 10, py: 4 }}>
    <Stack spacing={15} direction="row" sx={{my : 5}}>
        <Typography color="secondary" sx={{textAlign: 'left'}} variant="h3">
            <b>Create a New Case</b>
        </Typography>
        <Button variant="contained" color="primary" onClick={handleSubmit}>
                Submit
        </Button>
    </Stack>
   

<Grid2 container spacing={10}>
    <Grid2 item xs={6}>
    <Stack spacing={2}>
        <TextField
            id="outlined-basic"
            label="Funding Number"
            variant="outlined"
            type="number"
            value={fundingNumber}
            onChange={(event) => setFundingNumber(event.target.value)}
        />

        <TextField
            id="outlined-basic"
            label="Subject"
            variant="outlined"
            value={subject}
            onChange={(event) => setSubject(event.target.value)}
        />

        <TextField
            id="outlined-basic"
            label="Discription"
            variant="outlined"
            value={discription}
            onChange={(event) => setDiscription(event.target.value)}
        />
    </Stack>
    </Grid2>
        <Grid2 item xs={6}>
            <Stack spacing={2}>
                <TextField
                            id="outlined-basic"
                            label="Add Comment"
                            variant="outlined"
                            value={currentComment}
                            onChange={(event) => setCurrentComment(event.target.value)}
                        /> 

                <Box>
                    <Button variant="contained" color="primary"  
                            onClick={addComment} style={{ marginTop: '10px' }}>
                        Add Comment to List
                    </Button>
                </Box>
            </Stack>

            <Badge badgeContent={commentCount} color="primary" sx={{mt:5}}>
                    <Typography>  Comments:  </Typography>
                    <MailIcon color="secondary" />
            </Badge>
        </Grid2>
    </Grid2>
    <Divider sx={{my :2}} color="secondary"/>

    <Stack spacing={2}>
        {comments.map((comment, index) => (
                        <CaseComment key={index} 
                                    text={comment} 
                                    index={index} 
                                    deleteComment={() => deleteComment(index)}>
                        </CaseComment>
                    ))}
    </Stack>
</Paper>
</>);
}
