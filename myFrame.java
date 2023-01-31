/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author subha
 */
public class myFrame extends javax.swing.JFrame {
    BufferedImage img = null;
    BufferedImage img2 = null;
    
    public myFrame() {
        initComponents();
        rgb.setVisible(false);
        rbg.setVisible(false);
        brg.setVisible(false);
        bgr.setVisible(false);
        grb.setVisible(false);
        gbr.setVisible(false);
 }
    
    public boolean check = false;
    
    
    @Override
    public void paint (Graphics g){
        super.paint(g);
        g.drawImage(img,100,100,300,300,null);
        g.drawRect(100, 100, 300, 300);
        
        if(check == true){
            g.setColor(Color.BLACK);
            g.setFont (new Font ("Arial Black", 5, 45));
            g.drawString("HAPPY", 170, 165);
            g.drawString("NEW", 195, 265);
            g.drawString("YEAR", 180, 365);
        }
    }
    
    public final int S = 10;
    
    public int truncate(int value){
        if(value < 0){
            value = 0;
        }
        else if(value > 255){
            value = 255;
        }
        return value;
    }
    
    public void brightness(int br){
        for(int x = 0; x < img.getWidth(); ++x){
            for(int y = 0; y < img.getHeight(); ++y){
                int pixel = img2.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                int nred = truncate(red + br);
                int ngreen = truncate(green + br);
                int nblue = truncate(blue + br);
                img.setRGB(x, y, new Color(nred,ngreen,nblue).getRGB());
            }
        }
    }
    
        public void brightper(int br){
        for(int x = 0; x < img.getWidth(); ++x){
            for(int y = 0; y < img.getHeight(); ++y){
                int pixel = img2.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                int nred = truncate(red+red*br/100);
                int ngreen = truncate(green+green*br/100);
                int nblue = truncate(blue+blue*br/100);
                img.setRGB(x, y, new Color(nred,ngreen,nblue).getRGB());
            }
        }
    }
    
    
    

    public void rgbr(int r){
        for(int x = 0; x < img.getWidth(); ++x){
            for(int y = 0; y < img.getHeight(); ++y){
                int pixel = img2.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                img.setRGB(x, y, new Color(r,green,blue).getRGB());
            }
        }

    }
    
        public void rgbg(int g){
        for(int x = 0; x < img.getWidth(); ++x){
            for(int y = 0; y < img2.getHeight(); ++y){
                int pixel = img2.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                img.setRGB(x, y, new Color(red,g,blue).getRGB());
            }
        }
    }
        
public void rgbb(int b){
        for(int x = 0; x < img.getWidth(); ++x){
            for(int y = 0; y < img.getHeight(); ++y){
                int pixel = img2.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                img.setRGB(x, y, new Color(red,green,b).getRGB());
            }
        }
    }
        
public void dimmer(){
    for(int x = 0; x < img.getWidth(); ++x){
            for(int y = 0; y < img.getHeight(); ++y){
                int pixel = img.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                img.setRGB(x, y, new Color(red/2,green/2,blue/2).getRGB());
            }
        }
}

public void undimmer(){
    for(int x = 0; x < img.getWidth(); ++x){
            for(int y = 0; y < img.getHeight(); ++y){
                int pixel = img.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                img.setRGB(x, y, new Color(red*2,green*2,blue*2).getRGB());
            }
        }
}

public void monochrom(){
    for(int x = 0; x < img.getWidth(); ++x){
            for(int y = 0; y < img.getHeight(); ++y){
                int pixel = img.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                int avg = (red+green+blue)/3;
                img.setRGB(x, y, new Color(avg,avg,avg).getRGB());
            }
        }
}

public void unmono(){
    for(int x = 0; x < img.getWidth(); ++x){
            for(int y = 0; y < img.getHeight(); ++y){
                int pixel = img2.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                img.setRGB(x, y, new Color(red,green,blue).getRGB());
            }
        }
}

public void horizontalEdge(){    
    for(int y=0;y<img.getHeight()-1;y++){
            for(int x=0;x<img.getWidth();x++){
                int tc=img.getRGB(x,y);
                int bc=img.getRGB(x,y+1);
                int red=(tc >> 16 ) & 0x0ff;
                int green=(tc >> 8 ) & 0x0ff;
                int blue=(tc) & 0x0ff;
                Color col=new Color(red,green,blue);
                int redh=(bc >> 16 ) & 0x0ff;
                int greenh=(bc >> 8 ) & 0x0ff;
                int blueh=(bc) & 0x0ff;
                Color col2=new Color(redh,greenh,blueh);
                int ta=(col.getRed()+col.getGreen()+col.getBlue())/3;
                int ba=(col2.getRed()+col2.getGreen()+col2.getBlue())/3;
                
                if(Math.abs(ta-ba)<S){
                    img.setRGB(x,y,Color.WHITE.getRGB());
                }else{
                    img.setRGB(x,y,Color.BLACK.getRGB());
                }
            }
        }
}

public void unhor(){
    for(int x = 0; x < img.getWidth(); ++x){
            for(int y = 0; y < img.getHeight(); ++y){
                int pixel = img2.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                img.setRGB(x, y, new Color(red,green,blue).getRGB());
            }
        }
}

public void verticalEdge(){
    for(int x=0;x<img.getWidth()-1;x++){
            for(int y=0;y<img.getHeight();y++){
                int tc=img2.getRGB(x,y);
                int bc=img2.getRGB(x+1,y);
                int red=(tc >> 16 ) & 0x0ff;
                int green=(tc >> 8 ) & 0x0ff;
                int blue=(tc) & 0x0ff;
                Color col=new Color(red,green,blue);
                int red1=(bc >> 16 ) & 0x0ff;
                int green1=(bc >> 8 ) & 0x0ff;
                int blue1=(bc) & 0x0ff;
                Color col2=new Color(red1,green1,blue1);
                int ta=(col.getRed()+col.getGreen()+col.getBlue())/3;
                int ba=(col2.getRed()+col2.getGreen()+col2.getBlue())/3;
                
                if(Math.abs(ta-ba)<S){
                    img.setRGB(x,y,Color.WHITE.getRGB());
                }else{
                    img.setRGB(x,y,Color.BLACK.getRGB());
                }
            }
            repaint();
    }
}

public void unver(){
    for(int x = 0; x < img.getWidth(); ++x){
            for(int y = 0; y < img.getHeight(); ++y){
                int pixel = img2.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                img.setRGB(x, y, new Color(red,green,blue).getRGB());
            }
        }
}

public void reversex(){
   
    for(int x = 0; x < img.getWidth(); ++x){
            for(int y = 0; y < img.getHeight(); ++y){
                int pixel = img2.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                img.setRGB(img.getWidth()-x-1, y, new Color(red,green,blue).getRGB());
            }
        }
}

public void reversey(){
   
    for(int x = 0; x < img.getWidth(); ++x){
            for(int y = 0; y < img.getHeight(); ++y){
                int pixel = img2.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                img.setRGB(x, img.getHeight()-y-1, new Color(red,green,blue).getRGB());
            }
        }
}

public void fdivide(){
    for(int x = 0; x < img.getWidth()/2; ++x){
        for(int y = 0;y < img.getHeight()/2;++y){
            int pixel = img2.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                img.setRGB(img.getWidth()/2+x, img.getHeight()/2+y, new Color(red,green,blue).getRGB());
        }
    }
    
    for(int x = img.getWidth()/2; x < img.getWidth(); ++x){
        for(int y = img.getHeight()/2;y < img.getHeight();++y){
            int pixel = img2.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                img.setRGB(x-img.getWidth()/2,y-img.getHeight()/2, new Color(red,green,blue).getRGB());
        }
    }
    
}

public void onedivfour(){
     for(int x = 0; x < img.getWidth()/2; ++x){
        for(int y = 0;y < img.getHeight()/2;++y){
            int pixel = img2.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                img.setRGB(2*x, 2*y, new Color(red,green,blue).getRGB());
                img.setRGB(2*x+1, 2*y+1, new Color(red,green,blue).getRGB());
                img.setRGB(2*x+1, 2*y, new Color(red,green,blue).getRGB());
                img.setRGB(2*x, 2*y+1, new Color(red,green,blue).getRGB());
                
        }
    }
}

public void sixdivide(){
    for(int x = 0; x < img.getWidth()/3; ++x){
        for(int y = 0;y < img.getHeight()/3;++y){
            int pixel = img2.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                img.setRGB(2*img.getWidth()/3+x, 2*img.getHeight()/3+y, new Color(red,green,blue).getRGB());
        }
    }
    
     for(int x = 2*img.getWidth()/3; x < img.getWidth(); ++x){
        for(int y = 2*img.getHeight()/3;y < img.getHeight();++y){
            int pixel = img2.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                img.setRGB(x-2*img.getWidth()/3,y-2*img.getHeight()/3, new Color(red,green,blue).getRGB());
        }
    }
}


    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        redSlider = new javax.swing.JSlider();
        jButton1 = new javax.swing.JButton();
        blueSlider = new javax.swing.JSlider();
        greenSlider = new javax.swing.JSlider();
        rbg = new javax.swing.JRadioButton();
        grb = new javax.swing.JRadioButton();
        gbr = new javax.swing.JRadioButton();
        bgr = new javax.swing.JRadioButton();
        brg = new javax.swing.JRadioButton();
        brightness = new javax.swing.JSlider();
        dimmer = new javax.swing.JCheckBox();
        monochrom = new javax.swing.JCheckBox();
        horizontal = new javax.swing.JCheckBox();
        vertical = new javax.swing.JCheckBox();
        Save2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ChSwap = new javax.swing.JCheckBox();
        rgb = new javax.swing.JRadioButton();
        reversex = new javax.swing.JButton();
        reversey = new javax.swing.JButton();
        fdivide = new javax.swing.JButton();
        onedivfour = new javax.swing.JButton();
        sixdivide = new javax.swing.JButton();
        brper = new javax.swing.JSlider();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        dont = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        redSlider.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        redSlider.setMaximum(255);
        redSlider.setPaintTicks(true);
        redSlider.setToolTipText("");
        redSlider.setValue(127);
        redSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                redSliderStateChanged(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        jButton1.setText("Cancel");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        blueSlider.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        blueSlider.setMaximum(255);
        blueSlider.setPaintTicks(true);
        blueSlider.setToolTipText("");
        blueSlider.setValue(127);
        blueSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                blueSliderStateChanged(evt);
            }
        });

        greenSlider.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        greenSlider.setMaximum(255);
        greenSlider.setPaintTicks(true);
        greenSlider.setToolTipText("");
        greenSlider.setValue(127);
        greenSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                greenSliderStateChanged(evt);
            }
        });

        buttonGroup1.add(rbg);
        rbg.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        rbg.setText("RBG");
        rbg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbgActionPerformed(evt);
            }
        });

        buttonGroup1.add(grb);
        grb.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        grb.setText("GRB");
        grb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grbActionPerformed(evt);
            }
        });

        buttonGroup1.add(gbr);
        gbr.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        gbr.setText("GBR");
        gbr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gbrActionPerformed(evt);
            }
        });

        buttonGroup1.add(bgr);
        bgr.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        bgr.setText("BGR");
        bgr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgrActionPerformed(evt);
            }
        });

        buttonGroup1.add(brg);
        brg.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        brg.setText("BRG");
        brg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brgActionPerformed(evt);
            }
        });

        brightness.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        brightness.setMinimum(-100);
        brightness.setPaintTicks(true);
        brightness.setToolTipText("");
        brightness.setValue(0);
        brightness.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                brightnessStateChanged(evt);
            }
        });

        dimmer.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        dimmer.setText("Dimmer");
        dimmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dimmerActionPerformed(evt);
            }
        });

        monochrom.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        monochrom.setText("Monochrom");
        monochrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monochromActionPerformed(evt);
            }
        });

        horizontal.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        horizontal.setText("Horizontal");
        horizontal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horizontalActionPerformed(evt);
            }
        });

        vertical.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        vertical.setText("Vertical");
        vertical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verticalActionPerformed(evt);
            }
        });

        Save2.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        Save2.setText("Save");
        Save2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Save2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        jLabel1.setText("BRIGHTNESS");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("RED");

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 255, 0));
        jLabel5.setText("GREEN");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("BLUE");

        ChSwap.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        ChSwap.setText("Channel Swap");
        ChSwap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChSwapActionPerformed(evt);
            }
        });

        buttonGroup1.add(rgb);
        rgb.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        rgb.setText("RGB");
        rgb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rgbActionPerformed(evt);
            }
        });

        reversex.setText("reverse x");
        reversex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reversexActionPerformed(evt);
            }
        });

        reversey.setText("reverse y");
        reversey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reverseyActionPerformed(evt);
            }
        });

        fdivide.setText("four divide");
        fdivide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fdivideActionPerformed(evt);
            }
        });

        onedivfour.setText("onedvfour");
        onedivfour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onedivfourActionPerformed(evt);
            }
        });

        sixdivide.setText("sixdivide");
        sixdivide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sixdivideActionPerformed(evt);
            }
        });

        brper.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        brper.setPaintTicks(true);
        brper.setToolTipText("");
        brper.setValue(0);
        brper.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                brperStateChanged(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setText("Load");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Save");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Save as");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        dont.setText("Don't Push");
        dont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dontActionPerformed(evt);
            }
        });
        jMenu2.add(dont);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(brightness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vertical, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monochrom)
                    .addComponent(dimmer, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChSwap)
                    .addComponent(horizontal)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(rgb)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbg)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(grb))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(gbr)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bgr)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(brg)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(blueSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(greenSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(redSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(brper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(Save2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1)
                            .addGap(35, 35, 35))))
                .addGap(64, 64, 64))
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reversex)
                    .addComponent(onedivfour))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sixdivide)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(reversey)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fdivide)
                        .addGap(99, 357, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ChSwap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbg)
                            .addComponent(grb)
                            .addComponent(rgb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gbr)
                            .addComponent(bgr)
                            .addComponent(brg))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(monochrom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dimmer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vertical)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(horizontal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(brightness, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reversex)
                            .addComponent(reversey)
                            .addComponent(fdivide)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(redSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(greenSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(blueSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(Save2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(brper, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(onedivfour)
                    .addComponent(sixdivide))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);   
                BufferedImage img = null;
                try {
                    img = ImageIO.read(chooser.getSelectedFile());
                    img2 = ImageIO.read(chooser.getSelectedFile());
                    
                } catch (IOException ex) {
                    System.out.println("Couldn't find file");
                }
                this.setVisible(true);
                this.setImage(img);
                repaint();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
          if(img != null){  
            File file = new File("ss.png");
                try {
                    ImageIO.write(img,"png",file);
                    System.out.println("Saved");
                } catch (IOException ex) {
                    System.out.println("Not Saved");
                }
        }
      
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void redSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_redSliderStateChanged
        if(img != null){
        rgbr(redSlider.getValue());
        repaint();
        }  
    }//GEN-LAST:event_redSliderStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        redSlider.setValue(127);
        redSlider.setValueIsAdjusting(false);
        greenSlider.setValue(127);
        greenSlider.setValueIsAdjusting(false);
        blueSlider.setValue(127);
        blueSlider.setValueIsAdjusting(false);
        brightness.setValue(0);
        brightness.setValueIsAdjusting(false);
        if(img2 != null){
        for(int x = 0; x < img.getWidth(); ++x){
            for(int y = 0; y < img.getHeight(); ++y){
                int pixel = img2.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                img.setRGB(x, y, new Color(red,green,blue).getRGB());
            }
         }    
        repaint();
        
        dimmer.setSelected(false);
        monochrom.setSelected(false);
        horizontal.setSelected(false);
        vertical.setSelected(false);
        buttonGroup1.clearSelection();}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void blueSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_blueSliderStateChanged
        if(img != null){    
            rgbb(blueSlider.getValue());
            repaint();}
    }//GEN-LAST:event_blueSliderStateChanged

    private void greenSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_greenSliderStateChanged
        if(img != null){    
            rgbg(greenSlider.getValue());
            repaint();}
    }//GEN-LAST:event_greenSliderStateChanged

    private void rbgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbgActionPerformed
        for(int x = 0; x < img.getWidth(); ++x){
            for(int y = 0; y < img.getHeight(); ++y){
                int pixel = img.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                img.setRGB(x, y, new Color(red,blue,green).getRGB());
            }
        }
        repaint();
    }//GEN-LAST:event_rbgActionPerformed

    private void grbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grbActionPerformed
        for(int x = 0; x < img.getWidth(); ++x){
            for(int y = 0; y < img.getHeight(); ++y){
                int pixel = img.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                img.setRGB(x, y, new Color(green,red,blue).getRGB());
            }
        }
        repaint();
    }//GEN-LAST:event_grbActionPerformed

    private void brgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brgActionPerformed
        for(int x = 0; x < img.getWidth(); ++x){
            for(int y = 0; y < img.getHeight(); ++y){
                int pixel = img.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                img.setRGB(x, y, new Color(green,blue,red).getRGB());
            }
        }
        repaint();
    }//GEN-LAST:event_brgActionPerformed

    private void bgrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgrActionPerformed
        for(int x = 0; x < img.getWidth(); ++x){
            for(int y = 0; y < img.getHeight(); ++y){
                int pixel = img.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                img.setRGB(x, y, new Color(blue,green,red).getRGB());
            }
        }
        repaint();
    }//GEN-LAST:event_bgrActionPerformed

    private void gbrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gbrActionPerformed
        for(int x = 0; x < img.getWidth(); ++x){
            for(int y = 0; y < img.getHeight(); ++y){
                int pixel = img.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                img.setRGB(x, y, new Color(blue,red,green).getRGB());
            }
        }
        repaint();
    }//GEN-LAST:event_gbrActionPerformed

    private void brightnessStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_brightnessStateChanged
        if(img != null){
        brightness(brightness.getValue());
        repaint();}
//        img = img2;
        
    }//GEN-LAST:event_brightnessStateChanged

    private void dimmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dimmerActionPerformed
        if(dimmer.isSelected() == true){
            dimmer();
            repaint();
        }
        else{
            undimmer();
            repaint();
        }
    }//GEN-LAST:event_dimmerActionPerformed

    private void monochromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monochromActionPerformed
       if(monochrom.isSelected() == true){
           monochrom();
           repaint();
       }
       else{
           unmono();
           repaint();
       }
    }//GEN-LAST:event_monochromActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       JFileChooser chooser=new JFileChooser();
        chooser.setDialogTitle("Specify a file to save");
        chooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter=new FileNameExtensionFilter("Image Files","jpg","png","gif");
        chooser.addChoosableFileFilter(filter);
        int act=chooser.showOpenDialog(this);
        if(act==JFileChooser.APPROVE_OPTION){
           File fileToSave=chooser.getSelectedFile();
            File currentFile = fileToSave;
        try{
            ImageIO.write(img, "png",fileToSave);
            System.out.println("image saved");
        }catch(IOException ex){
            System.out.println("not saved");
        }
        }
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    
    
    private void horizontalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horizontalActionPerformed
            if(horizontal.isSelected() == true){
                horizontalEdge();
                repaint();
            }
            else{
                unhor();
                repaint();
            }
    }//GEN-LAST:event_horizontalActionPerformed

    private void verticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verticalActionPerformed
        if(vertical.isSelected() == true){
            verticalEdge();
            repaint();
        }
        else{
            unver();
            repaint();
        }
    }//GEN-LAST:event_verticalActionPerformed

    private void Save2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save2ActionPerformed
        if(img != null){  
            File file = new File("ss.png");
                try {
                    ImageIO.write(img,"png",file);
                    System.out.println("Saved");
                } catch (IOException ex) {
                    System.out.println("Not Saved");
                }
        }
    }//GEN-LAST:event_Save2ActionPerformed

    private void ChSwapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChSwapActionPerformed
       if(ChSwap.isSelected() == true){
           rgb.setVisible(true);
           rbg.setVisible(true);
           gbr.setVisible(true);
           grb.setVisible(true);
           brg.setVisible(true);
           bgr.setVisible(true);
       }
       else{
           rgb.setVisible(false);
           rbg.setVisible(false);
           brg.setVisible(false);
           bgr.setVisible(false);
           grb.setVisible(false);
           gbr.setVisible(false);
       }
       repaint();
    }//GEN-LAST:event_ChSwapActionPerformed

    private void dontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dontActionPerformed
        check = true;
        repaint();
    }//GEN-LAST:event_dontActionPerformed

    private void rgbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rgbActionPerformed
         for(int x = 0; x < img.getWidth(); ++x){
            for(int y = 0; y < img.getHeight(); ++y){
                int pixel = img.getRGB(x,y);
                int red = (pixel >> 16) & 0x0ff;
                int green = (pixel >> 8) & 0x0ff;
                int blue = (pixel) & 0x0ff;
                img.setRGB(x, y, new Color(red,green,blue).getRGB());
            }
        }
        repaint();
    }//GEN-LAST:event_rgbActionPerformed

    private void reversexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reversexActionPerformed
        reversex();
        repaint();
    }//GEN-LAST:event_reversexActionPerformed

    private void reverseyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reverseyActionPerformed
        reversey();
        repaint();
    }//GEN-LAST:event_reverseyActionPerformed

    private void fdivideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fdivideActionPerformed
        fdivide();
        repaint();
    }//GEN-LAST:event_fdivideActionPerformed

    private void onedivfourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onedivfourActionPerformed
       onedivfour();
       repaint();
    }//GEN-LAST:event_onedivfourActionPerformed

    private void sixdivideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sixdivideActionPerformed
        sixdivide();
        repaint();
    }//GEN-LAST:event_sixdivideActionPerformed

    private void brperStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_brperStateChanged
        brightper(brper.getValue());
        repaint();
    }//GEN-LAST:event_brperStateChanged
    
    public void setImage (BufferedImage image){
        img = image;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(myFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(myFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(myFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(myFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new myFrame().setVisible(true);
            }
        });
        
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ChSwap;
    private javax.swing.JButton Save2;
    private javax.swing.JRadioButton bgr;
    private javax.swing.JSlider blueSlider;
    private javax.swing.JRadioButton brg;
    private javax.swing.JSlider brightness;
    private javax.swing.JSlider brper;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox dimmer;
    private javax.swing.JMenuItem dont;
    private javax.swing.JButton fdivide;
    private javax.swing.JRadioButton gbr;
    private javax.swing.JRadioButton grb;
    private javax.swing.JSlider greenSlider;
    private javax.swing.JCheckBox horizontal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JCheckBox monochrom;
    private javax.swing.JButton onedivfour;
    private javax.swing.JRadioButton rbg;
    private javax.swing.JSlider redSlider;
    private javax.swing.JButton reversex;
    private javax.swing.JButton reversey;
    private javax.swing.JRadioButton rgb;
    private javax.swing.JButton sixdivide;
    private javax.swing.JCheckBox vertical;
    // End of variables declaration//GEN-END:variables
}
