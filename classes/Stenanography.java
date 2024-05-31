import java.awt.Color;

public class Stenanography {
    public static void clearLow(Pixel p){
        p.setColor(new Color(p.getRed()*4, p.getGreen()*4, p.getBlue()*4));
    }

    public static Picture testClearLow(Picture picture){
        Picture pic = picture;
        for(int i = 0; i < pic.getWidth(); i++){
            for(int j = 0; j < pic.getHeight(); j++){
                clearLow(pic.getPixel(i, j));
            }
        }
        return pic;
    }

    public static void setLow(Pixel p, Color c){
        int r = p.getRed();
        int g = p.getGreen();
        int b = p.getBlue();
        p.setColor(new Color(r*4/4+r/64, g*4/4+g/64, b*4/4+b/64));
    }

    public static Picture testSetLow(Picture p, Color c){
        Picture pic = p;
        for(int i = 0; i < pic.getWidth(); i++){
            for(int j = 0; j < pic.getHeight(); j++){
                setLow(pic.getPixel(i, j), c);
            }
        }
        return pic;
    }

    public static void main(String[] args) {
      //  Picture beach = new Picture("beach.jpg");
      //  beach.explore();
       // Picture copy = testClearLow(beach);
       // copy.explore();

        //Picture beach2 = new Picture("beach.jpg");
        //beach2.explore();
        Picture copy2 = testSetLow(beach2, Color.PINK);
        copy2.explore();
    }
}
