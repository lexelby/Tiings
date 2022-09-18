package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_236
   extends TilingType
{
   public TilingTypeNC5_236(){
      super( "NC5-236", 5, SymmetryType.pgg);

      paramMin = new int[]{  0};
      paramMax = new int[]{180};
      paramDef = new int[]{ 70};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 1,0, 0,0,1, 0},
            {1, 1,2, 1,1,2, 1},
            {1, 2,0, 2,0,2, 1},
            {0, 1,2, 3,1,2, 0},
            {2, 0,1, 4,1,0, 0},
            
            {2, 4,0, 0,1,2, 1},
            {0, 1,0, 6,0,1, 1},
            {1, 1,2, 7,1,2, 0},
            {1, 2,0, 8,0,2, 0},
            {0, 1,2, 9,1,2, 1},
            {2, 0,1,10,1,0, 1},
      };
      
      info = "a=d=e\nc=b+2a\nB=C\nC+D=180\nD+E=360\n(A+B+C=180)";
   }
   public void recalcBase(double[] paramValues) {
      double ln = .4;
      double e = getParam(paramValues, 0);
      double a = 90 - e/2;
      double dx = ln * Math.cos(a * DEG2RAD);
      double dy = ln * Math.sin(a * DEG2RAD);
      
      baseTile.setPoint(1,   0,   0);
      baseTile.setPoint(2, 4*dx+ln,  0);
      baseTile.setPoint(3, 3*dx+ln,  dy);
      baseTile.setPoint(4, 3*dx,  dy);
      baseTile.setPoint(0, 2*dx,  2*dy);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[6].getX(1)-tiles[0].getX(4);
      offsets[1] = tiles[6].getY(1)-tiles[0].getY(4);
      offsets[2] = tiles[11].getX(1)-tiles[5].getX(4);
      offsets[3] = tiles[11].getY(1)-tiles[5].getY(4);
   }
}
