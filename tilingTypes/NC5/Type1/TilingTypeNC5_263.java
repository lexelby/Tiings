package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_263
   extends TilingType
{
   public TilingTypeNC5_263(){
      super( "NC5-263", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{180};
      paramDef = new int[]{ 70};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 1,4, 0,4,1, 0},
            {0, 1,0, 0,0,1, 0},
            {0, 1,0, 1,0,1, 0},
            {2, 3,2, 0,0,4, 1},
            {2, 2,1, 4,1,2, 1},
      };
      info = "a=2d\nb=3d\nc=e\nB=E\nB+C=180\nC+D=360\n(A+B+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double a = getParam(paramValues, 0);
      double s = ln * Math.sin(a*DEG2RAD);
      double c = ln * Math.cos(a*DEG2RAD);
      double w = (ln-c)/2;
      
      baseTile.setPoint(0,  0,   0);
      baseTile.setPoint(1, 3*ln/2, 0);
      baseTile.setPoint(2, 3*ln/2-w, s/2);
      baseTile.setPoint(3, c+w, s/2);
      baseTile.setPoint(4, c, s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(3)-tiles[3].getX(4);
      offsets[1] = tiles[2].getY(3)-tiles[3].getY(4);
      offsets[2] = tiles[2].getX(4)-tiles[4].getX(0);
      offsets[3] = tiles[2].getY(4)-tiles[4].getY(0);
   }
}
