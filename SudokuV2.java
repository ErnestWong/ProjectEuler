https://groups.google.com/forum/#!topic/android-opencv/zqD7IeExSSw/discussion

public class ImageManip{
    public Mat rotateGrid(Mat m){
        Mat tmp = new Mat(m.size(), m.type());
        Mat lines = new Mat();
        Imgproc.Canny(m, tmp, 50, 200);
        HoughLines(tmp, lines, 1, Math.PI/180, 100, 0, 0);
        
        double angle = findAngle(lines);
        if(angle >= 0){
            return rotateImage(m, angle);
        }
        else{
            Log.d("Angle error", "cant find angle");
            return null;
        }
    }
    
    public Mat trim(Mat m){
        Mat tmp = new Mat(m.size(), m.type());
        Imgproc.cvtColor(m, tmp, Imgproc.COLOR_BGR2GRAY);
        Imgproc.adaptiveThreshold(tmp, tmp, 255, Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C, Imgproc.THRESH_BINARY, 11, 2);
        byte pixels[] = new byte[tmp.total()];
        tmp.get(0, 0, pixels);
        
    }
    
    private Mat rotateImage(Mat src, double angle){
            Point centre = new Point(src.cols()/2, src.rows()/2);
            Mat matrix = Imgproc.getRotationMatrix2D(centre, angle, 1.0);
            Mat result = new Mat(src.type(), src.size());
            Imgproc.warpAffine(src, result, matrix, src.size());
            return result;
    }
        
    private double findAngle(Mat lines){
        for(int i = 0; i < lines.col(); i++){
            double[] data = lines.get(0, i);
            double theta = data[1];
            if(theta == 0) return 0;
            if(theta > 0 && theta < 45) return 360 - theta;
            else if(theta > 45 && theta < 90) return 90 - theta;
        }
        return -1;
    }
}
