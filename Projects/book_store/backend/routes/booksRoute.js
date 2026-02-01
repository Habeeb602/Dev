import express from "express";
import { Book } from "../models/bookModel.js";


const router = express.Router();


router.get("/", async(request, response) => {

    try{
        const books = await Book.find({});
        return response.status(200).json({
            count: books.length,
            data: books
        })
    }
    catch(error){
        console.log(error.message);
        return response.status(500).send({message: error.message});
    }
});

router.get("/:id", async (request, response) => {

    try {
        const { id } = request.params;
        const book = await Book.findById(id);
        
        return response.status(200).json(book);

    } catch (error) {
        console.log(error.message);
        return response.status(500).send({message: error.message});
    }
});

router.patch("/:id", async(req, res) => {
    try {
        const { id } = req.params;
        let bookObj = {};
        if(!req.body.title && !req.body.author && !req.body.publishYear){
            return res.status(400).send({message: "None of the fields given to update the book"});
        }
        const attributes = ["title", "author", "publishYear"];

        for (const attr of attributes) {
            if(req.body.hasOwnProperty(attr)){
                bookObj[attr] = req.body[attr];
            }
        }

        const updatedBook = await Book.findByIdAndUpdate(id, bookObj);

        return res.status(200).json({
            message: "Book updated successfully",
            updatedBook
        })

    } catch (error) {
        console.log(error);
        return res.status(500).send({message: error.message});
    }
});

router.delete("/:id", async (req, res) => {
    try {
        const { id } = req.params;

        const deletedBook = await Book.findByIdAndDelete(id);
        
        if(!deletedBook){
            return res.status(404).json({message: "Book not found!"});
        }

        res.status(200).json({
            message: "Deleted successfully",
            book: deletedBook
        });

        return;

    } catch (error) {
        console.log(error);
        return res.status(500).send({message: error.message});
    }
})

router.post("/", async (request, response) => {

    try{
        if(!request.body.title || !request.body.author || !request.body.publishYear){
            return response.status(400).send({message: "Send all required fields: title, author and publishYear"});
        }
        
        const newBook = {
            title: request.body.title,
            author: request.body.author,
            publishYear: request.body.publishYear
        };


        const book = await Book.create(newBook);
        
        return response.status(201).send(book);
    }
    catch(error){
        console.log(error.message);
        response.status(500).send({message: error.message});
    }

});


export default router;

