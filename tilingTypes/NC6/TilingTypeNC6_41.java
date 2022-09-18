package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_41
   extends TilingType
{
   public TilingTypeNC6_41(){
      super( "NC6-41", 6, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,360};
      paramDef = new int[]{ 40,110};
      paramName = new String[]{"Relative Length", "Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 5,0, 0,0,5, 0},
            {1, 3,4, 1,3,4, 1},
            {1, 5,0, 2,0,5, 1},
      };
      info = "b=c=d=f\nB+C=360\nD=E\nC+D+E=360\n(A+F=C)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 1.4;
      double ln2 = lntotal * getParam(paramValues, 0)/100;
      double ln1 = (lntotal - ln2)/2;
      
      double a = getParam(paramValues, 1);
      double x = 90-a/2;
      double c = ln1 * Math.cos(x*DEG2RAD);
      double s = ln1 * Math.sin(x*DEG2RAD);
      
      if( a>180 ) ln2 -= s*2;
      
      baseTile.setPoint(0,     0,  0);
      baseTile.setPoint(1,     c,  s);
      baseTile.setPoint(2,   2*c,  0);
      baseTile.setPoint(3,   3*c,  s);
      baseTile.setPoint(4,   3*c,  s+ln2);
      baseTile.setPoint(5,   2*c,2*s+ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(5)-tiles[0].getX(1);
      offsets[1] = tiles[0].getY(5)-tiles[0].getY(1);
      offsets[2] = tiles[0].getX(3)-tiles[3].getX(3);
      offsets[3] = tiles[0].getY(3)-tiles[3].getY(3);
   }
}