const http = require('http');
const fs = require('fs');
const chalk = require('chalk');

http.createServer((req,res)=>{

    fs.readFile('../photo.html',(err,data)=>{

        if(err){
            console.error(err);
        }

        res.writeHead(200,{'Content-Type':'text/html'});
        res.end(data);


    });

    if(req.url=='test.png'){

        fs.readFile('../test',(err,data)=>{

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

