package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_71b
   extends TilingType
{
   public TilingTypeNC5_71b(){
      super( "NC5-71b", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 90, 50};
      paramName = new String[]{ "Angle", "Relative Length" };
      // 90.0 63.43 153.43 206.57 26.57

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 4,0, 0,3,4, 1},
            {2, 1,0, 1,3,4, 1},

            {1, 0,4, 1,1,0, 0},
            {0, 4,0, 3,3,4, 1},
            {2, 1,0, 4,3,4, 1},
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
      offsets[0] = tiles[0].getX(1)-tiles[3].getX(2);
      offsets[1] = tiles[0].getY(1)-tiles[3].getY(2);
      offsets[2] = tiles[2].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[2].getY(2)-tiles[0].getY(0);
   }
}
