package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_34a
   extends TilingType
{
   public TilingTypeN3_34a(){
      super( "N3-34a", 3, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 90, 50};
      paramName = new String[]{ "Angle", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,0, 0,1,2, 1},
            {2, 1,0, 1,0,1, 1},
            
            {2, 2,1, 2,1,2, 1},
            {1, 0,1, 3,1,0, 1},
            {0, 1,2, 4,2,0, 0},
     };
      info = "2a=c\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double h = .5;
      double c = h * Math.cos(paramValues[0]*DEG2RAD);
      double s = h * Math.sin(paramValues[0]*DEG2RAD);
      double w = c + Math.sqrt(4*h*h-s*s);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,  c,  s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[5].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[5].getY(1)-tiles[0].getY(0);
      double os = paramValues[1]/50.-1;
      if( os>0 ){
         offsets[0]+=offsets[2]*os;
         offsets[1]+=offsets[3]*os;
      }else {
         offsets[2]+=offsets[0]*os;
         offsets[3]+=offsets[1]*os;
      }
      
   }
}
