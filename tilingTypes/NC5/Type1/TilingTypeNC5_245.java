package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_245
   extends TilingType
{
   public TilingTypeNC5_245(){
      super( "NC5-245", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{ 90};
      paramDef = new int[]{ 70};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 1,0, 0,0,1, 0},
            {1, 0,4, 1,2,3, 0},
            {1, 4,1, 2,1,4, 0},
            {0, 2,3, 3,0,4, 0},
            {2, 0,1, 4,1,0, 0},

            {2, 2,3, 0,3,4, 1},
            {0, 1,0, 6,0,1, 1},
            {1, 0,4, 7,2,3, 1},
            {1, 4,1, 8,1,4, 1},
            {0, 2,3, 9,0,4, 1},
            {2, 0,1,10,1,0, 1},
      };
      info = "a=b\nc=e\nA=B\nB+C=180\nC+D=360\n(A+B+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln = .35;
      double a = getParam(paramValues, 0);
      double s = ln * Math.sin(a*DEG2RAD);
      double c = ln * Math.cos(a*DEG2RAD);
      
      baseTile.setPoint(0,  0,   0);
      baseTile.setPoint(1, 4*c + 2*ln, 0);
      baseTile.setPoint(2, 3*c + 2*ln, s);
      baseTile.setPoint(3, 3*c, s);
      baseTile.setPoint(4, c+c, s+s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(4);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(4);
      offsets[2] = tiles[5].getX(2)-tiles[11].getX(3);
      offsets[3] = tiles[5].getY(2)-tiles[11].getY(3);
   }
}
