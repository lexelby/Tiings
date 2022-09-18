package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_252
   extends TilingType
{
   public TilingTypeNC5_252(){
      super( "NC5-252", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{180};
      paramDef = new int[]{ 85};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 4,0, 0,0,4, 0},
            {1, 0,1, 1,1,0, 0},
            {1, 4,0, 2,0,4, 0},
            {0, 0,1, 3,1,0, 0},
            {2, 4,0, 4,0,4, 0},

            {2, 0,1, 2,3,4, 1},
            {0, 4,0, 6,0,4, 1},
            {1, 0,1, 7,1,0, 1},
            {1, 4,0, 8,0,4, 1},
            {0, 0,1, 9,1,0, 1},
            {2, 4,0,10,0,4, 1},
};
      info = "c=d=e\nb=2c\nB+C=180\nC+D=360\n(A+B+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln = .5;
      double a = getParam(paramValues, 0);
      double dx = ln * Math.cos(a*DEG2RAD);
      double dy = ln * Math.sin(a*DEG2RAD);
      baseTile.setPoint(0,  0,   0);
      baseTile.setPoint(1, 2*ln, 0);
      baseTile.setPoint(2, 2*ln-dx, dy);
      baseTile.setPoint(3, ln-dx, dy);
      baseTile.setPoint(4, ln-2*dx, 2*dy);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(1)-tiles[0].getX(4);
      offsets[1] = tiles[5].getY(1)-tiles[0].getY(4);
      offsets[2] = tiles[3].getX(3)-tiles[11].getX(0);
      offsets[3] = tiles[3].getY(3)-tiles[11].getY(0);
   }
}
