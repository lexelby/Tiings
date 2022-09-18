package tilings;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import tilingTypes.ITilingType;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PanelShowTiling
   extends JPanel
   implements ActionListener
{
   private PanelTilingDraw dispPanel = new PanelTilingDraw();

   private PanelTilingControl contPanel;
   private PanelTilingInfo infoPanel;
   private JSplitPane split = new JSplitPane( JSplitPane.VERTICAL_SPLIT, true );
   private int infoHeight;
   private ITilingType tt;

   public PanelShowTiling(boolean isApplet) {
      setLayout(new BorderLayout());

      contPanel = new PanelTilingControl(this, isApplet);
      infoPanel = new PanelTilingInfo();

      split.setTopComponent(dispPanel);
      split.setBottomComponent(infoPanel);
      add(split);
      split.setResizeWeight(1);
      add(contPanel, BorderLayout.EAST);
   }

   public void setTilingType(ITilingType t) {
      if (tt != t) {
         tt = t;
         contPanel.setTilingType(t);
         update();
      }
   }

   public void actionPerformed(ActionEvent ae) {
      if(ae.getID() == 2) {
         saveFile();
      }else if(ae.getID() == 3) {
         startRecording();
      }else if(ae.getID() == 4) {
         saveRecording();
      }else if(ae.getID() == 5) {
         abortSaving(null);
      } else {
         update();
         synchronized(this){
            if(isRecording){
               addFrameToRecording();
            }
         }
      }
   }
   
   
   private GifSequenceWriter gifWriter = null;
   private File outputfile = null;
   private boolean isRecording = false;
   
   private void startRecording(){
      gifWriter = null;
      outputfile = null;
      isRecording = true;
   }
   private void addFrameToRecording(){
      synchronized(this){
         if( !isRecording) return;
         Image myImage = dispPanel.getImage();
         // on first frame, create a file gifwriter
         if(gifWriter==null){
            setupFileChooser(true);
            setupPreview(myImage);

            if( !selectOutputFile()) {
               isRecording = false;
               contPanel.finishedSave();
               return;
            }
            
            try {
               ImageOutputStream outputStream = new FileImageOutputStream(outputfile);
               // create a gif sequence, which loops continuously
               gifWriter = new GifSequenceWriter(outputStream, BufferedImage.TYPE_INT_ARGB,
                     PanelTilingControl.FRAMEDURATION, true);
            } catch (IOException e) {
               abortSaving(e);
            }
         }
         
         // add the frame to the stream
         myImage = getScaledImage(myImage);
         BufferedImage bufferedImage = toBufferedImage(myImage, BufferedImage.TYPE_INT_ARGB);
         try {
            gifWriter.writeToSequence(bufferedImage);
         } catch (IOException e) {
            abortSaving(e);
         }
      }
   }
   
   private void saveRecording(){
      // finish the file and close it
      synchronized(this){
         try {
            gifWriter.close();
            gifWriter.getOutputStream().close();
         } catch (IOException e) {
            abortSaving(e);
         }
         gifWriter = null;
         isRecording = false;
      }
   }
   
   private void abortSaving(IOException e){
      synchronized(this){
         if(e!=null){
            JOptionPane.showMessageDialog(this, "Saving the image failed with the following error:\n"+e.getMessage(), "Error while saving", JOptionPane.ERROR_MESSAGE);
         }

         // close stream
         if(gifWriter!=null){
            try {
               gifWriter.getOutputStream().close();
            } catch (IOException e2) {
            }
         }
         gifWriter = null;
         isRecording = false;
         // remove file
         if(outputfile!=null){
            try {
               outputfile.delete();
            } catch (Exception e3) {
            }
         }
         outputfile = null;
      }
   }
   
   private class Resolution {
      private int w,h;
      public Resolution(int w,int h){
         this.w = w;
         this.h = h;
      }
      @Override
      public String toString(){
         return w+"x"+h;
      }
      public int getWidth(){ return w; }
      public int getHeight(){ return h; }
   }
   private JFileChooser localchooser;
   private JLabel imageInfo;
   private JComboBox<Resolution> resolutionList;
   private FileNameExtensionFilter[] filters = {
         new FileNameExtensionFilter("BMP image","bmp"),
         new FileNameExtensionFilter("GIF image","gif"),
         new FileNameExtensionFilter("PNG image","png"),
         new FileNameExtensionFilter("JPEG image","jpg","jpeg"),
         new FileNameExtensionFilter("SVG image","svg"),
      };
   
   private void setupFileChooser(boolean animated){
      if( localchooser == null ){
         localchooser = new JFileChooser();
         // set preview
         Box box = Box.createVerticalBox();
         box.add(Box.createVerticalGlue());
         imageInfo = new JLabel();
         imageInfo.setVerticalTextPosition(JLabel.BOTTOM);
         imageInfo.setHorizontalTextPosition(JLabel.CENTER);
         box.add(imageInfo);
         imageInfo.setAlignmentX(0.5f);
         box.add(Box.createVerticalStrut(10));
         box.add(new JLabel("Select size:"));
         resolutionList = new JComboBox<Resolution>(); 
         box.add(resolutionList);
         Dimension maxsize = resolutionList.getMaximumSize();
         Dimension minsize = resolutionList.getMinimumSize();
         resolutionList.setMaximumSize(new Dimension(maxsize.width,minsize.height));
         box.add(Box.createVerticalGlue());
         Box box2 = Box.createHorizontalBox();
         box2.add(Box.createHorizontalStrut(10));
         box2.add(box);
         localchooser.setAccessory(box2);
      }
      // Reset filters
      FileFilter previousFilter = localchooser.getFileFilter();
      localchooser.resetChoosableFileFilters();
      if( animated ){
         // gif only
         localchooser.addChoosableFileFilter(filters[1]);
      }else{
         // all types
         boolean found = false;
         for(FileNameExtensionFilter filter : filters) {
            localchooser.addChoosableFileFilter(filter);
            found |= filter == previousFilter;
         }
         localchooser.setFileFilter(found? previousFilter: filters[2]);
      }
      localchooser.setAcceptAllFileFilterUsed(false);
   }
   
   private void setupPreview(Image image){
      int h = image.getHeight(null);
      int w = image.getWidth(null);
      ImageIcon tmpIcon = new ImageIcon( image.getScaledInstance(h>w ?-1:90, h>w ?90:-1, Image.SCALE_DEFAULT));
      imageInfo.setIcon(tmpIcon);
      imageInfo.setText(w+"x"+h);

      int ix = resolutionList.getSelectedIndex();
      resolutionList.removeAllItems();
      int r = 50;
      while( r<h && r<w ){
         resolutionList.addItem(new Resolution(r,r));
         r+=r;
      }
      resolutionList.addItem(new Resolution(w,h));
      if( ix<0 || ix>=resolutionList.getItemCount())
         ix=resolutionList.getItemCount()-1;
      resolutionList.setSelectedIndex(ix);
   }
   
   private void saveFile(){
      setupFileChooser(false);
      Image myImage = dispPanel.getImage();
      setupPreview(myImage);
            
      if( !selectOutputFile()) return;
      
      String ext = GetChosenFileExtension();
      try {
         if( ext.compareTo("svg")==0) {
            // retrieve svg image
            String svg = dispPanel.getSvgImage();
            FileWriter myWriter = new FileWriter(outputfile);
            myWriter.write(svg);
            myWriter.close();
         }else {
            // retrieve raster image
            myImage = getScaledImage(myImage);
            BufferedImage bi = toBufferedImage(myImage, BufferedImage.TYPE_INT_ARGB); 
            ImageIO.write(bi, ext, outputfile);
         }
     } catch (IOException e) {
        abortSaving(e);
     }
   }
   
   private Image getScaledImage(Image image){
      Resolution res = (Resolution)resolutionList.getSelectedItem();
      if( res==null ) return image;
      if( res.getHeight() == image.getHeight(null) && res.getWidth()==image.getWidth(null) )
         return image;
      return image.getScaledInstance(res.getWidth(), res.getHeight(), Image.SCALE_SMOOTH);
   }
   
   // returns true if successful
   private boolean selectOutputFile(){
      while(true){
         int returnVal = localchooser.showSaveDialog(this);
         if( returnVal != JFileChooser.APPROVE_OPTION){
            return false;
         }
         outputfile = GetChosenFile();

         if( !outputfile.exists()) return true;
         
         returnVal = JOptionPane.showConfirmDialog(this, "That file already exists.\nDo you want to overwrite it?");
         if( returnVal == JOptionPane.YES_OPTION)
            return true;
         else if( returnVal == JOptionPane.CANCEL_OPTION)
            return false;
      }
   }

   private String GetChosenFileExtension(){
      FileNameExtensionFilter filter = (FileNameExtensionFilter)localchooser.getFileFilter();
      String[] extensions = filter.getExtensions();
      return extensions[0]; 
   }
   
   private File GetChosenFile(){
      File file = localchooser.getSelectedFile();
      FileNameExtensionFilter filter = (FileNameExtensionFilter)localchooser.getFileFilter();
      String[] extensions = filter.getExtensions();
      
      // check if file already has a valid extension
      String filename = file.getName().toLowerCase();
      boolean ok = false;
      for(String ex : extensions){
         if( filename.endsWith("."+ex.toLowerCase())){
            ok = true;
            break;
         }
      }
      // add extension if necessary
      if( !ok )
         file = new File(file.toString() + "." + extensions[0]);
      return file;
   }
   
   private static BufferedImage toBufferedImage(Image img, int type)
   {
       if (img instanceof BufferedImage)
       {
           return (BufferedImage) img;
       }
       BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), type);
       Graphics2D bGr = bimage.createGraphics();
       bGr.drawImage(img, 0, 0, null);
       bGr.dispose();
       return bimage;
   }
   

   public void update() {
      if(contPanel.getInfo()){
         if( split.getBottomComponent()==null ){
            split.setBottomComponent(infoPanel);
            split.setDividerLocation(split.getHeight()-infoHeight);
            split.setEnabled(true);
         }
      }else{
         if( split.getBottomComponent()!=null ){
            infoHeight = split.getHeight()-split.getDividerLocation();
            split.setBottomComponent(null);
            split.setEnabled(false);
         }
      }
      dispPanel.setRepeat(contPanel.getRepeat());
      dispPanel.setShowPara(contPanel.getShowPara());
      dispPanel.setShowFill(contPanel.getShowFill());
      if(tt!=null){
         tt.recalc( contPanel.getParam(), contPanel.getRotation(), contPanel.getZoom() );
         dispPanel.setTiles(tt.getTiles(), tt.getOffsets(), tt.getTileLabels());
         infoPanel.setTile(tt.getTile(), tt.getInfo(), tt.getTileLabels(), contPanel.getShowPara() ? tt.getOffsets() : null);
         revalidate();
      }else{
         dispPanel.setTiles(null, null, null);
         infoPanel.setTile(null, null, null, null);
      }
   }
}
