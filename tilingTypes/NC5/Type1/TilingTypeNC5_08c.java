package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_08c
   extends TilingType
{
   public TilingTypeNC5_08c(){
      super( "NC5-8c: sawtooth", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 60};
      paramName = new String[]{ "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,1,2, 1},
            {0, 2,3, 0,3,2, 0},
            {1, 1,2, 2,1,2, 1},

            {1, 0,4, 0,0,1, 0},
            {0, 1,2, 4,1,2, 1},
            {0, 2,3, 5,3,2, 1},
            {1, 1,2, 6,1,2, 0},
      };
      info = "a=b=d=e\nD+E=360\n2C=E\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnb = paramValues[0]/100.;   // base length
      double lnh2 = 1 - lnb; // cap height
      double ln1 = Math.sqrt(lnh2*lnh2+lnb*lnb); // teeth side
      double lnb3 = lnb/3; // tooth base
      double lnh1 = Math.sqrt(ln1*ln1-lnb3*lnb3); // teeth height

      double x4 = lnb3;
      double y4 = lnh1;
      double x3 = 2*lnb3;
      double y3 = 0;
      double x2 = 3*lnb3;
      double y2 = lnh1;
      double x1 = 3*lnb3;
      double y1 = -lnh2;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[0].getX(1);
      offsets[1] = tiles[3].getY(0)-tiles[0].getY(1);
      offsets[2] = tiles[1].getX(0)-tiles[5].getX(0);
      offsets[3] = tiles[1].getY(0)-tiles[5].getY(0);
   }
}
