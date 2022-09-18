package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_07e
   extends TilingType
{
   public TilingTypeNC6_07e(){
      super( "NC6-7e", 7, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{180};
      paramDef = new int[]{ 90};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,2,3, 1},
            {0, 0,6, 1,0,6, 0},
            {1, 3,4, 2,2,3, 1},

            {1, 1,2, 3,0,1, 0},
            {0, 2,3, 4,3,4, 1},
            {1, 0,6, 5,0,6, 0},
            {0, 2,3, 6,3,4, 1},
      };
      info = "c=d=e=f\nB+C=180\nC+D=360\nC=E\nE+2F=360\n(A+F=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .3;
      double a = getParam(paramValues, 0);
      double c = ln * Math.cos( a * DEG2RAD );
      double s = ln * Math.sin( a * DEG2RAD );

      baseTile.setPoint(0,   0,    0);
      baseTile.setPoint(1,2*ln,    0);
      baseTile.setPoint(2,4*ln,    0);
      baseTile.setPoint(3,4*ln+c,  s);
      baseTile.setPoint(4,3*ln+c,  s);
      baseTile.setPoint(5,3*ln+2*c, 2*s);
      baseTile.setPoint(6,2*ln+2*c, 2*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[6].getX(2);
      offsets[1] = tiles[1].getY(1)-tiles[6].getY(2);
      offsets[2] = tiles[3].getX(0)-tiles[3].getX(2);
      offsets[3] = tiles[3].getY(0)-tiles[3].getY(2);
   }
}