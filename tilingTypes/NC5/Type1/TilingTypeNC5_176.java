package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_176
   extends TilingType
{
   public TilingTypeNC5_176(){
      super( "NC5-176", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 70, 50};
      paramName = new String[]{ "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,3, 0,3,4, 0},
            {1, 1,2, 1,2,1, 0},
            {0, 4,3, 2,3,4, 0},

            {0, 4,0, 0,2,3, 1},
            {1, 4,3, 4,3,4, 1},
            {1, 1,2, 5,2,1, 1},
            {0, 4,3, 6,3,4, 1},
      };
      info = "a=b\nc+d=a\nA=C\nB+C=360\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnab = 0.8;
      double lnc = lnab * getParam(paramValues,1)/200;
      double lnd = lnab - lnc;
      
      double a = getParam(paramValues,0);
      double c = Math.cos(a * DEG2RAD);
      double s = Math.sin(a * DEG2RAD);
      
      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lnab, 0);
      baseTile.setPoint(2,  lnab - lnc*c, -lnc*s);
      baseTile.setPoint(3,  lnab + lnd - lnc*c, -lnc*s);
      baseTile.setPoint(4,  lnab*c, lnab*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(0)-tiles[0].getX(3);
      offsets[1] = tiles[7].getY(0)-tiles[0].getY(3);
      offsets[2] = tiles[4].getX(2)-tiles[0].getX(4);
      offsets[3] = tiles[4].getY(2)-tiles[0].getY(4);
   }
}
