package tilings;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import tilingTypes.ITilingType;


@SuppressWarnings("serial")
public final class PanelTilingControl extends JPanel
	implements ChangeListener
{
   public static final int FRAMEDURATION = 50; // in milliseconds
   public static final int FRAMESPERPOINT = 50;

	private List<Pair<JLabel,JSlider>> sliders = new ArrayList<Pair<JLabel,JSlider>>();
	private double[] param;   // actual slider settings
	private double rotation = 0, zoom = 50;   // actual slider settings
	private JLabel tilingName = new JLabel();
	private JCheckBox infoButton = new JCheckBox("Show Info", true);
	private JCheckBox repButton = new JCheckBox("Fill plane", true);
	private JCheckBox unitButton = new JCheckBox("Show Unit parallelogram", false);
	private JCheckBox fillButton = new JCheckBox("Colourfill tiles", true);
	private JButton copyButton = new JButton("Save as...");
	private int isRecording = 0;   // 0= not recording, 1= waiting to start recording, 2=recording  

   private JButton setAnimPointButton = new JButton("Set point");
   private JButton clearAnimPointButton = new JButton("Clear points");
   private JCheckBox animateButton = new JCheckBox("Animate", false);
   private List<double[]> animationPoints = new ArrayList<double[]>();
   private double[] previousAnimationPoint;
   private boolean[] animatedSliders;
   private int nextAnimationIndex;  // index of current goal point
   private int animationCounter;    // counts down from FRAMESPERPOINT to 0
   private Timer animationTimer = new Timer();
   private TimerTask animationTask = null;
	
	private Box sliderPanel = Box.createVerticalBox();
	private ActionListener parent;

	public PanelTilingControl(ActionListener p, boolean isApplet){
      super(new BorderLayout());
		parent = p;
		
		Box box = Box.createVerticalBox();
		box.add(Box.createHorizontalStrut(220));
		
		Box horBox; 
		if( !isApplet ){
		   horBox = Box.createHorizontalBox();
		   horBox.add( Box.createHorizontalGlue());
		   horBox.add( copyButton );
		   box.add(horBox);
	      copyButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               copyButtonPressed();
            }
         });
	      copyButton.setEnabled(false);
		}
      
      horBox = Box.createHorizontalBox();
      horBox.add( tilingName );
      horBox.add( Box.createHorizontalGlue());
      box.add(horBox);
      
      box.add(Box.createVerticalStrut(10));

      horBox = Box.createHorizontalBox();
      horBox.add( infoButton );
      horBox.add( Box.createHorizontalGlue());
      box.add(horBox);
      infoButton.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) { triggerRedraw(); }
      });
      
      horBox = Box.createHorizontalBox();
      horBox.add( repButton );
      horBox.add( Box.createHorizontalGlue());
      box.add(horBox);
      repButton.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) { triggerRedraw(); }
      });
      
      horBox = Box.createHorizontalBox();
      horBox.add( unitButton );
      horBox.add( Box.createHorizontalGlue());
      box.add(horBox);
      unitButton.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) { triggerRedraw(); }
      });
      
      horBox = Box.createHorizontalBox();
      horBox.add( fillButton );
      horBox.add( Box.createHorizontalGlue());
      box.add(horBox);
      fillButton.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) { triggerRedraw(); }
      });

      horBox = Box.createHorizontalBox();
      horBox.add( animateButton );
      horBox.add( Box.createHorizontalGlue());
      box.add(horBox);
      animateButton.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) { animationChanged(); }
      });
      animateButton.setEnabled(false);

      
      horBox = Box.createHorizontalBox();
      horBox.add( setAnimPointButton );
      horBox.add( clearAnimPointButton );
      horBox.add( Box.createHorizontalGlue());
      box.add(horBox);
      setAnimPointButton.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) { setAnimationPoint(); }
      });
      clearAnimPointButton.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) { clearAnimationPoints(); }
      });
      setAnimPointButton.setEnabled(false);
      clearAnimPointButton.setEnabled(false);
      
      add(box, BorderLayout.NORTH);
      add(new JScrollPane(sliderPanel));
      setPreferredSize(new Dimension(220,getPreferredSize().height));
      setTilingType(null);
   }
	
	public void triggerRedraw(){
      parent.actionPerformed(new ActionEvent(this,-1,""));
	}
	public void stateChanged(ChangeEvent ce){
		if( param!=null ){
		   // read new slider settings. This will change all settings to nearest integer
         int i=0;
         for( Pair<JLabel,JSlider> pair : sliders){
            if( i==0 ) rotation = pair.second().getValue();
            else if( i==1 ) zoom = pair.second().getValue();
            else if( i-2<param.length ) param[i-2] = pair.second().getValue();
            else break;
            i++;
         }
         triggerRedraw();
		}
	}
   public void copyButtonPressed() {
      if( isRecording>0 ){
         // abort recording
         finishedSave();
         parent.actionPerformed(new ActionEvent(this,5,""));
      }else if( animateButton.isSelected()){
         // start recording when animation cycle starts 
         copyButton.setText("Waiting...");
         isRecording = 1;
      }else{
         // save snapshot
         parent.actionPerformed(new ActionEvent(this,2,""));
      }
   }
 
   public void animationChanged(){
      if( animateButton.isSelected()){
         // Prepare animation
         animatedSliders = new boolean[param.length+2];
         for( int i=0; i<param.length+2; i++){
            animatedSliders[i] = false;
            for( int j=1; j<animationPoints.size(); j++){
               if( animationPoints.get(j)[i] != animationPoints.get(j-1)[i] ){
                  animatedSliders[i] = true;
                  break;
               }
            }
         }
         // start animation
         nextAnimationIndex=0;    // index of current goal point
         animationCounter=FRAMESPERPOINT;
         previousAnimationPoint = getCurrentPoint();
         animationTask = new TimerTask(){
            @Override
            public void run() { animateFrame(); }
         };
         animationTimer.schedule(animationTask, 0, FRAMEDURATION);
         
         setAnimPointButton.setEnabled(false);
      }else{
         // end animation
         if(animationTask!=null){
            animationTask.cancel();
            animationTask = null;
         }
         setAnimPointButton.setEnabled(true);
         for( int i=0; i<2+param.length; i++){
            JSlider slider = sliders.get(i).second();
            slider.setEnabled(true);
         }
         // abort recording
         if( isRecording>0 )
            copyButtonPressed();
      }
   }
   public void setAnimationPoint(){
      // end animation, if any
      if( animateButton.isSelected() ){
         animateButton.setSelected(false);
         animationChanged();
      }
      // append current state
      animationPoints.add(getCurrentPoint());
      // update controls
      animateButton.setEnabled(animationPoints.size()>1);
      clearAnimPointButton.setEnabled(true);
   }
   private double[] getCurrentPoint(){
      double[] point = new double[param.length+2];
      point[0] = rotation;
      point[1] = zoom;
      for( int i=0; i<param.length; i++)
         point[i+2] = param[i];
      return point;
   }
   public void clearAnimationPoints(){
      // end animation, if any
      if( animateButton.isSelected() ){
         animateButton.setSelected(false);
         animationChanged();
      }
      // erase points
      animationPoints.clear();
      animateButton.setEnabled(false);
      clearAnimPointButton.setEnabled(false);
   }
   public void finishedSave(){
      isRecording = 0;
      copyButton.setText("Save as...");
   }
   public void animateFrame(){
      animationCounter--;
      if( animationCounter<=0){
         animationCounter=FRAMESPERPOINT;
         previousAnimationPoint = animationPoints.get(nextAnimationIndex);
         nextAnimationIndex=(nextAnimationIndex+1)%animationPoints.size();
         if( nextAnimationIndex==1 ){
            if( isRecording==1){
               isRecording = 2;
               // start recording for real
               copyButton.setText("Recording...");
               parent.actionPerformed(new ActionEvent(this,3,""));
            }else if(isRecording==2){
               // finish recording and save
               parent.actionPerformed(new ActionEvent(this,4,""));
               finishedSave();
            }
         }
      }
      // calculate frame
      double[] currentAnimationPoint = new double[previousAnimationPoint.length];
      double[] nextAnimationPoint = animationPoints.get(nextAnimationIndex);
      double f = getAnimationOffset();
      for( int i=0; i<previousAnimationPoint.length; i++){
         currentAnimationPoint[i] = (f*previousAnimationPoint[i] + (1-f)*nextAnimationPoint[i]);
      }
      // update param
      if( animatedSliders[0] ) rotation = currentAnimationPoint[0];
      if( animatedSliders[1] ) zoom = currentAnimationPoint[1];
      for( int i=2; i<currentAnimationPoint.length; i++){
         if( animatedSliders[i] ) param[i-2] = currentAnimationPoint[i];
      }
      
      // set sliders without triggering redraw
      for( int i=0; i<previousAnimationPoint.length; i++){
         JSlider slider = sliders.get(i).second();
         if( animatedSliders[i] ){
            slider.removeChangeListener(this);
            slider.setValue((int)(0.5+currentAnimationPoint[i]));
            slider.addChangeListener(this);
            slider.setEnabled(false);
         }
      }
      triggerRedraw();
   }
   private double getAnimationOffset(){
      double f = animationCounter/(double)FRAMESPERPOINT;
      return (1-Math.cos(f*Math.PI))/2;
   }
   
   public double[] getParam(){ return param; }
   public double getZoom(){ return zoom; }
   public double getRotation(){ return rotation; }
   public boolean getInfo(){ return infoButton.isSelected(); }
   public boolean getRepeat(){ return repButton.isSelected(); }
   public boolean getShowPara(){ return unitButton.isSelected(); }
   public boolean getShowFill(){ return fillButton.isSelected(); }
	public void setTilingType( ITilingType t ){
      // end animation, if any
      if( animateButton.isSelected() ){
         animateButton.setSelected(false);
         animationChanged();
      }

      if( t!=null){
         tilingName.setText("<html>Name: "+t+"<br>Symmetry: "+t.symmetryType()+"</html>");
         int numSlid = t.getNumParam()+2;
         param = new double[numSlid-2];
         while( sliders.size() < numSlid ){
            sliderPanel.add( Box.createVerticalStrut(15) );
            JLabel label = new JLabel();
            sliderPanel.add(label);
            JSlider slider = new JSlider();
            sliderPanel.add(slider);
            sliders.add(new Pair<JLabel,JSlider>(label,slider));
         }
         int i=0;
         for (Pair<JLabel,JSlider> pair : sliders) {
            JLabel label = pair.first();
            JSlider slider = pair.second();
            if( i <numSlid ){
               slider.removeChangeListener(this);
               if( i==0 ){
                  setSlider( slider, 0, 360, (int)(rotation+.5));
                  label.setText("Rotation");
               }else if(i==1){
                  setSlider( slider, 0, 100, (int)(zoom+0.5));
                  label.setText("Zoom");
               }else {
                  setSlider( slider, t.getParamMin(i-2), t.getParamMax(i-2), t.getParamDefault(i-2));
                  param[i-2] = slider.getValue();
                  label.setText(t.getParamName(i-2));
               }
               slider.setVisible(true);
               label.setVisible(true);
               slider.setEnabled(true);
               slider.addChangeListener(this);
            }else{
               slider.setVisible(false);
               label.setVisible(false);
               slider.removeChangeListener(this);
            }
            i++;
         }
         copyButton.setEnabled(true);
         animationPoints.clear();
         setAnimPointButton.setEnabled(true);
         clearAnimPointButton.setEnabled(false);
         animateButton.setEnabled(false);
         revalidate();
      }else{
         param = null;
         tilingName.setText("<html>Name:<br>Symmetry:</html>");
         for (Pair<JLabel,JSlider> pair : sliders) {
            JLabel label = pair.first();
            JSlider slider = pair.second();
            slider.setVisible(false);
            label.setVisible(false);
            copyButton.setEnabled(false);
            animationPoints.clear();
            setAnimPointButton.setEnabled(false);
            clearAnimPointButton.setEnabled(false);
            animateButton.setEnabled(false);
            slider.removeChangeListener(this);
         }
      }
	}
	private void setSlider(JSlider slider, int min, int max, int def){
		slider.setMinimum(min);
		slider.setMaximum(max);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(false);
		int len = max-min;
		int scale = 1;
		while( len>=scale*100 ) scale *=10;
		len /=scale;
		// len is in range [10,100)
		int major,minor;
      if( len<=10 ){
         major = 2*scale;
         minor = 1*scale;
      }else if( len<=25 ){
         major = 5*scale;
         minor = 1*scale;
      }else if( len<=50 ){
         major = 10*scale;
         minor = 5*scale;
      }else{
         major = 20*scale;
         minor = 10*scale;
		}
      int first = min>=0 ? (min+major-1)/major*major : min/major*major;
      slider.setLabelTable( slider.createStandardLabels(major, first) );
      slider.setMajorTickSpacing(major);
      slider.setMinorTickSpacing(minor);
		
		slider.setPaintLabels(true);
		slider.setValue(def);
	}
}