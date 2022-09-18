package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_07g
   extends TilingType
{
   public TilingTypeNC6_07g(){
      super( "NC6-7g", 6, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{180};
      paramDef = new int[]{ 90};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,1,2, 1},
            {0, 0,5, 1,0,5, 0},
            {1, 2,3, 2,1,2, 1},

            {1, 0,1, 0,1,0, 0},
            {0, 1,2, 4,2,3, 1},
            {1, 0,5, 5,0,5, 0},
            {0, 1,2, 6,2,3, 1},
      };
      info = "c=d=e=f\nB+C=180\nC+D=360\nC=E\nE+2F=360\n(A+F=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .3;
      double a = getParam(paramValues, 0);
      double c = ln * Math.cos( a * DEG2RAD );
      double s = ln * Math.sin( a * DEG2RAD );

      baseTile.setPoint(0,   0,    0);
      baseTile.setPoint(1,4*ln,    0);
      baseTile.setPoint(2,4*ln+c,  s);
      baseTile.setPoint(3,3*ln+c,  s);
      baseTile.setPoint(4,3*ln+2*c, 2*s);
      baseTile.setPoint(5,2*ln+2*c, 2*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(0)-tiles[3].getX(1);
      offsets[1] = tiles[4].getY(0)-tiles[3].getY(1);
      offsets[2] = tiles[1].getX(1)-tiles[5].getX(0);
      offsets[3] = tiles[1].getY(1)-tiles[5].getY(0);
   }
}