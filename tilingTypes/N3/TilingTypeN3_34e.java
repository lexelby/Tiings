package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_34e
   extends TilingType
{
   public TilingTypeN3_34e(){
      super( "N3-34e", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{180};
      paramDef = new int[]{ 90};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,0, 0,1,3, 1},
            {2, 1,0, 1,0,1, 1},
            {2, 3,1, 2,1,3, 1},
            {1, 0,1, 3,1,0, 1},
            {0, 1,3, 4,3,0, 0},

            {0, 0,3, 4,2,3, 1},
            {1, 3,0, 6,1,3, 0},
            {2, 1,0, 7,0,1, 0},
            {2, 3,1, 8,1,3, 0},
            {1, 0,1, 9,1,0, 0},
            {0, 1,3,10,3,0, 1},
      };
      info = "2a=c\n(A+B+C=180)";
      labels = new int[]{0,1,-1,2};
   }

   public void recalcBase(double[] paramValues) {
      double h = .5;
      double c = h * Math.cos(paramValues[0]*DEG2RAD);
      double s = h * Math.sin(paramValues[0]*DEG2RAD);
      double w = c + Math.sqrt(4*h*h-s*s);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,(3*w+c)/4, s/4);
      baseTile.setPoint(3,  c,  s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(2)-tiles[6].getX(1);
      offsets[1] = tiles[1].getY(2)-tiles[6].getY(1);
      offsets[2] = tiles[5].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[5].getY(1)-tiles[0].getY(0);
   }
}
