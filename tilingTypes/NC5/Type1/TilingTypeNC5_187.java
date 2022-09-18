package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_187
   extends TilingType
{
   public TilingTypeNC5_187(){
      super( "NC5-187", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 80, 40};
      paramName = new String[]{ "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,4,3, 0},
            {1, 0,4, 1,4,0, 0},
            {0, 3,4, 2,4,3, 0},

            {0, 0,4, 2,1,0, 1},
            {1, 3,4, 4,4,3, 1},
            {1, 0,4, 5,4,0, 1},
            {0, 3,4, 6,4,3, 1},
      };
      info = "c=d\na=b+c\nA+B=180\nB+C=360\n(A+D+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lna = 1.0;
      double lnc = lna * getParam(paramValues,1)/100;
      double lnb = lna - lnc;
     
      double b = getParam(paramValues,0);
      double c = Math.cos(b * DEG2RAD);
      double s = Math.sin(b * DEG2RAD);

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, lnb, 0);
      baseTile.setPoint(2, lnb +lnc*c, lnc*s);
      baseTile.setPoint(3, lnb+lnc +lnc*c, lnc*s);
      baseTile.setPoint(4, lna*c, lna*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[4].getX(2);
      offsets[1] = tiles[0].getY(4)-tiles[4].getY(2);
      offsets[2] = tiles[3].getX(4)-tiles[7].getX(2);
      offsets[3] = tiles[3].getY(4)-tiles[7].getY(2);
   }
}
