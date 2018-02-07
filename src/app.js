const http = require('http');
const fs = require('fs');
const chalk = require('chalk');
const url = require("url");

http.createServer((req,res)=>{

    let path = url.parse(req.url).pathname;

    fs.readFile('../photo.html',(err,data)=>{

        if(err){
            console.error(err);
        }

        res.writeHead(200,{'Content-Type':'text/html'});
        res.end(data);


    });

    if(path=='/test.png'){

        fs.readFile('../test.png',(err,data)=>{

            if(err){
                console.error(err);
            }
    
            res.writeHead(200,{'Content-Type':'image/png'});
            res.end(data);
    
    
        });

    }

   
    

}).listen(9091,()=>{
    console.info(chalk.green('Server started!'));
});

