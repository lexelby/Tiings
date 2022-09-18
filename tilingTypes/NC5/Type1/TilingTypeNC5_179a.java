package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_179a
   extends TilingType
{
   public TilingTypeNC5_179a(){
      super( "NC5-179a", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 70, 50};
      paramName = new String[]{ "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,0,4, 0},
            {1, 1,0, 1,0,1, 0},
            {0, 4,0, 2,0,4, 0},

            {0, 0,1, 0,3,4, 1},
            {1, 4,0, 4,0,4, 1},
            {1, 1,0, 5,0,1, 1},
            {0, 4,0, 6,0,4, 1},
      };
      info = "c=d=e\nB+C=180\nB+C=360\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.5;
      double b = getParam(paramValues,0);

      double lnbcd = lnt * getParam(paramValues,1)/300;
      double lna = lnt - 2*lnbcd; 
      
      double dx = lnbcd * Math.cos(b * DEG2RAD);
      double dy = lnbcd * Math.sin(b * DEG2RAD);
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, lna, 0);
      baseTile.setPoint(2, lna-dx, dy);
      baseTile.setPoint(3, lna-lnbcd-dx, dy);
      baseTile.setPoint(4, lna-lnbcd-dx*2, dy*2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(1)-tiles[2].getX(2);
      offsets[1] = tiles[7].getY(1)-tiles[2].getY(2);
      offsets[2] = tiles[3].getX(1)-tiles[6].getX(2);
      offsets[3] = tiles[3].getY(1)-tiles[6].getY(2);
   }
}
