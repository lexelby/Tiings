package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_08g
   extends TilingType
{
   public TilingTypeNC5_08g(){
      super( "NC5-8g: sawtooth", 6, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,5, 0,0,5, 1},
            {1, 1,0, 1,0,1, 1},
            {0, 0,5, 2,0,5, 0},

            {0, 4,5, 0,3,4, 1},
            {1, 0,5, 4,0,5, 0},
            {1, 1,0, 5,0,1, 0},
            {0, 0,5, 6,0,5, 1},
      };
      info = "b=c=d\ne=3b\nB+C=360\n2A=C\n(A+D+E=180)";
      labels = new int[]{0,1,2,3,-1,4};
   }

   public void recalcBase(double[] paramValues) {
      double lnb = .6*paramValues[0]/100.;   // base length
      double lnh = (.6 - lnb)*3/4; // teeth height

      double x1 = lnb;
      double y1 = lnh;
      double x2 = 2*lnb;
      double y2 = 0;
      double x3 = 3*lnb;
      double y3 = lnh;
      double x4 = 1.5*lnb;
      double y4 = 2.5*lnh;
      double x5 = 0;
      double y5 = 4*lnh;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(5);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(5);
      offsets[2] = tiles[7].getX(3)-tiles[3].getX(4);
      offsets[3] = tiles[7].getY(3)-tiles[3].getY(4);
   }
}
