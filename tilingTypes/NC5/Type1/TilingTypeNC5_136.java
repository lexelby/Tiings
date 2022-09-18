package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_136
   extends TilingType
{
   public TilingTypeNC5_136(){
      super( "NC5-136", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Aspect"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 4,0, 1,0,4, 1},
            {0, 0,1, 2,0,1, 0},

            {0, 1,2, 0,3,4, 1},
            {1, 0,1, 4,0,1, 0},
            {1, 4,0, 5,0,4, 0},
            {0, 0,1, 6,0,1, 1},
      };
      info = "c=d\ne=2c\nC=90\nD+E=360\n2B+D=360\n(A+B=90)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1.5;
      double h = lntotal * getParam(paramValues,0)/200;
      double w = lntotal - h;
      double diag = Math.sqrt(w*w+h*h);
      double c = w/diag;
      double s = h/diag;
      double ln = h/(c+s);
      c *= ln;
      s *= ln;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, w+3*c+s, 0);
      baseTile.setPoint(2, w+3*c, h-s);
      baseTile.setPoint(3, w+2*c, h-2*s);
      baseTile.setPoint(4, w,   h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[1].getX(3);
      offsets[1] = tiles[0].getY(4)-tiles[1].getY(3);
      offsets[2] = tiles[7].getX(1)-tiles[3].getX(3);
      offsets[3] = tiles[7].getY(1)-tiles[3].getY(3);
   }
}
