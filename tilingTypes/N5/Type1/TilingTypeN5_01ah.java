package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01ah
   extends TilingType
{
   public TilingTypeN5_01ah(){
      super( "N5-1ah", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,180};
      paramDef = new int[]{ 80,110};
      paramName = new String[]{"Aspect", "Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,1,0, 1},
            {1, 1,0, 1,0,1, 1},
            {0, 1,0, 2,2,1, 0},

            {0, 4,3, 2,3,4, 1},
            {1, 2,1, 4,1,0, 0},
            {1, 1,0, 5,0,1, 0},
            {0, 1,0, 6,2,1, 1},
      };
      info = "b=a+c\na=d\nA+B=180\nB+C=180\n(C+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = 1.5 * paramValues[0]/200.;
      double ln1 = 1.5 - ln2;
      double ln3 = ln1 - ln2;

      double a = paramValues[1];
      double s1 = Math.sin(a * DEG2RAD);
      double c1 = Math.cos(a * DEG2RAD);

      double x4 =       c1 * ln3;
      double y4 =       s1 * ln3;
      double x2 = ln1 + c1 * ln2;
      double y2 =       s1 * ln2;
      
      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1, ln1,   0);
      baseTile.setPoint(2,  x2,  y2);
      baseTile.setPoint(3,  x2-ln3,  y2);
      baseTile.setPoint(4,  x4,  y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[2].getX(3);
      offsets[1] = tiles[0].getY(2)-tiles[2].getY(3);
      offsets[2] = tiles[5].getX(3)-tiles[3].getX(4);
      offsets[3] = tiles[5].getY(3)-tiles[3].getY(4);
   }
}
