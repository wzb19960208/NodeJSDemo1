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

	public static synchronized void sendData(Image image,File file) throws IOException{
		// File file = new File("./test"+System.currentTimeMillis()+".jpeg");
		
		FileOutputStream outputStream = new FileOutputStream(file);
		ImageIO.write((RenderedImage)image, "jpeg", outputStream);
		//outputStream.flush();
		outputStream.close();

		//ImageIO.write((RenderedImage)image, "jpeg", os);

        
	}
	
	public synchronized void recvData() {
        
	}
	
	



    public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = new ServerSocket(6002);
		//Socket sc = new Socket("119.29.156.242",6003);
		System.out.println("服务器启动!");
		Image image;
		File file = new File("./test.jpeg");
		if(!file.exists()){
			file.createNewFile();
			}
		//FileOutputStream outputStream;
		//OutputStream os;
		//os = sc.getOutputStream();
		
		while(true){
			Socket socket = null;
			socket = serverSocket.accept();
			System.out.println("new connection!");
			try{

				
				image = ImageIO.read(socket.getInputStream());
			
				if(image!=null){

					
						
							
					System.out.println("get image!");
					
					sendData(image,file);

					//开太多流同时传过去，会导致数据混乱，要保证同步，保证同时只有一个流传输东西
					
					// os = sc.getOutputStream();
					// ImageIO.write((RenderedImage)image, "jpeg", os);

					//每次要把socket关掉，连接的output关掉socket都关了奇怪
					socket.close();
					
	
					
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