package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_27b
   extends TilingType
{
   public TilingTypeNC6_27b(){
      super( "NC6-27b", 6, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{180};
      paramDef = new int[]{120};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 5,0, 0,4,5, 1},
            {1, 3,4, 1,4,3, 1},
            {0, 4,5, 2,5,0, 0},

            {0, 0,5, 1,0,1, 1},
            {1, 5,0, 4,4,5, 0},
            {1, 3,4, 5,4,3, 0},
            {0, 4,5, 6,5,0, 1},
      };
      info = "a=b=c=e=f\nE+F=360\nB+2C=360\n2D=F\n(A+D=C)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln = 0.5;
      double a = getParam(paramValues, 0);
      double base = calcSide(ln,ln,a);
      double h1 = Math.sqrt(ln*ln - base*base/9);
      double h2 = Math.sqrt(ln*ln - base*base/4);

      baseTile.setPoint(0,      0,   0);
      baseTile.setPoint(1, base/2, -h2);
      baseTile.setPoint(2, base  ,   0);
      baseTile.setPoint(3, base  ,  h1);
      baseTile.setPoint(4, base*2/3, 0);
      baseTile.setPoint(5, base/3,  h1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[7].getX(0)-tiles[3].getX(5);
      offsets[3] = tiles[7].getY(0)-tiles[3].getY(5);
   }
}