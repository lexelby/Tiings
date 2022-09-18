package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_19
   extends TilingType
{
   public TilingTypeN3_19(){
      super( "N3-19", 3, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{ 90};
      paramDef = new int[]{ 40};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,0,1, 0},
            {2, 0,1, 1,1,0, 0},
            {0, 2,0, 0,0,2, 0},
            {1, 2,1, 3,0,1, 0},
            {2, 0,1, 4,1,0, 0},

            {0, 1,2, 2,1,2, 1},
            {1, 2,1, 6,0,1, 1},
            {2, 0,1, 7,1,0, 1},
            {0, 2,0, 6,0,2, 1},
            {1, 2,1, 9,0,1, 1},
            {2, 0,1,10,1,0, 1},
      };
      info = "A+3C=360\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double a = paramValues[0];
      double b = (180-2*a)/3;
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
      offsets[0] = tiles[1].getX(1)-tiles[3].getX(1);
      offsets[1] = tiles[1].getY(1)-tiles[3].getY(1);
      offsets[2] = tiles[0].getX(2)-tiles[8].getX(2);
      offsets[3] = tiles[0].getY(2)-tiles[8].getY(2);
   }
}
