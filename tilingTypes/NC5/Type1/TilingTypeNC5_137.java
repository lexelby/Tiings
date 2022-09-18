package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_137
   extends TilingType
{
   public TilingTypeNC5_137(){
      super( "NC5-137", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 30};
      paramName = new String[]{ "Aspect"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,3,4, 0},
            {1, 4,1, 1,1,4, 0},
            {0, 3,4, 2,0,4, 0},

            {0, 1,2, 0,4,0, 1},
            {1, 0,4, 4,3,4, 1},
            {1, 4,1, 5,1,4, 1},
            {0, 3,4, 6,0,4, 1},
      };
      info = "a=c=e\nA=90\nC=90\nD=270\n(B+E=90)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 2.0;
      double lnd = lntotal * getParam(paramValues,0)/100;
      double h = (lntotal - lnd)/2;
      double diag = Math.sqrt(lnd*lnd+4*h*h);
      double w = Math.sqrt(diag*diag-h*h);
      double ang = Math.atan2(h,w) + Math.acos(2*h/diag);
      double c = h * Math.cos(ang);
      double s = h * Math.sin(ang);

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  w, 0);
      baseTile.setPoint(2,  w-c, s);
      baseTile.setPoint(3,  c, h-s);
      baseTile.setPoint(4,  0, h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[4].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[4].getY(0);
      offsets[2] = tiles[3].getX(2)-tiles[7].getX(0);
      offsets[3] = tiles[3].getY(2)-tiles[7].getY(0);
   }
}
