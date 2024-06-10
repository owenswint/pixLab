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
        p.setRed(r/4*4+c.getRed()/64);
        p.setGreen(g/4*4+c.getGreen()/64);
        p.setBlue(b/4*4+c.getBlue()/64);
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




    public static Picture revealPicture(Picture hidden){
        Picture copy = new Picture(hidden);
        Pixel[][] pixels = copy.getPixels2D();
        Pixel[][] source = hidden.getPixels2D();
        for (int r = 0; r < pixels.length; r++){
            for(int c = 0; c < pixels[0].length; c++){
                Color col = source[r][c].getColor();
                /*To be Implemented */
                int red = (col.getRed()%4)*64;
                int green = (col.getGreen()%4)*64 ;
                int blue = (col.getBlue()%4)*64 ;
                pixels[r][c].setColor(new Color(red, green, blue));
                //copy.getPixel(c, r).setColor(new Color(red, green, blue));
            }
           
        }
        return copy;
    }


    public static boolean canHide(Picture source, Picture secret){
        if(source.getWidth() >= secret.getWidth()){
            return false;
        }
        if(source.getHeight() >= secret.getHeight()){
            return false;
        }
        return true;
    }


   
    public static Picture hidePicture(Picture source, Picture secret){
       
        Pixel[][] secretPixel = secret.getPixels2D();
        Pixel[][] sourcePixel = source.getPixels2D();
        for(int h = 0; h<source.getHeight(); h++){
            for(int w = 0; w < source.getWidth(); w++){
                int r = sourcePixel[h][w].getRed();
                int g = sourcePixel[h][w].getGreen();
                int b = sourcePixel[h][w].getBlue();


                sourcePixel[h][w].setRed(r/4*4+secretPixel[h][w].getRed()/64);
                sourcePixel[h][w].setGreen(g/4*4+secretPixel[h][w].getGreen()/64);                  
                sourcePixel[h][w].setBlue(b/4*4+secretPixel[h][w].getBlue()/64);
            }
        }
        return source;
    }

    public static Picture hidePicture(Picture source, Picture secret, int startRow, int startColumn){
       
        Pixel[][] secretPixel = secret.getPixels2D();
        Pixel[][] sourcePixel = source.getPixels2D();
        int secretRow = 0;
        for(int h = startRow; h<startRow+secret.getHeight(); h++){
            int secretCol = 0;
            for(int w = startColumn; w < startColumn+secret.getWidth(); w++){
                int r = sourcePixel[h][w].getRed();
                int g = sourcePixel[h][w].getGreen();
                int b = sourcePixel[h][w].getBlue();

                int rs = secretPixel[secretRow][secretCol].getRed();
                int gs = secretPixel[secretRow][secretCol].getGreen();
                int bs = secretPixel[secretRow][secretCol].getBlue();


                sourcePixel[h][w].setRed(r/4*4+rs/64);
                sourcePixel[h][w].setGreen(g/4*4+gs/64);                  
                sourcePixel[h][w].setBlue(b/4*4+bs/64);
                secretCol++;
            }
            secretRow++;
        }
        return source;
    }


   








    public static void main(String[] args) {
        //Picture beach = new Picture("beach.jpg");
        //beach.explore();
        // Picture copy = testClearLow(beach);
        // copy.explore();


        //Picture blueMotorcycle = new Picture("blueMotorcycle.jpg");
        //blueMotorcycle.explore();




        // Picture beach2 = new Picture("beach.jpg");
        // beach2.explore();




        // Picture copy2 = testSetLow(beach2, Color.PINK);
        // copy2.explore();




        // Picture copy3 = revealPicture(copy2);
        // copy3.explore();


       


        // if (canHide(beach, blueMotorcycle) == true){


        //     Picture hidden1 = hidePicture(beach, blueMotorcycle);
        //     hidden1.explore();


        //     Picture revealed1 = revealPicture(hidden1);
        //     revealed1.explore();
           


        // }

        Picture beach = new Picture("beach.jpg");
        Picture robot = new Picture("robot.jpg");
        Picture flower1 = new Picture("flower1.jpg");
        beach.explore();

        Picture hidden1 = hidePicture(beach, robot, 65, 208);
        Picture hidden2 = hidePicture(hidden1, flower1, 280, 110);
        hidden2.explore();

        Picture unhidden = revealPicture(hidden2);
        unhidden.explore();




    }
}
