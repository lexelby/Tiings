package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_193
   extends TilingType
{
   public TilingTypeNC5_193(){
      super( "NC5-193", 5, SymmetryType.pgg );

      paramMin = new int[]{ 90,  0,  0};
      paramMax = new int[]{180,100,100};
      paramDef = new int[]{140, 50, 50};
      paramName = new String[]{"Angle", "Aspect", "Relative Length 2"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,2, 0,0,1, 0},
            {1, 4,3, 1,3,4, 0},
            {0, 0,1, 2,3,2, 0},

            {0, 3,2, 2,1,0, 1},
            {1, 3,2, 4,0,1, 1},
            {1, 4,3, 5,3,4, 1},
            {0, 0,1, 6,3,2, 1},
      };
      info = "b=d\nB+C=180\nB+D=360\n(A+C+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lnt = 1.6;
      double lnbc = lnt * getParam(paramValues, 1)/100; 
      double lna = lnt - lnbc;
      double lnb = lnbc * getParam(paramValues, 2)/100;
      double lnc = lnbc - lnb;
      
      double b = getParam(paramValues, 0);
      double c = -Math.cos(b * DEG2RAD);
      double s = Math.sin(b * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, lna, 0);
      baseTile.setPoint(2, lna+c*lnb, s*lnb);
      baseTile.setPoint(3, c*lnb, s*lnb);
      baseTile.setPoint(4, c*(lnb-lnc), s*(lnb+lnc));
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[6].getX(1)-tiles[0].getX(3);
      offsets[1] = tiles[6].getY(1)-tiles[0].getY(3);
      offsets[2] = tiles[5].getX(1)-tiles[3].getX(3);
      offsets[3] = tiles[5].getY(1)-tiles[3].getY(3);
   }
}
