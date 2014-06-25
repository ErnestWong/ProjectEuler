import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class OpenCVtest {
	

	public BufferedImage Mat2BufferedImage(Mat m) {
		// source:
		// http://answers.opencv.org/question/10344/opencv-java-load-image-to-gui/
		// Fastest code
		// The output can be assigned either to a BufferedImage or to an Image

		int type = BufferedImage.TYPE_BYTE_GRAY;
		if (m.channels() > 1) {
			type = BufferedImage.TYPE_3BYTE_BGR;
		}
		int bufferSize = m.channels() * m.cols() * m.rows();
		byte[] b = new byte[bufferSize];
		m.get(0, 0, b); // get all the pixels
		BufferedImage image = new BufferedImage(m.cols(), m.rows(), type);
		final byte[] targetPixels = ((DataBufferByte) image.getRaster()
				.getDataBuffer()).getData();
		System.arraycopy(b, 0, targetPixels, 0, b.length);
		return image;

	}
	
	public boolean writeImage(Mat m){
		return Highgui.imwrite("result.jpg", m);
	}
	
	public Mat getImage(){
		String filename = "image.jpg";
		Mat m = Highgui.imread(filename);
		return m;
	}
	
	public void fixImage(Mat m){
		Imgproc.blur(m, m, m.size());
		Imgproc.Canny(m, m, 100, 100);
		Mat lines = new Mat();
		Imgproc.HoughLinesP(m, lines, 1, Math.PI/180, 80, 30, 10);
		for(int i = 0; i < lines.cols(); i++){
			double[] data = lines.get(0, i);
			for(int j = 0; j < data.length; j++){
				System.out.println(j + ".: " + data[j]);
			}
		}
		
	}
	
	public static void main(String[] args){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		OpenCVtest cv = new OpenCVtest();
		Mat m = cv.getImage();
		cv.fixImage(m);
		cv.writeImage(m);
	}
}
