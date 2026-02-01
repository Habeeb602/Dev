import express from "express";
import mongoose from "mongoose";
import { PORT, mongoDBURL } from "./config.js";
import booksRoute from "./routes/booksRoute.js"
import cors from "cors";

const app = express();



app.use(express.json());
app.use(cors());
// app.use(cors({
//     origin: "http://localhost:3000",
//     methods: ["GET", "PATCH", "POST", "DELETE"],
//     allowedHeaders: ['Content-Type']
// }));

app.use("/books", booksRoute);

app.get("/", (request, response) => {
    console.log(request);

    return response.status(203).send("Welcome!!!");
});




mongoose
    .connect(mongoDBURL)
    .then(() => {
        console.log("App connected to database");

        app.listen(PORT, () => {
            console.log(`App listening at port ${PORT}`)
        })

    })
    .catch((error) => {
        console.log(error);
    })