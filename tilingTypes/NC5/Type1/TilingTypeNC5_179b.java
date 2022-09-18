package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_179b
   extends TilingType
{
   public TilingTypeNC5_179b(){
      super( "NC5-179b", 5, SymmetryType.pg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 70, 50};
      paramName = new String[]{ "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,0,4, 0},
            {0, 1,3, 1,2,4, 1},
            {1, 4,0, 2,0,4, 1},
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
      offsets[0] = tiles[2].getX(4)-tiles[1].getX(1);
      offsets[1] = tiles[2].getY(4)-tiles[1].getY(1);
      offsets[2] = tiles[0].getX(1)-tiles[3].getX(2);
      offsets[3] = tiles[0].getY(1)-tiles[3].getY(2);
   }
}
