package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_18
   extends TilingType
{
   public TilingTypeN3_18(){
      super( "N3-18", 3, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{180};
      paramDef = new int[]{ 80};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 1,2, 0,1,0, 0},
            {2, 1,0, 1,0,1, 0},

            {2, 2,1, 0,2,1, 1},
            {0, 1,0, 3,0,1, 1},
            {1, 1,0, 4,1,2, 1},

            {1, 2,0, 0,0,2, 0},
            {0, 1,2, 6,1,0, 0},
            {2, 1,0, 7,0,1, 0},

            {2, 2,1, 6,2,1, 1},
            {0, 1,0, 9,0,1, 1},
            {1, 1,0,10,1,2, 1},
      };
      info = "B=2C\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double a = paramValues[0];
      double b = (360-2*a)/3;
      double wa = 1/Math.tan(a*DEG2RAD);
      double wb = 1/Math.tan(b*DEG2RAD);
      double w = wa+wb;
      double h = 1;
      // scale
      double f = Math.sqrt( h*w*3 );
      h /= f;
      wa /= f;
      wb /= f;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,wa+wb,  0);
      baseTile.setPoint(2, wa,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[1].getX(2);
      offsets[1] = tiles[0].getY(2)-tiles[1].getY(2);
      offsets[2] = tiles[11].getX(2)-tiles[5].getX(0);
      offsets[3] = tiles[11].getY(2)-tiles[5].getY(0);
   }
}
