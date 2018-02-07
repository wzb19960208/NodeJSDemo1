import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;
import java.awt.Image;


public class socket{

    public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = new ServerSocket(6002);
		System.out.println("服务器启动!");
		Image image;
		File file;
		FileOutputStream outputStream;
		while(true){
			Socket socket = null;
			socket = serverSocket.accept();
			System.out.println("new connection!");
			try{

				image = ImageIO.read(socket.getInputStream());
			
				if(image!=null){
					System.out.println("get image!");
					file = new File("./test"+System.currentTimeMillis()+".png");
					if(!file.exists()){
						file.createNewFile();
					}
					outputStream = new FileOutputStream(file);
	            	ImageIO.write(image, "png", outputStream);
				}

			}catch(Exception ex){
				
			}
			
//			outputStream  = new FileOutputStream(file);
//			byte[] data = readInputStream(socket.getInputStream());
//			outputStream.write(data);
//			outputStream.close();
			
			
			
		}

	}



}