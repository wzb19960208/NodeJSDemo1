const net = require('net');

const tcpServer = net.createServer(function(sock){

    let client = sock.remoteAddress+':'+sock.remotePort;

    // 为'connection' 事件自动设置一个监听器。
    console.info(chalk.green(client+' connect!'));


    sock.on('close',function(){
        console.info(chalk.green(client+' disconnect!'));
    })

    sock.on('error',function(err){
        console.error(err);
    })


}).listen(6002);