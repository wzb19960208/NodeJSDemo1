const net = require('net');
const chalk = require('chalk');
const http = require('http');
const fs = require('fs');

const WebSocket = require('ws');
 
const wss = new WebSocket.Server({ port: 8080 });
 
// Broadcast to all.包括自己了
wss.broadcast = function broadcast(data) {
  wss.clients.forEach(function each(client) {
    if (client.readyState === WebSocket.OPEN) {
      client.send(data);
    }
  });
};
 
wss.on('connection', function connection(ws) {
    console.info('ws connect');
    
  ws.on('message', function incoming(data) {
    // Broadcast to everyone else.
    wss.clients.forEach(function each(client) {
      if (client !== ws && client.readyState === WebSocket.OPEN) {
        client.send(data);
      }
    });
  });
});
var buffers=[];
//tcp用于接收视频推流
const tcpServer = net.createServer(function(sock){

    let client = sock.remoteAddress+':'+sock.remotePort;

    // 为'connection' 事件自动设置一个监听器。
    console.info(chalk.green(client+' connect!'));

    sock.on('data',function(data){
        //console.info(data);
        
        buffers.push[data];
        var n_shu= data;
        if(n_shu[n_shu.length-1]==217 && n_shu[n_shu.length-2]==255){
            var n_buffer = Buffer.concat(buffers);
            wss.broadcast(data);
            buffers=[];  
        }
        wss.broadcast(data);

    })
    

    sock.on('close',function(){
        console.info(chalk.green(client+' disconnect!'));
    })

    sock.on('error',function(err){
        console.error(err);
    })

    


}).listen(6003);

