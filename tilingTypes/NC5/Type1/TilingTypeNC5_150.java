package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_150
   extends TilingType
{
   public TilingTypeNC5_150(){
      super( "NC5-150", 5, SymmetryType.pgg );

      paramMin = new int[]{ 72};
      paramMax = new int[]{180};
      paramDef = new int[]{ 100};
      paramName = new String[]{ "Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,0,4, 1},
            {1, 2,1, 1,1,2, 1},
            {0, 0,4, 2,0,4, 0},
            
            {0, 3,4, 0,1,2, 1},
            {1, 0,4, 4,0,4, 0},
            {1, 2,1, 5,1,2, 0},
            {0, 0,4, 6,0,4, 1},
      };
      info = "c=e\nd=2b\nA=90\nB+2D=180\nB+C=360\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnac = 1.0;
      double b = getParam(paramValues,0);
      double d = (180-b)/2;
      
      double c1 = Math.cos(d*DEG2RAD);
      double s1 = Math.sin(d*DEG2RAD);
      double c2 = Math.cos(d*2*DEG2RAD);
      double s2 = Math.sin(d*2*DEG2RAD);
      
      double lnd = lnac * (c1-c2)/3;
      double lnb = lnd*2;
      
      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lnd, 0);
      baseTile.setPoint(2,  lnd+c2*lnac, s2*lnac);
      baseTile.setPoint(3,  lnd+lnb+c2*lnac, s2*lnac);
      baseTile.setPoint(4,  lnd+lnb+c2*lnac-c1*lnac, s2*lnac+s1*lnac);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(2)-tiles[7].getX(4);
      offsets[1] = tiles[3].getY(2)-tiles[7].getY(4);
      offsets[2] = tiles[0].getX(4)-tiles[4].getX(2);
      offsets[3] = tiles[0].getY(4)-tiles[4].getY(2);
   }
}
