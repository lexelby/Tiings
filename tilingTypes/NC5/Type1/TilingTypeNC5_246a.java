package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_246a
   extends TilingType
{
   public TilingTypeNC5_246a(){
      super( "NC5-246a", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{180};
      paramDef = new int[]{ 70};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,2, 0,2,1, 0},
            {1, 1,0, 0,0,1, 0},
            {1, 4,1, 2,1,4, 0},
            {2, 4,0, 0,2,3, 1},
            {2, 4,1, 4,1,4, 1},
      };
      info = "a=d\nb=2a\nc=e\nB+C=180\nC+D=360\n(A+B+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double a = getParam(paramValues, 0);
      double s = ln * Math.sin(a*DEG2RAD);
      double c = ln * Math.cos(a*DEG2RAD);
      double w = (ln-c)/2;
      
      baseTile.setPoint(0,  0,   0);
      baseTile.setPoint(1, 2*ln, 0);
      baseTile.setPoint(2, 2*ln-w, s/2);
      baseTile.setPoint(3, c+w, s/2);
      baseTile.setPoint(4, c, s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(0)-tiles[0].getX(4);
      offsets[1] = tiles[5].getY(0)-tiles[0].getY(4);
      offsets[2] = tiles[1].getX(4)-tiles[0].getX(3);
      offsets[3] = tiles[1].getY(4)-tiles[0].getY(3);
   }
}
