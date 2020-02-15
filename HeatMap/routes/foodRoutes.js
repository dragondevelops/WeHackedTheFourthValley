const express = require('express');
const foodModel = require('../models/food');
const app = express();

app.get('/foods', async(req, res) => {
    const foods = await foodModel.find({});

    try {
        res.send(foods);
    } catch (err) {
        res.status(500).send(err);
    }
});

module.exports = app