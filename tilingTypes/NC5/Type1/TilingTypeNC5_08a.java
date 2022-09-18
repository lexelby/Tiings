package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_08a
   extends TilingType
{
   public TilingTypeNC5_08a(){
      super( "NC5-8a: sawtooth", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,-50};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 50, 50};
      paramName = new String[]{ "Aspect", "Teeth height" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,4,3, 0},
            {0, 0,4, 1,0,4, 1},
            {1, 3,4, 2,4,3, 1},
            {1, 1,0, 1,0,1, 0},
            {0, 3,4, 4,4,3, 0},
            {0, 0,4, 4,0,4, 1},
            {1, 3,4, 6,4,3, 1},
      };
      info = "b=c=d\nB+C=360\n2A=C\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnb = 2. * paramValues[0]/100;   // base length
      double lnh = 2 - lnb; // height
      double lnh1 = lnh * (paramValues[1]/100.); // teeth height
      double lnb3 = lnb/3; // tooth base

      double x1 = lnb3;
      double y1 = lnh1;
      double x2 = 2*lnb3;
      double y2 = 0;
      double x3 = 3*lnb3;
      double y3 = lnh1;
      double x4 = 0;
      double y4 = lnh;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[7].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(0)-tiles[0].getY(0);
   }
}
