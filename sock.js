const net = require('net');
const chalk = require('chalk');

const tcpServer = net.createServer(function(sock){

    let client = sock.remoteAddress+':'+sock.remotePort;

    // 为'connection' 事件自动设置一个监听器。
    console.info(chalk.green(client+' connect!'));

    //console.info(sock);

    sock.on('data',function(){
        console.info(data);
    })


    sock.on('close',function(){
        console.info(chalk.green(client+' disconnect!'));
    })

    sock.on('error',function(err){
        console.error(err);
    })

    //每次拿到数据就用websocket转发


}).listen(6002);