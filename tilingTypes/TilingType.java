package tilingTypes;

public abstract class TilingType
   implements ITilingType
{
   protected static final double DEG2RAD = Math.PI/180;

   // Tiling type base
   protected String name;
   protected SymmetryType symType;
   protected int[] paramMin;
   protected int[] paramMax;
   protected int[] paramDef;
   protected String[] paramName;
   protected Tile baseTile;
   protected ITile[] tiles;
   protected int[][] description;
   protected double[] offsets = new double[4];
   protected int[] labels;
   protected String info;

   protected TilingType(String nm, int sz, SymmetryType st){
      name = nm;
      baseTile = new Tile(sz);
      labels = new int[sz];
      for( int i=0; i<sz; i++) labels[i] = i;
      symType = st;
   }

   public String toString(){ return name; }
   public SymmetryType symmetryType(){ return symType; }
   public int getNumParam(){
      if(paramMax.length != paramMin.length || paramMax.length != paramDef.length
            || paramMax.length != paramName.length ){
         throw new RuntimeException(name);
      }
      return paramMax.length;
   }
   public int getParamMin(int p){ return paramMin[p]; }
   public int getParamMax(int p){ return paramMax[p]; }
   public int getParamDefault(int p){ return paramDef[p]; }
   public String getParamName(int p){ return paramName[p]; }
   public ITile[] getTiles(){ return tiles; }
   public double[] getOffsets(){ return offsets; }
   public String getInfo(){return info;}
   public ITile getTile(){ return baseTile; }
   public int[] getTileLabels(){ return labels; }

   protected double getParam(double[] paramValues, int ix){
      double v = paramValues[ix];
      if( v==paramMin[ix] ) return v + 0.1;
      if( v==paramMax[ix] ) return v - 0.1;
      return v;
   }

   
   /*
    * Given array of parameter values, calculate list of coordinates consisting of:
    *   vector1, vector2:  offsets to the next set of tiles along two independent axes
    * followed by any number of:
    *   (point1, point2):  pair of points between which to draw a line.
    */
   public abstract void recalcBase( final double[] paramValues );
   public abstract void recalcOffsets( final double[] paramValues );

   private boolean initialised = false;
   public void initialise(){ 
      if( !initialised ){
         initialiseImpl();
         initialised = true;
      }
   }
   protected void initialiseImpl(){}
   
   public void recalc( final double[] paramValues, double rotation, double zoom ){
      recalcBase(paramValues);
      recalcFundRegion();
      scaleAndRotate(zoom+1, rotation);
      recalcOffsets(paramValues);
      latticeReduce();
   }
   
   private void latticeReduce(){
      for( int i=0; i<10 && (latticeReduce2(0,2) || latticeReduce2(2,0)); i++)
      {
      }
   }
   private boolean latticeReduce2(int i1, int i2){
      double ln2 = Math.sqrt(offsets[i2]*offsets[i2] +  offsets[i2+1]*offsets[i2+1]);
      double prj = (offsets[i1]*offsets[i2]+offsets[i1+1]*offsets[i2+1])/ln2;
      long k = Math.round(prj/ln2);
      if( k==0 || Math.abs(prj/ln2)<0.501 ) return false;
      offsets[i1]   -= k*offsets[i2];
      offsets[i1+1] -= k*offsets[i2+1];
      return true;
   }

   private void recalcFundRegion(){
      if( tiles==null ){
         tiles = new ITile[description.length];
         for( int i=0; i<tiles.length; i++ ){
            tiles[i] = new Tile(baseTile.size());
         }
      }
      // desc has: colour, refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      for( int i=0; i<description.length; i++ ){
         int[] desc = description[i];
         Tile tile = (Tile)tiles[i];
         tile.setColour( desc[0] );
         tile.setPosition(baseTile);
         if(desc[3]!=i){
            ITile tile2 = tiles[desc[3]];
            double dx = tile2.getX(desc[4]) - tile.getX(desc[1]);
            double dy = tile2.getY(desc[4]) - tile.getY(desc[1]);
            tile.translate(dx, dy);
            if( desc[6]!=0 ){
               double angleRad = getAngle( tile.getX(desc[1]), tile.getY(desc[1]), tile.getX(desc[2]), tile.getY(desc[2]) );
               tile.rotate( tile.getX(desc[1]), tile.getY(desc[1]), -angleRad );
               tile.mirror( tile.getY(desc[1]) );
               angleRad = getAngle( tile.getX(desc[1]), tile.getY(desc[1]), tile2.getX(desc[5]), tile2.getY(desc[5]) );
               tile.rotate( tile.getX(desc[1]), tile.getY(desc[1]), angleRad );
            }else{
               double angleRad = getAngle( tile.getX(desc[1]), tile.getY(desc[1]), tile.getX(desc[2]), tile.getY(desc[2]), tile2.getX(desc[5]), tile2.getY(desc[5]) );
               tile.rotate( tile.getX(desc[1]), tile.getY(desc[1]), angleRad );
            }
         }
      }
   }

   private void scaleAndRotate(double scaleFactor, double angle){
      double angleRad = angle*DEG2RAD;
      for( int i=0; i<tiles.length; i++ ){
         Tile tile = (Tile)tiles[i];
         tile.scale(0, 0, scaleFactor);
         tile.rotate(0,0,angleRad);
      }
   }

   private static double getAngle( double x0, double y0, double x1, double y1, double x2, double y2 ){
      return Math.atan2( y2-y0, x2-x0 ) - Math.atan2( y1-y0, x1-x0 );
   }
   private static double getAngle( double x0, double y0, double x1, double y1){
      return Math.atan2( y1-y0, x1-x0 );
   }

   public static double calcAngle( double a, double b, double c){
      if( c>=a+b ) return 180;
      if( b>=a+c || a>=b+c ) return 0;
      return Math.acos((a*a+b*b-c*c)/(2*a*b))/DEG2RAD;
   }
   public static double calcSide( double a, double b, double angle){
      return Math.sqrt(a*a+b*b-2*a*b*Math.cos(angle*DEG2RAD));
   }
}
