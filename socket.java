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


public class socket{

    public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = new ServerSocket(6002);
		Socket sc = new Socket("119.29.156.242",6003);
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
					// file = new File("./test"+System.currentTimeMillis()+".jpeg");
					// if(!file.exists()){
					// 	file.createNewFile();
					// }
					// outputStream = new FileOutputStream(file);
					// ImageIO.write((RenderedImage)image, "jpeg", outputStream);
					ImageIO.write((RenderedImage)image, "jpeg", sc.getOutputStream());
					
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