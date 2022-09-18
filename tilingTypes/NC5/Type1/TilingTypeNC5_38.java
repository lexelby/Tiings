package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_38
   extends TilingType
{
   public TilingTypeNC5_38(){
      super( "NC5-38", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Indentation" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,3,4, 1},
            {1, 2,3, 1,3,2, 1},
            {0, 3,4, 2,3,4, 0},
            
            {0, 0,4, 3,1,0, 1},
            {1, 3,4, 4,3,4, 0},
            {1, 2,3, 5,3,2, 0},
            {0, 3,4, 6,3,4, 1},
      };
      info = "2a=b\nc=d\nB+C=360\nE=90\nB=2D\n(A+D=90)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .75;
      double lnc = ln*getParam( paramValues,0)/50;
      double h = ln * ln/(ln+lnc);
      double d = Math.asin(h/2/ln)/DEG2RAD;
      double f = d+d;
      double b = 90-d;

      double x2 = 2*ln - lnc*Math.cos( f * DEG2RAD);
      double y2 =        lnc*Math.sin( f * DEG2RAD);
      double x3 = x2 + lnc;
      double y3 = y2;
      double x4 = ln*Math.cos( b * DEG2RAD);
      double y4 = ln*Math.sin( b * DEG2RAD);

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1,2*ln,  0);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(1)-tiles[2].getX(0);
      offsets[1] = tiles[3].getY(1)-tiles[2].getY(0);
      offsets[2] = tiles[7].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[7].getY(1)-tiles[0].getY(0);
   }
}
