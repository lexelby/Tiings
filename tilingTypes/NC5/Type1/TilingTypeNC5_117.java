package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_117
   extends TilingType
{
   public TilingTypeNC5_117(){
      super( "NC5-117", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 30};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,3,4, 1},
            {1, 4,0, 1,0,4, 1},
            {0, 3,4, 2,0,1, 0},

            {0, 0,1, 0,4,0, 1},
            {1, 0,1, 4,3,4, 0},
            {1, 4,0, 5,0,4, 0},
            {0, 3,4, 6,0,1, 1},
      };
      info = "c+d=e\na=b=c+e\nB+C=180\nC+D=360\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnde = 1.0;
      double lnb = lnde * getParam(paramValues, 0)/100;
      double lna = (lnde-lnb)/2;

      double c = lna/lnde;
      double s = Math.sqrt(1-c*c);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  lnde,  0);
      baseTile.setPoint(2,  lnde-c*lna,  s*lna);
      baseTile.setPoint(3,  (2-c)*lna, s*lna);
      baseTile.setPoint(4,  c*lnde, s*lnde);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[0].getX(1);
      offsets[1] = tiles[0].getY(4)-tiles[0].getY(1);
      offsets[2] = tiles[3].getX(1)-tiles[7].getX(0);
      offsets[3] = tiles[3].getY(1)-tiles[7].getY(0);
   }
}
