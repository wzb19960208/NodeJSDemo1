import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.OutputStream;


public class socket{

	// public synchronized void sendData() {
        
	// }
	
	// public synchronized void recvData() {
        
    // }



    public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = new ServerSocket(6002);
		Socket sc = new Socket("119.29.156.242",6003);
		System.out.println("服务器启动!");
		Image image;
		File file;
		FileOutputStream outputStream;
		OutputStream os;
		os = sc.getOutputStream();
		volatile busy = 0;
		while(true){
			Socket socket = null;
			socket = serverSocket.accept();
			System.out.println("new connection!");
			try{

				
				image = ImageIO.read(socket.getInputStream());
			
				if(image!=null){

					if(busy==0){
						synchronized(busy){
							if(busy==0){
								System.out.println("get image!");
					// 	file = new File("./test"+System.currentTimeMillis()+".jpeg");
					// 		if(!file.exists()){
					// 	file.createNewFile();
					// }
					// outputStream = new FileOutputStream(file);
					// ImageIO.write((RenderedImage)image, "jpeg", outputStream);

					//开太多流同时传过去，会导致数据混乱，要保证同步，保证同时只有一个流传输东西
					os = sc.getOutputStream();
					ImageIO.write((RenderedImage)image, "jpeg", os);

					//每次要把socket关掉，连接的output关掉socket都关了奇怪
					socket.close();
					outputStream.flush();
					outputStream.close();
					busy = 1;

							}
						}
					}
					
						

					
					
					
				}

			}catch(Exception ex){
				
			}finally{
				//每次要把socket关掉，连接的output也关掉
				
			}
			
//			outputStream  = new FileOutputStream(file);
//			byte[] data = readInputStream(socket.getInputStream());
//			outputStream.write(data);
//			outputStream.close();
			
			
			
		}

	}



}