const http = require('http');
const fs = require('fs');
const chalk = require('chalk');
const url = require("url");

http.createServer((req,res)=>{

    let path = url.parse(req.url).pathname;

    console.info(path);

    if(path=='/test.png'){

        
        // 必须给图片添加新的响应方式，不然用src设置的图片根本找不到。
        fs.readFile('../test.jpeg',(err,data)=>{

            if(err){
                console.error(err);
            }
    
            res.writeHead(200,{'Content-Type':'image/jpeg'});
            res.end(data);
    
    
        });

    }else{

        fs.readFile('../photo.html',(err,data)=>{

            if(err){
                console.error(err);
            }
    
            res.writeHead(200,{'Content-Type':'text/html'});
            res.end(data);
    
    
        });

    }

    

    

   
    

}).listen(9091,()=>{
    console.info(chalk.green('Server started!'));
});

