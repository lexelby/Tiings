package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_71c
   extends TilingType
{
   public TilingTypeNC5_71c(){
      super( "NC5-71c", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 90, 50};
      paramName = new String[]{ "Angle", "Relative Length" };
      // 90.0 63.43 153.43 206.57 26.57

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,1,0, 0},
            {2, 3,4, 1,1,0, 0},
            {0, 2,1, 2,1,2, 0},
            {1, 3,4, 3,1,0, 0},
            {2, 3,4, 4,1,0, 0},

            {0, 0,4, 2,1,0, 1},
            {1, 3,4, 6,1,0, 1},
            {2, 3,4, 7,1,0, 1},
            {0, 2,1, 8,1,2, 1},
            {1, 3,4, 9,1,0, 1},
            {2, 3,4,10,1,0, 1},
      };
      info = "a=e\nb=a+d\nA+E=180\nA=D\n(C+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = .6;
      double s = Math.sin(paramValues[0] * DEG2RAD);
      double c = Math.cos(paramValues[0] * DEG2RAD);
      double f = paramValues[1]/100.;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln1*(1+f), 0);
      baseTile.setPoint(2,ln1*(1+c*(1-f)),ln1*s*(1-f));
      baseTile.setPoint(3,ln1*(1+c),  s*ln1);
      baseTile.setPoint(4,  c*ln1,  s*ln1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(0)-tiles[2].getX(4);
      offsets[1] = tiles[5].getY(0)-tiles[2].getY(4);
      offsets[2] = tiles[9].getX(0)-tiles[0].getX(2);
      offsets[3] = tiles[9].getY(0)-tiles[0].getY(2);
   }
}
