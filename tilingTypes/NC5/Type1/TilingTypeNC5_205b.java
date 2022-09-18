package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_205b
   extends TilingType
{
   public TilingTypeNC5_205b(){
      super( "NC5-205b", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 50, 50};
      paramName = new String[]{ "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 0,1, 0,0,1, 1},
            {0, 2,1, 1,1,2, 1},
            {1, 0,1, 2,0,1, 0},
      };
      info = "c=d\nA=B\nD+E=180\nC+D=360\n(A+B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lna = 1.0;
      double lnd = lna * getParam(paramValues,1)/200;

      double a = getParam(paramValues,0);
      double c = Math.cos(a * DEG2RAD);
      double s = Math.sin(a * DEG2RAD);
      double lne = lna-2*lnd;

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  (lna+lne)*c, 0);
      baseTile.setPoint(2,  (lna+lne-lnd)*c, lnd*s);
      baseTile.setPoint(3,  (lna+lne)*c, 2*lnd*s);
      baseTile.setPoint(4,  lna*c, lna*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(0)-tiles[1].getX(4);
      offsets[1] = tiles[2].getY(0)-tiles[1].getY(4);
      offsets[2] = tiles[0].getX(3)-tiles[3].getX(4);
      offsets[3] = tiles[0].getY(3)-tiles[3].getY(4);
   }
}
