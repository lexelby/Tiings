package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_32
   extends TilingType
{
   public TilingTypeN3_32(){
      super( "N3-32", 3, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{180};
      paramDef = new int[]{100};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,2, 0,1,2, 0},
            {2, 2,1, 1,1,2, 0},
            {2, 1,0, 2,0,1, 0},
            {1, 1,2, 3,2,1, 0},
            {0, 1,2, 4,0,2, 0},

            {0, 0,1, 1,0,1, 1},
            {1, 0,2, 6,1,2, 1},
            {2, 2,1, 7,1,2, 1},
            {2, 1,0, 8,0,1, 1},
            {1, 1,2, 9,2,1, 1},
            {0, 1,2,10,0,2, 1},
      };
      info = "2a=c\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double h = .5;
      double c = h * Math.cos(paramValues[0]*DEG2RAD);
      double s = h * Math.sin(paramValues[0]*DEG2RAD);
      double w = c + Math.sqrt(4*h*h-s*s);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,  c,  s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[5].getX(0)-tiles[11].getX(1);
      offsets[3] = tiles[5].getY(0)-tiles[11].getY(1);
   }
}
