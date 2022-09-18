package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_175c
   extends TilingType
{
   public TilingTypeNC5_175c(){
      super( "NC5-175c", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 70, 50};
      paramName = new String[]{ "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,1, 0,1,2, 0},
            {1, 3,4, 1,2,3, 1},
            {1, 2,1, 2,1,2, 1},
      };
      info = "a=b\nd=e\nA+E=180\nD+E=360\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.0;
      double lnb = lnt * getParam(paramValues,1)/200;
      double lna = lnt - lnb;
      
      double a = getParam(paramValues,0);
      double c = Math.cos(a * DEG2RAD);
      double s = Math.sin(a * DEG2RAD);
      
      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lna, 0);
      baseTile.setPoint(2,  lnt*c + lnb, lnt*s);
      baseTile.setPoint(3,  lna*c + lnb, lna*s);
      baseTile.setPoint(4,  lna*c, lna*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(3)-tiles[3].getX(4);
      offsets[3] = tiles[0].getY(3)-tiles[3].getY(4);
   }
}
